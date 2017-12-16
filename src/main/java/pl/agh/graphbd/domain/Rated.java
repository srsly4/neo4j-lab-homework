package pl.agh.graphbd.domain;


import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "RATED")
public class Rated {

    @GraphId
    private Long id;

    @Property
    private int stars;

    @StartNode
    private User user;

    @EndNode
    private Post post;

    public Rated() { }

    public Rated(int stars, User user, Post post) {
        this.stars = stars;
        this.user = user;
        this.post = post;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public User getUser() {
        return user;
    }

    public Post getPost() {
        return post;
    }
}
