package com.passwordVerify.application.web.controllers

import com.passwordVerify.application.web.exceptions.BadRequestAPIException
import com.passwordVerify.application.web.requests.PasswordRequest
import com.passwordVerify.application.web.responses.PasswordResponse
import com.passwordVerify.application.web.services.VerifyService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@Api(value = "Password")
@RequestMapping("api")
class VerifyController{
    @ApiOperation(value = "Recurso que recebe uma senha e verifica se é válida")
    @PostMapping("verify-pwd")
    fun verify(@RequestBody requestBody: PasswordRequest): PasswordResponse {
        try{
            return PasswordResponse(
                isValid = VerifyService().verifyPwd(requestBody.password)
            )
        }catch(e: BadRequestAPIException){
            throw BadRequestAPIException(msg = "Param is required: password")
        }
    }
}