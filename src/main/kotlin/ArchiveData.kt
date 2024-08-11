class ArchiveData(val name: String) {

    private val notesList = mutableListOf<NoteData>()

    fun putNotesList(list: NoteData) {
        notesList.add(list)
    }

    fun getNotesList(): MutableList<NoteData> {
        return notesList
    }

}