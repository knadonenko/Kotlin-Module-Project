class NoteWorker {

    fun createNote(): NoteData {
        while (true) {
            println("Введите имя заметки:")
            val name = ScannerHelper.readLine()
            if (name.isNotBlank()) {
                println("Введите содержимое заметки:")
                val content = ScannerHelper.readLine()
                if (content.isNotBlank()) {
                    println("Заметка $name с содержимым \n$content создана успешно")
                    return NoteData(name, content)
                } else {
                    println("Содержимое заметки не может быть пустым. Повторите ввод")
                }
            } else {
                println("Имя заметки не может быть пустым. Повторите ввод")
            }
        }
    }

    fun printNoteData(note: NoteData) {
        println("Название заметки: ${note.name}")
        println("Содержимое: ${note.content}")
    }

}