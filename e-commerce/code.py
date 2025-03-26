import json


class Commande:
    def __init__(self, id_commande):
        self.id_commande = id_commande
        self.produits = {}
        self.etat = "en attente"
        self._next_product_id = 1

    def ajouter_produit(self, nom, prix):
        self.produits[self._next_product_id] = {"nom": nom, "prix": prix}
        self._next_product_id += 1

    def calculer_total(self):
        return sum(produit["prix"] for produit in self.produits.values())

    def changer_etat(self, nouvel_etat):
        self.etat = nouvel_etat

    def to_dict(self):
        return {
            "id_commande": self.id_commande,
            "produits": self.produits,
            "etat": self.etat,
            "type": "Commande"
        }

    @classmethod
    def from_dict(cls, data):
        commande = cls(data["id_commande"])
        commande.produits = data["produits"]
        commande.etat = data["etat"]
        if data["produits"]:
            commande._next_product_id = max(map(int, data["produits"].keys())) + 1
        return commande


class CommandeExpress(Commande):
    def calculer_total(self):
        return super().calculer_total() * 1.10

    def to_dict(self):
        data = super().to_dict()
        data["type"] = "CommandeExpress"
        return data


def sauvegarder_commande(commande, fichier="commandes.json"):
    try:
        with open(fichier, 'r') as f:
            commandes = json.load(f)
    except (FileNotFoundError, json.JSONDecodeError):
        commandes = []


    commande_dict = commande.to_dict()
    updated = False
    for i, cmd in enumerate(commandes):
        if cmd["id_commande"] == commande.id_commande:
            commandes[i] = commande_dict
            updated = True
            break

    if not updated:
        commandes.append(commande_dict)

    with open(fichier, 'w') as f:
        json.dump(commandes, f, indent=2)


def charger_commandes(fichier="commandes.json"):
    try:
        with open(fichier, 'r') as f:
            data = json.load(f)
    except (FileNotFoundError, json.JSONDecodeError):
        return []

    commandes = []
    for cmd_data in data:
        if cmd_data["type"] == "CommandeExpress":
            commande = CommandeExpress.from_dict(cmd_data)
        else:
            commande = Commande.from_dict(cmd_data)
        commandes.append(commande)

    return commandes


def main():
    commandes = charger_commandes()

    while True:
        print("\n GESTION DES COMMANDES")
        print("1. Créer une commande")
        print("2. Ajouter un produit")
        print("3. Changer état")
        print("4. Afficher commandes")
        print("5. Quitter")

        choix = input("Choix: ")

        if choix == "1":
            id_cmd = input("ID commande: ")
            if any(c.id_commande == id_cmd for c in commandes):
                print("Erreur: ID existe déjà")
                continue

            type_cmd = input("Type (N=Normal, E=Express): ").upper()
            if type_cmd == "E":
                cmd = CommandeExpress(id_cmd)
            else:
                cmd = Commande(id_cmd)

            commandes.append(cmd)
            sauvegarder_commande(cmd)
            print("Commande créée!")

        elif choix == "2":
            if not commandes:
                print("Aucune commande!")
                continue

            print("\nCommandes disponibles:")
            for cmd in commandes:
                print(f"{cmd.id_commande} ({type(cmd).__name__}) - {cmd.etat}")

            id_cmd = input("ID commande: ")
            cmd = next((c for c in commandes if c.id_commande == id_cmd), None)

            if cmd:
                nom = input("Nom produit: ")
                prix = float(input("Prix: "))
                cmd.ajouter_produit(nom, prix)
                sauvegarder_commande(cmd)
                print("Produit ajouté!")
            else:
                print("Commande introuvable")

        elif choix == "3":
            if not commandes:
                print("Aucune commande!")
                continue

            for cmd in commandes:
                print(f"{cmd.id_commande} - {cmd.etat}")

            id_cmd = input("ID commande: ")
            cmd = next((c for c in commandes if c.id_commande == id_cmd), None)

            if cmd:
                nouvel_etat = input("Nouvel état: ")
                cmd.changer_etat(nouvel_etat)
                sauvegarder_commande(cmd)
                print("État mis à jour!")
            else:
                print("Commande introuvable")

        elif choix == "4":
            if not commandes:
                print("Aucune commande!")
                continue

            for cmd in commandes:
                total = cmd.calculer_total()
                print(f"\nCommande {cmd.id_commande} ({type(cmd).__name__})")
                print(f"État: {cmd.etat}")
                print("Produits:")
                for pid, p in cmd.produits.items():
                    print(f"  {p['nom']}: {p['prix']}DH")
                print(f"TOTAL: {total:.2f}€")

        elif choix == "5":
            print("Au revoir!")
            break

        else:
            print("Choix invalide")


if __name__ == "__main__":
    main()
