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
        assertEquals("86841457", `3`.secondSolution())
        assertEquals("467835", `3`.secondSolution(testInput))
        assertEquals("6756", `3`.secondSolution(testInput2))
        assertEquals("6756", `3`.secondSolution(testInput3))
        assertEquals("442", `3`.secondSolution(testInput4))
        assertEquals("0", `3`.secondSolution(testInput5))
        assertEquals("49096", `3`.secondSolution(testInput6))
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

    private val testInput2 =
        """
        12.......*..
        +.........34
        .......-12..
        ..78........
        ..*....60...
        78..........
        .......23...
        ....90*12...
        ............
        2.2......12.
        .*.........*
        1.1.......56
        """.trimIndent().split("\n")

    private val testInput3 =
        """
        12.......*..
        +.........34
        .......-12..
        ..78........
        ..*....60...
        78.........9
        .5.....23..$
        8...90*12...
        ............
        2.2......12.
        .*.........*
        1.1..503+.56
        """.trimIndent().split("\n")

    private val testInput4 =
        """
        .......5......
        ..7*..*.......
        ...*13*.......
        .......15.....
        """.trimIndent().split("\n")

    private val testInput5 =
        """
        ........
        .24..4..
        ......*.
        """.trimIndent().split("\n")

    private val testInput6 =
        """
        ........
        136.361.
        ...*....
        """.trimIndent().split("\n")
}
