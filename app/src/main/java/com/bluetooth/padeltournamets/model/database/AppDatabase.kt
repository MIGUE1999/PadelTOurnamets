package com.bluetooth.padeltournamets.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bluetooth.padeltournamets.model.dao.*
import com.bluetooth.padeltournamets.model.entities.*
import com.bluetooth.padeltournamets.model.entities.relations.OrganizatorWithTournaments
import com.bluetooth.padeltournamets.utilities.Converters

@Database(entities = [UserEntity::class, PlayerEntity::class, OrganizatorEntity::class,
                      TournamentEntity::class, CourtEntity::class,
                      InscripcionEntity::class, ReservaEntity::class,
                     //OrganizatorWithTournaments::class
                        ],
          version = 1,
          exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao : UserDao
    abstract val tournamentDao : TournamentDao
    abstract val playerDao : PlayerDao
    abstract val organizatorDao : OrganizatorDao
    abstract val courtDao: CourtDao
    abstract val inscripcionDao : InscripcionDao
    abstract val reservaDao : ReservaDao
    //abstract val organizatorWithTournaments : OrganizatorWithTournaments
}