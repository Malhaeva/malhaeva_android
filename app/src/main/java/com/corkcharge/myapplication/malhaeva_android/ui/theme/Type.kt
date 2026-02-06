package com.corkcharge.myapplication.malhaeva_android.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.corkcharge.myapplication.malhaeva_android.R

/* -------------------------------
 * Font Families
 * ------------------------------- */
val malhaevaFontBold = FontFamily(Font(R.font.pretendard_bold))
val malhaevaFontSemiBold = FontFamily(Font(R.font.pretendard_semibold))
val malhaevaFontMedium = FontFamily(Font(R.font.pretendard_medium))
val malhaevaFontRegular = FontFamily(Font(R.font.pretendard_regular))

/* -------------------------------
 * Custom Typography System
 * ------------------------------- */
@Immutable
data class MalhaevaTypography(
    // Title
    val B_30: TextStyle,
    val B_28: TextStyle,
    val B_26: TextStyle,
    val SB_24: TextStyle,
    val SB_22: TextStyle,
    val B_20: TextStyle,
    val SB_20: TextStyle,
    val M_20: TextStyle,
    val B_12: TextStyle,

    // Body
    val SB_18: TextStyle,
    val R_18: TextStyle,
    val B_17: TextStyle,
    val M_17: TextStyle,
    val R_17: TextStyle,
    val SB_16: TextStyle,
    val M_16: TextStyle,
    val R_16: TextStyle,
    val SB_12: TextStyle,

    // Caption
    val R_15: TextStyle,
    val SB_14: TextStyle,
    val R_14: TextStyle,
    val R_12: TextStyle
)

val defaultMalhaevaTypography = MalhaevaTypography(
    // Title
    B_30 = TextStyle(
        fontFamily = malhaevaFontBold,
        fontSize = 30.sp,
        lineHeight = 1.3.em,
        letterSpacing = (-0.02).em,
    ),
    B_28 = TextStyle(
        fontFamily = malhaevaFontBold,
        fontSize = 28.sp,
        lineHeight = 1.3.em,
        letterSpacing = (-0.02).em,
    ),
    B_26 = TextStyle(
        fontFamily = malhaevaFontBold,
        fontSize = 26.sp,
        lineHeight = 1.3.em,
        letterSpacing = (-0.02).em,
    ),
    SB_24 = TextStyle(
        fontFamily = malhaevaFontSemiBold,
        fontSize = 24.sp,
        lineHeight = 1.3.em,
        letterSpacing = (-0.02).em,
    ),
    SB_22 = TextStyle(
        fontFamily = malhaevaFontSemiBold,
        fontSize = 22.sp,
        lineHeight = 1.3.em,
        letterSpacing = (-0.02).em,
    ),
    B_20 = TextStyle(
        fontFamily = malhaevaFontBold,
        fontSize = 20.sp,
        lineHeight = 1.3.em,
        letterSpacing = (-0.02).em,
    ),
    SB_20 = TextStyle(
        fontFamily = malhaevaFontSemiBold,
        fontSize = 20.sp,
        lineHeight = 1.3.em,
        letterSpacing = (-0.02).em,
    ),
    M_20 = TextStyle(
        fontFamily = malhaevaFontMedium,
        fontSize = 20.sp,
        lineHeight = 1.3.em,
        letterSpacing = (-0.02).em,
    ),

    // Body
    SB_18 = TextStyle(
        fontFamily = malhaevaFontSemiBold,
        fontSize = 18.sp,
        lineHeight = 1.6.em,
        letterSpacing = 0.02.em,
    ),
    R_18 = TextStyle(
        fontFamily = malhaevaFontRegular,
        fontSize = 18.sp,
        lineHeight = 1.6.em,
    ),
    B_17 = TextStyle(
        fontFamily = malhaevaFontBold,
        fontSize = 17.sp,
        lineHeight = 1.6.em,
        letterSpacing = 0.02.em,
    ),
    M_17 = TextStyle(
        fontFamily = malhaevaFontMedium,
        fontSize = 17.sp,
        lineHeight = 1.6.em,
        letterSpacing = 0.02.em,
    ),
    R_17 = TextStyle(
        fontFamily = malhaevaFontRegular,
        fontSize = 17.sp,
        lineHeight = 1.6.em,
    ),
    SB_16 = TextStyle(
        fontFamily = malhaevaFontSemiBold,
        fontSize = 16.sp,
        lineHeight = 1.6.em,
    ),
    M_16 = TextStyle(
        fontFamily = malhaevaFontMedium,
        fontSize = 16.sp,
        lineHeight = 1.6.em,
    ),
    R_16 = TextStyle(
        fontFamily = malhaevaFontRegular,
        fontSize = 16.sp,
        lineHeight = 1.6.em,
    ),

    // Caption
    R_15 = TextStyle(
        fontFamily = malhaevaFontRegular,
        fontSize = 15.sp,
        lineHeight = 1.5.em,
        letterSpacing = 0.01.em,
    ),
    SB_14 = TextStyle(
        fontFamily = malhaevaFontSemiBold,
        fontSize = 14.sp,
        lineHeight = 1.5.em,
        letterSpacing = 0.01.em,
    ),
    R_14 = TextStyle(
        fontFamily = malhaevaFontRegular,
        fontSize = 14.sp,
        lineHeight = 1.5.em,
        letterSpacing = 0.01.em,
    ),
    R_12 = TextStyle(
        fontFamily = malhaevaFontRegular,
        fontSize = 12.sp,
        lineHeight = 1.5.em,
        letterSpacing = 0.01.em,
    ),
    SB_12 = TextStyle(
        fontFamily = malhaevaFontSemiBold,
        fontSize = 12.sp,
        lineHeight = 1.5.em,
        letterSpacing = 0.01.em,
    ),
    B_12 = TextStyle(
        fontFamily = malhaevaFontBold,
        fontSize = 12.sp,
        lineHeight = 1.5.em,
        letterSpacing = 0.01.em,
    )
)

/* -------------------------------
 * CompositionLocal
 * ------------------------------- */
val LocalMalhaevaTypography = staticCompositionLocalOf { defaultMalhaevaTypography }

/* -------------------------------
 * Material Typography (optional)
 * ------------------------------- */
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = malhaevaFontRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    )
)
