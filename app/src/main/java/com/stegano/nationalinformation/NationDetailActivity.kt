package com.stegano.nationalinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nation_detail.*

class NationDetailActivity : AppCompatActivity() {
    companion object {  // static처럼 동작함. 즉, 프로젝트 어디서든 불러서 사용할 수 있음
        val EXTRA_NATION_NAME = "nation_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nation_detail)

        val nation = intent.getStringExtra(EXTRA_NATION_NAME)
        location.text = nation
    }
}