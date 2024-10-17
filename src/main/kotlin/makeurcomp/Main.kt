 package org.example.makeurcomp

 import org.jetbrains.exposed.sql.Database

 fun main() {
    fun connectToDatabase() {
        Database.connect(
            url = "jdbc:mysql://localhost:3306/makeurcomp",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = ""
        )
    }
     connectToDatabase()

     val joueurs = recupererJoueurs()
     joueurs.forEach { joueur ->
         println("${joueur.prenom} ${joueur.nom}: Age=${joueur.age}, Niveau=${joueur.niveau}")
     }

     println()

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