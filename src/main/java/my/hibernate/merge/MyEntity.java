package my.hibernate.merge;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
public class MyEntity extends AbstractAggregateRoot<MyEntity> {


    @Id
    @GeneratedValue
    Long id;

    @OneToMany(cascade = jakarta.persistence.CascadeType.ALL)
    List<ChildEntity> children = new ArrayList<>();

    public void addChild(ChildEntity childEntity) {
        children.add(childEntity);
        registerEvent(new MyEntityEvent(this));
    }

    public Long getId() {
        return id;
    }

    public List<ChildEntity> getChildren() {
        return children;
    }
}