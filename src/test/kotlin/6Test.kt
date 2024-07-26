import klev.`6`
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `6Test` {
    @Test
    fun firstSolution() {
        assertEquals("288", `6`.firstSolution(testInput))
        assertEquals("211904", `6`.firstSolution())
    }

    @Test
    fun secondSolution() {
        assertEquals("71503", `6`.secondSolution(testInput))
        assertEquals("43364472", `6`.secondSolution())
    }

    private val testInput =
        """
        Time:      7  15   30
        Distance:  9  40  200
        """.trimIndent().split("\n")
}
