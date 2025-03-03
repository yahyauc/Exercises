liste = {}
validee = False

while True:
    print("\n1. Ajouter")
    print("2. Supprimer")
    print("3. Afficher")
    print("4. Valider")
    print("5. Quitter")
    
    choix = input("Choisir(khtar chi haja mn hadok ela 3jbatek chi haja sinon taper 5) : ")

    if choix == "1":
        nom = input("Article : ")
        if nom in liste:
            print("hadi frasna w deja 3ndna ")
        else:
            qte = input("Quantité : ")
            liste[nom] = qte

    elif choix == "2":
        nom = input("Article : ")
        if nom in liste:
            del liste[nom]
        else:
            print("makaynach makaynach")

    elif choix == "3":
        if not liste:
            print("Vide")
        else:
            for nom, qte in liste.items():
                print(nom, ":", qte)

    elif choix == "4":
        validee = True
        print("Validée")

    elif choix == "5":
        if not validee:
            validee = True
        print("Final :")
        for nom, qte in liste.items():
            print(nom, ":", qte)
        break

    else:
        print("hak wahd erreur ")
