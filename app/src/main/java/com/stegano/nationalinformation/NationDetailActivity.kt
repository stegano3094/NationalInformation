package com.stegano.nationalinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_nation_detail.*
import java.io.InputStream
import java.io.InputStreamReader

class NationDetailActivity : AppCompatActivity() {
    companion object {  // static처럼 동작함. 즉, 프로젝트 어디서든 불러서 사용할 수 있음
        val EXTRA_NATION_NAME = "nation_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nation_detail)

        val nation: String = intent.getStringExtra(EXTRA_NATION_NAME).toString()
        val data: NationDetailData? = getDataFromName(nation)

        img_flag.setImageResource(getResourId(nation))
        initView(data)
    }

    private fun getDataFromName(selected: String) : NationDetailData? {
        val gson: Gson = GsonBuilder().create()
        val inputStream: InputStream = assets.open("nation_data.json")
        val reader: InputStreamReader = InputStreamReader(inputStream)
        val detailData = gson.fromJson(reader, GsonData::class.java)

        for(data in detailData.data) {
            if(selected.equals(data.name)) {
                return data
            }
        }

        return null
    }

    private fun getResourId(selected: String) : Int {
        var resourId: Int = 0

        when(selected) {
            "벨기에" -> resourId = R.drawable.i_belgium
            "아르헨티나" -> resourId = R.drawable.i_argentina
            "캐나다" -> resourId = R.drawable.i_canada
            else -> resourId = 0
        }
        return resourId
    }

    private fun initView(data: NationDetailData?) {
        txt_name.text = data?.name
        capital.text = data?.capital
        volume.text = data?.volume
        weather.text = data?.weather
        language.text = data?.language
        location.text = data?.location
    }
}