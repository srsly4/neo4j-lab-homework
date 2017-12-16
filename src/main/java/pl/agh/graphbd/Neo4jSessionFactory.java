package pl.agh.graphbd;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

public class Neo4jSessionFactory {

    private final static Configuration configuration = new Configuration.Builder()
            .uri("file:///var/tmp/neo4j.db").build();
    private final static SessionFactory sessionFactory = new SessionFactory(configuration, "pl.agh.graphbd.domain");
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();

    public static Neo4jSessionFactory getInstance() {
        return factory;
    }
    private static Session session;
    // prevent external instantiation
    private Neo4jSessionFactory() {
    }

    public Session getNeo4jSession() {
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }
}