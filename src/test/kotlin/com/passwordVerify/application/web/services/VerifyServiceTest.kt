package com.passwordVerify.application.web.services

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.boot.test.context.SpringBootTest
import java.util.stream.Stream

@SpringBootTest
class VerifyServiceTest {

    private val verifyService = VerifyService()

    @ParameterizedTest(name = "should return a {1} when password have this character \"{0}\"")
    @MethodSource("passwordArguments")
    fun `given input password, when validating it, then is should return if it is valid`(pwd: String, expected: Boolean) {
        assertThat(verifyService.verifyPwd(pwd)).isEqualTo(expected)
    }

    private companion object {
        @JvmStatic
        fun passwordArguments(): Stream<Arguments> = Stream.of(
                Arguments.of("", false),
                Arguments.of("aa", false),
                Arguments.of("ab", false),
                Arguments.of("AAAbbbCc", false),
                Arguments.of("AbTp9!foo", false),
                Arguments.of("AbTp9!foA", false),
                Arguments.of("AbTp9 fok", false),
                Arguments.of("AbTp9!fok", true)
        )
    }
}