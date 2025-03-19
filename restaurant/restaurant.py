plates = []
commande = {}
historique = []
commande_en_attente = ["cmd1", "cmd2", "cmd3", "cmd4"]

def ajouter_plat_au_menu(plat):
    if plat not in plates:
        plates.append(plat)
        print("Le plat a été ajouté avec succès !")
    else:
        print("Le plat est deja ajouté !")

def passer_une_commande(plat):
    num_du_table = int(input("Entrer le numéro de la table : "))
    while num_du_table > 10 or num_du_table < 0:
        print("Cette table n'existe pas, pls refiez bien")
        num_du_table = int(input("Entrer le numéro de la table : "))
    if plat not in plates:
        print("Ce plat n'est pas disponible!")
    else:
        commande[num_du_table] = plat
        commande_en_attente.append(plat)
        print(f"La commande pour la table {num_du_table} a été enregistrée")

def servir_commande():
    if not commande_en_attente:
        print("Aucune commande en attente !")
    
    commande = commande_en_attente.pop(0)
    
    historique.append(commande)
    print("La commande a ete servie !")

def annuler_la_derniere_commande():
    if not commande_en_attente:
        print("Aucune commande à annuler")
    else:
        commande_en_attente.pop()

def afficher_statistique():
    if commande:
        print("Les commandes :\n")
        for cmd in commande:
            print(f"{cmd}")
    else:
        print("Aucune commande actuellement !")
    if commande_en_attente:
        print("Les commandes en attente :\n")
        for cmd in commande_en_attente:
            print(f"{cmd}")
    else:
        print("Aucune commande en attente actuellement !")
    if historique:
        print("Les historiques :\n")
        for hst in historique:
            print(f"{hst}")
    else:
        print("Aucun historique !")

def menu():
    while True:
        print("Menu :")
        print("1: Ajouter un plat")
        print("2: Passer une commande")
        print("3: Servir une commande")
        print("4: Annuler la dernière commande")
        print("5: Afficher les statistiques")
        print("6: Quitter")

        choix = input("Choix : ")

        match choix:
            case "1":
                plat = input("Entrer le nom du plat : ")
                ajouter_plat_au_menu(plat)
            case "2":
                plat = input("Entrer le nom du plat : ")
                passer_une_commande(plat)
            case "3":
                servir_commande()
            case "4":
                annuler_la_dernière_commande()
                print("La dernière commande a été annulée !")
            case "5":
                afficher_statistique()
            case "6":
                print("\nN'oubliez pas de nous revisiter !")
                exit()

menu()
