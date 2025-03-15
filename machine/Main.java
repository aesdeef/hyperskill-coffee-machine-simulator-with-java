package machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        mainLoop:
        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String action = scanner.nextLine();
            if (coffeeMachine.needsCleaning()) {
                if (action.equals("clean")) {
                    coffeeMachine.clean();
                } else {
                    System.out.println("I need cleaning!");
                }
            } else {
                switch (action) {
                    case "buy" -> {
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                        String choice = scanner.nextLine();
                        if (choice.equals("back")) {
                            continue;
                        }
                        coffeeMachine.sellACoffee(Integer.parseInt(choice));
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
                        coffeeMachine.fill(water, milk, coffee, cups);
                    }
                    case "take" -> {
                        int amount = coffeeMachine.takeCashOut();
                        System.out.println("I gave you $" + amount);
                    }
                    case "clean" -> {
                        coffeeMachine.clean();
                    }
                    case "remaining" -> coffeeMachine.print();
                    case "exit" -> {
                        break mainLoop;
                    }
                }
            }
        }

        scanner.close();
    }
}
