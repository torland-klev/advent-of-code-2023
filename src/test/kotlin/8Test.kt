import klev.`8`
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `8Test` {
    @Test
    fun firstSolution() {
        assertEquals("2", `8`.firstSolution(testInput))
        assertEquals("6", `8`.firstSolution(testInput2))
        assertEquals("15871", `8`.firstSolution())
    }

    @Test
    fun secondSolution() {
        assertEquals("6", `8`.secondSolution(testInput3))
        assertEquals("11283670395017", `8`.secondSolution())
    }

    private val testInput =
        """
        RL

        AAA = (BBB, CCC)
        BBB = (DDD, EEE)
        CCC = (ZZZ, GGG)
        DDD = (DDD, DDD)
        EEE = (EEE, EEE)
        GGG = (GGG, GGG)
        ZZZ = (ZZZ, ZZZ)
        """.trimIndent().split("\n")

    private val testInput2 =
        """
        LLR

        AAA = (BBB, BBB)
        BBB = (AAA, ZZZ)
        ZZZ = (ZZZ, ZZZ)
        """.trimIndent().split("\n")

    private val testInput3 =
        """
        LR

        11A = (11B, XXX)
        11B = (XXX, 11Z)
        11Z = (11B, XXX)
        22A = (22B, XXX)
        22B = (22C, 22C)
        22C = (22Z, 22Z)
        22Z = (22B, 22B)
        XXX = (XXX, XXX)
        """.trimIndent().split("\n")
}
