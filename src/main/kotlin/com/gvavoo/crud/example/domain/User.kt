package com.gvavoo.crud.example.domain

import javax.persistence.*

@Entity
@Table(name = "user")
data class User (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        var email: String? = null,
        var firstName: String? = null,
        var lastName: String? = null,
        var phone: String? = null
)
