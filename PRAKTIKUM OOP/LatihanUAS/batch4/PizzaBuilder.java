public class PizzaBuilder {
    private Pizza pizza;

    public PizzaBuilder() {
        this.pizza = new Pizza();
    }

    public PizzaBuilder size(String _size) {
        switch(_size) {
            case "small":
                this.pizza.setDiameter(25);
                break;
            case "medium":
                this.pizza.setDiameter(35);
                break;
            case "large":
                this.pizza.setDiameter(40);
                break;
        }
        return this;
    }

    public PizzaBuilder crust(String _crust) {
        this.pizza.setCrust(_crust);
        return this;
    }

    public PizzaBuilder addTopping(String topping) {
        switch(topping) {
            case "Meat Lovers":
                this.pizza.addToppingIngredient("beef");
                this.pizza.addToppingIngredient("mozarella");
                break;
            case "Tuna Melt":
                this.pizza.addToppingIngredient("tuna");
                this.pizza.addToppingIngredient("corn");
                this.pizza.addToppingIngredient("mozarella");
                break;
            case "Supreme":
                this.pizza.addToppingIngredient("pepperoni");
                this.pizza.addToppingIngredient("beef");
                this.pizza.addToppingIngredient("mushroom");
                this.pizza.addToppingIngredient("pineapple");
            break;
        }
        return this;
    }

    public Pizza build() {
        this.pizza.setPrice(15 * this.pizza.getDiameter() + 10 * this.pizza.getToppingIngredients().size());
        switch(this.pizza.getCrust()) {
            case "Original":
                break;
            case "Cheesy Bites":
                this.pizza.setPrice(this.pizza.getPrice() + 10);
                break;
            case "Stuffed":
                this.pizza.setPrice(this.pizza.getPrice() + 20);
                break;
        }
        return this.pizza;
    }
}