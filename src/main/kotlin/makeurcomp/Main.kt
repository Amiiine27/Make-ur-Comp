package org.example.makeurcomp

fun main() {
    val joueurs = listOf(
        Joueur("Amine", "Akhrib", 20, 7.0),
        Joueur("Nassim", "Rahal", 20, 7.0),
        Joueur("Nabil", "Aouraghe", 30, 9.0),
        Joueur("Faycal", "Beddiaf", 20, 8.0),

        Joueur("Mehdi", "Bouainane", 20, 8.5),
        Joueur("Axel", "Gerke", 54, 4.0),
        Joueur("Jordan", "Dutallis", 29, 6.5),
        Joueur("Rayan", "Acheraiou", 21, 7.0),

        Joueur("Yann-Yves", "Laplume", 37, 6.75),
        Joueur("Ahmed", "Elmzouri", 40, 7.5),
        Joueur("Thomas", "David", 24, 7.0),
        Joueur("Mickael", "Ettedgui", 43, 6.75)
    )

    val nbEquipes = 3
    val tableau = repartirJoueurs(joueurs, nbEquipes)

    tableau.equipes.forEachIndexed { index, equipe ->
        println("Equipe ${index +1} : ")
        equipe.joueurs.forEach { joueur ->
            println("${joueur.prenom} \t | ${joueur.nom} \t | ${joueur.niveau}")
        }
        println("Moyenne de nieveau : ${equipe.moyenneNiveau()}")
        println()
    }
}