package com.teulsko.HiringApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Document(collection= "JobPost")
public class Post {
    private String profile;
    private String desc;
    private int experience;
    private String[] techs;
}
