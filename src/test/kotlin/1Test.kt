import klev.`1`
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `1Test` {
    @Test
    fun secondSolution() {
        assertEquals("29", `1`.secondSolution(listOf("twonine")))
        assertEquals("22", `1`.secondSolution(listOf("pfnv2")))
        assertEquals("82", `1`.secondSolution(listOf("eightwo")))
        assertEquals("83", `1`.secondSolution(listOf("eighthree")))
        assertEquals("79", `1`.secondSolution(listOf("sevenine")))
        assertEquals("18", `1`.secondSolution(listOf("oneightsdfsd")))
        assertEquals("12", `1`.secondSolution(listOf("oneightwo")))
        assertEquals("13", `1`.secondSolution(listOf("oneighthree")))
        assertEquals("77", `1`.secondSolution(listOf("treb7uchet")))

        assertEquals(
            "281",
            `1`.secondSolution(
                listOf("two1nine", "eightwothree", "abcone2threexyz", "xtwone3four", "4nineeightseven2", "zoneight234", "7pqrstsixteen"),
            ),
        )

        assertEquals("53515", `1`.secondSolution())
    }
}
