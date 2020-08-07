public class Product implements HasPosition {
    private int price;
    private int stock;
    private Position storagePosition;

    public Product(int price, int stock, Position storagePosition) {
        this.price = price;
        this.stock = stock;
        this.storagePosition = storagePosition;
    }

    public void decrementStock() throws ProductOutOfStockException {
        if(this.stock == 0) {
            throw new ProductOutOfStockException("Produk ini kosong");
        }
        this.stock--;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public Position getPosition() {
        return this.storagePosition;
    }

    @Override
    public void setPosition(Position p) {
        this.storagePosition = p;
    }
}