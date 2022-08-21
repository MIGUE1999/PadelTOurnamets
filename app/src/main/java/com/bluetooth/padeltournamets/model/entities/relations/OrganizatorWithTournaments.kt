package com.bluetooth.padeltournamets.model.entities.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.bluetooth.padeltournamets.model.entities.OrganizatorEntity
import com.bluetooth.padeltournamets.model.entities.TournamentEntity

@Entity
data class OrganizatorWithTournaments (
    @Embedded val organizator: OrganizatorEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "idOrganizator"
    )
    val tournaments : List<TournamentEntity>

        )

