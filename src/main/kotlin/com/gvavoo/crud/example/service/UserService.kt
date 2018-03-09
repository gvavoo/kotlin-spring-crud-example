package com.gvavoo.crud.example.service

import com.gvavoo.crud.example.dto.AddUserDto
import com.gvavoo.crud.example.dto.EditUserDto
import com.gvavoo.crud.example.dto.GetUserDto

interface UserService {
    fun getAllUsers(): List<GetUserDto>
    fun getOneUser(userId: Long): GetUserDto
    fun addUser(addUserDto: AddUserDto): GetUserDto
    fun editUser(userId: Long, editUserDto: EditUserDto): GetUserDto
}