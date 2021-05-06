package com.stegano.nationalinformation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerListView = findViewById<RecyclerView>(R.id.nation_list)
        recyclerListView.layoutManager = LinearLayoutManager(this)
        val adapter = NationAdapter(this, listOf(
                NationData(R.drawable.ic_launcher_foreground, "벨기에", "브뤼셀"),
                NationData(R.drawable.ic_launcher_foreground, "아르헨티나", "부에노스아이레스"),
                NationData(R.drawable.ic_launcher_foreground, "브라질", "브라질리아")
        ))
        adapter.setOnItemClickListener(this)
        recyclerListView.adapter = adapter
    }

    override fun onClick(v: View?) {
        val textView: TextView = v?.findViewById(R.id.txt_name) as TextView
        val name = textView.text?:"None"
        val intent = Intent(this, NationDetailActivity::class.java)
        intent.putExtra(NationDetailActivity.EXTRA_NATION_NAME, name)
        startActivity(intent)
    }
}