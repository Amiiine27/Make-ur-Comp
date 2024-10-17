package makeurcomp

import org.jetbrains.exposed.sql.Table

object Joueurs : Table() {
    val id = integer("id").autoIncrement()
    val prenom = varchar("prenom", 50)
    val nom = varchar("nom", 50)
    val age = integer("age")
    val niveau = decimal("niveau", 3, 1)

    override val primaryKey = PrimaryKey(id)
}