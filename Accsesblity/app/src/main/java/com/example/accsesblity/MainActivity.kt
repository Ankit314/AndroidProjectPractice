package com.example.accsesblity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.accsesblity.ui.theme.AccsesblityTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent{


        }
    }
}

@Composable
fun AccessibleLoginScreen() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (logo, email, password, loginButton) = createGuidelineFromStart(0.15f).let { startGuideline ->
            createGuidelineFromTop(0.3f).let { topGuideline ->
                createGuidelineFromBottom(0.15f).let { bottomGuideline ->
                    createGuidelineFromEnd(0.15f).let { endGuideline ->
                        createGuidelineFromBottom(0.25f).let { buttonGuideline ->
                            createGuidelineFromBottom(0.1f).let { textGuideline ->
                                val (emailEdit, passwordEdit) = createGuidelineFromTop(0.15f).let { textTopGuideline ->
                                    createGuidelineFromTop(0.25f).let { textBottomGuideline ->
                                        createGuidelineFromTop(0.1f).let { emailGuideline ->
                                            createGuidelineFromTop(0.35f).let { passwordGuideline ->
                                                createGuidelineFromTop(0.45f).let { emailHintGuideline ->
                                                    createGuidelineFromTop(0.55f).let { passwordHintGuideline ->
                                                        createGuidelineFromTop(0.65f).let { buttonBottomGuideline ->
                                                            createGuidelineFromTop(0.75f).let { buttonTopGuideline ->
                                                                createGuidelineFromTop(0.85f).let { logoGuideline ->
                                                                    createGuidelineFromTop(0.95f).let { imageGuideline ->
                                                                        createGuidelineFromTop(0.05f).let { titleGuideline ->

                                                                            val logoModifier = Modifier.constrainAs(logo) {
                                                                                top.linkTo(logoGuideline)
                                                                                start.linkTo(startGuideline)
                                                                                end.linkTo(endGuideline)
                                                                            }

                                                                            val emailModifier = Modifier.constrainAs(emailEdit) {
                                                                                top.linkTo(emailGuideline)
                                                                                start.linkTo(startGuideline)
                                                                                end.linkTo(endGuideline)
                                                                            }

                                                                            val passwordModifier = Modifier.constrainAs(passwordEdit) {
                                                                                top.linkTo(passwordGuideline)
                                                                                start.linkTo(startGuideline)
                                                                                end.linkTo(endGuideline)
                                                                            }

                                                                            val loginButtonModifier = Modifier.constrainAs(loginButton) {
                                                                                bottom.linkTo(buttonGuideline)
                                                                                start.linkTo(startGuideline)
                                                                                end.linkTo(endGuideline)
                                                                            }

                                                                            logo(logoModifier)

                                                                            AccessibleTextField(
                                                                                value = TextFieldValue(""),
                                                                                onValueChange = {},
                                                                                label = "Email",
                                                                                hint = "Enter your email",
                                                                                modifier = emailModifier
                                                                            )

                                                                            AccessibleTextField(
                                                                                value = TextFieldValue(""),
                                                                                onValueChange = {},
                                                                                label = "Password",
                                                                                hint = "Enter your password",
                                                                                modifier = passwordModifier
                                                                            )

                                                                            AccessibleButton(
                                                                                text = "Login",
                                                                                onClick = { /* Handle login click action */ },
                                                                                modifier = loginButtonModifier
                                                                            )
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AccessibleTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String,
    hint: String,
    modifier: Modifier = Modifier
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .background(Color.White)
            .semantics {
                // Provide accessibility label and hint for the field
                contentDescription = label
                hint = hint
            }
    )
}

@Composable
fun AccessibleButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .background(Color.Blue)
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.Center)
        )
    }
}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    // Replace with your logo image resource
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "App Logo",
        modifier = modifier
    )
}

@Preview
@Composable
fun AccessibleLoginScreenPreview() {
    AccessibleLoginScreen()
}

