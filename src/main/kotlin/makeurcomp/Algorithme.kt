package org.example.makeurcomp
    fun repartirJoueurs(joueurs: List<Joueur>, nbEquipes: Int): Tableau {
        //Trier les joueurs dans l'ordre décroissant par rapport a leur niveau (du plus fort au plus faible)
        val joueursTries = joueurs.sortedByDescending { it.niveau }

        // Initialiser les equipes
        val equipes = MutableList(nbEquipes) { Equipe() }

        // Repartir les joueurs dans les equipes de manière équitable
        joueursTries.forEachIndexed { index, joueur ->
            val equipeIndex = index % nbEquipes
            equipes[equipeIndex].joueurs.add(joueur)
        }

        return Tableau(equipes)
    }

