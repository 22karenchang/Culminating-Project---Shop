import java.util.Scanner;
import java.util.*;
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to ShopTopia!");
        System.out.println("On ShopTopia, customers can make decisions using the " +
                "numbers in front of each option." +
                "Ex. 1. Footwear --> type 1");
        System.out.println("To begin, please choose a Mode: 1. Admin  2. User");
        int mode = input.nextInt();
        if (mode == 1) { //admin mode
            System.out.println("Hi, Admin!");
            System.out.println("Please enter the password to log in, please " +
                    "ensure correct capitalization\t Password: Admin's/Password:)");
            String password = input.next();
            if (password.equals("Admin's/Password:)")) {
                System.out.println("You have successfully logged in!");
            }
        } else if (mode == 2){ //user mode
            //set up for shop
            int total = 0;
            int sneakers_available = 4;
            int sneakers_price = 105;
            int boots_available = 6;
            int boots_price = 200;
            int sandals_available = 3;
            int sandals_price = 45;
            int lipsticks_available = 4;
            int lipsticks_price = 25;
            int eyeliners_available = 5;
            int eyeliners_price = 8;
            int foundations_available = 2;
            int foundations_price = 30;
            int earrings_available = 6;
            int earrings_price = 16;
            int sunglasses_available = 5;
            int sunglasses_price = 190;
            int hats_available = 3;
            int hats_price = 13;
            System.out.println("Hi, User!");
            System.out.println("Here is our three categories, please select: " +
                    "1. Footwear  2. Makeup  3. Accessories");
            int category = input.nextInt();
            if (category == 1) { //footwear
                System.out.println("Here is our menu for Footwear: ");
                System.out.println("1. Sneakers\t$105\t4 available");
                System.out.println("2. Boots\t$200\t6 available");
                System.out.println("3. Sandals\t$45 \t3 available");
                System.out.println("Select the product: ");
                int product = input.nextInt();
                if (product == 1) { //sneakers
                    System.out.println("Select quantity: ");
                    int quantity = input.nextInt();
                } else if (product == 2) { //boots
                    System.out.println("Select quantity: ");
                    int quantity = input.nextInt();
                } else if (product == 3) { //sandals
                    System.out.println("Select quantity: ");
                    int quantity = input.nextInt();
                } else {
                    System.out.println("Invalid product");
                }
            } else if (category == 2) { //makeup
                System.out.println("Here is our menu for Makeup: ");
                System.out.println("1. Lipsticks\t$25\t4 available");
                System.out.println("2. Eyeliners\t$8\t5 available");
                System.out.println("3. Foundations\t$30\t2 available");
                System.out.println("Select the product: ");
                int product = input.nextInt();
                if (product == 1) { //lipsticks
                    System.out.println("Select quantity: ");
                    int quantity = input.nextInt();
                } else if (product == 2) { //eyeliners
                    System.out.println("Select quantity: ");
                    int quantity = input.nextInt();
                } else if (product == 3) { //foundations
                    System.out.println("Select quantity: ");
                    int quantity = input.nextInt();
                } else {
                    System.out.println("Invalid product");
                }
            } else if (category == 3) { //accessories
                System.out.println("Here is our menu for Accessories: ");
                System.out.println("1. Earrings \t$16 \t6 available");
                System.out.println("2. Sunglasses\t$190\t5 available");
                System.out.println("3. Hats       \t$13 \t3 available");
                System.out.println("Select the product: ");
                int product = input.nextInt();
                if (product == 1) { //earrings
                    System.out.println("Select quantity: ");
                    int quantity = input.nextInt();
                } else if (product == 2) { //sunglasses
                    System.out.println("Select quantity: ");
                    int quantity = input.nextInt();
                } else if (product == 3) { //hats
                    System.out.println("Select quantity: ");
                    int quantity = input.nextInt();
                } else {
                    System.out.println("Invalid product");
                }
            } else {
                System.out.println("Invalid category");
            }
        } else { //invalid
            System.out.println("Invalid mode");
        }
    }
}