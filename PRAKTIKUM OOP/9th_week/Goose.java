class Goose {
    private String name;
    private int honk;

    public Goose(String name, int honk) {
        this.name = name;
        this.honk = honk;
    }
    public Goose() {
        this("Horrible", 1);
    }

    public void steal(String thing) {
        System.out.println(this.name + " steals " + thing);
    }

    public String toString() {
        String result = "";
        result += (this.name + " goose says");
        for(int i = 0 ; i < this.honk ; i++ ){
            result += " honk";
        }
        return result;
    }

    public static void main(String[] args) {
        Goose A = new Goose();
        A.steal("Shoes");
        String abc = "aaa";
        abc = abc.concat("bbb");
        System.out.println(abc);
        System.out.println(A);
        
    }
}