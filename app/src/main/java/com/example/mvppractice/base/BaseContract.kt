package com.example.mvppractice.base

interface BaseContract {
    interface BaseView{
        //Error 출력하는 부분이 공통적이라는 가정
        fun showError(error : String)
    }

    interface BasePresenter<T>{
        fun takeView(view : T) //view가 생성 혹은 vind될 때를 Presenter에게 전달
        fun dropView()//view가 생성 혹은 vind될 때를 Presenter에게 전달
    }
}