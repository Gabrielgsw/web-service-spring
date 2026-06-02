package br.com.calcassinc.webservice.controller;

import br.com.calcassinc.webservice.dto.UserDTO;
import br.com.calcassinc.webservice.model.User;
import br.com.calcassinc.webservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){

        User user = userService.findById(id);

        return ResponseEntity.ok().body(new UserDTO(user));

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        userService.addUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
