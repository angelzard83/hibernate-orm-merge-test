package my.hibernate.merge;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class MyEntityListener {

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleMyEntityEvent(MyEntityEvent event) {
        MyEntity entity = event.getObject();

        List<ChildEntity> children = entity.getChildren();

        for (ChildEntity child : children) {
            System.out.println("childId: " + child.getId());
//            assert child.getId() != null; //work at <= 6.4.2
        }
    }
}