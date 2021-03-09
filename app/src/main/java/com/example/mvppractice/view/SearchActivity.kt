package com.example.mvppractice.view

import BaseActivity
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mvppractice.R
import com.example.mvppractice.contract.SearchContract
import com.example.mvppractice.model.Dog
import com.example.mvppractice.presenter.SearchPresenter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity(), SearchContract.View {

    private lateinit var searchPresenter : SearchPresenter  //SearchActivity와 1:1 대응하는 SearchPresenter를 연결시켜주기위한
                                                            //초기화 지연 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchPresenter.takeView(this)//SearchContract.View를 상속받는 Activity가
                                            //생성이 되었다는 것을 Presenter에게 알려준다.

        setButton()
    }

    private fun setButton() {
        //버튼 이벤트가 발생하면 Presenter에 이벤트가 발생하였다고 알려줌과 동시에
        //Model로 부터 데이터를 가져오라는 것을 알려준다.
        getDogListButton.setOnClickListener {
            searchPresenter.getDogList()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun showDogList(dogList : List<Dog>) {
        //Model로부터 받은 데이터를 Presenter에서 View로 전달해 주며 TextView를 통해서 사용자에게 보여준다.
        firstDogText.text = "Name : ${dogList[0].name}, Age : ${dogList[0].age}"
        secondDogText.text = "Name : ${dogList[1].name}, Age : ${dogList[1].age}"
        thirdDogText.text = "Name : ${dogList[2].name}, Age : ${dogList[2].age}"
    }

    override fun onDestroy() {
        super.onDestroy()
        searchPresenter.dropView()
    }


    override fun initPresenter() {
        //BaseActivity에서 Activity가 생성이 되면 해당 Activity에 Presenter를 초기화
        searchPresenter = SearchPresenter()
    }

    override fun showError(error: String) {
        Toast.makeText(this@SearchActivity, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        searchRefresh.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        searchRefresh.visibility = View.GONE
    }
}