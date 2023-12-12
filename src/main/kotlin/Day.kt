package klev

interface Day {
    fun input(): String

    fun firstSolution(): String

    fun secondSolution(input: List<String> = splitInput()): String

    fun splitInput() = input().split(System.lineSeparator())

    fun print() = this::class.simpleName + " " + firstSolution() + " " + secondSolution()
}
