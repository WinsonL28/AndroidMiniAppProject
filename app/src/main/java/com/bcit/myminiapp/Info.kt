package com.bcit.myminiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcit.myminiapp.data.Study
import com.bcit.myminiapp.ui.theme.MyMiniAppTheme

@Composable
fun Info(studyState: StudyState) {
    InfoCard(studyState)
}

@Composable
fun InfoCard(studyState: StudyState) {
    val study = studyState.study
    MyMiniAppTheme {
        Box(modifier = Modifier
            .padding(16.dp)
            .background(Color.Yellow, shape = RoundedCornerShape(16.dp))
        ) {
            Column (modifier = Modifier.padding(15.dp,
            )) {
                Text(
                    text = study?.protocolSection?.identificationModule?.officialTitle ?: "No Title Available",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.padding(vertical = 20.dp))

                Text(
                    text = study?.protocolSection?.descriptionModule?.detailedDescription ?: "No Description Available",
                    fontSize = 15.sp
                )

                Text(
                    text = study?.protocolSection?.statusModule?.startDateStruct ?: "No",
                    fontSize = 15.sp
                )
            }
        }
    }
}