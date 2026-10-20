interface Pizza {
    String getDescription();
    double getCost();
}
class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Pizza";
    }
    @Override
    public double getCost() {
        return 1.5;
    }
}
abstract class PizzaDecorator implements Pizza {
    protected final Pizza tempPizza;
    public PizzaDecorator(Pizza tempPizza) {
        this.tempPizza = tempPizza;
    }
    @Override
    public String getDescription() {
        return tempPizza.getDescription();
    }
    @Override
    public double getCost() {
        return tempPizza.getCost();
    }
}
class Cheese extends PizzaDecorator {
    public Cheese(Pizza tempPizza) {
        super(tempPizza);
    }
    @Override
    public String getDescription() {
        return tempPizza.getDescription()+", cheese";
    }
    @Override
    public double getCost() {
        return tempPizza.getCost()+2.0;
    }
}
class olives extends PizzaDecorator {
    public olives(Pizza tempPizza) {
        super(tempPizza);
    }
    @Override
    public String getDescription() {
        return tempPizza.getDescription()+", olives";
    }
    @Override
    public double getCost() {
        return tempPizza.getCost()+1.0;
    }
}
class Pineapple extends PizzaDecorator {
    public Pineapple(Pizza tempPizza) {
        super(tempPizza);
    }
    @Override
    public String getDescription() {
        return tempPizza.getDescription()+", pineapple";
    }
    @Override
    public double getCost() {
        return tempPizza.getCost()+1.5;
    }
}
public class Main {
    public static void main(String[] args) {
        Pizza mypizza=new olives(new Pineapple(new Cheese(new PlainPizza())));
        System.out.println(mypizza.getDescription());
        System.out.printf("Total Cost:  $%.2f\n", mypizza.getCost());

    }
}