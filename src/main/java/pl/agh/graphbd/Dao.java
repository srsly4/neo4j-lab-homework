package pl.agh.graphbd;

import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import pl.agh.graphbd.domain.Observes;
import pl.agh.graphbd.domain.Post;
import pl.agh.graphbd.domain.Rated;
import pl.agh.graphbd.domain.User;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class Dao {

    public static User createUser(Session session, String firstName, String lastName) {
        User user = new User(firstName, lastName);
        session.save(user);
        return user;
    }

    // creates also POSTED relation
    public static Post createPost(Session session, String content, Long userId, Date date) {
        Post post = new Post(content, date, session.load(User.class, userId));
        session.save(post);
        return post;
    }

    public static Observes createObservesRelation(Session session, Long userId, Long observedUserId) {
        User user = session.load(User.class, userId);
        User observedUser = session.load(User.class, observedUserId);

        if (user == null || observedUser == null) {
            return null;
        }

        Observes observes = new Observes(new Date(), user, observedUser);
        session.save(observes);
        return observes;
    }

    public static Rated createRatedRelation(Session session, Long userId, Long postId, int stars) {
        User user = session.load(User.class, userId);
        Post post = session.load(Post.class, postId);

        if (user == null || post == null) {
            return null;
        }

        Rated rated = new Rated(stars, user, post);
        session.save(rated);
        return rated;
    }

    public static Result getRelations(Session session, Long id) {
        String query = String.format("MATCH (a)-[r]-(b) WHERE ID(a) = %d RETURN a, b, r," +
                " LABELS(a) AS alabel, LABELS(b) AS blabel, TYPE(r) as rtype", id);
        Result res = session.query(query, Collections.EMPTY_MAP);
        return res;
    }
}
