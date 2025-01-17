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
        ArrayList<Integer> orderNum_checkout = new ArrayList<Integer>(); // for order # in admin mode
        ArrayList<String> cartItems_checkout = new ArrayList<String>();
        ArrayList<Integer> itemQuantities_checkout = new ArrayList<>();
        ArrayList<Integer> itemTotalPrice_checkout = new ArrayList<>();
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
        boolean checker = true;
        System.out.println("Hello and welcome to ShopTopia!"); //-------------------------------------
        System.out.println("On ShopTopia, customers can make decisions using the " +
                "numbers in front of each option. Ex. 1. Footwear --> type: 1");
        System.out.println("Note: Please be careful when you are inputting your values! " +
                "Anything other than numbers (like letters/words) will cause problems! *except for passwords*");
        while (nextChoice == 4) {
        System.out.println("Choose a Mode to log into: 1. Admin  2. User  3. Exit Shop");
        int mode = input.nextInt();
        while (mode < 1 || mode > 3) {
            System.out.println("Invalid option, please re-enter");
            mode = input.nextInt();
        }
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
            for (int i = 0; i < cartItems_checkout.size(); i++) {
                cartItems_admin.add(cartItems_checkout.get(i));
                itemQuantities_admin.add(itemQuantities_checkout.get(i));
                itemTotalPrice_admin.add(itemTotalPrice_checkout.get(i));
            }
            boolean continueShipping = true; int adminChoose = 0;
            while (continueShipping) {
                System.out.println("Below are all the orders:");
                if (cartItems_admin.size() == 0) {
                    System.out.println("There are currently no orders.");
                    System.out.println("Choose what you want to do:  1. Switch Mode  2. Exit the shop");
                    nextChoice = input.nextInt();
                    while (nextChoice < 1 || nextChoice > 2) {
                        System.out.println("Invalid option, please re-enter");
                        nextChoice = input.nextInt();
                    }
                    if (nextChoice == 1) {
                        nextChoice = 4;
                        continueShipping = false;
                    } else if (nextChoice == 2) {
                        nextChoice = 6;
                        continueShipping = false;
                    }
                }
                else {
                    int j = 0; // index for the arraylist
                    for (int i = 0; i < orderNum_checkout.size(); i++) {
                        int numOfTimes = 1;
                        System.out.println("Order #" + (i+1));
                        while (numOfTimes <= orderNum_checkout.get(i)) {
                            if (j < cartItems_admin.size()) {
                                System.out.println(cartItems_admin.get(j) + " --- "
                                        + itemQuantities_admin.get(j) + " purchased --- $" +
                                        itemTotalPrice_admin.get(j));
                                j++;
                                numOfTimes++;
                            }
                        }
                    }
                    System.out.println("Which order number would you like to ship?");
                    int orderNum = input.nextInt();
                    while (orderNum <= 0 || orderNum > orderNum_checkout.size()) {
                        System.out.println("Invalid order number, please re-enter");
                        orderNum = input.nextInt();
                    }
                    orderNum_checkout.remove(orderNum-1); // must -1 to prevent IndexOutOfBounds!
                    cartItems_admin.remove(cartItems_admin.get(orderNum-1)); // removing the order
                    itemQuantities_admin.remove(itemQuantities_admin.get(orderNum-1));
                    itemTotalPrice_admin.remove(itemTotalPrice_admin.get(orderNum-1));
                    //
                    cartItems_checkout.remove(cartItems_checkout.get(orderNum-1));
                    itemQuantities_checkout.remove(itemQuantities_checkout.get(orderNum-1));
                    itemTotalPrice_checkout.remove(itemTotalPrice_checkout.get(orderNum-1));
                    System.out.println("Order has been shipped.");
                    System.out.println("Continue shipping orders?  1. Continue  2. No, switch mode  3. Exit Shop");
                    adminChoose = input.nextInt();
                    if (adminChoose == 2) {
                        continueShipping = false;
                        nextChoice = 4;
                    } else if (adminChoose == 3)
                        nextChoice = 6;
                }
            }
        } else if (mode == 2) { //user mode -----------------------------------------------------------
            int totalPrice = 0;
            int quantity = 0;
            int item = 0;
            int decision = 0;
            System.out.println("Hi, User!"); nextChoice = 1;
            while (nextChoice == 1) { // 1. continue shopping
                System.out.println("Please choose:  1. Shopping  2.  Edit/view cart  3. Checkout  4. Exit Shop");
                decision = input.nextInt();
                while (decision < 1 || decision > 4) {
                    System.out.println("Invalid option, please re-enter");
                    decision = input.nextInt();
                }
                if (decision == 2) {
                    decision = 1;
                    nextChoice = 2;
                }
                if (decision == 1) {
                    if (nextChoice == 1) {
                        System.out.println("Here are our three categories please select: ");
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
                                                itemTotalPrice.add(prices_1[item] * quantity);
                                                stock_1[1] = stock_1[1] - quantity;
                                                System.out.println("You added: " + products_1[item] + " --- $"
                                                        + (prices_1[item] * quantity));
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
                                            }
                                            break;
                                    }
                                    break; //break for accessory category
                            }
                            System.out.println("Please choose what you want to do next...");
                            System.out.println("1. Continue shopping\t2. Edit/view cart\t3. Checkout"
                                    + "\t4. Switch Mode\t5. Exit shop");
                            nextChoice = input.nextInt();
                            while (nextChoice < 1 || nextChoice > 4) {
                                System.out.println("Invalid choice, please re-enter:");
                                nextChoice = input.nextInt();
                            }
                        }
                    }
                    // come back from editing cart
                    while (nextChoice == 2) {
                        if (cartItems.size() == 0) {
                            System.out.println("There are no items in your cart");
                            System.out.println("Choose your action: 1. Continue"
                                    + " shopping  2. Checkout  3. Switch Mode  4. Exit shop");
                            nextChoice = input.nextInt();
                            while (nextChoice < 1 || nextChoice > 4) {
                                System.out.println("Invalid Choice option, please re-enter:");
                                nextChoice = input.nextInt();
                            }
                            if (nextChoice == 2) //checkout
                                nextChoice = 3;
                            else if (nextChoice == 3)
                                nextChoice = 4;
                            else if (nextChoice == 4)
                                nextChoice = 5;
                        } else {
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
                                    itemNum_toEdit = input.nextInt() - 1;
                                }
                                System.out.println("You'd like to...  1. Delete item from cart  2. Increase/decrease quantity");
                                int action = input.nextInt();
                                while (action != 1 && action != 2) {
                                    System.out.println("Invalid option, please re-enter:");
                                    action = input.nextInt();
                                }
                                if (action == 1) {
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
                                    cartItems.remove(cartItems.get(itemNum_toEdit));
                                    itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                    itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
                                    System.out.println("Item has been deleted from cart.");
                                    System.out.println("Select next action:  1. Continue shopping  2. Edit/view cart  " +
                                            "3. Checkout  4. Switch Mode  5. Exit shop");
                                    nextChoice = input.nextInt();
                                    while (nextChoice < 1 || nextChoice > 5) {
                                        System.out.println("Invalid choice, please re-enter:");
                                        nextChoice = input.nextInt();
                                    }
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
                                                    System.out.println("Quantity for Boots has been changed to "
                                                            + itemQuantities.get(itemNum_toEdit));
                                                } else
                                                    System.out.println("Not enough stock! Action cannot be done");
                                                break;
                                            case "Sandals":
                                                newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                                if (newQuantity <= stock_1[2]) {
                                                    itemQuantities.set(itemNum_toEdit, newQuantity);
                                                    itemTotalPrice.set(itemNum_toEdit, prices_1[2] * newQuantity);
                                                    System.out.println("Quantity for Sandals has been changed to "
                                                            + itemQuantities.get(itemNum_toEdit));
                                                } else
                                                    System.out.println("Not enough stock! Action cannot be done");
                                                break;
                                            case "Lipsticks":
                                                newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                                if (newQuantity <= stock_2[0]) {
                                                    itemQuantities.set(itemNum_toEdit, newQuantity);
                                                    itemTotalPrice.set(itemNum_toEdit, prices_2[0] * newQuantity);
                                                    System.out.println("Quantity for Lipsticks has been changed to "
                                                            + itemQuantities.get(itemNum_toEdit));
                                                } else
                                                    System.out.println("Not enough stock! Action cannot be done");
                                                break;
                                            case "Eyeliners":
                                                newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                                if (newQuantity <= stock_2[1]) {
                                                    itemQuantities.set(itemNum_toEdit, newQuantity);
                                                    itemTotalPrice.set(itemNum_toEdit, prices_2[1] * newQuantity);
                                                    System.out.println("Quantity for Eyeliners has been changed to "
                                                            + itemQuantities.get(itemNum_toEdit));
                                                } else
                                                    System.out.println("Not enough stock! Action cannot be done");
                                                break;
                                            case "Foundations":
                                                newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                                if (newQuantity <= stock_2[2]) {
                                                    itemQuantities.set(itemNum_toEdit, newQuantity);
                                                    itemTotalPrice.set(itemNum_toEdit, prices_2[2] * newQuantity);
                                                    System.out.println("Quantity for Foundations has been changed to "
                                                            + itemQuantities.get(itemNum_toEdit));
                                                } else
                                                    System.out.println("Not enough stock! Action cannot be done");
                                                break;
                                            case "Earrings":
                                                newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                                if (newQuantity <= stock_3[0]) {
                                                    itemQuantities.set(itemNum_toEdit, newQuantity);
                                                    itemTotalPrice.set(itemNum_toEdit, prices_3[0] * newQuantity);
                                                    System.out.println("Quantity for Earrings has been changed to "
                                                            + itemQuantities.get(itemNum_toEdit));
                                                } else
                                                    System.out.println("Not enough stock! Action cannot be done");
                                                break;
                                            case "Sunglasses":
                                                newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                                if (newQuantity <= stock_3[1]) {
                                                    itemQuantities.set(itemNum_toEdit, newQuantity);
                                                    itemTotalPrice.set(itemNum_toEdit, prices_3[1] * newQuantity);
                                                    System.out.println("Quantity for Sunglasses has been changed to "
                                                            + itemQuantities.get(itemNum_toEdit));
                                                } else
                                                    System.out.println("Not enough stock! Action cannot be done");
                                                break;
                                            case "Hats":
                                                newQuantity = itemQuantities.get(itemNum_toEdit) + addBy;
                                                if (newQuantity <= stock_3[2]) {
                                                    itemQuantities.set(itemNum_toEdit, newQuantity);
                                                    itemTotalPrice.set(itemNum_toEdit, prices_3[2] * newQuantity);
                                                    System.out.println("Quantity for Hats has been changed to "
                                                            + itemQuantities.get(itemNum_toEdit));
                                                } else
                                                    System.out.println("Not enough stock! Action cannot be done");
                                                break;
                                        }
                                        System.out.println("What do you want to do next");
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
                                                    stock_1[0] = stock_1[0] + itemQuantities.get(itemNum_toEdit);
                                                    cartItems.remove(cartItems.get(itemNum_toEdit));
                                                    itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                                    itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
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
                                                    stock_1[1] = stock_1[1] + itemQuantities.get(itemNum_toEdit);
                                                    cartItems.remove(cartItems.get(itemNum_toEdit));
                                                    itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                                    itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
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
                                                    stock_1[2] = stock_1[2] + itemQuantities.get(itemNum_toEdit);
                                                    cartItems.remove(cartItems.get(itemNum_toEdit));
                                                    itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                                    itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
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
                                                    stock_2[0] = stock_2[0] + itemQuantities.get(itemNum_toEdit);
                                                    cartItems.remove(cartItems.get(itemNum_toEdit));
                                                    itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                                    itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
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
                                                    stock_2[1] = stock_2[1] + itemQuantities.get(itemNum_toEdit);
                                                    cartItems.remove(cartItems.get(itemNum_toEdit));
                                                    itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                                    itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
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
                                                    stock_2[2] = stock_2[2] + itemQuantities.get(itemNum_toEdit);
                                                    cartItems.remove(cartItems.get(itemNum_toEdit));
                                                    itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                                    itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
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
                                                    stock_3[0] = stock_3[0] + itemQuantities.get(itemNum_toEdit);
                                                    cartItems.remove(cartItems.get(itemNum_toEdit));
                                                    itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                                    itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
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
                                                    stock_3[1] = stock_3[1] + itemQuantities.get(itemNum_toEdit);
                                                    cartItems.remove(cartItems.get(itemNum_toEdit));
                                                    itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                                    itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
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
                                                    stock_3[2] = stock_3[2] + itemQuantities.get(itemNum_toEdit);
                                                    cartItems.remove(cartItems.get(itemNum_toEdit));
                                                    itemQuantities.remove(itemQuantities.get(itemNum_toEdit));
                                                    itemTotalPrice.remove(itemTotalPrice.get(itemNum_toEdit));
                                                }
                                                break;
                                        }
                                        System.out.println("What you want to do next: 1. Continue shopping  " +
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
                    }
                    while (nextChoice == 3) { //are we allowing users to go back to shopping once at checking out stage
                        if (cartItems.size() != 0) {
                            double total_all = 0;
                            System.out.println("You have: ");
                            for (int i = 0; i < cartItems.size(); i++) {
                                System.out.println(cartItems.get(i) + " --- " + itemQuantities.get(i) + " --- $" +
                                        itemTotalPrice.get(i));
                                total_all = total_all + itemTotalPrice.get(i);
                                // copying into a new arraylist for checkout purposes
                                cartItems_checkout.add(cartItems.get(i));
                                itemQuantities_checkout.add(itemQuantities.get(i));
                                itemTotalPrice_checkout.add(itemTotalPrice.get(i));
                            }
                            orderNum_checkout.add(cartItems.size());
                            System.out.println("-------------------------"); //(-)*25
                            double tax = Math.round(total_all * 0.13 * 100.0) / 100.0;
                            System.out.println("Tax = " + total_all + " * 0.13 = $" + tax);
                            double finalAmount = tax + total_all;
                            System.out.println("Amount due = $" + finalAmount);
                            System.out.println("We appreciate your prompt payment!");
                            //removing all items in cart for next time's use
                            for (int i = cartItems.size() - 1; i >= 0; i--) {
                                cartItems.remove(cartItems.get(i));
                                itemQuantities.remove(itemQuantities.get(i));
                                itemTotalPrice.remove(itemTotalPrice.get(i));
                            } // cart should be empty by this line
                            System.out.println("Would you like to...  1. Switch Mode  2. Go back shopping  3. Exit Shop");
                            nextChoice = input.nextInt();
                            while (nextChoice < 1 || nextChoice > 3) {
                                System.out.println("Invalid option, please re-enter");
                                nextChoice = input.nextInt();
                            }
                            if (nextChoice == 1)
                                nextChoice = 4;
                            else if (nextChoice == 2)
                                nextChoice = 1;
                            else
                                nextChoice = 5;
                        } else {
                            System.out.println("You have no items to checkout");
                            System.out.println("Select:  1. Go shopping  2. Switch Mode  3. Exit Shop");
                            nextChoice = input.nextInt();
                            while (nextChoice < 1 || nextChoice > 3) {
                                System.out.println("Invalid option, please re-enter");
                                nextChoice = input.nextInt();
                            }
                            if (nextChoice == 2)
                                nextChoice = 4;
                            else if (nextChoice == 3)
                                nextChoice = 5;

                        }
                    }
                } else if (decision == 2) {
                    decision = 1;
                } else if (decision == 3) {
                    if (cartItems.size() != 0) {
                        double total_all = 0;
                        System.out.println("You have: ");
                        for (int i = 0; i < cartItems.size(); i++) {
                            System.out.println(cartItems.get(i) + " --- " + itemQuantities.get(i) + " --- $" +
                                    itemTotalPrice.get(i));
                            total_all = total_all + itemTotalPrice.get(i);
                            cartItems_checkout.add(cartItems.get(i));
                            itemQuantities_checkout.add(itemQuantities.get(i));
                            itemTotalPrice_checkout.add(itemTotalPrice.get(i));
                        }
                        orderNum_checkout.add(cartItems.size());
                        System.out.println("-------------------------"); //(-)*25
                        double tax = Math.round(total_all * 0.13 * 100.0) / 100.0; //rounding to 2 decimal places
                        System.out.println("Tax = " + total_all + " * 0.13 = $" + tax);
                        double finalAmount = tax + total_all;
                        System.out.println("Amount due = $" + finalAmount);
                        System.out.println("We appreciate your prompt payment!");
                        //removing all items in cart for next time's use
                        for (int i = cartItems.size() - 1; i >= 0; i--) {
                            cartItems.remove(cartItems.get(i));
                            itemQuantities.remove(itemQuantities.get(i));
                            itemTotalPrice.remove(itemTotalPrice.get(i));
                        } // cart should be empty by this line
                        System.out.println("Would you like to...  1. Switch Mode  2. Go back shopping  3. Exit Shop");
                        nextChoice = input.nextInt();
                        while (nextChoice < 1 || nextChoice > 3) {
                            System.out.println("Invalid option, please re-enter");
                            nextChoice = input.nextInt();
                        }
                        if (nextChoice == 1)
                            nextChoice = 4;
                        else if (nextChoice == 2)
                            nextChoice = 1;
                        else
                            nextChoice = 5;
                    } else {
                        System.out.println("You have no orders to checkout");
                        System.out.println("Please choose:  1. Go shopping  2. Switch Mode  3. Exit shop");
                        nextChoice = input.nextInt();
                        while (nextChoice < 1 || nextChoice > 3) {
                            System.out.println("Invalid option, please re-enter");
                            nextChoice = input.nextInt();
                        }
                        if (nextChoice == 2)
                            nextChoice = 4;
                        else if (nextChoice == 3)
                            nextChoice = 5;
                    }
                } else if (decision == 4)
                    nextChoice = 5;
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