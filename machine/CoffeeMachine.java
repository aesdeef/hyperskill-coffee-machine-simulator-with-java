package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        State state = new State();
        mainLoop:
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy" -> {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String choice = scanner.nextLine();
                    if (choice.equals("back")) {
                        continue;
                    }
                    state.sellACoffee(Integer.parseInt(choice));
                }
                case "fill" -> {
                    System.out.println("Write how many ml of water you want to add:");
                    int water = scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int milk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int coffee = scanner.nextInt();
                    System.out.println("Write how many disposable cups you want to add:");
                    int cups = scanner.nextInt();
                    state.fill(water, milk, coffee, cups);
                }
                case "take" -> {
                    int amount = state.takeCashOut();
                    System.out.println("I gave you $" + amount);
                }
                case "remaining" -> state.print();
                case "exit" -> {
                    break mainLoop;
                }
            }
        }
        scanner.close();
    }
}

class State {
    int mlsOfWater;
    int mlsOfMilk;
    int gsOfCoffee;
    int numberOfCups;
    int dollarsOfMoney;

    protected State() {
        this.mlsOfWater = 400;
        this.mlsOfMilk = 540;
        this.gsOfCoffee = 120;
        this.numberOfCups = 9;
        this.dollarsOfMoney = 550;
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
            case 1 -> new Espresso();
            case 2 -> new Latte();
            case 3 -> new Cappuccino();
            default -> throw new IllegalStateException("Unexpected value: " + coffeeType);
        };

        if (this.mlsOfWater < coffee.requiredWater) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (this.mlsOfMilk < coffee.requiredMilk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (this.gsOfCoffee < coffee.requiredCoffee) {
            System.out.println("Sorry, not enough coffee!");
            return;
        }
        if (this.numberOfCups < 1) {
            System.out.println("Sorry, not enough cups!");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        this.sell(coffee);
    }

    protected void sell(Coffee coffee) {
        this.mlsOfWater -= coffee.requiredWater;
        this.mlsOfMilk -= coffee.requiredMilk;
        this.gsOfCoffee -= coffee.requiredCoffee;
        this.numberOfCups -= 1;
        this.dollarsOfMoney += coffee.cost;
    }

    protected void fill(int water, int milk, int coffee, int cups) {
        this.mlsOfWater += water;
        this.mlsOfMilk += milk;
        this.gsOfCoffee += coffee;
        this.numberOfCups += cups;
    }

    protected int takeCashOut() {
        int amount = this.dollarsOfMoney;
        this.dollarsOfMoney = 0;
        return amount;
    }
}