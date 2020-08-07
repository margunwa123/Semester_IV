import java.util.ArrayList;
import java.util.List;

public class BedAndBreakfast {
    private static BedAndBreakfast instance = new BedAndBreakfast();
    private List<Pelanggan> pelangganList;
    private List<Pemilik> pemilikList;
    
    public static BedAndBreakfast getInstance() {
        if(instance == null) {
            instance = new BedAndBreakfast();
        }
        return instance;
    }

    public List<Pemilik> getPemilikList() {
        if(pemilikList == null) {
            pemilikList = new ArrayList<>();
        }
        return this.pemilikList;
    }

    /**
     * @return the pelangganList
     */
    public List<Pelanggan> getPelangganList() {
        if(pelangganList == null) {
            pelangganList = new ArrayList<>();
        }
        return pelangganList;
    }

    public void addPelanggan(Pelanggan pelanggan) {
        this.pelangganList.add(pelanggan);
    }
    
    public void addPemilik(Pemilik pemilik) {
        this.pemilikList.add(pemilik);
    }

    public void printAvailableProperties() {
        for(Pemilik pemilik : getPemilikList()) {
            for(Property property : pemilik.getProperties()) {
                System.out.println(pemilik.getName() + " memiliki " + property.getDescription() + " available");
            }
        }
    }
}