package machine;

public class CoffeeMachine {
    int mlsOfWater;
    int mlsOfMilk;
    int gsOfCoffee;
    int numberOfCups;
    int dollarsOfMoney;
    int cupsSinceCleaning;

    protected CoffeeMachine() {
        this.mlsOfWater = 400;
        this.mlsOfMilk = 540;
        this.gsOfCoffee = 120;
        this.numberOfCups = 9;
        this.dollarsOfMoney = 550;
        this.cupsSinceCleaning = 0;
    }

    protected void print() {
        System.out.println("The coffee machine has:");
        System.out.println(this.mlsOfWater + " ml of water");
        System.out.println(this.mlsOfMilk + " ml of milk");
        System.out.println(this.gsOfCoffee + " g of coffee beans");
        System.out.println(this.numberOfCups + " disposable cups");
        System.out.println("$" + this.dollarsOfMoney + " of money");
    }

    protected void sellACoffee(int coffeeType) {
        Coffee coffee = switch (coffeeType) {
            case 1 -> new Coffee(Coffee.CoffeeType.ESPRESSO);
            case 2 -> new Coffee(Coffee.CoffeeType.LATTE);
            case 3 -> new Coffee(Coffee.CoffeeType.CAPPUCCINO);
            default -> throw new IllegalStateException("Unexpected value: " + coffeeType);
        };

        if (this.mlsOfWater < coffee.getRequiredWater()) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (this.mlsOfMilk < coffee.getRequiredMilk()) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (this.gsOfCoffee < coffee.getRequiredCoffee()) {
            System.out.println("Sorry, not enough coffee!");
            return;
        }
        if (this.numberOfCups < 1) {
            System.out.println("Sorry, not enough cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        this.sell(coffee);
        this.cupsSinceCleaning++;
    }

    protected void sell(Coffee coffee) {
        this.mlsOfWater -= coffee.getRequiredWater();
        this.mlsOfMilk -= coffee.getRequiredMilk();
        this.gsOfCoffee -= coffee.getRequiredCoffee();
        this.numberOfCups -= 1;
        this.dollarsOfMoney += coffee.getCost();
    }

    protected void fill(int water, int milk, int coffee, int cups) {
        this.mlsOfWater += water;
        this.mlsOfMilk += milk;
        this.gsOfCoffee += coffee;
        this.numberOfCups += cups;
    }

    protected void clean() {
        this.cupsSinceCleaning = 0;
        System.out.println("I have been cleaned!");
    }

    protected boolean needsCleaning() {
        return this.cupsSinceCleaning >= 10;
    }

    protected int takeCashOut() {
        int amount = this.dollarsOfMoney;
        this.dollarsOfMoney = 0;
        return amount;
    }
}