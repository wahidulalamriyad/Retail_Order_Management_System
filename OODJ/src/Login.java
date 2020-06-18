import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    private String userID, userPassword, userType;
    private final String dataProduct = "dataProduct.txt";
    private final String dataUser = "dataUser.txt";
    private final String dataOrder = "dataOrder.txt";
    private final String dataOrderDetails = "dataOrderDetails.txt";
    
    public Login(){}
    
    public Login(String id, String Password, String type) {
        this.userID = id;
        this.userPassword = Password;
        this.userType = type;
    }
    
    public String getDataProduct() {
        return dataProduct;
    }
        
    public String getDataUser() {
        return dataUser;
    }
    
    public String getDataOrder() {
        return dataOrder;
    }
        
    public String getDataOrderDetails() {
        return dataOrderDetails;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserType() {
        return userType;
    }

    public static void main(String[] args) {
        new Login().verifyLogin();
    }

    private void verifyLogin() {
        clearConsole();
        new Manage().firstUser();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n---------- RETAIL ORDER MANAGEMENT SYSTEM ----------\n");
            System.out.println(">>> Please enter your ID number: ");
            userID = scanner.nextLine().toUpperCase();
            boolean idFound = false;
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(getDataUser()));
                Object obj = null;
                while ((obj = ois.readObject()) != null) {
                    if (((Customer) obj).getCusID().equals(userID)) {
                        idFound = true;
                        userPassword = ((Customer) obj).getCusPassword();
                        userType = ((Customer) obj).getCusType();
                    }
                }
            } catch (EOFException ex) {}
            catch (ClassNotFoundException ex) { ex.printStackTrace(); }
            catch (FileNotFoundException ex) { ex.printStackTrace(); }
            catch (IOException ex) { ex.printStackTrace(); }
            finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException ex) { ex.printStackTrace(); }
            }
            if (idFound == true) {
                System.out.println("\n>>> Please enter your password: ");
                if (userPassword.equals(scanner.nextLine().toUpperCase())) {
                    System.out.println(" Your username is " + userID + " and pass is: " + userPassword);
                    if(userType.equals("ADMIN")){
                        clearConsole();
                        adminMenu();
                    } 
                    if(userType.equals("CUSTOMER")){
                        clearConsole();
                        customerMenu();
                    }
                    break;
                } else {
                    clearConsole();
                    System.out.println("The password is incorrect!");
                }
            } else {
                clearConsole();
                System.out.println("The ID number is incorrect! (" + userID + ").");
            }
        }
    }

    public void callGUI() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new GUI(userID, userPassword).setVisible(true);
            }
        });
    }
    
    public void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-------------------- ADMIN MENU --------------------\n");
        System.out.println("[1] MANAGE ORDER\n");
        System.out.println("[2] MANAGE PRODUCT\n");
        System.out.println("[3] MANAGE CUSTOMER\n");
        System.out.println("[4] GUI MODE\n");
        System.out.println("[0] LOG OUT");
        System.out.println("\n----------------------------------------------------");
        System.out.println(">>> Please select your choice: ");
        String getInput = scanner.nextLine().toUpperCase();
        switch (getInput) {
            case "1":
                clearConsole();
                manageOrderMenu();
                break;
            case "2":
                clearConsole();
                manageProductMenu();
                break;
            case "3":
                clearConsole();
                manageCustomerMenu();
                break;
            case "4":
                clearConsole();
                callGUI();
                break;
            case "0":
                verifyLogin();
                break;
            default:
                clearConsole();
                System.out.println("Incorrect input! (" + getInput + ").");
                adminMenu();
        }
    }
    
    public void customerMenu() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("\n------------------- CUSTOMER MENU ------------------\n");
            System.out.println("[1] MAKE NEW ORDER\n");
            System.out.println("[2] SEARCH FOR SPECIFIC ORDER\n");
            System.out.println("[3] DELETE ORDER\n");
            System.out.println("[4] VIEW ALL MY ORDERS\n");
            System.out.println("[5] GUI MODE\n");
            System.out.println("[0] LOG OUT");
            System.out.println("\n----------------------------------------------------");
            System.out.println(">>> Please select your choice: ");
            String getInput = scanner.nextLine().toUpperCase();
            switch (getInput) {
                case "1":
                    clearConsole();
                    uiMakeOrder();
                    break;
                case "2":
                    clearConsole();
                    uiSearchOrder();
                    break;
                case "3":
                    clearConsole();
                    uiDeleteOrder();
                    break;
                case "4":
                    clearConsole();
                    uiViewAllOrders();
                    break;
                case "5":
                    clearConsole();
                    callGUI();
                    break;
                case "0":
                    clearConsole();
                    verifyLogin();
                    break;
                default:
                    clearConsole();
                    System.out.println("Incorrect input! (" + getInput + ").");
                    customerMenu();
            }
    }

    public void manageOrderMenu() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("\n------------------- MANAGE ORDER -------------------\n");
            System.out.println("[1] MAKE NEW ORDER\n");
            System.out.println("[2] SEARCH FOR SPECIFIC ORDER\n");
            System.out.println("[3] DELETE ORDER\n");
            System.out.println("[4] VIEW ALL ORDERS\n");
            System.out.println("[0] BACK");
            System.out.println("\n----------------------------------------------------");
            System.out.println(">>> Please select your choice: ");
            String getInput = scanner.nextLine().toUpperCase();
            switch (getInput) {
                case "1":
                    clearConsole();
                    uiMakeOrder();
                    break;
                case "2":
                    clearConsole();
                    uiSearchOrder();
                    break;
                case "3":
                    clearConsole();
                    uiDeleteOrder();
                    break;
                case "4":
                    clearConsole();
                    uiViewAllOrders();
                    break;
                case "0":
                    clearConsole();
                    adminMenu();
                    break;
                default:
                    clearConsole();
                    System.out.println("Incorrect input! (" + getInput + ").");
                    manageOrderMenu();
            }
    }

    public void manageProductMenu() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("\n------------------ MANAGE PRODUCT ------------------\n");
            System.out.println("[1] ADD NEW PRODUCT\n");
            System.out.println("[2] SEARCH FOR SPECIFIC PRODUCT\n");
            System.out.println("[3] EDIT PRODUCT\n");
            System.out.println("[4] DELETE PRODUCT\n");
            System.out.println("[5] VIEW ALL PRODUCTS\n");
            System.out.println("[0] BACK");
            System.out.println("\n----------------------------------------------------");
            System.out.println(">>> Please select your choice: ");
            String getInput = scanner.nextLine().toUpperCase();
            switch (getInput) {
                case "1":
                    clearConsole();
                    uiAddProduct();
                    break;
                case "2":
                    clearConsole();
                    uiSearchProduct();
                    break;
                case "3":
                    clearConsole();
                    uiEditProduct();
                    break;
                case "4":
                    clearConsole();
                    uiDeleteProduct();
                    break;
                case "5":
                    clearConsole();
                    uiViewAllProducts();
                    break;
                case "0":
                    clearConsole();
                    adminMenu();
                    break;
                default:
                    clearConsole();
                    System.out.println("Incorrect input! (" + getInput + ").");
                    manageProductMenu();
            }
    }

    public void manageCustomerMenu() {
        Scanner inMenu = new Scanner(System.in);
            System.out.println("\n----------------- MANAGE CUSTOMER ------------------\n");
            System.out.println("[1] ADD NEW CUSTOMER\n");
            System.out.println("[2] SEARCH FOR SPECIFIC CUSTOMER\n");
            System.out.println("[3] EDIT CUSTOMER\n");
            System.out.println("[4] DELETE CUSTOMER\n");
            System.out.println("[5] VIEW ALL CUSTOMERS\n");
            System.out.println("[0] BACK");
            System.out.println("\n----------------------------------------------------");
            System.out.println(">>> Please select your choice: ");
            String getInput = inMenu.nextLine().toUpperCase();
            switch (getInput) {
                case "1":
                    clearConsole();
                    uiAddCustomer();
                    break;
                case "2":
                    clearConsole();
                    uiSearchCustomer();
                    break;
                case "3":
                    clearConsole();
                    uiEditCustomer();
                    break;
                case "4":
                    clearConsole();
                    uiDeleteCustomer();
                    break;
                case "5":
                    clearConsole();
                    uiViewAllCustomers();
                    break;
                case "0":
                    clearConsole();
                    adminMenu();
                    break;
                default:
                    clearConsole();
                    System.out.println("Incorrect input! (" + getInput + ").");
                    manageCustomerMenu();
            }
    }

    public void uiMakeOrder() {
        Manage classManage = new Manage();
        while(true) {
        ArrayList<Product> tempProduct = new ArrayList<Product>();
        int counter=0;
        System.out.println("\n------------------ MAKE NEW ORDER ------------------\n");
        System.out.println("#NO   #ID        #NAME         #TYPE #PRICE\n");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataProduct()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                counter++;
                String name, type, space="", space1="";
                int spaceCounter = 12 - ((Product)obj).getProductName().length();
                for(int i = 0; i < spaceCounter; i++){
                    space1 += " ";
                }
                if(((Product)obj).getProductType().equals("FRAGILE")) {
                    type="FRA";
                } else { type="NON"; }
                name=((Product)obj).getProductName() + space1;
                if(counter < 10) { space="  "; }
                else if(counter > 99) {space=""; }
                else { space=" "; }
                
                int intOrderedQuantity=0;
                String strQty="";
                try {
                    for(OrderDetails eachOrderDetails:classManage.tempMakeOrderDetails) {
                        if((eachOrderDetails.getOrDetProductID().equals(((Product)obj).getProductID())) && (!eachOrderDetails.getOrDetProductQty().equals("0"))) {
                            strQty="⨯  " + eachOrderDetails.getOrDetProductQty();
                        }
                    }
                } catch (Exception e){}
                
                int spaceCounter2 = 9 - ((Product)obj).getProductPrice().length();
                String space2="";
                for(int i = 0; i < spaceCounter2; i++) { space2 += " "; }

                System.out.println("[" + counter + "]" + space + " " + ((Product)obj).getProductID() + "  " + name + "  " + type + "   " + ((Product)obj).getProductPrice() + space2 + strQty);
                Product product = new Product();
                product.setProductDate(Integer.toString(counter));
                product.setProductID(((Product)obj).getProductID());
                product.setProductName(((Product)obj).getProductName());
                product.setProductPrice(((Product)obj).getProductPrice());
                product.setProductType(((Product)obj).getProductType());
                tempProduct.add(product);
            }
        } catch (EOFException ex) {}
        catch (ClassNotFoundException ex) { ex.printStackTrace(); }
        catch (FileNotFoundException ex) { ex.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
        String strNO="", strQty;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n[F] FINISH\n[C] CANCEL");
        System.out.println("\n----------------------------------------------------\n");
        System.out.println(">>> Please select your product:");
        strNO = scanner.nextLine().toUpperCase();
        if(strNO.equals("F")) {
            clearConsole();
            classManage.addOrder(userID);
            scanner.nextLine();
            clearConsole();
            if(userType.equals("ADMIN")) {
                manageOrderMenu();
            } else {
                customerMenu();
            }
            break;
        } else if(strNO.equals("C")) {
            clearConsole();
            if(userType.equals("ADMIN")) {
                manageOrderMenu();
            } else {
                customerMenu();
            }
        } else {
            try {
                int intNO = Integer.parseInt(strNO);
                if((intNO <= counter) && (intNO >= 1)) {
                    System.out.println("\n>>> Please enter the quantity:");
                    strQty = scanner.nextLine().toUpperCase();
                    int intQty = Integer.parseInt(strQty);
                    if ((intQty >= 0) && (intQty <= 999)) {
                        for (Product eachProduct: tempProduct) {
                            if(eachProduct.getProductDate().equals(Integer.toString(intNO))) {
                                boolean orderFound=false;
                                for(OrderDetails eachOrderDetails:classManage.tempMakeOrderDetails) {
                                    if(eachOrderDetails.getOrDetProductID().equals(eachProduct.getProductID())) {
                                        eachOrderDetails.setOrDetProductQty(Integer.toString(intQty));
                                        orderFound=true;
                                    }
                                }
                                if(!orderFound) {
                                    classManage.makeOrder(eachProduct.getProductID(), Integer.toString(intQty), eachProduct.getProductType(), eachProduct.getProductPrice());
                                }
                                Double priceDouble = (Math.round((Double.parseDouble(eachProduct.getProductPrice()) * intQty) * 100.0)) / 100.0;
                                System.out.println(eachProduct.getProductName() + " (RM " + eachProduct.getProductPrice() + " X " + intQty + " = RM " + priceDouble + ")");
                            }
                        }
                    } else { System.out.println("Incorrect input!"); }
                } else { System.out.println("Incorrect input!"); }
            } catch (Exception e) { System.out.println("Incorrect input!"); }
        }
        scanner.nextLine();
        clearConsole();
        }
    }
    
    private void uiSearchOrder() {
        String id=""; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------------ SEARCH FOR SPECIFIC ORDER -------------\n");
        System.out.println("(Example: OID123456)");
        System.out.println(">>> Please enter the order ID number: ");
        id=scanner.nextLine().toUpperCase();
        clearConsole();
        new Manage().searchOrder(id);
        scanner.nextLine();
        clearConsole();
        if(userType.equals("ADMIN")) {
            manageOrderMenu();
        } else {
            customerMenu();
        }
    }
        
    private void uiDeleteOrder() {
        String id=""; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------------------- DELETE ORDER -------------------\n");
        System.out.println("(Example: OID123456)");
        System.out.println(">>> Please enter the order ID number: ");
        id=scanner.nextLine().toUpperCase();
        clearConsole();
        new Manage().deleteOrder(id);
        scanner.nextLine();
        clearConsole();
        if(userType.equals("ADMIN")) {
            manageOrderMenu();
        } else {
            customerMenu();
        }
        
    }
        
    private void uiViewAllOrders() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----------------- VIEW ALL ORDERS ------------------");
        new Manage().viewAllOrders();
        scanner.nextLine();
        clearConsole();
        if(userType.equals("ADMIN")) {
            manageOrderMenu();
        } else {
            customerMenu();
        }
    }
        
    private void uiAddProduct() {
        String name="", type="", price = "0";
        double priceDouble = 0.00;
        DecimalFormat format = new DecimalFormat("##.00");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----------------- ADD NEW PRODUCT ------------------\n");
        System.out.println("(Minimum 1 and maximum 12 characters!)");
        System.out.println(">>> Please enter the product name: ");
        name=scanner.nextLine().toUpperCase();
        if((name.length() >= 1) && (name.length() <= 12)) {
            System.out.println("\n[1] FRAGILE PRODUCT\n[0] NON-FRAGILE PRODUCT");
            System.out.println(">>> Please select your choice ");
            type=scanner.nextLine().toUpperCase();
            switch(type) {
                case "1":
                    type="FRAGILE";
                    break;
                case "0":
                    type="NON-FRAGILE";
                    break;
                default:
                    System.out.println("Incorrect input!");
                    scanner.nextLine();
                    clearConsole();
                    manageProductMenu();
            }
            System.out.println("\n(Example: 75.60)");
            System.out.println(">>> Please enter the product price: ");
            price=scanner.nextLine().toUpperCase();
            try {
                priceDouble = Double.parseDouble(price);
                priceDouble = (Math.round(priceDouble * 100.0)) / 100.0;
                clearConsole();
                new Manage().addProduct(name, type, Double.toString(priceDouble));
            } catch (Exception e) { System.out.println("\nIncorrect input!"); }
        } else { System.out.println("\nIncorrect input!"); }
        scanner.nextLine();
        clearConsole();
        manageProductMenu();
    }
    
    private void uiSearchProduct() {
        String id=""; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----------- SEARCH FOR SPECIFIC PRODUCT ------------\n");
        System.out.println("(Example: PID123456)");
        System.out.println(">>> Please enter the product ID number: ");
        id=scanner.nextLine().toUpperCase();
        clearConsole();
        new Manage().searchProduct(id);
        scanner.nextLine();
        clearConsole();
        manageProductMenu();
    }
    
    private void uiDeleteProduct() {
        String id=""; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------------------ DELETE PRODUCT ------------------\n");
        System.out.println("(Example: UID123456)");
        System.out.println(">>> Please enter the product ID number: ");
        id=scanner.nextLine().toUpperCase();
        clearConsole();
        new Manage().deleteProduct(id);
        scanner.nextLine();
        clearConsole();
        manageProductMenu();
    }

    private void uiEditProduct() {
        String id="", name="", type="", price="0"; 
        double priceDouble = 0.00;
        DecimalFormat format = new DecimalFormat("##.00");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------------------- EDIT PRODUCT -------------------\n");
        System.out.println("(Example: PID123456)");
        System.out.println(">>> Please enter the product ID number: ");
        id=scanner.nextLine().toUpperCase();
        if(id.length() == 9) {
            System.out.println("\n(Minimum 1 and maximum 12 characters!)");
            System.out.println(">>> Please enter the new name: ");
            name=scanner.nextLine().toUpperCase();
            if((name.length() >= 1) && (name.length() <= 12)) {
                System.out.println("\n[1] FRAGILE PRODUCT\n[0] NON-FRAGILE PRODUCT");
                System.out.println(">>> Please select your choice ");
                type=scanner.nextLine().toUpperCase();
                switch(type) {
                    case "1":
                        type="FRAGILE";
                        break;
                    case "0":
                        type="NON-FRAGILE";
                        break;
                    default:
                        System.out.println("Incorrect input!");
                        scanner.nextLine();
                        clearConsole();
                        manageProductMenu();
                }
                System.out.println("\n(Example: 75.60)");
                System.out.println(">>> Please enter the new price: ");
                price=scanner.nextLine().toUpperCase();
                try {
                    priceDouble = Double.parseDouble(price);
                    priceDouble = (Math.round(priceDouble * 100.0)) / 100.0;
                    clearConsole();
                    new Manage().editProduct(id, name, type, Double.toString(priceDouble));
                } catch (Exception e) { System.out.println("\nIncorrect input!"); }
            } else { System.out.println("\nIncorrect input!"); }
        } else { System.out.println("\nIncorrect input!"); }
        scanner.nextLine();
        clearConsole();
        manageProductMenu();
    }
    
    private void uiViewAllProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---------------- VIEW ALL PRODUCTS -----------------");
        new Manage().viewProducts();
        scanner.nextLine();
        clearConsole();
        manageProductMenu();
    }
    
    private void uiAddCustomer() {
        String name="", password="", address="", contact=""; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----------------- ADD NEW CUSTOMER -----------------\n");
        System.out.println("(Minimum 4 and maximum 12 characters!)");
        System.out.println(">>> Please enter the customer name: ");
        name=scanner.nextLine().toUpperCase();
        if((name.length() >= 4) && (name.length() <= 12)) {
            System.out.println("\n(Minimum 4 and maximum 12 characters!)");
            System.out.println(">>> Please enter the password: ");
            password=scanner.nextLine().toUpperCase();
            if((password.length() >= 4) && (password.length() <= 12)) {
                System.out.println("\n(Maximum 25 characters!)");
                System.out.println(">>> Please enter the address: ");
                address=scanner.nextLine().toUpperCase();
                if(address.equals("")) {address="-";}
                if((address.length() <= 25)) {
                    System.out.println("\n(Maximum 16 characters!)");
                    System.out.println(">>> Please enter the contact number: ");
                    contact=scanner.nextLine().toUpperCase();
                    if(contact.equals("")) { contact="-"; }
                    if(contact.length() <= 16) {
                        clearConsole();
                        new Manage().addCustomer(password, name, address, contact);
                    } else { System.out.println("\nIncorrect input!"); }
                } else { System.out.println("\nIncorrect input!"); }
            } else { System.out.println("\nIncorrect input!"); }
        } else { System.out.println("\nIncorrect input!"); }
        scanner.nextLine();
        clearConsole();
        manageCustomerMenu();
    }
    
    private void uiSearchCustomer() {
        String id=""; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----------- SEARCH FOR SPECIFIC CUSTOMER -----------\n");
        System.out.println("(Example: UID123456)");
        System.out.println(">>> Please enter the customer ID number: ");
        id=scanner.nextLine().toUpperCase();
        clearConsole();
        new Manage().searchCustomer(id);
        scanner.nextLine();
        clearConsole();
        manageCustomerMenu();
    }
        
    private void uiEditCustomer() {
        String id="", name="", password="", address="", contact=""; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------------------- EDIT CUSTOMER ------------------\n");
        System.out.println("(Example: UID123456)");
        System.out.println(">>> Please enter the customer ID number: ");
        id=scanner.nextLine().toUpperCase();
        if(id.length() == 9) {
            System.out.println("\n(Minimum 4 and maximum 12 characters!)");
            System.out.println(">>> Please enter the new name: ");
            name=scanner.nextLine().toUpperCase();
            if((name.length() >= 4) && (name.length() <= 12)) {
                System.out.println("\n(Minimum 4 and maximum 12 characters!)");
                System.out.println(">>> Please enter the new password: ");
                password=scanner.nextLine().toUpperCase();
                if((password.length() >= 4) && (password.length() <= 12)) {
                    System.out.println("\n(Maximum 25 characters!)");
                    System.out.println(">>> Please enter the new address: ");
                    address=scanner.nextLine().toUpperCase();
                    if(address.equals("")) {address="-";}
                    if((address.length() <= 25)) {
                        System.out.println("\n(Maximum 16 characters!)");
                        System.out.println(">>> Please enter the new contact number: ");
                        contact=scanner.nextLine().toUpperCase();
                        if(contact.equals("")) {contact="-";}
                        if((contact.length() <= 16)) {
                            clearConsole();
                            new Manage().editCustomer(id, password, name, address, contact);
                        } else { System.out.println("\nIncorrect input!"); }
                    } else { System.out.println("\nIncorrect input!"); }
                } else { System.out.println("\nIncorrect input!"); }
            } else { System.out.println("\nIncorrect input!"); }
        } else { System.out.println("\nIncorrect input!"); }
        scanner.nextLine();
        clearConsole();
        manageCustomerMenu();
    }
 
    private void uiDeleteCustomer() {
        String id=""; 
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----------------- DELETE CUSTOMER ------------------\n");
        System.out.println("(Example: UID123456)");
        System.out.println(">>> Please enter the customer ID number: ");
        id=scanner.nextLine().toUpperCase();
        if(!id.equals(userID)) {
            clearConsole();
            new Manage().deleteCustomer(id);
        } else { System.out.println("\nYou can not delete yourself!"); }
        scanner.nextLine();
        clearConsole();
        manageCustomerMenu();
    }
    
    private void uiViewAllCustomers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---------------- VIEW ALL CUSTOMERS ----------------");
        new Manage().viewCustomer();
        scanner.nextLine();
        clearConsole();
        manageCustomerMenu();
    }
        
    public void clearConsole() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }
}
