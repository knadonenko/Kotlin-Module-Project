class Archive {

    private val archives: MutableList<ArchiveData> = mutableListOf()
    private val menuHelper = MenuHelper()
    private val noteWorker = NoteWorker()

    fun createArchive() {
        while (true) {
            println("Введите название архива, который хотите создать:")
            val name = ScannerHelper.readLine()
            if (name.isNotBlank()) {
                archives.add(ArchiveData(name))
                println("Архив $name создан")
                return
            } else {
                println("Название архива не может быть пустым. Введите валидное название архива")
            }
        }
    }

    fun printArchive(archive: ArchiveData) {
        val notesList = archive.getNotesList()
        while (true) {
            menuHelper.showMenu(
                "Архив: ${archive.name}",
                listOf("Создать заметку") + notesList.map { it.name } + "Назад"
            )
            when (val choice = menuHelper.readChoice(notesList.size + 1)) {
                0 -> {
                    val note = noteWorker.createNote()
                    archive.putNotesList(note)
                }
                in 1..notesList.size -> noteWorker.printNoteData(notesList[choice - 1])
                notesList.size + 1 -> return
                else -> println("Ошибка ввода, повторите снова.")
            }
        }
    }

    fun getArchiveList(): List<ArchiveData> {
        return archives
    }
}