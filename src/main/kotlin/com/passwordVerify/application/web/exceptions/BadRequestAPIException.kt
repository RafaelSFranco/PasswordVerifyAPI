package com.passwordVerify.application.web.exceptions

import org.springframework.http.HttpStatus

data class BadRequestAPIException(
    private val msg: String? = HttpStatus.BAD_REQUEST.reasonPhrase
) : Exception(msg)