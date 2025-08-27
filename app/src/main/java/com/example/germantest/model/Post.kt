package com.example.germantest.model

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

data class TestItem(
    val id:Int,
    val title: String,
    val description: String,
    val terms: String,
    val defenitions: String,
    val userId: String,
)

data class BrowseApi(
    val message: String,
    val tests: List<TestItem>,
    val loggedIn: Boolean,
    val authors: List<String>,
)

