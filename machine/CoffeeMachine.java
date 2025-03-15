package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int numberOfCups = scanner.nextInt();
        System.out.printf("For %d cups of coffee you will need:%n", numberOfCups);
        System.out.printf("%d ml of water%n", numberOfCups * 200);
        System.out.printf("%d ml of milk%n", numberOfCups * 50);
        System.out.printf("%d g of coffee beans%n", numberOfCups * 15);
    }
}