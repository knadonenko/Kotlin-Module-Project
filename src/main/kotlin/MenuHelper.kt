class MenuHelper {
    fun showMenu(title: String, options: List<String>?) {
        print("$title:\n")
        options?.withIndex()?.forEach { (index, option) ->
            println("$index. $option")
        }
        println("Введите номер команды:")
    }

    fun readChoice(maxChoice: Int): Int {
        val value = ScannerHelper.readLine()

        if (value.all { char -> !char.isDigit() })
            return -1

        return if (value.toInt() in 0..maxChoice) value.toInt() else -1
    }
}