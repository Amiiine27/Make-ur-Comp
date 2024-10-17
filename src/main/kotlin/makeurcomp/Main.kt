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

    val tableau = EquipeManager.repartirEquipes(joueurs)

    tableau.equipes.forEachIndexed { index, equipe ->
        println("Équipe ${index + 1}: Niveau moyen = ${equipe.niveauMoyen}")
        println("  ${equipe.joueur1.prenom} (${equipe.joueur1.niveau})")
        println("  ${equipe.joueur2.prenom} (${equipe.joueur2.niveau})")
        println("  ${equipe.joueur3.prenom} (${equipe.joueur3.niveau})")
        println("  ${equipe.joueur4.prenom} (${equipe.joueur4.niveau})")
        println()
    }
}