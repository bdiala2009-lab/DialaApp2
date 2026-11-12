package diala.b.dialaapp.ui.signin

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material.icons.rounded.LocalFlorist
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import diala.b.dialaapp.ui.theme.FlorifyBackground
import diala.b.dialaapp.ui.theme.FlorifyOnSurface
import diala.b.dialaapp.ui.theme.FlorifyOnSurfaceVariant
import diala.b.dialaapp.ui.theme.FlorifyOutline
import diala.b.dialaapp.ui.theme.FlorifyRoseLight
import diala.b.dialaapp.ui.theme.FlorifyRosePrimary
import diala.b.dialaapp.ui.theme.FlorifyRosePrimaryDark
import diala.b.dialaapp.ui.theme.FlorifySageLight
import diala.b.dialaapp.ui.theme.FlorifySageSecondary
import diala.b.dialaapp.ui.theme.FlorifySurface
import diala.b.dialaapp.ui.theme.FlorifyTheme

/**
 * Modern, elegant, and responsive Sign-In Screen for 'Florify'
 * Smart Flower Gifting and Delivery Platform.
 */
@Composable
fun FlorifySignInScreen(
    onSignInClick: (email: String, password: String) -> Unit = { _, _ -> },
    onSignUpClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {},
    onGoogleSignInClick: () -> Unit = {},
    onAppleSignInClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    // Subtle fade-in animation trigger
    var isVisible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        isVisible = true
    }

    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FlorifyBackground)
            .systemBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(durationMillis = 700)) +
                    slideInVertically(
                        initialOffsetY = { 60 },
                        animationSpec = tween(durationMillis = 700)
                    )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 460.dp)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 24.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Header / App Logo Placeholder
                FlorifyLogoHeader()

                Spacer(modifier = Modifier.height(28.dp))

                // Sign In Form Container
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(
                            elevation = 8.dp,
                            shape = RoundedCornerShape(24.dp),
                            spotColor = FlorifyRosePrimary.copy(alpha = 0.15f)
                        ),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = FlorifySurface)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    ) {
                        Text(
                            text = "Welcome Back",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.Bold,
                                color = FlorifyOnSurface
                            )
                        )

                        Text(
                            text = "Sign in to send flowers & spread joy",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = FlorifyOnSurfaceVariant
                            ),
                            modifier = Modifier.padding(top = 4.dp, bottom = 20.dp)
                        )

                        // Email Field
                        OutlinedTextField(
                            value = email,
                            onValueChange = {
                                email = it
                                emailError = null
                            },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text("Email Address") },
                            placeholder = { Text("name@example.com") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Email,
                                    contentDescription = "Email Icon",
                                    tint = FlorifyRosePrimary
                                )
                            },
                            isError = emailError != null,
                            supportingText = emailError?.let { { Text(it) } },
                            singleLine = true,
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email,
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions(
                                onNext = { focusManager.moveFocus(FocusDirection.Down) }
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = FlorifyRosePrimary,
                                unfocusedBorderColor = FlorifyOutline,
                                focusedLabelColor = FlorifyRosePrimary,
                                cursorColor = FlorifyRosePrimary,
                                focusedContainerColor = FlorifyBackground.copy(alpha = 0.5f),
                                unfocusedContainerColor = FlorifyBackground.copy(alpha = 0.5f)
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Password Field
                        OutlinedTextField(
                            value = password,
                            onValueChange = {
                                password = it
                                passwordError = null
                            },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text("Password") },
                            placeholder = { Text("Enter your password") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Outlined.Lock,
                                    contentDescription = "Lock Icon",
                                    tint = FlorifyRosePrimary
                                )
                            },
                            trailingIcon = {
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                    Icon(
                                        imageVector = if (passwordVisible) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff,
                                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                        tint = FlorifyOnSurfaceVariant
                                    )
                                }
                            },
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            isError = passwordError != null,
                            supportingText = passwordError?.let { { Text(it) } },
                            singleLine = true,
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    focusManager.clearFocus()
                                    validateAndSubmit(
                                        email, password,
                                        onEmailErr = { emailError = it },
                                        onPassErr = { passwordError = it },
                                        onSuccess = onSignInClick
                                    )
                                }
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = FlorifyRosePrimary,
                                unfocusedBorderColor = FlorifyOutline,
                                focusedLabelColor = FlorifyRosePrimary,
                                cursorColor = FlorifyRosePrimary,
                                focusedContainerColor = FlorifyBackground.copy(alpha = 0.5f),
                                unfocusedContainerColor = FlorifyBackground.copy(alpha = 0.5f)
                            )
                        )

                        // Forgot Password Link
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            TextButton(
                                onClick = onForgotPasswordClick,
                                modifier = Modifier.padding(vertical = 0.dp)
                            ) {
                                Text(
                                    text = "Forgot Password?",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = FlorifyRosePrimary,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Prominent Sign In Primary Button
                        Button(
                            onClick = {
                                focusManager.clearFocus()
                                validateAndSubmit(
                                    email, password,
                                    onEmailErr = { emailError = it },
                                    onPassErr = { passwordError = it },
                                    onSuccess = onSignInClick
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp)
                                .shadow(
                                    elevation = 6.dp,
                                    shape = RoundedCornerShape(16.dp),
                                    spotColor = FlorifyRosePrimary.copy(alpha = 0.4f)
                                ),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = FlorifyRosePrimary,
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Sign In",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Divider: "or continue with"
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        color = FlorifyOutline,
                        thickness = 1.dp
                    )
                    Text(
                        text = "or continue with",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = FlorifyOnSurfaceVariant,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        color = FlorifyOutline,
                        thickness = 1.dp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Social Login Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    SocialLoginButton(
                        text = "Google",
                        iconContent = { GoogleIconBadge() },
                        onClick = onGoogleSignInClick,
                        modifier = Modifier.weight(1f)
                    )
                    SocialLoginButton(
                        text = "Apple",
                        iconContent = { AppleIconBadge() },
                        onClick = onAppleSignInClick,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Footer: Sign Up Link
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text(
                        text = "Don't have an account? ",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = FlorifyOnSurfaceVariant
                        )
                    )
                    Text(
                        text = "Sign Up",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = FlorifyRosePrimary,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.clickable { onSignUpClick() }
                    )
                }
            }
        }
    }
}

