package com.teulsko.HiringApp.Controller;

import com.teulsko.HiringApp.Model.Post;
import com.teulsko.HiringApp.Repository.PostRepo;
import com.teulsko.HiringApp.Repository.SearchRepo;
import com.teulsko.HiringApp.Repository.SearchRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class PostController {

    @Autowired
    PostRepo repo;

    @Autowired
    SearchRepo searchRepo;

    @Autowired
    SearchRepoImpl searchRepoImpl;


    @RequestMapping("/health")
    public void health(){
        System.out.println("Ok");
    }

    @GetMapping("/allPosts")
    public List<Post> getAllJobPosts(){
        return repo.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return searchRepo.searchByText(text);
    }
}
