package org.example.makeurcomp
import kotlin.collections.mutableListOf

data class Equipe(
    val joueurs: MutableList<Joueur> = mutableListOf()
){
    fun moyenneNiveau(): Double {
        return if(joueurs.isNotEmpty()){
            joueurs.map {it.niveau}.average()
        } else{
            0.0
        }
    }
}
