
public class HotelRoom extends Property {
    private HotelRoomType hotelRoomType;
    private int cost;

    public HotelRoom(HotelRoomType hotelRoomType, int cost) {
        super(PropertyType.HOTEL_ROOM);
        this.hotelRoomType = hotelRoomType;
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return super.getCost() + cost;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + "hotel room";
    }
}