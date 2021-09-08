package com.passwordVerify.componentTests.VerifyPwd

import com.passwordVerify.application.web.requests.PasswordRequest
import com.passwordVerify.application.web.responses.PasswordResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VerifyPwdTests(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `should return a payload with false response if password is not valid`(){
        val response = restTemplate.postForEntity<PasswordResponse>(
            "/api/verify-pwd",
            PasswordRequest(password = "AbTp9 fok"),
            PasswordRequest::class.java
        )
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isNotNull
        assertThat(response.body?.isValid).isEqualTo(false)
    }

    @Test
    fun `should return a payload with true response if password is valid`(){
        val response = restTemplate.postForEntity<PasswordResponse>(
            "/api/verify-pwd",
            PasswordRequest(password = "AbTp9!fok"),
            PasswordRequest::class.java
        )
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isNotNull
        assertThat(response.body?.isValid).isEqualTo(true)
    }

    @Test
    fun `should return 400 status code when receives a invalid payload`(){
        val response = restTemplate.postForEntity<PasswordResponse>(
            "/api/verify-pwd",
            "???" to "???",
            PasswordRequest::class.java
        )
        assertThat(response.statusCode).isEqualTo(HttpStatus.BAD_REQUEST)
    }
}