package org.example.makeurcomp

data class Joueur(val prenom: String, val nom: String, val age: Int, val niveau: Double) {
    init {
        require(niveau in 1.0..10.0) { "Le niveau doit être compris entre 1.0 et 10.0" }
    }
}
