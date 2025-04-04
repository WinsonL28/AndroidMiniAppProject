package com.bcit.myminiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bcit.myminiapp.data.Study
import com.bcit.myminiapp.ui.theme.MyMiniAppTheme

@Composable
fun Home(navController: NavController, studyState: StudyState) {
    val studies = studyState.studies ?: emptyList<Study>()  // List<Study>


    LazyColumn {
        items(studies.size) {
            Card(studies[it])  // Assuming 'Card' can accept a Study object
        }
    }
}


@Composable
fun Card(study: Study) {
    MyMiniAppTheme {
        Box(modifier = Modifier
            .padding(16.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(16.dp))
        ) {
            Column (modifier = Modifier.padding(15.dp,
                    )) {
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
}
