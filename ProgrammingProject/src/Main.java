import java.util.ArrayList;
import java.util.Scanner;

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
        } else if (mode == 2) { //user mode
            //set up for User Mode
            String[] categories = {"Footwear", "Makeup", "Accessories"};
            String[] products_1 = {"Sneakers", "Boots", "Sandals"};
            String[] products_2 = {"Lipsticks", "Eyeliners", "Foundations"};
            String[] products_3 = {"Earrings", "Sunglasses", "Hats"};
            int[] prices_1 = {105, 200, 45};
            int[] prices_2 = {25, 8, 30};
            int[] prices_3 = {16, 190, 13};
            int[] stock_1 = {4, 6, 3};
            int[] stock_2 = {4, 5, 2};
            int[] stock_3 = {6, 5, 3};
            int totalPrice = 0;
            int quantity = 0;
            int item = 0;
            ArrayList<String> cartItems = new ArrayList<String>(); //can you have multiple arrays inside?
            ArrayList<Integer> itemQuantities = new ArrayList<>(); // all quantity stored here
            ArrayList<Integer> itemTotalPrice = new ArrayList<>(); // each item's total stored here
            //each index of each arraylist will represent an item added to cart

            System.out.println("Hi, User!");
            for (int i = 0; i < categories.length; i++) {
                System.out.println("Here is our three categories, please select: " + categories[i]);
            }
            int chosenCategory = input.nextInt() - 1; //index!!!
            if (chosenCategory >= 0 && chosenCategory < categories.length) {
                switch (chosenCategory) {
                    case 0: //footwear
                        for (int i = 0; i < products_1.length; i++) { //menuForProducts in each category
                            System.out.println(products_1[i] + "\t$" + prices_1[i] + "\t" + stock_1[i]
                                    + " available");
                        }
                        System.out.println("Select an item");
                        item = input.nextInt() - 1; //INDEX!!
                        switch (item) {
                            case 0: //sneaker
                                System.out.println("Select quantity: ");
                                quantity = input.nextInt();
                                if (quantity <= stock_1[0] && quantity > 0) {
                                    cartItems.add(products_1[item]);
                                    itemQuantities.add(quantity);
                                    itemTotalPrice.add(prices_1[item] * quantity); //may have issues!
                                } else {
                                    System.out.println("Quantity exceeds stock limit " +
                                            "OR Quantity can't be 0");
                                    quantity = input.nextInt(); //enter again?
                                }
                                break;
                            case 1: //boots
                                System.out.println("Select quantity: ");
                                quantity = input.nextInt();
                                if (quantity <= stock_1[1] && quantity > 0) {
                                    cartItems.add(products_1[item]);
                                    itemQuantities.add(quantity);
                                    itemTotalPrice.add(prices_1[item] * quantity); //may have issues!
                                } else {
                                    System.out.println("Quantity exceeds stock limit " +
                                            "OR Quantity can't be 0");
                                    quantity = input.nextInt(); //enter again?
                                }
                                break;
                            case 2: //sandals
                                System.out.println("Select quantity: ");
                                quantity = input.nextInt();
                                if (quantity <= stock_1[2] && quantity > 0) {
                                    cartItems.add(products_1[item]);
                                    itemQuantities.add(quantity);
                                    itemTotalPrice.add(prices_1[item] * quantity); //may have issues!
                                } else {
                                    System.out.println("Quantity exceeds stock limit " +
                                            "OR Quantity can't be 0");
                                    quantity = input.nextInt(); //enter again?
                                }
                                break;
                            default:
                                System.out.println("invalid item number");
                                break;
                        }
                        break;
                    case 1: // makeup
                        for (int i = 0; i < products_2.length; i++) { //print items in category2
                            System.out.println(products_2[i] + "\t$" + prices_2[i] + "\t" + stock_2[i]
                                    + " available");
                        }
                        System.out.println("Select an item");
                        item = input.nextInt() - 1;
                        switch (item) {
                            case 0: //lipsticks
                                System.out.println("Select quantity: ");
                                quantity = input.nextInt();
                                if (quantity <= stock_2[0] && quantity > 0) {
                                    cartItems.add(products_2[item]);
                                    itemQuantities.add(quantity);
                                    itemTotalPrice.add(prices_2[item] * quantity); //may have issues!
                                } else {
                                    System.out.println("Quantity exceeds stock limit " +
                                            "OR Quantity can't be 0");
                                    quantity = input.nextInt(); //enter again?
                                }
                                break;
                            case 1: //eyeliners
                                System.out.println("Select quantity: ");
                                quantity = input.nextInt();
                                if (quantity <= stock_2[1] && quantity > 0) {
                                    cartItems.add(products_2[item]);
                                    itemQuantities.add(quantity);
                                    itemTotalPrice.add(prices_2[item] * quantity); //may have issues!
                                } else {
                                    System.out.println("Quantity exceeds stock limit " +
                                            "OR Quantity can't be 0");
                                    quantity = input.nextInt(); //enter again?
                                }
                                break;
                            case 2: //foundations
                                System.out.println("Select quantity: ");
                                quantity = input.nextInt();
                                if (quantity <= stock_2[1] && quantity > 0) {
                                    cartItems.add(products_2[item]);
                                    itemQuantities.add(quantity);
                                    itemTotalPrice.add(prices_2[item] * quantity); //may have issues!
                                } else {
                                    System.out.println("Quantity exceeds stock limit " +
                                            "OR Quantity can't be 0");
                                    quantity = input.nextInt(); //enter again?
                                }
                                break;
                            default:
                                System.out.println("invalid item number");
                                break;
                        }

                    case 2: //accessories
                        for (int i = 0; i < products_3.length; i++) {
                            System.out.println(products_3[i] + "\t$" + prices_3[i] + "\t" + stock_3[i]
                                    + " available");
                        }
                        System.out.println("Select an item");
                        item = input.nextInt() - 1;
                        switch (item) {
                            case 0: //earrings
                                System.out.println("Select quantity: ");
                                quantity = input.nextInt();
                                if (quantity <= stock_3[0] && quantity > 0) {
                                    cartItems.add(products_3[item]);
                                    itemQuantities.add(quantity);
                                    itemTotalPrice.add(prices_3[item] * quantity); //may have issues!
                                } else {
                                    System.out.println("Quantity exceeds stock limit " +
                                            "OR Quantity can't be 0");
                                    quantity = input.nextInt(); //enter again?
                                }
                                break;
                            case 1: //sunglasses
                                System.out.println("Select quantity: ");
                                quantity = input.nextInt();
                                if (quantity <= stock_3[1] && quantity > 0) {
                                    cartItems.add(products_3[item]);
                                    itemQuantities.add(quantity);
                                    itemTotalPrice.add(prices_3[item] * quantity); //may have issues!
                                } else {
                                    System.out.println("Quantity exceeds stock limit " +
                                            "OR Quantity can't be 0");
                                    quantity = input.nextInt(); //enter again?
                                }
                                break;
                            case 2: //hats
                                System.out.println("Select quantity: ");
                                quantity = input.nextInt();
                                if (quantity <= stock_3[1] && quantity > 0) {
                                    cartItems.add(products_3[item]);
                                    itemQuantities.add(quantity);
                                    itemTotalPrice.add(prices_3[item] * quantity); //may have issues!
                                } else {
                                    System.out.println("Quantity exceeds stock limit " +
                                            "OR Quantity can't be 0");
                                    quantity = input.nextInt(); //enter again?
                                }
                                break;
                            default:
                                System.out.println("invalid item number");
                                break;
                        }


                        break; //break for category

                }
            } else
                System.out.println("Invalid category");
        }
    }
}