package pl.agh.graphbd.domain;


import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "RATED")
public class Rated {

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
