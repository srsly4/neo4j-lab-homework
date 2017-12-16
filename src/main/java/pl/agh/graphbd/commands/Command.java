package pl.agh.graphbd.commands;


import org.neo4j.ogm.session.Session;
import pl.agh.graphbd.InputProcessor;
import pl.agh.graphbd.Neo4jSessionFactory;

public abstract class Command {

    protected Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();
    protected InputProcessor input = InputProcessor.getInstance();

    public abstract void execute();
    public abstract String getDescription();
}
