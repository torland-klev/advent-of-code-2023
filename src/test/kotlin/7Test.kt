import klev.`7`
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `7Test` {
    @Test
    fun firstSolution() {
        assertEquals("6440", `7`.firstSolution(testInput))
        assertEquals("251216224", `7`.firstSolution())
    }

    @Test
    fun secondSolution() {
        assertEquals("5905", `7`.secondSolution(testInput))
        assertEquals("500", `7`.secondSolution(listOf("JJJJJ 100", "KKKKK 200")))
        assertEquals("500", `7`.secondSolution(listOf("JJJJJ 100", "JJ8JJ 200")))
        assertEquals("250825971", `7`.secondSolution())
    }

    private val testInput =
        """
        32T3K 765
        T55J5 684
        KK677 28
        KTJJT 220
        QQQJA 483
        """.trimIndent().split("\n")
}
