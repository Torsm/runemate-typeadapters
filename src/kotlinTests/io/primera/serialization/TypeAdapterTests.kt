package io.primera.serialization

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.runemate.game.api.hybrid.location.Area
import com.runemate.game.api.hybrid.location.Coordinate
import io.primera.serialization.adapters.RuneMateTypeAdapterFactory
import org.junit.Assert
import org.junit.Test

class TypeAdapterTests {
    private val gson: Gson = GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .registerTypeAdapterFactory(RuneMateTypeAdapterFactory)
            .create()

    @Test
    fun coordinateTest() {
        val coordinate = Coordinate(10, 10, 0)
        val json = gson.toJson(coordinate).also(::println)
        gson.fromJson(json, Coordinate::class.java).let { deserialized ->
            Assert.assertEquals(coordinate, deserialized)
        }
    }

    @Test
    fun rectangularAreaTest() {
        val area = Area.Rectangular(Coordinate(10, 10, 0), Coordinate(20, 20, 0))
        val json = gson.toJson(area).also(::println)
        gson.fromJson(json, Area::class.java).let { deserialized ->
            Assert.assertEquals(area, deserialized)
        }
    }

    @Test
    fun circularAreaTest() {
        val area = Area.Circular(Coordinate(10, 10, 0), 10.5)
        val json = gson.toJson(area).also(::println)
        gson.fromJson(json, Area::class.java).let { deserialized ->
            Assert.assertEquals(area, deserialized)
        }
    }

    @Test
    fun absoluteAreaTest() {
        val area = Area.Absolute(Coordinate(10, 10, 0), Coordinate(20, 20, 0), Coordinate(13, 13, 0))
        val json = gson.toJson(area).also(::println)
        gson.fromJson(json, Area::class.java).let { deserialized ->
            Assert.assertEquals(area, deserialized)
        }
    }

    @Test
    fun polygonalAreaTest() {
        val area = Area.Polygonal(Coordinate(10, 10, 0), Coordinate(20, 20, 0), Coordinate(13, 13, 0))
        val json = gson.toJson(area).also(::println)
        gson.fromJson(json, Area::class.java).let { deserialized ->
            Assert.assertEquals(area.vertices, (deserialized as Area.Polygonal).vertices)
            //comparing the areas directly will fail because java.awt.Polygon does not override the equals method
        }
    }
}