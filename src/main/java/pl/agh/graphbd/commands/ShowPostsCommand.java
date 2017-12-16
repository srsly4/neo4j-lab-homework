package pl.agh.graphbd.commands;


import pl.agh.graphbd.domain.Post;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ShowPostsCommand extends Command {
    @Override
    public void execute() {
        Collection<Post> posts = session.loadAll(Post.class);
        List<Post> sorted = new ArrayList<>(posts);
        sorted.sort(Comparator.comparing(Post::getCreated));
        sorted.forEach((post) -> System.out.println(post.toString()));
    }

    @Override
    public String getDescription() {
        return "shows all posts";
    }
}
