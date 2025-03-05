genre_list = ["Roman", "Science-fiction", "Histoire", "Poésie"]
livre_dispo = {}
livre_emprunte = {}

def ajouter_livre(titre, genre):
    if genre not in genre_list:
        print("Erreur, Le genre doit être valide !!")
        return 0
    if titre in livre_dispo or titre in livre_emprunte:
        print("Le livre existe déjà !!")
        return 0
    livre_dispo[titre] = genre
    print("Livre ajouté avec succès !!")

def supprimer_livre(titre):
    if titre not in livre_dispo:
        print("Le livre n'existe pas !!")
        return 0
    del livre_dispo[titre]
    print("Livre supprimé avec succès !!")

def emprunter_livre(titre):
    if titre in livre_dispo:
        livre_emprunte[titre] = livre_dispo[titre]
        del livre_dispo[titre]
        print("Livre emprunté avec succès !!")
    else:
        print("Le livre n'existe pas !!")

def retourner_livre(titre):
    if titre in livre_emprunte:
        livre_dispo[titre] = livre_emprunte[titre]
        del livre_emprunte[titre]
        print("Livre retourné avec succès !!")
    else:
        print("Le livre n'existe pas !!")

def afficher_livres_dispo():
    if livre_dispo:
        print("\n Livres disponibles :")
        for titre, genre in livre_dispo.items():
            print(titre, ":", genre)
    else:
        print("Aucun livre disponible !!")

def afficher_livres_empruntes():
    if livre_emprunte:
        print("\n Livres empruntés :")
        for titre in livre_emprunte:
            print(titre)
    else:
        print("Aucun livre emprunté !!")

def menu():
    print("\n1. Ajouter")
    print("2. Supprimer")
    print("3. Emprunter")
    print("4. Retourner")
    print("5. Afficher les livres disponibles")
    print("6. Afficher les livres empruntés")
    print("7. Quitter")
    choix = input("Choisir  : ")
    return choix

while True:
    choix = menu()
    if choix == "1":
        titre = input("Titre : ")
        genre = input("Genre : ")
        ajouter_livre(titre, genre)
    elif choix == "2":
        titre = input("Titre : ")
        supprimer_livre(titre)
    elif choix == "3":
        titre = input("Titre : ")
        emprunter_livre(titre)
    elif choix == "4":
        titre = input("Titre : ")
        retourner_livre(titre)
    elif choix == "5":
        afficher_livres_dispo()
    elif choix == "6":
        afficher_livres_empruntes()
    elif choix == "7":
        break
    else:
        print("Erreur !!")

print("Final :")
afficher_livres_dispo()
afficher_livres_empruntes()
