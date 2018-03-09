package com.gvavoo.crud.example.controller

import com.gvavoo.crud.example.dto.AddUserDto
import com.gvavoo.crud.example.dto.EditUserDto
import com.gvavoo.crud.example.dto.GetUserDto
import com.gvavoo.crud.example.service.UserService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@RestController
class UserController(val userService: UserService) {

    @GetMapping("/users")
    fun getAllUsers(): List<GetUserDto> = userService.getAllUsers()

    @GetMapping("/users/{userId}")
    fun getoneUser(@PathVariable userId: Long): GetUserDto = userService.getOneUser(userId)

    @PostMapping("/users")
    fun addUser(@RequestBody @Validated addUserDto: AddUserDto): GetUserDto = userService.addUser(addUserDto)

    @PutMapping("/users/{userId}")
    fun editUser(@PathVariable userId: Long, @RequestBody @Validated editUserDto: EditUserDto): GetUserDto = userService.editUser(userId, editUserDto)



}