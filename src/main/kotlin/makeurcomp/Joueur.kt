package org.example.makeurcomp

import makeurcomp.Joueurs
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

data class Joueur(val prenom: String, val nom: String, val age: Int, val niveau: Double, val id: Int) {
    init {
        require(niveau in 1.0..10.0) { "Le niveau doit être compris entre 1.0 et 10.0" }
    }
}

fun recupererJoueurs(): List<Joueur> {
    return transaction {
        Joueurs.selectAll().map { row ->
            Joueur(
                id = row[Joueurs.id],
                prenom = row[Joueurs.prenom],
                nom = row[Joueurs.nom],
                age = row[Joueurs.age],
                niveau = row[Joueurs.niveau].toDouble()
            )
        }
    }
}