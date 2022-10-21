package com.rabarka.day.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rabarka.day.R

val work_sans = FontFamily(
    Font(R.font.worksans_regular, FontWeight.Normal),
    Font(R.font.worksans_bold, FontWeight.Bold),
)
val seymourOne = FontFamily(Font(R.font.seymour_one_regular, FontWeight.Normal))

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = work_sans,
    h1 = TextStyle(
        fontFamily = seymourOne,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),

    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

)