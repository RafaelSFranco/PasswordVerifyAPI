package com.passwordVerify.application.web.controllers

import com.passwordVerify.application.web.requests.PasswordRequest
import com.passwordVerify.application.web.responses.PasswordResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class VerifyControllerTest {

    private val verifyController = VerifyController()

    @Test
    fun `should return a false PasswordResponse if password is not valid`() {
        val pwd = "AbTp9!foA"
        val expectedResponse = PasswordResponse(
            isValid = false
        )
        val request = PasswordRequest(
            password = pwd
        )
        assertThat(verifyController.verify(request)).isEqualTo(expectedResponse)
    }

    @Test
    fun `should return a true PasswordResponse if password is valid`() {
        val pwd = "AbTp9!fok"
        val expectedResponse = PasswordResponse(
            isValid = true
        )
        val request = PasswordRequest(
            password = pwd
        )
        assertThat(verifyController.verify(request)).isEqualTo(expectedResponse)
    }
}