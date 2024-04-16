package com.example.printit

class userData {
    var firstname:String=""
    var lastname:String=""
    var email:String=""
    var password:String=""

    constructor()
    constructor(firstname: String, lastname: String, email: String, password: String) {
        this.firstname = firstname
        this.lastname = lastname
        this.email = email
        this.password = password
    }
}