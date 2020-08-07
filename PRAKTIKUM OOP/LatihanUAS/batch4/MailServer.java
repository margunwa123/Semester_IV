import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import java api jika diperlukan

public class MailServer implements EventChannel {
  // tambahkan properties jika perlu
    private Map<String, List<Subscriber>> servers; 

  public MailServer() {
    // menginisiasi daftar subscriber
    servers = new HashMap<>();
  }

  public void addSubscriber(String topic, Subscriber s) {
    // tambahkan s sebagai subscriber ke topic yang diberikan
    if(!servers.containsKey(topic)) {
        servers.put(topic, new ArrayList<Subscriber>());
    }
    servers.get(topic).add(s);
  }

  public void sendEvent(String topic, Event event) {
    // untuk setiap subscriber s yang sudah subscribe ke topic yang diberikan,
    // panggil s.onEvent(event)
    if(this.servers.containsKey(topic)) {
        List<Subscriber> listOfSubscriber = this.servers.get(topic);
        for (Subscriber subscriber : listOfSubscriber) {
            subscriber.onEvent(event);
        }
    }
  }
}
