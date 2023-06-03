package com.rcl.nextshiki.user

class GetData {
    fun getDataByNickname(nickname: String, viewModel: HiltVM) {
        viewModel.getUser(id = nickname, isNickname = true)
    }
    fun getDataById(id: String, viewModel: HiltVM) {
        viewModel.getUser(id = id, isNickname = false)
    }
}