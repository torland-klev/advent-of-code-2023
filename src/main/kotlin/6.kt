package klev

object `6` : Day {
    override fun firstSolution(input: List<String>): String {
        val times = input[0].substringAfter(":").split(" ").filter { it.isNotBlank() }.map { it.toLong() }
        val distanceRecords = input[1].substringAfter(":").split(" ").filter { it.isNotBlank() }.map { it.toLong() }

        return times.mapIndexed { index, time -> findWays(time, distanceRecords[index]) }.reduce(Long::times).toString()
    }

    private fun findWays(
        time: Long,
        record: Long,
    ) = (0..time).count { (time - it) * it > record }.toLong()

    override fun secondSolution(input: List<String>): String {
        val time = input[0].substringAfter(":").split(" ").filter { it.isNotBlank() }.joinToString("").toLong()
        val distanceRecord = input[1].substringAfter(":").split(" ").filter { it.isNotBlank() }.joinToString("").toLong()

        return findWays(time, distanceRecord).toString()
    }

    override fun input() =
        """
        Time:        56     71     79     99
        Distance:   334   1135   1350   2430
        """.trimIndent()
}