/**
 * App Logo Header with Floral Branding Placeholder
 */
@Composable
private fun FlorifyLogoHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 12.dp)
    ) {
        // Floral Logo Badge Placeholder
        Box(
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(FlorifyRoseLight, FlorifySageLight)
                    )
                )
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(FlorifyRosePrimary, FlorifySageSecondary)
                    ),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.LocalFlorist,
                contentDescription = "Florify Logo",
                tint = FlorifyRosePrimary,
                modifier = Modifier.size(38.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Florify",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.ExtraBold,
                color = FlorifyRosePrimaryDark,
                letterSpacing = 1.2.sp
            )
        )

        Text(
            text = "Smart Flower Gifting & Delivery",
            style = MaterialTheme.typography.labelMedium.copy(
                color = FlorifySageSecondary,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.5.sp
            ),
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}

/**
 * Custom Styled Social Login Button
 */
@Composable
private fun SocialLoginButton(
    text: String,
    iconContent: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        modifier = modifier.height(50.dp),
        shape = RoundedCornerShape(16.dp),
        color = FlorifySurface,
        border = androidx.compose.foundation.BorderStroke(1.dp, FlorifyOutline),
        shadowElevation = 1.dp
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            iconContent()
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = FlorifyOnSurface
                )
            )
        }
    }
}

/**
 * Clean Vector Google Logo Badge
 */
@Composable
private fun GoogleIconBadge() {
    Box(
        modifier = Modifier
            .size(22.dp)
            .clip(CircleShape)
            .background(Color(0xFFF1F3F4)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "G",
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Black,
                color = Color(0xFF4285F4),
                textAlign = TextAlign.Center
            )
        )
    }
}

/**
 * Clean Vector Apple Logo Badge
 */
@Composable
private fun AppleIconBadge() {
    Box(
        modifier = Modifier
            .size(22.dp)
            .clip(CircleShape)
            .background(Color(0xFF111111)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "",
            style = MaterialTheme.typography.labelSmall.copy(
                color = Color.White,
                fontSize = 12.sp
            )
        )
    }
}

private fun validateAndSubmit(
    emailVal: String,
    passVal: String,
    onEmailErr: (String?) -> Unit,
    onPassErr: (String?) -> Unit,
    onSuccess: (String, String) -> Unit
) {
    var isValid = true
    val emailTrimmed = emailVal.trim()
    val passTrimmed = passVal.trim()

    if (emailTrimmed.isEmpty()) {
        onEmailErr("Email address is required")
        isValid = false
    } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailTrimmed).matches()) {
        onEmailErr("Please enter a valid email address")
        isValid = false
    } else {
        onEmailErr(null)
    }

    if (passTrimmed.isEmpty()) {
        onPassErr("Password is required")
        isValid = false
    } else {
        onPassErr(null)
    }

    if (isValid) {
        onSuccess(emailTrimmed, passTrimmed)
    }
}

@Preview(showBackground = true, widthDp = 380, heightDp = 800)
@Composable
fun FlorifySignInScreenPreview() {
    FlorifyTheme {
        FlorifySignInScreen()
    }
}
