package br.com.calcassinc.webservice.controller;

import br.com.calcassinc.webservice.dto.UserDTO;
import br.com.calcassinc.webservice.model.User;
import br.com.calcassinc.webservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> users = userService.findAll();
        List<UserDTO> userDTO = users.stream().map(u -> new UserDTO(u)).toList();

        return ResponseEntity.ok().body(userDTO);

    }


}
