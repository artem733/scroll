package com.koroche.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)





        class CustomRecyclerAdapter(private val values: List<String>) :
                RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

            override fun getItemCount() = values.size

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.recyclerview_item, parent, false)
                return MyViewHolder(itemView)
            }

            override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                holder.largeTextView?.text = values[position]
                holder.smallTextView?.text = "кот"
            }

            class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                var largeTextView: TextView? = null
                var smallTextView: TextView? = null

                init {
                    largeTextView = itemView?.findViewById(R.id.textViewLarge)
                    smallTextView = itemView?.findViewById(R.id.textViewSmall)
                }
            }
        }




        class MainActivity : Activity() {

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = CustomRecyclerAdapter(fillList())
            }

            private fun fillList(): List<String> {
                val data = mutableListOf<String>()
                (0..30).forEach { i -> data.add("\$i element") }
                return data
            }
        }
    }

}