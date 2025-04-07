import com.bcit.myminiapp.data.HistoryDao
import com.bcit.myminiapp.data.HistoryEntry

class HistoryRepository(private val dao: HistoryDao) {

    suspend fun addStudyToHistory(studyId: String, title: String) {
        val entry = HistoryEntry(
            studyId = studyId,
            title = title,
            timestamp = System.currentTimeMillis()
        )
        dao.insert(entry)
        dao.trimToLast50() // Keep it at most 50
    }

    suspend fun getHistory(): List<HistoryEntry> = dao.getAll()
}