import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Pemilik {
    private LocalDateTime timeRegistered;
    // anggap 1 pemilik 1 property
    private List<Property> properties;
    private String name;
    private Server server;

    public Pemilik(String name) {
        this.name = name;
        this.timeRegistered = LocalDateTime.now();
        this.properties = new ArrayList<>();
        this.server = new Server();
    }

    /**
     * @return the timeRegistered
     */
    public LocalDateTime getTimeRegistered() {
        return timeRegistered;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public void addPelangganToServer(Pelanggan pelanggan) {
        this.server.addPelanggan(pelanggan);
    }

    public void broadcastMessage(String message) {
        this.server.broadcastMessage(message);
    }

    /**
     * @param property the property to set
     */
    public void addProperty(Property property) {
        this.properties.add(property);
    }

    /**
     * @return the properties
     */
    public List<Property> getProperties() {
        return properties;
    }
}