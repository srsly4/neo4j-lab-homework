package pl.agh.graphbd.domain;


import org.neo4j.ogm.annotation.*;

import java.util.Date;

@RelationshipEntity(type = "OBSERVES")
public class Observes {

    @GraphId
    private Long id;

    @Property
    private Date startDate;

    @StartNode
    private User observer;

    @EndNode
    private User observed;

    public Observes() {
    }

    public Observes(Date startDate, User observer, User observed) {
        this.startDate = startDate;
        this.observer = observer;
        this.observed = observed;
    }

    @Override
    public String toString() {
        return String.format("------\n%s\n-OBSERVES (from %s)-\n%s\n------",
                observer.toString(), startDate.toString(), observed.toString());
    }

    public Long getId() {
        return id;
    }
}
