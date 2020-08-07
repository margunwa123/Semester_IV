import java.util.Set;

public class PizzaBuilder {
  private static Pizza pizza;

  public PizzaBuilder() {
    this.pizza = new Pizza();
  }
  
  public PizzaBuilder size(String _size_) {
    switch (_size_) {
      case "small":
        pizza.setDiameter(25);
        break;
      case "medium":
        pizza.setDiameter(35);
        break;
      case "large":
        pizza.setDiameter(40);
        break;
    }
    return this;
  }

  public PizzaBuilder crust(String _crust_) {
    pizza.setCrust(_crust_);
    return this;
  }

  
  public PizzaBuilder addTopping(String topping) {
    switch (topping) {
      case "Meat Lovers":
        pizza.addToppingIngredient("beef");  
        pizza.addToppingIngredient("mozarella");
        break;
      case "Tuna Melt":
        pizza.addToppingIngredient("tuna");  
        pizza.addToppingIngredient("corn");  
        pizza.addToppingIngredient("mozarella");  
        break;
      case "Supreme":
        pizza.addToppingIngredient("pepperoni");  
        pizza.addToppingIngredient("beef");  
        pizza.addToppingIngredient("mushroom");  
        pizza.addToppingIngredient("pineapple");  
        break;
    }
    return this;
  }

  public Pizza build() {
    int hargaTopping = pizza.getToppingIngredients().size() * 10;
    int hargaCrust = pizza.getCrust().equals("Original") ? 0 :
                      pizza.getCrust().equals("Cheesy Bites") ? 10 : 20;
    pizza.setPrice(pizza.getDiameter() * 15 + hargaTopping + hargaCrust);
    return pizza;
  }

}