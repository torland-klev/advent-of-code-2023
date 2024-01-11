import klev.`3`
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `3Test` {
    @Test
    fun firstSolution() {
        assertEquals("4361", `3`.firstSolution(testInput))
        assertEquals("559667", `3`.firstSolution())
    }

    @Test
    fun secondSolution() {
        assertEquals("467835", `3`.secondSolution(testInput))
    }

    private val testInput =
        """
        467..114..
        ...*......
        ..35..633.
        ......#...
        617*......
        .....+.58.
        ..592.....
        ......755.
        ...$.*....
        .664.598..
        """.trimIndent().split("\n")
}
