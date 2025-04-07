package com.bcit.myminiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Info(studyState: StudyState, ) {

    InfoCard(studyState)
}

@Composable
fun InfoCard(studyState: StudyState) {
    val study = studyState.study

    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0xFFFFF9C4))
    ) {
        LazyColumn(
            modifier = Modifier.padding(15.dp)
        ) {
            item {
                Text(
                    text = study?.protocolSection?.identificationModule?.officialTitle
                        ?: "No Title Available",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }

            item {
                Spacer(modifier = Modifier.padding(vertical = 20.dp))
            }

            item {
                Text(
                    text = study?.protocolSection?.descriptionModule?.detailedDescription
                        ?: "No Description Available",
                    fontSize = 15.sp
                )
            }

            item {
                Spacer(modifier = Modifier.padding(vertical = 20.dp))
            }

            item {
                Text(
                    text = "Status of Trial",
                    fontSize = 15.sp
                )
            }

            item {
                Row {
                    Text(
                        text = "Start date: ",
                        fontSize = 10.sp
                    )
                    Spacer(modifier = Modifier.padding(8.dp)) // Changed to width for horizontal spacing
                    Text(
                        text = study?.protocolSection?.statusModule?.startDateStruct?.date ?: "NA",
                        fontSize = 10.sp
                    )
                }
            }

            item {
                Row {
                    Text(
                        text = "End date: ",
                        fontSize = 10.sp
                    )
                    Spacer(modifier = Modifier.padding(8.dp)) // Changed to width for horizontal spacing
                    Text(
                        text = study?.protocolSection?.statusModule?.completionDateStruct?.date
                            ?: "NA",
                        fontSize = 10.sp
                    )
                }
            }

            item {
                Text(
                    text = study?.protocolSection?.statusModule?.overallStatus ?: "NA",
                    fontSize = 10.sp
                )
            }

            item {
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "More details go to:",
                    fontSize = 10.sp
                )
                Text(
                    text = "https://clinicaltrials.gov/study/${study?.protocolSection?.identificationModule?.id}"
                )
            }
        }

    }
}
