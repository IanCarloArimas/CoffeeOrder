interface Coffee {
    String getDescription();
    double getCost();
}

class BlackCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Black Coffee";
    }

    @Override
    public double getCost() {
        return 100.00;
    }
}

class Espresso implements Coffee {
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return 120.00;
    }
}

abstract class CoffeeDecorator implements Coffee {
    private final Coffee wrappedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.wrappedCoffee = coffee;
    }

    protected Coffee getWrappedCoffee() {
        return wrappedCoffee;
    }

    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return wrappedCoffee.getCost();
    }
}

class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return getWrappedCoffee().getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return getWrappedCoffee().getCost() + 25.00;
    }
}

class CaramelSyrup extends CoffeeDecorator {
    public CaramelSyrup(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return getWrappedCoffee().getDescription() + ", Caramel Syrup";
    }

    @Override
    public double getCost() {
        return getWrappedCoffee().getCost() + 40.00;
    }
}

class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return getWrappedCoffee().getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return getWrappedCoffee().getCost() + 10.00;
    }
}

class WhippedCream extends CoffeeDecorator {
    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return getWrappedCoffee().getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return getWrappedCoffee().getCost() + 35.00;
    }
}

public class BrewtifulCoffeeShop {

    private static void printOrder(Coffee coffee) {
        System.out.printf("%-50s ₱ %.2f%n", coffee.getDescription(), coffee.getCost());
    }

    public static void main(String[] args) {
        Coffee order1 = new BlackCoffee();
        printOrder(order1);

        Coffee order2 = new CaramelSyrup(new Milk(new BlackCoffee()));
        printOrder(order2);

        Coffee order3 = new CaramelSyrup(new Milk(new Espresso()));
        printOrder(order3);

        Coffee order4 = new WhippedCream(
                           new CaramelSyrup(
                               new CaramelSyrup(
                                   new Sugar(
                                       new Milk(new BlackCoffee())))));
        printOrder(order4);
    }
}
