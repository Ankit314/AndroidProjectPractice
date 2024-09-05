package com.example.realproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class messageAdapter(var context:Context,var messageList: ArrayList<Message>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val ITEM_RECEVE=1;
    val ITEM_SENT=2;





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType==1){


            val view:View= LayoutInflater.from(context).inflate(R.layout.receve,parent,false)
            return RecevedViewHolder(view)


        }else{
            val view:View= LayoutInflater.from(context).inflate(R.layout.sent,parent,false)
            return SentViewHolder(view)


        }

    }

    override fun getItemCount(): Int {
         return messageList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentMessage=messageList[position]

        if (holder.javaClass==SentViewHolder::class.java){



            val ViewHolder=holder as SentViewHolder
            holder.sentMessage.text=currentMessage.message

        }else{

            val ViewHolder=holder as RecevedViewHolder
            holder.recevedMessage.text=currentMessage.message



        }
    }

    override fun getItemViewType(position: Int): Int {
        val currentMessage=messageList[position]

        if (FirebaseAuth.getInstance().currentUser?.uid.equals(currentMessage.senderId)){

            return ITEM_SENT
        }else{

            return ITEM_RECEVE
        }
    }

    class SentViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val sentMessage=itemView.findViewById<TextView>(R.id.txt_sent_sms)

    }

    class RecevedViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val recevedMessage=itemView.findViewById<TextView>(R.id.txt_receve_sms)



    }


}