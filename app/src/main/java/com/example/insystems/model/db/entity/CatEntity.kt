package com.example.insystems.model.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cats")
data class CatEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB) val image: ByteArray,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CatEntity

        if (id != other.id) return false
        if (!image.contentEquals(other.image)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + image.contentHashCode()
        return result
    }
}