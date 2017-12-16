package pl.agh.graphbd;

import org.neo4j.ogm.session.Session;
import pl.agh.graphbd.domain.Observes;
import pl.agh.graphbd.domain.Post;
import pl.agh.graphbd.domain.User;

import java.util.Collection;
import java.util.Date;

public class Dao {

    public static User createUser(Session session, String firstName, String lastName) {
        User user = new User(firstName, lastName);
        session.save(user);
        return user;
    }

    public static Post createPost(Session session, String content, Long userId) {
        Post post = new Post(content, new Date(), session.load(User.class, userId));
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
}
