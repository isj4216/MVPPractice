package com.example.mvppractice.model

object DogList {
    //ex) GET Response
    fun getDogListData() : List<Dog>{
        return listOf(
            Dog("Maltese", 3),
            Dog("Retriver", 5),
            Dog("Husky", 2)
        )
    }
}