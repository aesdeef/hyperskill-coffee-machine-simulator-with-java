package machine;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int mlsOfWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int mlsOfMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int gsOfCoffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int numberOfCups = scanner.nextInt();

        int[] cupsPerIngredient = {mlsOfWater / 200, mlsOfMilk / 50, gsOfCoffee / 15};
        int capacity = Arrays.stream(cupsPerIngredient).min().orElse(0);

        if (numberOfCups > capacity) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)%n", capacity - numberOfCups);
        } else if (numberOfCups == capacity) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee%n", capacity);
        }

        /* STAGE 2
        System.out.printf("For %d cups of coffee you will need:%n", numberOfCups);
        System.out.printf("%d ml of water%n", numberOfCups * 200);
        System.out.printf("%d ml of milk%n", numberOfCups * 50);
        System.out.printf("%d g of coffee beans%n", numberOfCups * 15);
         */
    }
}