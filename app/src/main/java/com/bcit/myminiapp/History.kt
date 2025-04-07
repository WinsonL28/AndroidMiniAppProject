package com.bcit.myminiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bcit.myminiapp.data.HistoryEntry
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun History(navController: NavController, historyState: HistoryState) {
    val history = historyState.history
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        ) {
            Text(
                text = "Trial History",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(history.size) { entry ->
                HistoryCard(history[entry], navController)

            }
        }
    }
}

@Composable
fun HistoryCard(historyEntry: HistoryEntry, navController: NavController) {
    val studyId = historyEntry.studyId
    val briefTitle = historyEntry.title
    val timestamp = historyEntry.timestamp

    // Convert the timestamp to a Date object
    val date = Date(timestamp)

    // Format the Date to a human-readable format
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val formattedDate = dateFormat.format(date)
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(vertical = 10.dp)
            .background(Color(0xFFFFCC99), shape = RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .clickable {
                navController.navigate("info/$studyId/$briefTitle")
            }
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(
                text = historyEntry.title,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Unique Trial Code: " + historyEntry.studyId,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Last Access : $formattedDate",
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 12.sp
            )
        }
    }
}

