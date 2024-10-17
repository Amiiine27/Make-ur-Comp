package org.example.makeurcomp
    fun repartirJoueurs(joueurs: List<Joueur>, nbEquipes: Int): Tableau {
        //Trier les joueurs dans l'ordre décroissant par rapport a leur niveau (du plus fort au plus faible)
        val joueursTries = joueurs.sortedByDescending { it.niveau }

        // Initialiser les deux groupes de niveau
        val forts = joueursTries.take(joueursTries.size/2)
        val faibles = joueursTries.takeLast(joueursTries.size/2)

        // Indices pour parcourir les groupes
        var indexFort = 0
        var indexFaible = 0

        // Initialiser les equipes :  on créee nbEquipes fois des Equipe qu'on stock dans la val equipes
        val equipes = MutableList(nbEquipes) { Equipe() }

        // Repartir les joueurs dans les equipes de manière équitable
        while (indexFort < forts.size || indexFaible < faibles.size) {

            // Ajouter un joueur fort a une equipe
            if (indexFort < forts.size) {
                val equipeIndex = indexFort % nbEquipes
                equipes[equipeIndex].joueurs.add(forts[indexFort])
                indexFort++
            }

            // Ajouter un joueur faible a une equipe
            if (indexFaible < faibles.size) {
                val equipeIndex = indexFaible % nbEquipes
                equipes[equipeIndex].joueurs.add(faibles[indexFaible])
                indexFaible++
            }
        }

        return Tableau(equipes)
    }

