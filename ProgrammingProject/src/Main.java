import java.util.ArrayList;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        // set up for Admin Mode
        ArrayList<String> cartItems_admin = new ArrayList<String>(); // all items bought stored here
        ArrayList<Integer> itemQuantities_admin = new ArrayList<>(); // each item's quantity stored here
        ArrayList<Integer> itemTotalPrice_admin = new ArrayList<>(); // each item's total stored here
        //set up for User Mode -----------------------------------------------------------------------
        String[] categories = {"Footwear", "Makeup", "Accessories"};
        String[] products_1 = {"Sneakers", "Boots", "Sandals"};
        String[] products_2 = {"Lipsticks", "Eyeliners", "Foundations"};
        String[] products_3 = {"Earrings", "Sunglasses", "Hats"};
        int[] prices_1 = {105, 200, 45};
        int[] prices_2 = {25, 8, 30};
        int[] prices_3 = {16, 190, 13};
        int[] stock_1 = {4, 6, 3}; // CHANGED FOR TESTING -- 4
        int[] stock_2 = {4, 5, 2};
        int[] stock_3 = {6, 5, 3};
        ArrayList<String> cartItems = new ArrayList<String>(); // all items bought stored here
        ArrayList<Integer> itemQuantities = new ArrayList<>(); // each item's quantity stored here
        ArrayList<Integer> itemTotalPrice = new ArrayList<>(); // each item's total stored here
        //each index of each arraylist will represent an item added to cart
        int nextChoice = 4;
        System.out.println("Hello and welcome to ShopTopia!"); //-------------------------------------
        System.out.println("On ShopTopia, customers can make decisions using the " +
                "numbers in front of each option." +
                "Ex. 1. Footwear --> type: 1");
        while (nextChoice == 4) {
        System.out.println("Choose a Mode to log into: 1. Admin  2. User  3. Exit Shop");
        int mode = input.nextInt();
        if (mode == 1) { //admin mode -----------------------------------------------------------------
            System.out.println("Hi, Admin!");
            System.out.println("Please enter the password to log in, please " +
                    "ensure correct capitalization --- Password: open!Sesame?");
            String password = input.next();
            while (!password.equals("open!Sesame?")) {
                System.out.println("Incorrect password. Enter again:");
                password = input.next();
            }
            System.out.println("You have successfully logged in."); // means password is right
            for (int i = 0; i < cartItems.size(); i++) {
                cartItems_admin.add(cartItems.get(i));
                itemQuantities_admin.add(itemQuantities.get(i));
                itemTotalPrice_admin.add(itemTotalPrice.get(i));
            }
            boolean continueShipping = true; int adminChoose = 0;
            while (continueShipping) {
                System.out.println("Below are all the orders:");
                if (cartItems.size() == 0) {
                    System.out.println("There are currently no orders.");
                    System.out.println("Choose what you want to do:  1. Switch Mode  2. Exit the shop");
                    nextChoice = input.nextInt();
                    if (nextChoice == 1) {
                        nextChoice = 4;
                        continueShipping = false;
                    } else if (nextChoice == 2) {
                        nextChoice = 6;
                        continueShipping = false;
                    }
                }
                else {
                    for (int i = 0; i < cartItems.size(); i++) {
                        System.out.println((i+1) + ". " + cartItems_admin.get(i) + " --- "
                                + itemQuantities_admin.get(i) + " purchased --- $" + itemTotalPrice_admin.get(i));
                        System.out.println("Which order number would you like to Ship?");
                        int orderNum = input.nextInt() - 1; //this would be the index of arraylist
                        if (orderNum >= 0 && orderNum < cartItems.size()) {
                            cartItems_admin.remove(cartItems_admin.get(orderNum));
                            itemQuantities_admin.remove(itemQuantities_admin.get(orderNum));
                            itemTotalPrice_admin.remove(itemTotalPrice_admin.get(orderNum));
                            System.out.println("Order #" + (orderNum + 1) + " has been shipped.");
                            System.out.println("Continue shipping orders?  1. Continue  2. No, switch mode  3. Exit Shop");
                            adminChoose = input.nextInt();
                            if (adminChoose == 2) {
                                continueShipping = false;
                                nextChoice = 4;
                            } else if (adminChoose == 3)
                                nextChoice = 6;
                        } else
                            System.out.println("Invalid order number.");
                    }
                }
            }
        } else if (mode == 2) { //user mode -----------------------------------------------------------
            int totalPrice = 0;
            int quantity = 0;
            int item = 0;
            System.out.println("Hi, User!"); nextChoice = 1;
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
                                if (item < 0 || item >= 3) { // if not 1,2,3
                                    System.out.println("Invalid Item option, please re-enter:");
                                } else if (stock_1[item] <= 0)  // not enough stock
                                    System.out.println("Sorry! Item is out of stock, please re-enter:");
                                else if (stock_1[item] != 0) { // enough stock + valid item num
                                    stay_f = false;
                                }
                            }
                            switch (item) {
                                case 0: //sneaker
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    while (quantity > stock_1[0] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    if (quantity <= stock_1[0] && quantity > 0) {
                                        cartItems.add(products_1[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_1[item] * quantity);//may have issues!
                                        stock_1[0] = stock_1[0] - quantity;
                                        System.out.println("You added: " + products_1[item] + " --- $"
                                                + (prices_1[item] * quantity));
                                        System.out.println("Please choose what you want to do next...");
                                        System.out.println("1. Continue shopping\t2. Edit/view cart\t3 Checkout"
                                                + "\t4. Switch Mode\t5. Exit shop");
                                        nextChoice = input.nextInt();

                                    }
                                    break;
                                case 1: //boots
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    while (quantity > stock_1[1] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    if (quantity <= stock_1[1] && quantity > 0) {
                                        cartItems.add(products_1[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_1[item] * quantity); //may have issues!
                                        stock_1[1] = stock_1[1] - quantity;
                                        System.out.println("You added: " + products_1[item] + " --- $"
                                                + (prices_1[item] * quantity));
                                        System.out.println("Please choose what you want to do next...");
                                        System.out.println("1. Continue shopping\t2. Edit/view cart\t3 Checkout"
                                                + "\t4. Switch Mode\t5. Exit shop");
                                        nextChoice = input.nextInt();
                                    }
                                    break;
                                case 2: //sandals
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    while (quantity > stock_1[2] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    if (quantity <= stock_1[2] && quantity > 0) {
                                        cartItems.add(products_1[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_1[item] * quantity); //may have issues!
                                        stock_1[2] = stock_1[2] - quantity;
                                        System.out.println("You added: " + products_1[item] + " --- $"
                                                + (prices_1[item] * quantity));
                                        System.out.println("Please choose what you want to do next...");
                                        System.out.println("1. Continue shopping\t2. Edit/view cart\t3 Checkout"
                                                + "\t4. Switch Mode\t5. Exit shop");
                                        nextChoice = input.nextInt();
                                    }
                                    break;
                            }
                            break;
                        case 1: // makeup
                            System.out.println("Category: Makeup");
                            for (int i = 0; i < products_2.length; i++) {
                                if (stock_2[i] > 0) {
                                    System.out.println(i + 1 + ". " + products_2[i] + " --- $" + prices_2[i]
                                            + " --- " + stock_2[i] + " available");
                                } else {
                                    System.out.println(i + 1 + ". " + products_2[i] + " --- $" + prices_2[i]
                                            + " --- " + " out of stock");
                                }
                            }
                            boolean stay_m = true;
                            while (stay_m) {
                                System.out.println("Select an item");
                                item = input.nextInt() - 1; //INDEX!!
                                if (item < 0 || item >= 3) { // if not 1,2,3
                                    System.out.println("Invalid Item option, please re-enter:");
                                } else if (stock_2[item] <= 0)  // not enough stock
                                    System.out.println("Sorry! Item is out of stock, please re-enter:");
                                else if (stock_2[item] != 0) { // enough stock + valid item num
                                    stay_m = false;
                                }
                            }
                            switch (item) {
                                case 0: //lipsticks
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    while (quantity > stock_2[0] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    if (quantity <= stock_2[0] && quantity > 0) {
                                        cartItems.add(products_2[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_2[item] * quantity); //may have issues!
                                        stock_2[0] = stock_2[0] - quantity;
                                        System.out.println("You added: " + products_2[item] + " --- $"
                                                + (prices_2[item] * quantity));
                                        System.out.println("Please choose what you want to do next...");
                                        System.out.println("1. Continue shopping\t2. Edit/view cart\t3 Checkout"
                                                + "\t4. Switch Mode\t5. Exit shop");
                                        nextChoice = input.nextInt();
                                    }
                                    break;
                                case 1: //eyeliners
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    while (quantity > stock_2[1] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    if (quantity <= stock_2[1] && quantity > 0) {
                                        cartItems.add(products_2[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_2[item] * quantity); //may have issues!
                                        stock_2[1] = stock_2[1] - quantity;
                                        System.out.println("You added: " + products_2[item] + " --- $"
                                                + (prices_2[item] * quantity));
                                        System.out.println("Please choose what you want to do next...");
                                        System.out.println("1. Continue shopping\t2. Edit/view cart\t3 Checkout"
                                                + "\t4. Switch Mode\t5. Exit shop");
                                        nextChoice = input.nextInt();
                                    }
                                    break;
                                case 2: //foundations
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    while (quantity > stock_2[2] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    if (quantity <= stock_2[2] && quantity > 0) {
                                        cartItems.add(products_2[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_2[item] * quantity); //may have issues!
                                        stock_2[2] = stock_2[2] - quantity;
                                        System.out.println("You added: " + products_2[item] + " --- $"
                                                + (prices_2[item] * quantity));
                                        System.out.println("Please choose what you want to do next...");
                                        System.out.println("1. Continue shopping\t2. Edit/view cart\t3 Checkout"
                                                + "\t4. Switch Mode\t5. Exit shop");
                                        nextChoice = input.nextInt();
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
                                if (item < 0 || item >= 3) { // if not 1,2,3
                                    System.out.println("Invalid Item option, please re-enter:");
                                } else if (stock_3[item] <= 0)  // not enough stock
                                    System.out.println("Sorry! Item is out of stock, please re-enter:");
                                else if (stock_3[item] != 0) { // enough stock + valid item num
                                    stay_a = false;
                                }
                            }
                            switch (item) {
                                case 0: //earrings
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    while (quantity > stock_3[0] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    if (quantity <= stock_3[0] && quantity > 0) {
                                        cartItems.add(products_3[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_3[item] * quantity); //may have issues!
                                        stock_3[0] = stock_3[0] - quantity;
                                        System.out.println("You added: " + products_3[item] + " --- $"
                                                + (prices_3[item] * quantity));
                                        System.out.println("Please choose what you want to do next...");
                                        System.out.println("1. Continue shopping\t2. Edit/view cart\t3 Checkout"
                                                + "\t4. Switch Mode\t5. Exit shop");
                                        nextChoice = input.nextInt();
                                    }
                                    break;
                                case 1: //sunglasses
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    while (quantity > stock_3[1] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    if (quantity <= stock_3[1] && quantity > 0) {
                                        cartItems.add(products_3[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_3[item] * quantity); //may have issues!
                                        stock_3[1] = stock_3[1] - quantity;
                                        System.out.println("You added: " + products_3[item] + " --- $"
                                                + (prices_3[item] * quantity));
                                        System.out.println("Please choose what you want to do next...");
                                        System.out.println("1. Continue shopping\t2. Edit/view cart\t3 Checkout"
                                                + "\t4. Switch Mode\t5. Exit shop");
                                        nextChoice = input.nextInt();
                                    }
                                    break;
                                case 2: //hats
                                    System.out.println("Select quantity: ");
                                    quantity = input.nextInt();
                                    while (quantity > stock_3[2] || quantity == 0) {
                                        System.out.println("Quantity exceeds stock limit " +
                                                "OR Quantity can't be 0. Please re-enter:");
                                        quantity = input.nextInt(); //enter quantity again
                                    }
                                    if (quantity <= stock_3[2] && quantity > 0) {
                                        cartItems.add(products_3[item]);
                                        itemQuantities.add(quantity);
                                        itemTotalPrice.add(prices_3[item] * quantity); //may have issues!
                                        stock_3[2] = stock_3[2] - quantity;
                                        System.out.println("You added: " + products_3[item] + " --- $"
                                                + (prices_3[item] * quantity));
                                        System.out.println("Please choose what you want to do next...");
                                        System.out.println("1. Continue shopping\t2. Edit/view cart\t3 Checkout"
                                                + "\t4. Switch Mode\t5. Exit shop");
                                        nextChoice = input.nextInt();
                                    }
                                    break;
                            }
                            break; //break for accessory category
                    }
                }
                // come back from editing cart
                while (nextChoice == 2) {
                    System.out.println("Your Cart:");
                    for (int i = 0; i < cartItems.size(); i++) {
                        System.out.println(i + 1 + ". " + cartItems.get(i) + " --- "
                                + itemQuantities.get(i) + " --- $" + itemTotalPrice.get(i));
                    }
                    System.out.println("Choose your action: 1. Edit item quantity  2. Continue" +
                            " shopping  3. Checkout  4. Switch Mode  5. Exit shop");
                    nextChoice = input.nextInt();
                    while (nextChoice < 1 || nextChoice > 5) {
                        System.out.println("Invalid Choice option, please re-enter:");
                        nextChoice = input.nextInt();
                    }
                    if (nextChoice == 1) { //edit item quantity
                        System.out.println("Which item number would you like to edit:");
                        int itemNum_toEdit = input.nextInt() - 1; //index
                        while (itemNum_toEdit < 0 || itemNum_toEdit >= cartItems.size()) {
                            System.out.println("Invalid item number, please re-enter:");
                            itemNum_toEdit = input.nextInt();
                        }
                        System.out.println("You'd like to...  1. Delete item from cart  2. Increase/decrease quantity");
                        int action = input.nextInt();
                        while (action != 1 && action != 2) {
                            System.out.println("Invalid option, please re-enter:");
                            action = input.nextInt();
                        }
                        if (action == 1) {
                            cartItems.remove(cartItems.get(itemNum_toEdit));
                            itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                            itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
                            switch (cartItems.get(itemNum_toEdit)) { //adding quantity back in stock
                                case "Sneakers":
                                    stock_1[0] = stock_1[0] + itemQuantities.get(itemNum_toEdit);
                                    break;
                                case "Boots":
                                    stock_1[1] = stock_1[1] + itemQuantities.get(itemNum_toEdit);
                                    break;
                                case "Sandals":
                                    stock_1[2] = stock_1[2] + itemQuantities.get(itemNum_toEdit);
                                    break;
                                case "Lipsticks":
                                    stock_2[0] = stock_2[0] + itemQuantities.get(itemNum_toEdit);
                                    break;
                                case "Eyeliners":
                                    stock_2[1] = stock_2[1] + itemQuantities.get(itemNum_toEdit);
                                    break;
                                case "Foundations":
                                    stock_2[2] = stock_2[2] + itemQuantities.get(itemNum_toEdit);
                                    break;
                                case "Earrings":
                                    stock_3[0] = stock_3[0] + itemQuantities.get(itemNum_toEdit);
                                    break;
                                case "Sunglasses":
                                    stock_3[1] = stock_3[1] + itemQuantities.get(itemNum_toEdit);
                                    break;
                                case "Hats":
                                    stock_3[2] = stock_3[2] + itemQuantities.get(itemNum_toEdit);
                                    break;
                            }
                            System.out.println("Item has been deleted from cart.");
                            System.out.println("Select next action:  1. Continue shopping  2. Edit/view cart  " +
                                    "3. Checkout  4. Switch Mode  5. Exit shop");
                            nextChoice = input.nextInt();
                            if (nextChoice == 1)
                                nextChoice = 4;
                        } else if (action == 2) {
                            System.out.println("You would like to...  1. Increase quantity  2. Decrease quantity");
                            int quantity_edit = input.nextInt();
                            while (quantity_edit != 1 && quantity_edit != 2) {
                                System.out.println("Invalid option, please re-enter:");
                                quantity_edit = input.nextInt();
                            }
                            int newQuantity;
                            if (quantity_edit == 1) { // add more
                                System.out.println("Increase by how many more:");
                                int addBy = input.nextInt();
                                switch (cartItems.get(itemNum_toEdit)) {
                                    case "Sneakers":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                        if (newQuantity <= stock_1[0]) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_1[0] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                            + itemQuantities.get(itemNum_toEdit));
                                        } else
                                            System.out.println("Not enough stock! Action cannot be done");
                                        //can come back and loop
                                        break;
                                    case "Boots":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                        if (newQuantity <= stock_1[1]) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_1[1] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                        } else
                                            System.out.println("Not enough stock! Action cannot be done");
                                        break;
                                    case "Sandals":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                        if (newQuantity <= stock_1[2]) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_1[2] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                        } else
                                            System.out.println("Not enough stock! Action cannot be done");
                                        break;
                                    case "Lipsticks":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                        if (newQuantity <= stock_2[0]) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_2[0] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                        } else
                                            System.out.println("Not enough stock! Action cannot be done");
                                        break;
                                    case "Eyeliners":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                        if (newQuantity <= stock_2[1]) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_2[1] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                        } else
                                            System.out.println("Not enough stock! Action cannot be done");
                                        break;
                                    case "Foundations":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                        if (newQuantity <= stock_2[2]) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_2[2] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                        } else
                                            System.out.println("Not enough stock! Action cannot be done");
                                        break;
                                    case "Earrings":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                        if (newQuantity <= stock_3[0]) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_3[0] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                        } else
                                            System.out.println("Not enough stock! Action cannot be done");
                                        break;
                                    case "Sunglasses":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                        if (newQuantity <= stock_3[1]) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_3[1] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                        } else
                                            System.out.println("Not enough stock! Action cannot be done");
                                        break;
                                    case "Hats":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                        if (newQuantity <= stock_3[2]) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_3[2] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                        } else
                                            System.out.println("Not enough stock! Action cannot be done");
                                        break;
                                }
                                System.out.println("What do you want to do next")
                            } else { //decrease stock
                             System.out.println("Decrease by how many:");
                             int takeaway = input.nextInt();
                                switch (cartItems.get(itemNum_toEdit)) {
                                    case "Sneakers":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) - takeaway;
                                        if (newQuantity >= 1) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_1[0] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                            stock_1[0] = stock_1[0] + takeaway;
                                        } else {
                                            System.out.println("Quantity is/or is below 0, so item will " +
                                                    "be automatically removed from your cart");
                                            cartItems.remove(cartItems.get(itemNum_toEdit));
                                            itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                            itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
                                            stock_1[0] = stock_1[0] + itemQuantities.get(itemNum_toEdit);
                                        }
                                        break;
                                    case "Boots":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) - takeaway;
                                        if (newQuantity >= 1) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_1[1] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                            stock_1[1] = stock_1[1] + takeaway;
                                        } else {
                                            System.out.println("Quantity is/or is below 0, so item will " +
                                                    "be automatically removed from your cart");
                                            cartItems.remove(cartItems.get(itemNum_toEdit));
                                            itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                            itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
                                            stock_1[1] = stock_1[1] + itemQuantities.get(itemNum_toEdit);
                                        }
                                        break;
                                    case "Sandals":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) - takeaway;
                                        if (newQuantity >= 1) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_1[2] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                            stock_1[2] = stock_1[2] + takeaway;
                                        } else {
                                            System.out.println("Quantity is/or is below 0, so item will " +
                                                    "be automatically removed from your cart");
                                            cartItems.remove(cartItems.get(itemNum_toEdit));
                                            itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                            itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
                                            stock_1[2] = stock_1[2] + itemQuantities.get(itemNum_toEdit);
                                        }
                                        break;
                                    case "Lipsticks":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) - takeaway;
                                        if (newQuantity >= 1) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_2[0] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                            stock_2[0] = stock_2[0] + takeaway;
                                        } else {
                                            System.out.println("Quantity is/or is below 0, so item will " +
                                                    "be automatically removed from your cart");
                                            cartItems.remove(cartItems.get(itemNum_toEdit));
                                            itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                            itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
                                            stock_2[0] = stock_2[0] + itemQuantities.get(itemNum_toEdit);
                                        }
                                        break;
                                    case "Eyeliners":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) - takeaway;
                                        if (newQuantity >= 1) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_2[1] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                            stock_2[1] = stock_2[1] + takeaway;
                                        } else {
                                            System.out.println("Quantity is/or is below 0, so item will " +
                                                    "be automatically removed from your cart");
                                            cartItems.remove(cartItems.get(itemNum_toEdit));
                                            itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                            itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
                                            stock_2[1] = stock_2[1] + itemQuantities.get(itemNum_toEdit);
                                        }
                                        break;
                                    case "Foundations":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) - takeaway;
                                        if (newQuantity >= 1) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_2[2] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                            stock_2[2] = stock_2[2] + takeaway;
                                        } else {
                                            System.out.println("Quantity is/or is below 0, so item will " +
                                                    "be automatically removed from your cart");
                                            cartItems.remove(cartItems.get(itemNum_toEdit));
                                            itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                            itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
                                            stock_2[2] = stock_2[2] + itemQuantities.get(itemNum_toEdit);
                                        }
                                        break;
                                    case "Earrings":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) - takeaway;
                                        if (newQuantity >= 1) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_3[0] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                            stock_3[0] = stock_3[0] + takeaway;
                                        } else {
                                            System.out.println("Quantity is/or is below 0, so item will " +
                                                    "be automatically removed from your cart");
                                            cartItems.remove(cartItems.get(itemNum_toEdit));
                                            itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                            itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
                                            stock_3[0] = stock_3[0] + itemQuantities.get(itemNum_toEdit);
                                        }
                                        break;
                                    case "Sunglasses":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) - takeaway;
                                        if (newQuantity >= 1) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_3[1] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                            stock_3[1] = stock_3[1] + takeaway;
                                        } else {
                                            System.out.println("Quantity is/or is below 0, so item will " +
                                                    "be automatically removed from your cart");
                                            cartItems.remove(cartItems.get(itemNum_toEdit));
                                            itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                            itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
                                            stock_3[1] = stock_3[1] + itemQuantities.get(itemNum_toEdit);
                                        }
                                        break;
                                    case "Hats":
                                        newQuantity = itemQuantities.get(itemNum_toEdit) - takeaway;
                                        if (newQuantity >= 1) {
                                            itemQuantities.set(itemNum_toEdit, newQuantity);
                                            itemTotalPrice.set(itemNum_toEdit, prices_3[2] * newQuantity);
                                            System.out.println("Quantity for Sneakers has been changed to "
                                                    + itemQuantities.get(itemNum_toEdit));
                                            stock_3[2] = stock_3[2] + takeaway;
                                        } else {
                                            System.out.println("Quantity is/or is below 0, so item will " +
                                                    "be automatically removed from your cart");
                                            cartItems.remove(cartItems.get(itemNum_toEdit));
                                            itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                            itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
                                            stock_3[2] = stock_3[2] + itemQuantities.get(itemNum_toEdit);
                                        }
                                        break;
                                } System.out.println("What you want to do next: 1. Continue shopping  " +
                                        "2. Edit/view cart  3. Checkout  4. Switch Mode  5. Exit shop");
                                nextChoice = input.nextInt();
                                while (nextChoice < 1 || nextChoice > 5) {
                                    System.out.println("Invalid option, please re-enter");
                                    nextChoice = input.nextInt();
                                }
                            }
                        }
                    } else if (nextChoice == 2)
                        nextChoice = 1;
                }
                while (nextChoice == 3) { //are we allowing users to go back to shopping once at checking out stage
                    double total_all = 0;
                    System.out.println("You have: ");
                    for (int i = 0; i < cartItems.size(); i++) {
                        System.out.println(cartItems.get(i) + " --- " + itemQuantities.get(i) + " --- $" +
                                itemTotalPrice.get(i));
                        total_all = total_all + itemTotalPrice.get(i);
                    }
                    System.out.println("Tax =  " + total_all + " * 0.13 = " + (Math.round(total_all*0.13)*100.00)/100.00);
                    System.out.println("Amount due = " + (Math.round(total_all*1.13)*100.00)/100.00);
                    System.out.println("We appreciate your prompt payment!");
                    nextChoice = 5;
                }
            }
        } else if (mode == 3)
            nextChoice = 5;
        } // swtiching mode
        if (nextChoice == 5) {
            System.out.println("Thank you for your visit! We hope to serve you again~");
        } else if (nextChoice == 6)
            System.out.println("Bye Admin! Have a nice day~");
    }
}