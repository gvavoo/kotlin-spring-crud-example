package com.gvavoo.crud.example.repository;

import com.gvavoo.crud.example.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long>{
    fun findByEmail(email: String): Optional<User>
}