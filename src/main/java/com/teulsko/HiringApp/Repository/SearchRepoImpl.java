package com.teulsko.HiringApp.Repository;

import com.teulsko.HiringApp.Model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchRepoImpl implements SearchRepo{
    @Override
    public List<Post> searchByText(String text) {
        ArrayList<Post> posts = new ArrayList<>();
        return posts;
    }
}
