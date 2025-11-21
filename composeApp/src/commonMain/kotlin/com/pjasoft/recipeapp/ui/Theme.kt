package com.pjasoft.recipeapp.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import recipeapp512.composeapp.generated.resources.SimpleHandmade
import recipeapp512.composeapp.generated.resources.Res


private val LightColors = lightColorScheme(
    primary = PrimaryColorLight,
    secondary = SecondaryColorLight,
    background = BackgroundColorLight,
    surface = SurfaceColorLight,
    onPrimary = Color.White,
    onBackground = TextPrimaryLight,
    onSurface = TextPrimaryLight,
    surfaceVariant = Color(0xFFFFE8C7),
    onSurfaceVariant = TextSecondaryLight,
    outline = OutlineLight
)

private val DarkColors = darkColorScheme(
    primary = PrimaryColorDark,
    secondary = SecondaryColorDark,
    background = BackgroundColorDark,
    surface = SurfaceColorDark,
    onPrimary = Color.Black,
    onBackground = TextPrimaryDark,
    onSurface = TextPrimaryDark,
    surfaceVariant = Color(0xFF2A2621),
    onSurfaceVariant = TextSecondaryDark,
    outline = OutlineDark
)

@Composable
fun SimpleHandmadeFontFamily() : FontFamily{
    return FontFamily(
        Font(Res.font.SimpleHandmade)
    )
}

@Composable
fun HeyCommicTypo() = Typography(
    bodyLarge = TextStyle(
        fontFamily = SimpleHandmadeFontFamily(),
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = SimpleHandmadeFontFamily(),
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = SimpleHandmadeFontFamily(),
        fontSize = 12.sp
    ),
    titleLarge = TextStyle(
        fontFamily = SimpleHandmadeFontFamily(),
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    ),
    headlineMedium = TextStyle(
        fontFamily = SimpleHandmadeFontFamily(),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    labelLarge = TextStyle(
        fontFamily = SimpleHandmadeFontFamily(),
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
)


@Composable
fun RecipeTheme(
    content : @Composable () -> Unit
){
    val colors = if (isSystemInDarkTheme()) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = HeyCommicTypo(),
        content = content
    )
}
