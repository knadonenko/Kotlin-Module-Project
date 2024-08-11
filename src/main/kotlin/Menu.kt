class Menu {

    private val archive = Archive()
    private val menuHelper = MenuHelper()

    fun showMenu() {
        while (true) {
            menuHelper.showMenu(
                "Меню архивa",
                listOf("Создать архив") + archive.getArchiveList().map { it.name } + "Выход"
            )
            when (val choice = menuHelper.readChoice(archive.getArchiveList().size + 1)) {
                0 -> archive.createArchive()
                in 1..archive.getArchiveList().size -> archive.printArchive(archive.getArchiveList()[choice - 1])
                archive.getArchiveList().size + 1 -> {
                    println("Программа завершена. До свидания!")
                    return
                }
                else -> println("Ошибка ввода, повторите снова.")
            }
        }
    }

}