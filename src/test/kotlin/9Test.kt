import klev.`9`
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `9Test` {
    @Test
    fun firstSolution() {
        assertEquals("114", `9`.firstSolution(testInput))
        assertEquals("1938800261", `9`.firstSolution())
    }

    @Test
    fun secondSolution() {
        assertEquals("2", `9`.secondSolution(testInput))
        assertEquals("1112", `9`.secondSolution())
    }

    private val testInput =
        """
        0 3 6 9 12 15
        1 3 6 10 15 21
        10 13 16 21 30 45
        """.trimIndent().split("\n")
}
