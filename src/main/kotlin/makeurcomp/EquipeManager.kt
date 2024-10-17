package org.example.makeurcomp

object EquipeManager {
    fun repartirEquipes(joueurs: List<Joueur>): Tableau {
        require(joueurs.size % 4 == 0) { "Le nombre de joueurs doit être un multiple de 4" }

        // Trier les joueurs par niveau décroissant
        val joueursTries = joueurs.sortedByDescending { it.niveau }

        // Créer les équipes initiales
        val equipes = mutableListOf<Equipe>()
        for (i in joueursTries.indices step 4) {
            equipes.add(Equipe(joueursTries[i], joueursTries[i+1], joueursTries[i+2], joueursTries[i+3]))
        }

        // Optimiser les équipes
        var optimisationNecessaire = true
        while (optimisationNecessaire) {
            optimisationNecessaire = false
            for (i in equipes.indices) {
                for (j in i + 1 until equipes.size) {
                    if (Math.abs(equipes[i].niveauMoyen - equipes[j].niveauMoyen) > 0.5) {
                        // Essayer d'échanger des joueurs pour équilibrer
                        val joueursEquipe1 = listOf(equipes[i].joueur1, equipes[i].joueur2, equipes[i].joueur3, equipes[i].joueur4)
                        val joueursEquipe2 = listOf(equipes[j].joueur1, equipes[j].joueur2, equipes[j].joueur3, equipes[j].joueur4)

                        for (joueur1 in joueursEquipe1) {
                            for (joueur2 in joueursEquipe2) {
                                val nouvelleEquipe1 = equipes[i].remplacerJoueur(joueur1, joueur2)
                                val nouvelleEquipe2 = equipes[j].remplacerJoueur(joueur2, joueur1)

                                if (Math.abs(nouvelleEquipe1.niveauMoyen - nouvelleEquipe2.niveauMoyen) <= 0.5) {
                                    // Échanger les joueurs
                                    equipes[i] = nouvelleEquipe1
                                    equipes[j] = nouvelleEquipe2
                                    optimisationNecessaire = true
                                    break
                                }
                            }
                            if (optimisationNecessaire) break
                        }
                    }
                    if (optimisationNecessaire) break
                }
                if (optimisationNecessaire) break
            }
        }

        return Tableau(equipes)
    }
}