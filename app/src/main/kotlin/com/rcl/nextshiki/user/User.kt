package com.rcl.nextshiki.user

object User {
    var isAuthorized: Boolean = false
    lateinit var accessCode: String
    lateinit var vm: HiltVM
}