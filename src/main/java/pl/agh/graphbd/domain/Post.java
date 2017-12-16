package pl.agh.graphbd.domain;


import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label="Post")
public class Post {

    @GraphId
    private Long id;

    @Property(name="content")
    private String content;

    @Property(name="timestamp")
    private Long timestamp;

    @Relationship(type="POSTED")
    private User author;

    @Relationship(type= "RATED", direction=Relationship.INCOMING)
    Set<User> ratings = new HashSet<>();
}
