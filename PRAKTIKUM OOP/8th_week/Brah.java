class Brah {
    private String brather;
    Brah(String brather) {
        this.brather = brather;
    }
    Brah() {
        this("hohoho");
    }

    public String toString() {
        return String.format("nama brother kamu %s", this.brather);
    }

    public static void main(String[] args) {
        Brah brah = new Brah();
        System.out.println(brah);
    }
}