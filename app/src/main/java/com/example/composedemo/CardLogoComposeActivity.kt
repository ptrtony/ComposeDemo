package com.example.composedemo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class CardLogoComposeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewConversation()
        }
    }

//    @Composable
//    fun JetpackCompose() {
//
//        Card (backgroundColor = Color.White,shape = RoundedCornerShape(8f),border = BorderStroke(1.dp,Color.Gray),
//        elevation = 8.dp){
//            var expanded by remember { mutableStateOf(false) }
//            Column(modifier = Modifier
//                .clickable { expanded = !expanded },
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally) {
//                Image(
//                    painter = painterResource(id = R.drawable.icon_compose),
//                    contentDescription = "jetPack Compose"
//                )
//                AnimatedVisibility(visible = expanded) {
//                    Text(
//                        text = "Jetpack Compose",
//                        style = MaterialTheme.typography.h2,
//                        textDecoration = TextDecoration.Underline
//                    )
//                }
//            }
//        }
//    }

    data class Message(val icon: Int, val username: String, val conversationContent: String)

    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(messages.size) { index ->
                MessageCard(messages[index])
            }
        }
    }


    @Composable
    fun MessageCard(message: Message) {
        Surface(
            elevation = 8.dp,
            shape = RoundedCornerShape(10.dp),
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = message.icon), contentDescription = "avatar",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colors.secondaryVariant)
                )
                Spacer(modifier = Modifier.width(8.dp))
                var isExpanded by remember { mutableStateOf(false) }
                Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {

                    Text(
                        text = message.username,
                        color = MaterialTheme.colors.primaryVariant,
                        style = MaterialTheme.typography.subtitle2
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                        Text(
                            text = message.conversationContent, modifier = Modifier.padding(4.dp),
                            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun PreviewConversation() {
        Conversation(messages = SampleData.conversation())
    }


    object SampleData {
        fun conversation(): List<Message> {
            val conversations = ArrayList<Message>()
            for (i in 0 until 100) {
                conversations.add(
                    Message(
                        R.drawable.icon_compose, "张三 $i",
                        "asfkasdnflkasklfalkasdkjas" +
                                "dnfknasknknvkjnakjsdkjkjasndjknask" +
                                "jnkjakjasdjnaskjnakjsdkjnaskjvnkjbvkajnkjndvjkksd"
                    )
                )
            }
            return conversations
        }
    }


}

