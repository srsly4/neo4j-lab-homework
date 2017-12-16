package pl.agh.graphbd.commands;


import org.fluttercode.datafactory.impl.DataFactory;
import pl.agh.graphbd.Dao;
import pl.agh.graphbd.domain.Post;
import pl.agh.graphbd.domain.Rated;
import pl.agh.graphbd.domain.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PopulateDatabaseCommand extends Command {
    private static int USERS = 10;
    private static int OBSERVES = 4;
    private static int POSTS = 7;
    private static int RATINGS = 10;

    @Override
    public void execute() {
        DataFactory df = new DataFactory();

        List<User> users = new ArrayList<>();
        List<Post> posts = new ArrayList<>();
        // users and posts
        for (int i = 0; i < USERS; i++) {
            User user = Dao.createUser(session, df.getFirstName(), df.getLastName());
            users.add(user);
            for (int j = 0; j < POSTS; j++) {
                Calendar startDate = Calendar.getInstance();
                startDate.add(Calendar.YEAR, -1);
                Post post = Dao.createPost(session,
                        df.getRandomText(40, 120),
                        user.getId(), df.getDateBetween(startDate.getTime(), new Date()));
                posts.add(post);
            }
        }

        // observes
        for (User user : users) {
            List<User> remain = new ArrayList<>();
            remain.addAll(users);
            remain.remove(user);
            for (int i = 0; i < OBSERVES & i < remain.size(); i++) {
                User randUser = remain.get((int)Math.floor(Math.random()*remain.size()));
                Dao.createObservesRelation(session, user.getId(), randUser.getId());
                remain.remove(randUser);
            }
        }

        // ratings
        for (User user : users) {
            List<Post> remain = new ArrayList<>();
            remain.addAll(posts);
            for (int i = 0; i < RATINGS & i < remain.size(); i++) {
                Post randPost = remain.get((int)Math.floor(Math.random()*remain.size()));
                Dao.createRatedRelation(session, user.getId(), randPost.getId(), (int)Math.ceil(Math.random()*5));
                remain.remove(randPost);
            }
        }

        System.out.println(String.format("Created %d users, %d posts, %d observes relations, %d rated relations",
                USERS, USERS*POSTS, USERS*OBSERVES, USERS*RATINGS
                ));
    }

    @Override
    public String getDescription() {
        return "populates database with random data";
    }
}
