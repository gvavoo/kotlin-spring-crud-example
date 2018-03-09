package com.gvavoo.crud.example.service

import com.gvavoo.crud.example.domain.User
import com.gvavoo.crud.example.dto.AddUserDto
import com.gvavoo.crud.example.dto.EditUserDto
import com.gvavoo.crud.example.dto.GetUserDto
import com.gvavoo.crud.example.repository.UserRepository
import javassist.NotFoundException
import org.springframework.stereotype.Service


@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {
    override fun addUser(addUserDto: AddUserDto): GetUserDto {
        if (userRepository.findByEmail(addUserDto.email).isPresent){
            throw Exception("Email exists")
        }
        var user = User(null, addUserDto.email, addUserDto.firstName, addUserDto.lastName, addUserDto.phone)
        user = userRepository.save(user)
        return GetUserDto(user.id!!, user.email!!, user.firstName!!, user.lastName!!, user.phone!!)
    }

    override fun editUser(userId: Long, editUserDto: EditUserDto): GetUserDto {
        if (userRepository.findByEmail(editUserDto.email).isPresent){
            throw Exception("Email exists")
        }
        var userOpt = userRepository.findById(userId)
        if (userOpt.isPresent) {
            var user: User = userOpt.get()
            user.email = editUserDto.email
            user.firstName = editUserDto.firstName
            user.lastName = editUserDto.lastName
            user.phone = editUserDto.phone
            val userToReturn = userRepository.save(user)
            return GetUserDto(userToReturn.id!!, userToReturn.email!!, userToReturn.firstName!!, userToReturn.lastName!!, userToReturn.phone!!)
        } else {
            throw NotFoundException("User not found")
        }
    }

    override fun getOneUser(userId: Long): GetUserDto {
        var userOpt = userRepository.findById(userId)
        if (userOpt.isPresent) {
            var user: User = userOpt.get()
            val userToReturn = userRepository.save(user)
            return GetUserDto(userToReturn.id!!, userToReturn.email!!, userToReturn.firstName!!, userToReturn.lastName!!, userToReturn.phone!!)
        } else {
            throw NotFoundException("User not found")
        }
    }

    override fun getAllUsers(): List<GetUserDto> {
        val users: List<User> = userRepository.findAll()
        val usersDto: ArrayList<GetUserDto> = ArrayList()
        for (user: User in users) {
            usersDto.add(GetUserDto(user.id!!, user.email!!, user.firstName!!, user.lastName!!, user.phone!!))
        }
        return usersDto
    }


}