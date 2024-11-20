package com.teulsko.HiringApp.Repository;

import com.teulsko.HiringApp.Model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SearchRepo {

    public List<Post> searchByText(String text) ;
}
