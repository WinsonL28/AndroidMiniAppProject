package com.bcit.myminiapp.data

class HistoryRepository(private val dao: HistoryDao) {

    fun addStudyToHistory(studyId: String, title: String) {
        val entry = HistoryEntry(
            studyId = studyId,
            title = title,
            timestamp = System.currentTimeMillis()
        )
        dao.insert(entry)
    }

    fun getHistory(): List<HistoryEntry> {
        return dao.getAll()

    }
}