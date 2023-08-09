package com.met.identityservice.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


@Table(name="users")
@Entity
open class User (
    @Id var id: Int,
    @Column(name="full_name")var fullName:String,
    var email:String,
    private var password:String,
    //private val authorities: MutableCollection<GrantedAuthority>

    ):UserDetails{
    override fun getAuthorities() = null
    override fun getPassword() = password
    override fun getUsername() = email
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired()= true
    override fun isEnabled() = true
    fun setPassword(password: String){
        this.password=password
    }
    }
