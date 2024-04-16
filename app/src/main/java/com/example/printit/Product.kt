package com.example.printit

class Product {
    var uniqueid:String?=null
    var name:String=""
    var price:Double=-1.0
    var desc:String=""
    var imageurl:String=""
    var category:String=""
    var discount:Int=0

    constructor()

    constructor(uniqueid:String,name: String, price: Double, desc: String, imageurl: String,category: String,discount:Int) {
        this.uniqueid=uniqueid
        this.name = name
        this.price = price
        this.desc = desc
        this.imageurl = imageurl
        this.category = category
        this.discount = discount
    }

}