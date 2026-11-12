package diala.b.dialaapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = FlorifyRosePrimary,
    onPrimary = FlorifySurface,
    primaryContainer = FlorifyRoseLight,
    onPrimaryContainer = FlorifyRosePrimaryDark,
    secondary = FlorifySageSecondary,
    onSecondary = FlorifySurface,
    secondaryContainer = FlorifySageLight,
    onSecondaryContainer = FlorifySageSecondary,
    background = FlorifyBackground,
    onBackground = FlorifyOnSurface,
    surface = FlorifySurface,
    onSurface = FlorifyOnSurface,
    onSurfaceVariant = FlorifyOnSurfaceVariant,
    outline = FlorifyOutline,
    outlineVariant = FlorifyOutline,
)

@Composable
fun FlorifyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content,
    )
}
