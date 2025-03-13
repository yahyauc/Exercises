equipe = []
scoure = []
equipes_jouees = []

def tournoi(nom):
    if nom not in equipe:
        equipe.append(nom)
        scoure[nom] = 0 
        print(f"l'equipe {nom}a ete ajoute")
    else:
        print("l'equipe existe deja")

def enregistrer_resultat_match(equipe1,equipe2,score1,score2):
    if equipe1 not in equipe or equipe2 not in equipe:
        print("l'equipe n'existe pas")
        return
    equipes_jouees.update({equipe1,equipe2})
    if score1 > score2:
        scoure[equipe1] += 3
    elif score1 < score2:
        scoure[equipe2] += 3
    else:
        scoure[equipe1] += 1
        scoure[equipe2] += 1
    print("resultat enregistre")

def afficher_classement():
    classement = sorted(scoure.items(), key=lambda x: x[1], reverse=True)
    print("Classement du tournoi :")
    for i, (nom, score) in enumerate(classement, 1):
        print(f"{i}. {nom} : {score} points")

def suprimer_equipe(nom):
    if nom in equipe:
        equipe.remove(nom)
        del scoure[nom]
        print(f"l'equipe {nom} a ete supprime")
    else:
        print("l'equipe n'existe pas")

def menu():
    print("\n1: Ajouter une equipe")
    print("\n2: Enregister la resultat d'un match")
    print("\n 3: Afficher le classement")
    print("\n 4: Supprimer une equipe")
    print("\n 5: Quitter")

    choix = input("choix :")
    if choix == "1":
        nom = input("nom de l'equipe : ")
        tournoi(nom)
    elif choix == "2":
        equipe1 = input("nom de l'equipe 1 : ")
        equipe2 = input("nom de l'equipe 2 : ")
        score1 = int(input("score de l'equipe 1 : "))
        score2 = int(input("score de l'equipe 2 : "))
        enregistrer_resultat_match(equipe1, equipe2, score1, score2)
    elif choix == "3":
        afficher_classement()
    elif choix == "4":
        nom = input("nom de l'equipe : ")
        suprimer_equipe(nom)
    elif choix == "5":
        print("fin du tournoi")
    return


    