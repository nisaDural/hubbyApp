package com.nehir.hubbylogin.ui.Screen

//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hubby.R


@Composable
fun LoginScreen(
    onLoginInButtonClicked: () -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {}
) {
    ThreeTextWithCard(onLoginInButtonClicked, onSignUpButtonClicked)
    // LoginArea()
}


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ThreeTextWithCard(
    onLoginInButtonClicked: () -> Unit = {},
    onSignUpButtonClicked: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember {
        mutableStateOf("")
    }
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()


    ) {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.linearGradient(listOf(Color(0xFF1BA5DE), Color(0xFF6041B0)))),
            // .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 30.dp)
            contentAlignment = Alignment.Center

        ) {


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "Your hobby defines you.",
                    fontSize = 18.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.Default
                    ),
                    color = Color.White
                )
                Text(
                    text = "Show everyone.",
                    fontSize = 18.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.Default
                    ),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Hubby",
                    fontSize = 48.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif),
                    color = Color.White
                )


                Spacer(modifier = Modifier.height(155.dp))

                // CARD
                Card(
                    modifier = Modifier

                        .fillMaxWidth(),
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                    // köşeleri oval yapma


                    // elevation = 8.dp // golge efekti
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()

                            .padding(20.dp),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Log in",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        OutlinedTextField(
                            value = email, onValueChange = { email = it },
                            label = {
                                Text(text = "Email", color = Color.Gray)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .padding(top = 10.dp),

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email
                            ),
                            singleLine = true,
                        )

//  sifreyi gösterme gizleme
                        OutlinedTextField(value = password, onValueChange = { password = it },
                            label = {
                                Text(text = "Password", color = Color.Gray)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 25.dp)
                                .padding(top = 10.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password
                            ),
                            singleLine = true,


                            visualTransformation = if (passwordVisible) {
                                VisualTransformation.None
                            } else {
                                PasswordVisualTransformation()
                            },
                            trailingIcon = {
                                val text = if (passwordVisible) "Hide" else "Show"
                                Text(
                                    text = text,
                                    color = Color.Unspecified,
                                    modifier = Modifier.clickable {
                                        passwordVisible = !passwordVisible
                                    }
                                )
                            }

///
                        )

                        Button(
                            onClick = onLoginInButtonClicked,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 17.dp)
                                .padding(top = 17.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF9CBFA7), Color(0xFFC9F299)
                                //contentColor = Color.White
                            ),


                            contentPadding = PaddingValues(vertical = 15.dp)
                        ) {
                            Text(
                                text = "Login in",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                        }
                        TextButton(
                            onClick = {},
                            contentPadding = PaddingValues(vertical = 0.dp),


                            ) {
                            Text(
                                text = "  Forgot Your Password?   ",
                                color = Color.Black,
                                //color = Color(0x9CBFA7),
                                fontSize = 15.sp,
                                modifier = Modifier.padding(top = 20.dp)
                            )

                        }
                        Text(
                            text = "----------- OR -----------",
                            color = Color.Black,
                            //color = Color(0x9CF299),
                            fontSize = 15.sp,
                            modifier = Modifier.padding(top = 15.dp)

                        )
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                // renk
                                containerColor = Color(0xFF9CBFA7), Color(0xFFC9F299)
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .padding(top = 20.dp),
                            contentPadding = PaddingValues(
                                horizontal = 20.dp,
                                vertical = 10.dp
                            ),
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.googleicon),
                                    contentDescription = "",
                                    tint = Color.Unspecified,
                                    modifier = Modifier.size(26.dp)
                                )
                                Spacer(modifier = Modifier.width(20.dp))
                                Text(
                                    text = "Login in with Google",
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        TextButton(
                            onClick = onSignUpButtonClicked,
                            contentPadding = PaddingValues(vertical = 0.dp)

                        ) {
                            Text(
                                text = "  Don't have an account? Sing Up  ",
                                color = Color.Black,
                                fontSize = 15.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                    }
                }

            }
        }


    }


}

@Preview
@Composable
fun ThreeTextWithCardPreview() {
    ThreeTextWithCard(onLoginInButtonClicked = {})
}

