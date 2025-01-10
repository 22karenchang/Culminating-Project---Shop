import java.util.ArrayList;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        //set up for User Mode -----------------------------------------------------------------------
        String[] categories = {"Footwear", "Makeup", "Accessories"};
        String[] products_1 = {"Sneakers", "Boots", "Sandals"};
        String[] products_2 = {"Lipsticks", "Eyeliners", "Foundations"};
        String[] products_3 = {"Earrings", "Sunglasses", "Hats"};
        int[] prices_1 = {105, 200, 45};
        int[] prices_2 = {25, 8, 30};
        int[] prices_3 = {16, 190, 13};
        int[] stock_1 = {0, 6, 3}; // CHANGED FOR TESTING -- 0
        int[] stock_2 = {4, 5, 2};
        int[] stock_3 = {6, 5, 3};
        ArrayList<String> cartItems = new ArrayList<String>(); // all items bought stored here
        ArrayList<Integer> itemQuantities = new ArrayList<>(); // each item's quantity stored here
        ArrayList<Integer> itemTotalPrice = new ArrayList<>(); // each item's total stored here
        //each index of each arraylist will represent an item added to cart
        System.out.println("Hello and welcome to ShopTopia!"); //-------------------------------------
        System.out.println("On ShopTopia, customers can make decisions using the " +
                "numbers in front of each option." +
                "Ex. 1. Footwear --> type 1");
        //ADD A LOOP HERE
        System.out.println("Choose a Mode to log into: 1. Admin  2. User");
        int mode = input.nextInt();
        if (mode == 1) { //admin mode -----------------------------------------------------------------
            System.out.println("Hi, Admin!");
            System.out.println("Please enter the password to log in, please " +
                    "ensure correct capitalization\t Password: open!sesame?");
            String password = input.next();
            if (password.equals("open!sesame?")) {
                System.out.println("You have successfully logged in.");
            }
            System.out.println("Below are all the orders:");
            if (cartItems.size() == 0)
                System.out.println("There are currently no orders.");
            else {
                for (int i = 0; i < cartItems.size(); i++) {
                    System.out.println(cartItems.get(i) + " --- " + itemQuantities.get(i) +
                            " purchased --- $" + itemTotalPrice.get(i));
                }
            }

        } else if (mode == 2) { //user mode -----------------------------------------------------------
            int totalPrice = 0;
            int quantity = 0;
            int item = 0;
            int nextChoice = 1;
            System.out.println("Hi, User!");
            while (nextChoice == 1) { // 1. continue shopping
                System.out.println("Here is our three categories, please select: ");
                for (int i = 0; i < categories.length; i++) {
                    System.out.println(i + 1 + ". " + categories[i]);
                }
                int chosenCategory = input.nextInt() - 1; //index!!!
                while (chosenCategory > 2 || chosenCategory < 0) {
                    System.out.println("Invalid Category option, please re-enter:");
                    chosenCategory = input.nextInt() - 1;
                }
                if (chosenCategory >= 0 && chosenCategory <= 2) {
                    switch (chosenCategory) {
                        case 0: //footwear
                            System.out.println("Category: Footwear");
                            for (int i = 0; i < products_1.length; i++) { //menuForProducts in each category
                                if (stock_1[i] > 0) {
                                    System.out.println(i + 1 + ". " + products_1[i] + " --- $" + prices_1[i]
                                            + " --- " + stock_1[i] + " available");
                                } else {
                                    System.out.println(i + 1 + ". " + products_1[i] + " --- $" + prices_1[i]
                                            + " --- " + " out of stock");
                                }
                            }
                            boolean stay_f = true;
                            while (stay_f) {
                                System.out.println("Select an item");
                                item = input.nextInt() - 1; //INDEX!!
                                if (stock_1[item] <= 0) { // not enough stock
                                    System.out.println("Sorry! Item is out of stock, please re-enter:");
                                }
                                if (item < 0 && item >= products_1.length) { // not 1,2,3
                                    System.out.println("Invalid Item option, please re-enter:");
                                } else if (stock_1[item] != 0) { // enough stock + valid item num
                                    stay_f = false;
                                }
                            }
                            switch (item) {
                                case 0: //sneaker
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    if (quantity <= stock_1[0] && quantity > 0) {
                                        cartItems.add(products_1[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_1[item] * quantity);//may have issues!
                                        stock_1[0] = stock_1[0] - quantity;
                                        System.out.println("Item added to cart :)");
                                        System.out.println("Please choose what you want to do next...");
                                        System.out.println("1. Continue shopping\t2. Edit cart\t3 Checkout" +
                                                "\t4. Log out\t5. Exit program");
                                        nextChoice = input.nextInt();

                                    }
                                    while (quantity > stock_1[0] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    break;
                                case 1: //boots
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    if (quantity <= stock_1[1] && quantity > 0) {
                                        cartItems.add(products_1[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_1[item] * quantity); //may have issues!
                                    }
                                    while (quantity > stock_1[1] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    break;
                                case 2: //sandals
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    if (quantity <= stock_1[2] && quantity > 0) {
                                        cartItems.add(products_1[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_1[item] * quantity); //may have issues!
                                    }
                                    while (quantity > stock_1[2] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    break;
                            }
                            break;
                        case 1: // makeup
                            System.out.println("Category: Makeup");
                            for (int i = 0; i < products_2.length; i++) {
                                if (stock_1[i] > 0) {
                                    System.out.println(i + 1 + ". " + products_3[i] + " --- $" + prices_3[i]
                                            + " --- " + stock_3[i] + " available");
                                } else {
                                    System.out.println(i + 1 + ". " + products_3[i] + " --- $" + prices_3[i]
                                            + " --- " + " out of stock");
                                }
                            }
                            boolean stay_m = true;
                            while (stay_m) {
                                System.out.println("Select an item");
                                item = input.nextInt() - 1; //INDEX!!
                                if (stock_2[item] <= 0) { // not enough stock
                                    System.out.println("Sorry! Item is out of stock, please re-enter:");
                                }
                                if (item < 0 && item >= products_2.length) { // not 1,2,3
                                    System.out.println("Invalid Item option, please re-enter:");
                                } else if (stock_2[item] != 0) { // enough stock, valid item num
                                    stay_m = false;
                                }
                            }
                            switch (item) {
                                case 0: //lipsticks
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    if (quantity <= stock_2[0] && quantity > 0) {
                                        cartItems.add(products_2[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_2[item] * quantity); //may have issues!
                                    }
                                    while (quantity > stock_2[0] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    break;
                                case 1: //eyeliners
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    if (quantity <= stock_2[1] && quantity > 0) {
                                        cartItems.add(products_2[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_2[item] * quantity); //may have issues!
                                    }
                                    while (quantity > stock_2[1] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    break;
                                case 2: //foundations
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    if (quantity <= stock_2[2] && quantity > 0) {
                                        cartItems.add(products_2[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_2[item] * quantity); //may have issues!
                                    }
                                    while (quantity > stock_2[2] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    break;
                            }
                            break;
                        case 2: //accessories
                            System.out.println("Category: Accessories");
                            for (int i = 0; i < products_3.length; i++) {
                                if (stock_3[i] > 0) {
                                    System.out.println(i + 1 + ". " + products_3[i] + " --- $" + prices_3[i]
                                            + " --- " + stock_3[i] + " available");
                                } else {
                                    System.out.println(i + 1 + ". " + products_3[i] + " --- $" + prices_3[i]
                                            + " --- " + " out of stock");
                                }
                            }
                            boolean stay_a = true;
                            while (stay_a) {
                                System.out.println("Select an item");
                                item = input.nextInt() - 1; //INDEX!!
                                if (stock_3[item] <= 0) { // not enough stock
                                    System.out.println("Sorry! Item is out of stock, please re-enter:");
                                }
                                if (item < 0 && item >= products_3.length) { // not 1,2,3
                                    System.out.println("Invalid Item option, please re-enter:");
                                } else if (stock_3[item] != 0) { // enough stock, valid item num
                                    stay_a = false;
                                }
                            }
                            switch (item) {
                                case 0: //earrings
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    if (quantity <= stock_3[0] && quantity > 0) {
                                        cartItems.add(products_3[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_3[item] * quantity); //may have issues!
                                    }
                                    while (quantity > stock_3[0] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    break;
                                case 1: //sunglasses
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    if (quantity <= stock_3[1] && quantity > 0) {
                                        cartItems.add(products_3[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_3[item] * quantity); //may have issues!
                                    }
                                    while (quantity > stock_3[1] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    break;
                                case 2: //hats
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    if (quantity <= stock_3[2] && quantity > 0) {
                                        cartItems.add(products_3[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_3[item] * quantity); //may have issues!
                                    }
                                    while (quantity > stock_3[2] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    break;
                            }
                            break; //break for accessory category
                    }
                }
            }
        }
    }
}