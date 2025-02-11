package com.rmso.irecipe.presentation.features.register.composable

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
import com.rmso.irecipe.presentation.features.register.RegisterState
import com.rmso.irecipe.ui.components.RecipeBannerError
import com.rmso.irecipe.ui.components.RecipeButton
import com.rmso.irecipe.ui.theme.IRecipeTheme
import com.rmso.irecipe.ui.theme.Orange500
import com.rmso.irecipe.ui.theme.Typography
import com.rmso.irecipe.ui.theme.poppinsFontFamily

@Composable
internal fun RegisterContent(
    registerState: RegisterState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String, String) -> Unit,
    onConfirmPasswordChanged: (String, String) -> Unit,
    onRegisterButtonClick: () -> Unit,
    onSignInLinkClick: () -> Unit,
    onShowPasswordClicked: () -> Unit,
    onShowConfirmPasswordClicked: () -> Unit
) {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        RecipeBannerError(
            messageError = registerState.errorMessage,
            isVisible = registerState.errorMessage.isNotEmpty()
        )
        Text(
            text = "Register",
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
            value = registerState.email,
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
                if (registerState.isEmailInvalid) Text("Please enter a valid email")
            },
            isError = registerState.isEmailInvalid,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier =
            Modifier
                .fillMaxWidth(),
            value = registerState.password,
            onValueChange = { newPassword ->
                onPasswordChanged(newPassword, registerState.confirmPassword)
            },
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
                        imageVector = if (registerState.isShowPassword) {
                            Icons.Outlined.Visibility
                        } else {
                            Icons.Outlined.VisibilityOff
                        },
                        contentDescription = if (registerState.isShowPassword) {
                            "hide password"
                        } else {
                            "show password"
                        }
                    )
                }
            },
            visualTransformation = if (registerState.isShowPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            supportingText = {
                if (registerState.isPasswordInvalid) Text("Please enter a valid password ")
            },
            isError = registerState.isPasswordInvalid
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier =
            Modifier
                .fillMaxWidth(),
            value = registerState.confirmPassword,
            onValueChange = { newConfirmPassword ->
                onConfirmPasswordChanged(newConfirmPassword, registerState.password)
            },
            shape = shapes.medium,
            label = { Text("Confirm Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = null
                )
            },
            trailingIcon = {
                IconButton(onShowConfirmPasswordClicked) {
                    Icon(
                        imageVector = if (registerState.isShowConfirmPassword) {
                            Icons.Outlined.Visibility
                        } else {
                            Icons.Outlined.VisibilityOff
                        },
                        contentDescription = if (registerState.isShowConfirmPassword) {
                            "hide password"
                        } else {
                            "show password"
                        }
                    )
                }
            },
            visualTransformation = if (registerState.isShowConfirmPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            supportingText = {
                if (registerState.isNotEqualsPassword) {
                    Text("Passwords do not match")
                }
            },
            isError = registerState.isNotEqualsPassword
        )
        Spacer(modifier = Modifier.height(32.dp))
        RecipeButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = onRegisterButtonClick,
            text = "Create Account",
            isEnabled = registerState.isButtonEnabled,
            isLoading = registerState.isLoading
        )
        Spacer(modifier = Modifier.height(40.dp))
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
                append("Do you have an account? ")
                withStyle(
                    style = SpanStyle(
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = Orange500
                    )
                ) {
                    append("Sign In")
                }
            },
            style = Typography.bodyMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { onSignInLinkClick() }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    IRecipeTheme {
        RegisterContent(
            registerState = RegisterState(
                email = "rmso@gmail.com",
                password = "1234",
                confirmPassword = "1234",
                isNotEqualsPassword = true,
                isPasswordInvalid = false,
                isEmailInvalid = false,
                isShowConfirmPassword = false,
                isShowPassword = false
            ),
            onEmailChanged = {},
            onPasswordChanged = { _, _ -> },
            onConfirmPasswordChanged = { _, _ -> },
            onRegisterButtonClick = {},
            onSignInLinkClick = {},
            onShowPasswordClicked = {},
            onShowConfirmPasswordClicked = {}
        )
    }
}
