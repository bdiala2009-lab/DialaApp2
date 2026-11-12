package diala.b.dialaapp.ui.signin

import androidx.compose.ui.platform.ComposeView
import diala.b.dialaapp.ui.theme.FlorifyTheme

object FlorifySignInBridge {

    fun interface OnSignInListener {
        fun onSignIn(email: String, pass: String)
    }

    @JvmStatic
    fun setSignInContent(
        composeView: ComposeView,
        onSignInListener: OnSignInListener,
        onSignUpClick: Runnable,
        onForgotPasswordClick: Runnable,
        onGoogleSignInClick: Runnable,
        onAppleSignInClick: Runnable
    ) {
        composeView.setContent {
            FlorifyTheme {
                FlorifySignInScreen(
                    onSignInClick = { email, pass ->
                        onSignInListener.onSignIn(email, pass)
                    },
                    onSignUpClick = { onSignUpClick.run() },
                    onForgotPasswordClick = { onForgotPasswordClick.run() },
                    onGoogleSignInClick = { onGoogleSignInClick.run() },
                    onAppleSignInClick = { onAppleSignInClick.run() }
                )
            }
        }
    }
}
