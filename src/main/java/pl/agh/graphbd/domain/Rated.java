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
}
