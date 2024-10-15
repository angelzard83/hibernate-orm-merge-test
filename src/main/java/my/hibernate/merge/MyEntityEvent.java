package my.hibernate.merge;

public class MyEntityEvent {

    MyEntity object;

    public MyEntityEvent(MyEntity entity) {
        this.object = entity;
    }

    public MyEntity getObject() {
        return object;
    }
}