package com.teulsko.HiringApp.Repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClients;
import com.teulsko.HiringApp.Model.Post;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImpl implements SearchRepo {

    // Use MongoClients.create() to establish a connection with MongoDB
    MongoClient mongoClient = MongoClients.create(
            "mongodb+srv://root:root@telusko.vw3ei.mongodb.net/?retryWrites=true&w=majority&appName=telusko"
    );
@Autowired
    MongoConverter converter;
    MongoDatabase database = mongoClient.getDatabase("telusko");

    @Override
    public List<Post> searchByText(String text) {
        ArrayList<Post> posts = new ArrayList<>();
        MongoCollection<Document> collection = database.getCollection("JobPost");

        // MongoDB Aggregation pipeline to search, sort and limit results
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                        new Document("index", "default")
                                .append("text", new Document("query", text)
                                        .append("path", Arrays.asList("techs", "profile", "desc")))),
                new Document("$sort", new Document("exp", 1L)),
                new Document("$limit", 5L)
        ));

        // Process the result and add the posts (this part is currently missing)
        // Here, you would typically iterate over the result and convert it into Post objects
        result.forEach(document -> {
            // Assuming Post class has a constructor that can take a Document
            posts.add(converter.read(Post.class,document));
        });

        return posts;
    }
}
