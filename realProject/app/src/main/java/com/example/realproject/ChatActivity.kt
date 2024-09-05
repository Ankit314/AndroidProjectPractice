package com.example.realproject

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ChatActivity : AppCompatActivity() {

    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var messageBox: EditText
    private lateinit var sentButton: ImageView
    private lateinit var messageAdapter: messageAdapter
    private lateinit var messageList: ArrayList<Message>
    private lateinit var mDbref:DatabaseReference

    var receiverRoom:String?=null
    var senderRoom:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)



        var name=intent.getStringArrayExtra("name")
        var receverUid=intent.getStringArrayExtra("uid")
        var senderUID=FirebaseAuth.getInstance().currentUser?.uid

        mDbref=FirebaseDatabase.getInstance().getReference()


        receiverRoom=senderUID+receverUid
        senderRoom=senderUID+receverUid
        supportActionBar?.title= name.toString()



        chatRecyclerView=findViewById(R.id.chatRecyclerView)
        messageBox=findViewById(R.id.messageBox)
        sentButton=findViewById(R.id.sentButton)
        messageList= ArrayList()
        messageAdapter= messageAdapter(this,messageList)
        sentButton.setOnClickListener {

            var message=messageBox.text.toString()
            var messageObjects=Message(message,senderUID)
            mDbref.child("chats").child(senderRoom!!).child("messages").push()
                .setValue(messageObjects).addOnSuccessListener {
                    mDbref.child("chats").child(receiverRoom!!).child("messages").push()
                        .setValue(messageObjects)

                }

        }


    }
}