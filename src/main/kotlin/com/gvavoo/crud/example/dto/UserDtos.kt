package com.gvavoo.crud.example.dto

data class GetUserDto(val id: Long, val email: String, val firstName: String, val lastName: String, val phone : String)
data class AddUserDto(val email: String, val firstName: String, val lastName: String, val phone: String)
data class EditUserDto(val email: String, val firstName: String, val lastName: String, val phone: String)
