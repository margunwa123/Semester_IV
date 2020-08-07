import java.util.LinkedList;
import java.util.Queue;

public class Courier implements HasPosition {

    private class Order {
        private HasPosition from;
        private HasPosition to;
        private Product product;

        public Order(HasPosition from, HasPosition to, Product product) {
            this.from = from;
            this.to = to;
            this.product = product;
        }

        public HasPosition getFrom() {
            return from;
        }

        public HasPosition getTo() {
            return to;
        }

        public Product getProduct() {
            return product;
        }
    }

    private Queue<Order> orderQueue;
    private int multiplier;
    private Position officeAddress;

    public Courier(int multiplier, Position officeAdress) {
        this.multiplier = multiplier;
        this.officeAddress = officeAdress;
        this.orderQueue = new LinkedList<>(); 
    }

    public void addToQueue(HasPosition from, HasPosition to, Product product) {
        this.orderQueue.add(new Order(from, to, product));
    }

    public void send() {
        if(this.orderQueue.isEmpty()) {
            return;
        }
        Order order = this.orderQueue.poll();
        System.out.println(String.format("AvatarDuel %d berhasil dikirim", this.checkPrice(order.getFrom().getPosition(), order.getTo().getPosition())));
    }

    public int checkPrice(Position from, Position to) {
        return (this.multiplier * (this.officeAddress.distanceTo(from) + from.distanceTo(to) + to.distanceTo(this.officeAddress)));
    }
 
    @Override
    public Position getPosition() {
        return officeAddress;
    }

    @Override
    public void setPosition(Position p) {
        this.officeAddress = p;
    }
}