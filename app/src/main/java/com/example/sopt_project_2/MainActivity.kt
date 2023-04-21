package com.example.sopt_project_2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var layoutManager: LinearLayoutManager

    private val data = listOf("짱구", "철수", "훈이", "유리", "맹구", "오수", "액션")
    private val imageUrls = data.map {"http://$it.짱구캐릭터.메인.한국"}
    /*
    private val imageUrls = listOf(
        "http://짱구.짱구캐릭터.메인.한국",
        "http://철수.짱구캐릭터.메인.한국",
        "http://짱구.짱구캐릭터.메인.한국",
        "http://짱구.짱구캐릭터.메인.한국",
        "http://짱구.짱구캐릭터.메인.한국",
        "http://짱구.짱구캐릭터.메인.한국",
        "http://짱구.짱구캐릭터.메인.한국"
    )
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(this, data, imageUrls)

        val headerAdapter = HeaderAdapter("떡잎유치원 친구들!")
        val concatAdapter = ConcatAdapter(headerAdapter, adapter)

        recyclerView.adapter = concatAdapter




        //나중에 이미지 따로따로 넣고싶을 때 imageUrl param 추가하기
//        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                when {
                    dy > 0 -> headerAdapter.headerText = "내려가욧~"
                    dy < 0 -> headerAdapter.headerText = "올라가욧~"
                    else -> headerAdapter.headerText = "떡잎유치원 친구들!"
                }
                headerAdapter.notifyDataSetChanged()
            }
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    headerAdapter.headerText = "떡잎유치원 친구들!"
                }
            }
        })

    }


}
