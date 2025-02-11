package com.rmso.irecipe.presentation.features.signin.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rmso.irecipe.R
import com.rmso.irecipe.presentation.features.signin.SignInState
import com.rmso.irecipe.ui.components.RecipeBannerError
import com.rmso.irecipe.ui.components.RecipeButton
import com.rmso.irecipe.ui.theme.IRecipeTheme
import com.rmso.irecipe.ui.theme.Orange500
import com.rmso.irecipe.ui.theme.Typography
import com.rmso.irecipe.ui.theme.poppinsFontFamily

@Composable
internal fun SignInContent(
    signInState: SignInState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onShowPasswordClicked: () -> Unit,
    onSignInButtonClick: () -> Unit,
    onRegisterLinkClick: () -> Unit
) {
    Scaffold(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            RecipeBannerError(
                messageError = signInState.errorMessage,
                isVisible = signInState.errorMessage.isNotEmpty()
            )
            Text(
                text = "Sign In",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                style = Typography.displayLarge
            )
            Spacer(modifier = Modifier.height(36.dp))
            OutlinedTextField(
                modifier =
                Modifier
                    .fillMaxWidth(),
                value = signInState.email,
                onValueChange = onEmailChanged,
                shape = shapes.medium,
                label = { Text("Email") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = null
                    )
                },
                supportingText = {
                    if (signInState.isEmailInvalid) Text("Please enter a valid email")
                },
                isError = signInState.isEmailInvalid
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                modifier =
                Modifier
                    .fillMaxWidth(),
                value = signInState.password,
                onValueChange = onPasswordChanged,
                shape = shapes.medium,
                label = { Text("Password") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    IconButton(onShowPasswordClicked) {
                        Icon(
                            imageVector = if (signInState.isShowPassword) {
                                Icons.Outlined.Visibility
                            } else {
                                Icons.Outlined.VisibilityOff
                            },
                            contentDescription = if (signInState.isShowPassword) {
                                "hide password"
                            } else {
                                "show password"
                            }
                        )
                    }
                },
                visualTransformation = if (signInState.isShowPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(52.dp))
            RecipeButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onSignInButtonClick,
                text = "Sign In",
                isEnabled = signInState.isButtonEnabled,
                isLoading = signInState.isLoading
            )

            Spacer(modifier = Modifier.height(75.dp))
            Text(
                text = "--- OR Continue with ---",
                style = Typography.bodySmall,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.spacedBy(48.dp)

            ) {
                Image(
                    modifier = Modifier
                        .size(56.dp)
                        .clickable {
                            // TODO - login with Google
                        },
                    painter = painterResource(R.drawable.ic_google),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .size(56.dp)
                        .clickable {
                            // TODO - login with facebook
                        },
                    painter = painterResource(R.drawable.ic_facebook),
                    contentDescription = null
                )
            }

            Text(
                buildAnnotatedString {
                    append("Not A Member? ")
                    withStyle(
                        style = SpanStyle(
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                            color = Orange500
                        )
                    ) {
                        append("Register Now")
                    }
                },
                style = Typography.bodyMedium,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable { onRegisterLinkClick() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun LoginScreenWithoutFillingPreview() {
    IRecipeTheme {
        SignInContent(
            signInState = SignInState(
                email = "",
                password = "",
                isShowPassword = false,
                isEmailInvalid = false
            ),
            onEmailChanged = {},
            onPasswordChanged = {},
            onShowPasswordClicked = {},
            onSignInButtonClick = {},
            onRegisterLinkClick = {}
        )
    }
}
