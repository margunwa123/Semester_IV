public abstract class Account implements HasPosition {
    protected String username;
    protected Position address;

    public Account(String username, Position address) {
        this.username = username;
        this.address = address;
    }

    @Override
    public Position getPosition() {
        return this.address;
    }

    @Override
    public void setPosition(Position p) {
        this.address = p;
    }
    
}