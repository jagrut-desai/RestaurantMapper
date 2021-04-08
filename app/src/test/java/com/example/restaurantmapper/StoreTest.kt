package com.example.restaurantmapper

import com.example.restaurantmapper.data.restaurant.*
import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.justRun
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class StoreTest {

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `testShortDescription when description is empty`() {
        val store = Store(
            1.0,
            1,
            "",
            1,
            DeliveryFeeMonetaryFields("", 2, "", 1),
            "",
            "",
            0.0,
            1,
            ExtraSosDeliveryFeeMonetaryFields("", 1, "", 1),
            "",
            1,
            true,
            true,
            Location(1.0, 1.0),
            listOf(),
            listOf(),
            "",
            "",
            "",
            1,
            1,
            1,
            1,
            Status(true, listOf(), false, false, ""),
            ""
        )

        assertEquals("", store.getShortDescription())
    }

    @Test
    fun `testShortDescription when description is only one word`() {
        val store = Store(
            1.0,
            1,
            "",
            1,
            DeliveryFeeMonetaryFields("", 2, "", 1),
            "Pizza",
            "",
            0.0,
            1,
            ExtraSosDeliveryFeeMonetaryFields("", 1, "", 1),
            "",
            1,
            true,
            true,
            Location(1.0, 1.0),
            listOf(),
            listOf(),
            "",
            "",
            "",
            1,
            1,
            1,
            1,
            Status(true, listOf(), false, false, ""),
            ""
        )

        assertEquals("Pizza", store.getShortDescription())
    }

    @Test
    fun `testShortDescription when description is multiple words`() {
        val store = Store(
            1.0,
            1,
            "",
            1,
            DeliveryFeeMonetaryFields("", 2, "", 1),
            "Pizza, Pasta, Sauce, Bread",
            "",
            0.0,
            1,
            ExtraSosDeliveryFeeMonetaryFields("", 1, "", 1),
            "",
            1,
            true,
            true,
            Location(1.0, 1.0),
            listOf(),
            listOf(),
            "",
            "",
            "",
            1,
            1,
            1,
            1,
            Status(true, listOf(), false, false, ""),
            ""
        )

        assertEquals("Pizza, Pasta", store.getShortDescription())
    }

    @Test
    fun `getDistanceWithTwoDecimalPoint`() {
        val store = Store(
            1.0,
            1,
            "",
            1,
            DeliveryFeeMonetaryFields("", 2, "", 1),
            "Pizza",
            "",
            0.45214325352,
            1,
            ExtraSosDeliveryFeeMonetaryFields("", 1, "", 1),
            "",
            1,
            true,
            true,
            Location(1.0, 1.0),
            listOf(),
            listOf(),
            "",
            "",
            "",
            1,
            1,
            1,
            1,
            Status(true, listOf(), false, false, ""),
            ""
        )

        assertEquals("0.45", store.getDistanceWithTwoDecimalPoint())
    }

    @Test
    fun `getImageUrl when both image source are null`() {
        val store = Store(
            1.0,
            1,
            null,
            1,
            DeliveryFeeMonetaryFields("", 2, "", 1),
            "Pizza",
            "",
            0.45214325352,
            1,
            ExtraSosDeliveryFeeMonetaryFields("", 1, "", 1),
            null,
            1,
            true,
            true,
            Location(1.0, 1.0),
            listOf(),
            listOf(),
            "",
            "",
            "",
            1,
            1,
            1,
            1,
            Status(true, listOf(), false, false, ""),
            ""
        )

        assertEquals(" ", store.getImageUrl())
    }

    @Test
    fun `getImageUrl when header image is null`() {
        val store = Store(
            1.0,
            1,
            "null",
            1,
            DeliveryFeeMonetaryFields("", 2, "", 1),
            "Pizza",
            "",
            0.45214325352,
            1,
            ExtraSosDeliveryFeeMonetaryFields("", 1, "", 1),
            null,
            1,
            true,
            true,
            Location(1.0, 1.0),
            listOf(),
            listOf(),
            "",
            "",
            "",
            1,
            1,
            1,
            1,
            Status(true, listOf(), false, false, ""),
            ""
        )

        assertEquals("null", store.getImageUrl())
    }

    @Test
    fun `getImageUrl when cover image is null`() {
        val store = Store(
            1.0,
            1,
            null,
            1,
            DeliveryFeeMonetaryFields("", 2, "", 1),
            "Pizza",
            "",
            0.45214325352,
            1,
            ExtraSosDeliveryFeeMonetaryFields("", 1, "", 1),
            "header image",
            1,
            true,
            true,
            Location(1.0, 1.0),
            listOf(),
            listOf(),
            "",
            "",
            "",
            1,
            1,
            1,
            1,
            Status(true, listOf(), false, false, ""),
            ""
        )

        assertEquals("header image", store.getImageUrl())
    }

}