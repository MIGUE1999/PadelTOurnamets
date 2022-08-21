package com.bluetooth.padeltournamets.model.di

import android.content.Context
import androidx.room.Room
import com.bluetooth.padeltournamets.model.database.AppDatabase
import com.bluetooth.padeltournamets.model.repository.implementation.*
import com.bluetooth.padeltournamets.model.repository.interfaces.*
import com.bluetooth.padeltournamets.utilities.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
/*
    @Provides
    @Singleton
    fun provideUsuarioDao(db:AppDatabase) = db.usuarioDao
*/
    @Provides
    @Singleton
    fun provideUserRepository(db:AppDatabase) : IUserRepository {
        return UserRepositoryImpl(db.userDao)
    }

/*
    @Provides
    @Singleton
    fun provideTorneoDao(db:AppDatabase) = db.torneoDao
*/
    @Provides
    @Singleton
    fun provideTournamentRepository(db:AppDatabase) : ITournamentRepository {
        return TournamentRepositoryImpl(db.tournamentDao)
    }
/*
    @Provides
    @Singleton
    fun provideReservaDao(db:AppDatabase) = db.reservaDao
*/
    @Provides
    @Singleton
    fun provideReservaRepository(db:AppDatabase) : IReservaRepository {
        return ReservaRepositoryImpl(db.reservaDao)
    }
/*
    @Provides
    @Singleton
    fun providePistaDao(db:AppDatabase) = db.pistaDao
*/
    @Provides
    @Singleton
    fun provideCourtRepository(db:AppDatabase) : ICourtRepository {
        return CourtRepositoryImpl(db.courtDao)
    }


/*
    @Provides
    @Singleton
    fun provideOrganizadorDao(db:AppDatabase) = db.organizadorDao
*/
    @Provides
    @Singleton
    fun provideOrganizatorRepository(db:AppDatabase) : IOrganizatorRepository {
        return OrganizatorRepositoryImpl(db.organizatorDao)
    }
/*
    @Provides
    @Singleton
    fun provideJugadorDao(db:AppDatabase) = db.jugadorDao
*/
    @Provides
    @Singleton
    fun providePlayerRepository(db:AppDatabase) : IPlayerRepository {
        return PlayerRepositoryImpl(db.playerDao)
    }
/*
    @Provides
    @Singleton
    fun provideInscripcionDao(db:AppDatabase) = db.inscripcionDao
*/
    @Provides
    @Singleton
    fun provideInscripcionRepository(db:AppDatabase) : IInscripcionRepository {
        return InscripcionRepositoryImpl(db.inscripcionDao)
    }


}