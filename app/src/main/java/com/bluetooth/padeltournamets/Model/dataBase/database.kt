package com.bluetooth.padeltournamets.Model.dataBase

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.bluetooth.padeltournamets.Model.DAOs.*
import com.bluetooth.padeltournamets.Model.Entities.*

@Database(entities = [Usuario::class, Jugador::class, Organizador::class, Torneo::class,
                     Pista::class, Pareja::class, Pago::class, Enfrentamiento::class, Inscripcion::class,
                     TorneoOrganizado::class, Reserva::class],
          version = 2,
    autoMigrations = [AutoMigration (from = 1, to = 2)]
)
abstract class database : RoomDatabase() {

    abstract fun usuarioDao() : UsuarioDao
    abstract fun jugadorDao() : JugadorDao
    abstract fun organizadorDao() : OrganizadorDao
    abstract fun torneoDao() : TorneoDao
    abstract fun pistaDao(): PistaDao
    abstract fun parejaDao(): ParejaDao
    abstract fun pagoDao(): PagoDao
    abstract fun inscripcionDao() : InscripcionDao
    abstract fun torneoOrganizadoDao() : TorneoOrganizadoDao
    abstract fun reservaDao() : ReservaDao
}