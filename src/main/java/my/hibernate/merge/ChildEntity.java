package my.hibernate.merge;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ChildEntity {

    @Id
    @GeneratedValue
    Long id;

    public Long getId() {
        return id;
    }
}