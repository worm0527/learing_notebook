package test;

import com.xsy.notebook.RunBoot;
import com.xsy.notebook.entity.Position;
import com.xsy.notebook.entity.PositionDetail;
import com.xsy.notebook.repo.PositionDetailRepo;
import com.xsy.notebook.repo.PositionRepo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shuyuan.xu, <shuyuan.xu@leyantech.com>
 * @date 2020-08-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBoot.class)
public class Test {

  @Autowired
  private PositionRepo positionRepo;

  @Autowired
  private PositionDetailRepo positionDetailRepo;

  @org.junit.Test
  public void addTest() {
    for (int i = 1; i <= 20; i++) {
      Position position = new Position();
//      position.setId((long) i);
      position.setName("position" + i);
      positionRepo.save(position);

      PositionDetail detail = new PositionDetail();
      detail.setPid(position.getId());
      positionDetailRepo.save(detail);
    }
  }

}
