package com.met.identityservice.configuration.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenUtil {

    private val secret = "7f3cac5d84d151468b5bebc4d9caf6dc79abe5dcded55bdf8c7d4e5682c8bba3d84d9fcab32286ce7e0a5d0de1d2ff94f80af94805fcb087411f8c37b8384c3b"
    private val expiration = 6000000

    fun generateToken(username: String): String =
        Jwts.builder().setSubject(username).setExpiration(Date(System.currentTimeMillis() + expiration))
            .signWith(SignatureAlgorithm.HS512, secret.toByteArray()).compact()

    private fun getClaims(token: String) =
        Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(token).body

    fun getEmail(token: String): String = getClaims(token).subject

    fun isTokenValid(token: String): Boolean {
        val claims = getClaims(token)
        val expirationDate = claims.expiration
        val now = Date(System.currentTimeMillis())
        return now.before(expirationDate)
    }
}
