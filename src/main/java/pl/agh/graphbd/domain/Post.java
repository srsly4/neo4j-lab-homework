package pl.agh.graphbd.domain;


import org.neo4j.ogm.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NodeEntity(label="Post")
public class Post {

    @GraphId
    private Long id;

    @Property(name="content")
    private String content;

    @Property(name="timestamp")
    private Date created;

    @Relationship(type="POSTED", direction=Relationship.INCOMING)
    private User author;

    @Relationship(type= "RATED", direction=Relationship.INCOMING)
    Set<Rated> ratings = new HashSet<>();

    public Post() {

    }

    public Post(String content, Date created, User author) {
        this.content = content;
        this.created = created;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("--- Posted by: %s %s on: %s ---\n%s\n------",
                this.author.getFirstName(),
                this.author.getLastName(),
                this.created.toString(),
                this.content
        );
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getCreated() {
        return created;
    }

    public User getAuthor() {
        return author;
    }

    public Set<Rated> getRatings() {
        return ratings;
    }
}
