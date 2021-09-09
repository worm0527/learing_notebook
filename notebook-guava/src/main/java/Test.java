import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @author xushuyuan@zj.tech.
 * @date 2021/8/16 10:51.
 */
public class Test {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus("test");
        eventBus.register(new EventMsg1Listener());
        eventBus.register(new EventMsg2Listener());
        eventBus.post(new EventMsg1());
        eventBus.post(new EventMsg2());
    }

    public static class EventMsg1 {

        public void action() {
            System.out.println("this is EventMsg1");
        }

    }

    public static class EventMsg1Listener {

        @Subscribe
        public void listener(EventMsg1 eventMsg1) {
            eventMsg1.action();
        }

    }

    public static class EventMsg2 {

        public void action() {
            System.out.println("this is EventMsg2");
        }

    }

    public static class EventMsg2Listener {

        @Subscribe
        public void listener(EventMsg2 eventMsg) {
            eventMsg.action();
        }

    }

}
