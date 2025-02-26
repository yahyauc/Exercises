
def calcule_du_moyenne(n1, n2, n3):
    return (n1 + n2 + n3) / 3

def montion(moyenne):
    if moyenne >= 16:
        return "Tres bien"
    elif moyenne >= 14:
        return "Bien"
    elif moyenne >= 12:
        return "Assez bien"
    elif moyenne >= 10:
        return "Passable"
    else:
        return "Insuffisant"
    
def add_stud():
    name = str(input("Entrer le nom du etudiant :"))
    username = str(input("Entrer le prenom du etudiant :"))
    note1 = int(input("Entrer la note 1 du etudiant :"))
    note2 = int(input("Entrer la note 2 du etudiant :"))
    note3 = int(input("Entrer la note 3 du etudiant :"))
    moyenne = calcule_du_moyenne(note1, note2, note3)
    mention = montion(moyenne)
    print(f"La moyenne de l'etudiant {name} {username} est {moyenne} et sa mention est {mention}")


add_stud()
