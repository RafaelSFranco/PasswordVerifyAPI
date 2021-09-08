package com.passwordVerify.application.web.services

class VerifyService {

    private val passwordRegex =
        Regex("""^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#${'$'}%^&*()-+])(?=\S+${'$'}).{9,}""")

    fun verifyPwd(pwd: String): Boolean = pwd.let { pwdLetterRepeater(pwd) and pwdRegex(pwd) }

    private fun pwdLetterRepeater(pwd: String): Boolean {
        val letters = pwd.toCharArray().sorted()
        letters.forEach { letter ->
            if (pwd.count { it == letter } > 1  ) return false
        }
        return true
    }

    private fun pwdRegex(pwd: String): Boolean = passwordRegex.matches(pwd)
}