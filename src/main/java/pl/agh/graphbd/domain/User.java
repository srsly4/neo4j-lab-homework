package pl.agh.graphbd.domain;

import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label="User")
public class User {

    @GraphId
    private Long id;

    @Property(name="firstName")
    private String firstName;

    @Property(name="lastName")
    private String lastName;

    @Relationship(type = "POSTED")
    private Set<Post> posts = new HashSet<>();

    @Relationship(type = "OBSERVES", direction=Relationship.INCOMING)
    private Set<Observes> observers = new HashSet<>();

    @Relationship(type = "OBSERVES")
    private Set<Observes> observedUsers = new HashSet<>();

    public User() { }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Observes> getObservers() {
        return observers;
    }

    public Set<Observes> getObservedUsers() {
        return observedUsers;
    }

    @Override
    public String toString() {
        return String.format("%d, %s %s Observed: %d, Observers: %d",
                this.id, this.firstName, this.lastName, this.observedUsers.size(), this.observers.size());
    }
}
