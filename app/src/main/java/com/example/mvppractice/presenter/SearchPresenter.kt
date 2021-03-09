package com.example.mvppractice.presenter

import android.os.Handler
import com.example.mvppractice.contract.SearchContract
import com.example.mvppractice.model.DogList


class SearchPresenter : SearchContract.Presenter{
    //View와 1:1관계를 유지 할 Presenter를 구현
    private var searchView : SearchContract.View? = null

    override fun takeView(view: SearchContract.View) {
        //view와 Presenter연결
        searchView = view
    }

    override fun getDogList() {
        searchView?.showLoading()   //1초간 네트워크와 통신하는 척을 해주었다.
                                    // (View에 프로그레스바를 보여주도록 요청한다.)

        Handler().postDelayed({
            val dogList = DogList.getDogListData()//Model에서 DogList를 전달 받는다.
            searchView?.showDogList(dogList)//Model에게 전달받은 Data를 View에게 전달
            searchView?.hideLoading()//통신이 끝났으니 View에게 프로그레스바를 숨기도록 요청
        }, 1000)
    }

    override fun dropView() {
        //View가 제거된것을 Presenter에게 알려줌.
        searchView = null
    }
}