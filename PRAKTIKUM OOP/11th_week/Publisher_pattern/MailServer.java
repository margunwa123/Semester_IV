import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// import java api jika diperlukan

public class MailServer implements EventChannel {
  // tambahkan properties jika perlu
  private Map<String, List<Subscriber>> topic_subscribers;

  public MailServer() {
    // menginisiasi daftar subscriber 
    topic_subscribers = new HashMap<String, List<Subscriber>>(); 
  }

  public void addSubscriber(final String topic, final Subscriber s) {
    // tambahkan s sebagai subscriber ke topic yang diberikan
    if(topic_subscribers.containsKey(topic)) {
      topic_subscribers.get(topic).add(s);
    }
    else {
      List<Subscriber> list = new ArrayList<Subscriber>();
      list.add(s);
      topic_subscribers.put(topic, list);
    }
  }

  public void sendEvent(final String topic, final Event event) {
    // untuk setiap subscriber s yang sudah subscribe ke topic yang diberikan,
    // panggil s.onEvent(event)
    if(this.topic_subscribers.containsKey(topic)) {
      List<Subscriber> listOfSubscriber = this.topic_subscribers.get(topic);
      for (Subscriber subscriber : listOfSubscriber) {
        subscriber.onEvent(event);
      }
    }
  }
}
