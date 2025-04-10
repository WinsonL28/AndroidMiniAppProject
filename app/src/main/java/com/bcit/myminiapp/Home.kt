package com.bcit.myminiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.bcit.myminiapp.data.Study

@Composable
fun Home(navController: NavController, studiesState: StudiesState) {
    val studies = studiesState.studies
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        ) {
            Text(
                text = "Clinical Trials",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

        }

        LazyColumn {
            items(studies.size) {
                Card(studies[it], navController)
            }
        }
    }
}


@Composable
fun Card(study: Study, navController: NavController) {
    val studyId = study.protocolSection.identificationModule?.id
    val briefTitle = study.protocolSection.identificationModule?.briefTitle

    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(vertical = 10.dp)
            .background(Color(0xFFADD8E6), shape = RoundedCornerShape(16.dp))
            .clickable { navController.navigate("info/$studyId/$briefTitle") }
    ) {
        Column(
            modifier = Modifier.padding(
                15.dp,
            )
        ) {
            Text(
                text = study.protocolSection.identificationModule?.briefTitle ?: "No ID Available",
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            study.protocolSection.descriptionModule?.let {
                Text(
                    text = it.briefSummary.take(150) + " ...",
                    fontSize = 15.sp
                )
            }
        }
    }
}
