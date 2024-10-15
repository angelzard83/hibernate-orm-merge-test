package my.hibernate.merge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AggregateRootEventMergeTest {

  @Autowired
  private MyEntityRepository myEntityRepository;

  @Test
  void When_Merge_Then_MyEntityListener_ChildEntity_getId_Is_Null() {
    MyEntity myEntity = myEntityRepository.save(new MyEntity());

    myEntity.addChild(new ChildEntity());

    // In MyEntityListener, the id value of the merged ChildEntity becomes null.
    myEntity = myEntityRepository.save(myEntity);

    assertThat(myEntity.getChildren().get(0).getId()).isNotNull();
  }

}
