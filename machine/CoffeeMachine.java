package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        State state = new State();
        state.print();
        System.out.println();

        System.out.println("Write action (buy, fill, take):");
        String action = scanner.nextLine();
        switch (action) {
            case "buy" -> {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> state.sellAnEspresso();
                    case 2 -> state.sellALatte();
                    case 3 -> state.sellACappuccino();
                }
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
        }

        System.out.println();
        state.print();
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

    protected void sellAnEspresso() {
        this.mlsOfWater -= 250;
        this.gsOfCoffee -= 16;
        this.numberOfCups -= 1;
        this.dollarsOfMoney += 4;
    }

    protected void sellALatte() {
        this.mlsOfWater -= 350;
        this.mlsOfMilk -= 75;
        this.gsOfCoffee -= 20;
        this.numberOfCups -= 1;
        this.dollarsOfMoney += 7;
    }

    protected void sellACappuccino() {
        this.mlsOfWater -= 200;
        this.mlsOfMilk -= 100;
        this.gsOfCoffee -= 12;
        this.numberOfCups -= 1;
        this.dollarsOfMoney += 6;
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