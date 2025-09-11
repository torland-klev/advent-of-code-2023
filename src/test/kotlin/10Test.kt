import klev.`10`
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `10Test` {

    @Test
    fun firstSolution() {
        assertEquals("8", `10`.firstSolution(testInput))
        assertEquals("6757", `10`.firstSolution())
    }

    @Test
    fun secondSolution() {
        assertEquals("2", `10`.secondSolution(testInput))
        assertEquals("1112", `10`.secondSolution())
    }

    private val testInput =
        """
        7-F7-
        .FJ|7
        SJLL7
        |F--J
        LJ.LJ
        """.trimIndent().split("\n")
}
