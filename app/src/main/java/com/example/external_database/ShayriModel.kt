package com.example.external_database

class ShayriModel{
    var id = 0
    lateinit var shayari_id:String
    lateinit var shayari_cate:String


    constructor(id: Int, shayri: String, cat: String){
        this.id = id
        this.shayari_id = shayari_id
        this.shayari_cate = shayari_cate


    }
}