package com.bluetooth.padeltournamets.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bluetooth.padeltournamets.model.dao.*
import com.bluetooth.padeltournamets.model.entities.*

@Database(entities = [UsuarioEntity::class, JugadorEntity::class, OrganizadorEntity::class, TorneoEntity::class,
                     PistaEntity::class, ParejaEntity::class, PagoEntity::class, EnfrentamientoEntity::class, InscripcionEntity::class,
                     TorneoOrganizadoEntity::class, ReservaEntity::class],
          version = 1,
          exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract val usuarioDao : UsuarioDao
    abstract val jugadorDao : JugadorDao
    abstract val organizadorDao : OrganizadorDao
    abstract val torneoDao : TorneoDao
    abstract val pistaDao: PistaDao
    abstract val parejaDao: ParejaDao
    abstract val pagoDao: PagoDao
    abstract val enfrentamientoDao : EnfrentamientoDao
    abstract val inscripcionDao : InscripcionDao
    abstract val torneoOrganizadoDao : TorneoOrganizadoDao
    abstract val reservaDao : ReservaDao
}