package com.teulsko.HiringApp.Controller;

import com.teulsko.HiringApp.Model.Post;
import com.teulsko.HiringApp.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepo repo;

    @RequestMapping("/health")
    public void health(){
        System.out.println("Ok");
    }

    @GetMapping("/posts")
    public List<Post> getAllJobPosts(){
        return repo.findAll();
    }
}
