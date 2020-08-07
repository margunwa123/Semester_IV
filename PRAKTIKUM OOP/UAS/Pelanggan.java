import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pelanggan {
    private String name;
    private String email;
    private String noTelp;
    private Property registeredProperty;
    
    public Pelanggan(String name, String email, String noTelp) {
        this.name = name;
        this.email = email;
        this.noTelp = noTelp;
    }

    public String getDescription() {
        return ("Nama : " + name + "\n Email : " + email + "\n No. telp : " + noTelp);
    }

    public void receiveMessage(String message) {
        System.out.println("Message diterima : " + message);
    }

    public void registerToProperty(Pemilik pemilik, Property property) {
        property.setAvailability(false);
        this.registeredProperty = property;
        pemilik.addPelangganToServer(this);
    }
}