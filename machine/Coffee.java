package machine;

public class Coffee {
    private int requiredWater;
    private int requiredMilk;
    private int requiredCoffee;
    private int cost;

    public enum CoffeeType {
        ESPRESSO,
        LATTE,
        CAPPUCCINO
    }

    Coffee(CoffeeType type) {
        switch (type) {
            case ESPRESSO -> {
                this.requiredWater = 250;
                this.requiredMilk = 0;
                this.requiredCoffee = 16;
                this.cost = 4;
            }
            case LATTE -> {
                this.requiredWater = 350;
                this.requiredMilk = 75;
                this.requiredCoffee = 20;
                this.cost = 7;
            }
            case CAPPUCCINO -> {
                this.requiredWater = 200;
                this.requiredMilk = 100;
                this.requiredCoffee = 12;
                this.cost = 6;
            }
        }
    }

    public int getRequiredWater() {
        return this.requiredWater;
    }

    public int getRequiredMilk() {
        return this.requiredMilk;
    }

    public int getRequiredCoffee() {
        return this.requiredCoffee;
    }

    public int getCost() {
        return this.cost;
    }
}

