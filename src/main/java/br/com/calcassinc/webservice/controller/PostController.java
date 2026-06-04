package br.com.calcassinc.webservice.controller;

import br.com.calcassinc.webservice.controller.util.URL;
import br.com.calcassinc.webservice.model.Post;
import br.com.calcassinc.webservice.service.PostService;
import br.com.calcassinc.webservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {


    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> getPost(@PathVariable String id) {

        Post post = postService.findbyId(id);

        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text); // decodifica parametro para fazer a consulta no mongo

        List<Post> posts = postService.findByTitle(text);

        return ResponseEntity.ok().body(posts);
    }
}
