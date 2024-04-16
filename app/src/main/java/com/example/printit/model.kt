package com.example.printit

 class model{
    var imageurl:String =""
    var category:String =""
    var price:Double?=-1.0
    constructor()

    constructor(imageurl: String, category: String, price: Double?) {
        this.imageurl = imageurl
        this.category = category
        this.price = price
    }


}

