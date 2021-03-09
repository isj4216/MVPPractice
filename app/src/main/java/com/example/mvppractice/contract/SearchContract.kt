package com.example.mvppractice.contract

import com.example.mvppractice.base.BaseContract
import com.example.mvppractice.model.Dog

interface SearchContract {
    //view와 Presenter가 구현해야할 인터페이스를 정의하는 Contract
    interface  View : BaseContract.BaseView{
        fun showLoading() //데이터를 받아서 정제하는동안 보일 ProgressBar관리 함수
        fun hideLoading() //데이터를 받아서 정제하는동안 보일 ProgressBar관리 함수
        fun showDogList(dogList : List<Dog>)//Model로 부터 데이터를 받아오기(정제하기)위한 함수
    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun getDogList()
    }
}