
public class Main {
    public static void main(String[] args) {
        FacilityInjector facilityInjector = new FacilityInjector();
        Pemilik pemilik1 = new Pemilik("pemilik1");
        for(int i = 0 ; i < 10 ; i++) {
            pemilik1.addProperty(new HotelRoom(HotelRoomType.DELUXE, 600000));
            for(Property property : pemilik1.getProperties()) {
                facilityInjector.inject(property, "Kolam renang", 0);
                facilityInjector.inject(property, "Sarapan", 80000);
            }
        }

        Pemilik pemilik2 = new Pemilik("pemilik2");
        for(int i = 0 ; i < 3 ; i++) {
            UnitApartment unitApartment = new UnitApartment(2, 700000); 
            pemilik2.addProperty(unitApartment);
            facilityInjector.inject(unitApartment, "Sarapan",60000);
        }
        for(int i = 0 ; i < 5 ; i++) {
            Homestay homestay = new Homestay(150000);
        }
    }
}