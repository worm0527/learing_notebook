import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author shuyuan.xu
 * @date 2021-03-31.
 */
public class CollectionsTest {

  @Test
  public void shuffleTest() {
    List<String> list = new ArrayList() {
      {
        add("1");
        add("2");
        add("3");
        add("4");
        add("5");
        add("6");
        add("7");
        add("8");
      }
    };


    Random random = new Random();
    for (int i = list.size(); i > 1; i--) {
      int randomIndex = random.nextInt(i);
      int index = i - 1;
      list.set(index, list.set(randomIndex, list.get(index)));
      System.out.println(list);
    }
  }

}
