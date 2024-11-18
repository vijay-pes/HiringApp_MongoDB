package com.teulsko.HiringApp;

import com.teulsko.HiringApp.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Post,String>{

}
