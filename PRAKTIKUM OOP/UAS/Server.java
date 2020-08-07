import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Pelanggan> pelangganList;

    public Server() {
        this.pelangganList = new ArrayList<>();
    }

    /**
     * @return the pelangganList
     */
    public List<Pelanggan> getPelangganList() {
        return pelangganList;
    }

    public void addPelanggan(Pelanggan pelanggan) {
        this.pelangganList.add(pelanggan);
    }

    public void broadcastMessage(String message) {
        for(Pelanggan pelanggan : pelangganList) {
            pelanggan.receiveMessage(message);
        }
    }
}