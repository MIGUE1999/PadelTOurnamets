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
import javax.inject.Named
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
    fun provideUsuarioRepository(db:AppDatabase) : IUsuarioRepository {
        return UsuarioRepositoryImpl(db.usuarioDao)
    }

/*
    @Provides
    @Singleton
    fun provideTorneoOrganizadoDao(db:AppDatabase) = db.torneoOrganizadoDao
*/
    @Provides
    @Singleton
    fun provideTorneoOrganizadoRepository(db:AppDatabase) : ITorneoOrganizadoRepository {
        return TorneoOrganizadoRepositoryImpl(db.torneoOrganizadoDao)
    }
/*
    @Provides
    @Singleton
    fun provideTorneoDao(db:AppDatabase) = db.torneoDao
*/
    @Provides
    @Singleton
    fun provideTorneoRepository(db:AppDatabase) : ITorneoRepository {
        return TorneoRepositoryImpl(db.torneoDao)
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
    fun providePistaRepository(db:AppDatabase) : IPistaRepository {
        return PistaRepositoryImpl(db.pistaDao)
    }
/*
    @Provides
    @Singleton
    fun provideParejaDao(db:AppDatabase) = db.parejaDao
*/
    @Provides
    @Singleton
    fun provideParejaRepository(db:AppDatabase) : IParejaRepository {
        return ParejaRepositoryImpl(db.parejaDao)
    }
  /*
    @Provides
    @Singleton
    fun providePagoDao(db:AppDatabase) = db.pagoDao
*/
    @Provides
    @Singleton
    fun providePagoRepository(db:AppDatabase) : IPagoRepository {
        return PagoRepositoryImpl(db.pagoDao)
    }
/*
    @Provides
    @Singleton
    fun provideOrganizadorDao(db:AppDatabase) = db.organizadorDao
*/
    @Provides
    @Singleton
    fun provideOrganizadorRepository(db:AppDatabase) : IOrganizadorRepository {
        return OrganizadorRepositoryImpl(db.organizadorDao)
    }
/*
    @Provides
    @Singleton
    fun provideJugadorDao(db:AppDatabase) = db.jugadorDao
*/
    @Provides
    @Singleton
    fun provideJugadorRepository(db:AppDatabase) : IJugadorRepository {
        return JugadorRepositoryImpl(db.jugadorDao)
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
/*
    @Provides
    @Singleton
    fun provideEnfrentamientoDao(db:AppDatabase) = db.enfrentamientoDao
*/
    @Provides
    @Singleton
    fun provideEnfrentamientoRepository(db:AppDatabase) : IEnfrentamientoRepository {
        return EnfrentamientoRepositoryImpl(db.enfrentamientoDao)
    }

}