package com.bluetooth.padeltournamets.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bluetooth.padeltournamets.model.dao.*
import com.bluetooth.padeltournamets.model.entities.*
import com.bluetooth.padeltournamets.utilities.Converters

@Database(entities = [UsuarioEntity::class, JugadorEntity::class, OrganizadorEntity::class, TournamentEntity::class,
                     PistaEntity::class, ParejaEntity::class, PagoEntity::class, EnfrentamientoEntity::class, InscripcionEntity::class,
                     TorneoOrganizadoEntity::class, ReservaEntity::class],
          version = 1,
          exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val usuarioDao : UsuarioDao
    abstract val jugadorDao : JugadorDao
    abstract val organizadorDao : OrganizadorDao
    abstract val tournamentDao : TournamentDao
    abstract val pistaDao: PistaDao
    abstract val parejaDao: ParejaDao
    abstract val pagoDao: PagoDao
    abstract val enfrentamientoDao : EnfrentamientoDao
    abstract val inscripcionDao : InscripcionDao
    abstract val torneoOrganizadoDao : TorneoOrganizadoDao
    abstract val reservaDao : ReservaDao
}