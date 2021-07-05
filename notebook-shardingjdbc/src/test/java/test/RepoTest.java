package test;

import com.xsy.notebook.RunBoot;
import com.xsy.notebook.entity.Position;
import com.xsy.notebook.entity.PositionDetail;
import com.xsy.notebook.repo.PositionDetailRepo;
import com.xsy.notebook.repo.PositionRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shuyuan.xu
 * @date 2020-08-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBoot.class)
public class RepoTest {

  @Autowired
  private PositionRepo positionRepo;

  @Autowired
  private PositionDetailRepo positionDetailRepo;

  @Test
  public void addTest() {
    for (int i = 1; i <= 20; i++) {
      Position position = new Position();
//      position.setId((long) i);
      position.setName("position" + i);
      position.setSalary(i + "");
      position.setCity("shanghai" + i);
      positionRepo.save(position);

      PositionDetail detail = new PositionDetail();
      detail.setPid(position.getId());
      detail.setDescription("position detail" + i);
      positionDetailRepo.save(detail);
    }
  }

  @Test
  public void queryTest() {
    Object data = positionRepo.getInfoById(502975941174099968L);
    Object[] values = (Object[]) data;
    for (Object value : values) {
      System.out.println(value);
    }
  }

}
