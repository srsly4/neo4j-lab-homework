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
    private Set<Rated> ratings = new HashSet<>();

    public Post() {

    }

    public Post(String content, Date created, User author) {
        this.content = content;
        this.created = created;
        this.author = author;
    }

    public String getRatingsString() {
        StringBuilder ret = new StringBuilder();
        this.getRatings().forEach((rating) -> {
            ret.append(String.format("%d by %s %s, ",
                    rating.getStars(),
                    rating.getUser().getFirstName(),
                    rating.getUser().getLastName()
                    ));
        });
        return ret.toString();
    }

    @Override
    public String toString() {
        return String.format("--- [%d] Posted by: %s %s on: %s ---\n%s\n--- Ratings ---\n%s\n------",
                this.getId(),
                this.author.getFirstName(),
                this.author.getLastName(),
                this.created.toString(),
                this.getContent(),
                this.getRatingsString()
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
