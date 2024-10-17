package org.example.makeurcomp
data class Equipe(val joueur1: Joueur, val joueur2: Joueur, val joueur3: Joueur, val joueur4: Joueur) {
    val niveauMoyen: Double
        get() = listOf(joueur1, joueur2, joueur3, joueur4).map { it.niveau }.average()

    fun remplacerJoueur(ancienJoueur: Joueur, nouveauJoueur: Joueur): Equipe {
        return when (ancienJoueur) {
            joueur1 -> copy(joueur1 = nouveauJoueur)
            joueur2 -> copy(joueur2 = nouveauJoueur)
            joueur3 -> copy(joueur3 = nouveauJoueur)
            joueur4 -> copy(joueur4 = nouveauJoueur)
            else -> this
        }
    }
}