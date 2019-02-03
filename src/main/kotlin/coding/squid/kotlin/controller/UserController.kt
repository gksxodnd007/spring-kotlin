package coding.squid.kotlin.controller

import coding.squid.kotlin.domain.User
import coding.squid.kotlin.dto.RegisterUserDto
import coding.squid.kotlin.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UserController(private val userService: UserService) {

    @PostMapping("/user")
    fun registerUser(@RequestBody userInfo: RegisterUserDto) {
        userService.registerUser(userInfo)
    }

    @GetMapping("/user/{id}")
    fun retrieveUser(@PathVariable("id") id: Int): User {
        return userService.getUserOrThrow(id)
    }
}