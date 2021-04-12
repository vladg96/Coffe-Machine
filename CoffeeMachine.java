package machine;
import java.util.Scanner;

public class CoffeeMachine {

    static int money = 550;
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int disposableCups = 9;
    static boolean exit = false;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            Scanner in = new Scanner(System.in);
            String action = in.nextLine();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    exit();
                    break;
            }
        }
        while (exit == false);
    }

    static void buy() {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String option = in.next();
        switch (option) {
            case "1": {
                if (canMakeCoffee(250, 0, 16)) {
                    water = water - 250;
                    coffeeBeans = coffeeBeans - 16;
                    money = money + 4;
                    disposableCups = disposableCups - 1;
                    break;
                }
            }
            case "2": {
                if (canMakeCoffee(350, 75, 20)) {
                    water = water - 350;
                    milk = milk - 75;
                    coffeeBeans = coffeeBeans - 20;
                    money = money + 7;
                    disposableCups = disposableCups - 1;
                    break;
                }
            }
            case "3": {
                if (canMakeCoffee(200, 100, 12)) {
                    water = water - 200;
                    milk = milk - 100;
                    coffeeBeans = coffeeBeans - 12;
                    money = money + 6;
                    disposableCups = disposableCups - 1;
                    break;
                }
            }
            case "back": {
                break;
            }
            default: {
                break;
            }

        }
    }

    static void fill() {
        System.out.println();
        System.out.println("Write how many ml of water do you want to add: ");
        water = water + in.nextInt();
        System.out.println();

        System.out.println("Write how many ml of milk do you want to add: ");
        milk = milk + in.nextInt();
        System.out.println();

        System.out.println("Write how many grams of coffee beans do you want to add: ");
        coffeeBeans = coffeeBeans + in.nextInt();
        System.out.println();

        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        disposableCups = disposableCups + in.nextInt();
        System.out.println();
    }

    static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " money");
        System.out.println();
    }

    static void exit() {
        exit = true;
    }

    static boolean canMakeCoffee(int waterNeed, int milkNeed, int coffeeBeansNeed) {
        if (water >= waterNeed) {
            if (milk >= milkNeed) {
                if (coffeeBeans >= coffeeBeansNeed) {
                    System.out.println("I have enough resources for making you a coffee!");
                    return true;
                }
                else {
                    System.out.println("Sorry, not enough coffee beans!");
                    return false;
                }
            }
            else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        }
        else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }
}