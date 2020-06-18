import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Manage {
    public ArrayList<OrderDetails> tempMakeOrderDetails = new ArrayList<OrderDetails>();
    public final double fragileRate=1.5;
    
    private static int generateNum(int min, int max){
        Random rand = new Random();
        return min + rand.nextInt((max - min) + 1);
    }
    
    public void setTempMakeOrderDetails(OrderDetails tempMakeOrderDetails) {
        this.tempMakeOrderDetails.add(tempMakeOrderDetails);
    }
    
    public void firstUser() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataUser()));
        } catch (FileNotFoundException ex) {
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream(new Login().getDataUser()));
                Customer customer = new Customer();
                customer.setCusID("UID" + Integer.toString(generateNum(100000, 999999)));
                customer.setCusPassword(Integer.toString(generateNum(1000, 9999)));
                customer.setCusType("ADMIN");
                customer.setCusName("ADMIN");
                customer.setCusAddress("-");
                customer.setCusContact("-");
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                customer.setCusDate(dateFormat.format(date));
                oos.writeObject(customer);
                System.out.println("WELCOME NEW USER!\n");
                System.out.println("ID NUMBER: " + customer.getCusID());
                System.out.println("PASSWORD:  " + customer.getCusPassword());
                System.out.println("USER TYPE: " + customer.getCusType());
                System.out.println("\nAuto-generated login credentials for new system!");
                customer=null;
                oos.flush();
                oos.close();
            } catch (Exception e) {}
        } catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
        
        ObjectInputStream ois1 = null;
        try {
            ois1 = new ObjectInputStream(new FileInputStream(new Login().getDataProduct()));
        } catch (FileNotFoundException ex) {
            ObjectOutputStream oos1 = null;
            try {
                oos1 = new ObjectOutputStream(new FileOutputStream(new Login().getDataProduct()));
                Product product = new Product();
                product.setProductID("PID000000");
                product.setProductName("TEST");
                product.setProductPrice("0.0");
                product.setProductType("FRAGILE");
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                product.setProductDate(dateFormat.format(date));
                oos1.writeObject(product);
                product=null;
                oos1.flush();
                oos1.close();
            } catch (Exception e) {}
        } catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois1 != null) {
                    ois1.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }

        ObjectInputStream ois2 = null;
        try {
            ois2 = new ObjectInputStream(new FileInputStream(new Login().getDataOrder()));
        } catch (FileNotFoundException ex) {
            ObjectOutputStream oos2 = null;
            try {
                oos2 = new ObjectOutputStream(new FileOutputStream(new Login().getDataOrder()));
                Order order = new Order();
                order.setOrderID("OID000000");
                order.setOrderCusID("UID000000");
                order.setOrderTotalPrice("0.0");
                order.setOrderAmount("0");
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                order.setOrderDate(dateFormat.format(date));
                oos2.writeObject(order);
                order=null;
                oos2.flush();
                oos2.close();
            } catch (Exception e) {}
        } catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois2 != null) {
                    ois2.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
        
        ObjectInputStream ois3 = null;
        try {
            ois3 = new ObjectInputStream(new FileInputStream(new Login().getDataOrderDetails()));
        } catch (FileNotFoundException ex) {
            ObjectOutputStream oos3 = null;
            try {
                oos3 = new ObjectOutputStream(new FileOutputStream(new Login().getDataOrderDetails()));
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setOrDetOrderID("OID000000");
                orderDetails.setOrDetProductID("PID000000");
                orderDetails.setOrDetProductPrice("0.0");
                orderDetails.setOrDetProductQty("0");
                orderDetails.setOrDetProductType("FRAGILE");
                oos3.writeObject(orderDetails);
                orderDetails=null;
                oos3.flush();
                oos3.close();
            } catch (Exception e) {}
        } catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois3 != null) { ois3.close(); }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }

    public void makeOrder(String id, String qty, String type, String price) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrDetProductID(id);
        orderDetails.setOrDetProductQty(qty);
        orderDetails.setOrDetProductType(type);
        orderDetails.setOrDetProductPrice(price);
        setTempMakeOrderDetails(orderDetails);
    }
    
    public String addOrder(String userID) {
        String orderID = "OID" + Integer.toString(generateNum(100000, 999999));
        ArrayList<Order> tempOrder = new ArrayList<Order>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataOrder()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                tempOrder.add((Order)obj);
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
        
        ObjectOutputStream oos = null;
        int intTotalAmount=0;
        double doubleTotalPrice=0;
        for(OrderDetails eachOrderDetails:tempMakeOrderDetails) {
            intTotalAmount+=Integer.parseInt(eachOrderDetails.getOrDetProductQty());
            doubleTotalPrice+=Integer.parseInt(eachOrderDetails.getOrDetProductQty()) * Double.parseDouble(eachOrderDetails.getOrDetProductPrice());
        }
        doubleTotalPrice = (Math.round(doubleTotalPrice * 100.0)) / 100.0;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new Login().getDataOrder()));
            Order order = new Order();
            order.setOrderID(orderID);
            order.setOrderAmount(Integer.toString(intTotalAmount));
            order.setOrderCusID(userID);
            order.setOrderTotalPrice(Double.toString(doubleTotalPrice));
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            order.setOrderDate(dateFormat.format(date));

            boolean idExists = false;
            for(Order eachOrder:tempOrder){
                if(eachOrder.getOrderID().equals(order.getOrderID())) {
                    idExists = true;
                }
            }
            
            if (idExists == false) {
                tempOrder.add(order);
                doubleTotalPrice=0;
                addOrderDetails(order.getOrderID());
            } else {
                addOrder(userID);
            }
            for(Order eachOrder: tempOrder){
                oos.writeObject(eachOrder);
            }
            System.out.println("\nOrder '" + order.getOrderID() + "' is successfully finished!");
            tempOrder.clear();
            oos.flush();
            oos.close();
            searchOrder(order.getOrderID());
            order=null;
        } catch (Exception e) {}
        return orderID;
    }

    public void addOrderDetails(String orderID) {
        ArrayList<OrderDetails> tempOrderDetails = new ArrayList<OrderDetails>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataOrderDetails()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                tempOrderDetails.add((OrderDetails)obj);
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
        
        for(OrderDetails eachMakeOrderDetails: tempMakeOrderDetails) {
            eachMakeOrderDetails.setOrDetOrderID(orderID);
            tempOrderDetails.add(eachMakeOrderDetails);
        }
        
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new Login().getDataOrderDetails()));

            for(OrderDetails eachOrderDetails: tempOrderDetails){
                oos.writeObject(eachOrderDetails);
            }
            tempOrderDetails.clear();
            oos.flush();
            oos.close();
        } catch (Exception e) {}
    }
        
    public String [] searchOrder(String id) {
        int fragileCounter=0;
        double doubleTotalPrice=0;
        boolean idFound = false;
        String[] temp = new String[8];
        temp[0] = "";temp[1] = "";temp[2] = "";temp[3] = "";temp[4] = "";temp[5] = "";temp[6] = "";temp[7] = "";
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataOrder()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                if(((Order)obj).getOrderID().equals(id)){
                    idFound = true;
                    System.out.println("\nSearch result for '" + id + "':");
                    System.out.println("\n----------------------------------------------------");
                    System.out.println(((Order)obj).toString());
                    doubleTotalPrice = Double.parseDouble(((Order)obj).getOrderTotalPrice());
                    temp[0] = ((Order)obj).getOrderID();
                    temp[1] = ((Order)obj).getOrderCusID();
                    temp[2] = ((Order)obj).getOrderAmount();
                    temp[3] = ((Order)obj).getOrderDate();
                    temp[4] = ((Order)obj).getOrderTotalPrice();
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
            ObjectInputStream ois1 = null;
            int intCounter=0;
        try {
            ois1 = new ObjectInputStream(new FileInputStream(new Login().getDataOrderDetails()));
            Object obj1 = null;
            String strCounter="", strType="", strPrice="";
            System.out.println("#NO #ID       #TYPE #PRICE       #QTY   #TOTAL PRICE");
            while ((obj1 = ois1.readObject()) != null) {
                if(((OrderDetails)obj1).getOrDetOrderID().equals(id)) {
                    intCounter++;
                    if(intCounter <= 9) { strCounter=Integer.toString(intCounter) + "   "; }
                    else if(intCounter >= 100) { strCounter=Integer.toString(intCounter) + " "; }
                    else { strCounter=Integer.toString(intCounter) + "  "; }
                    if(((OrderDetails)obj1).getOrDetProductType().equals("FRAGILE")) {
                        strType="FRA";
                        fragileCounter += Integer.parseInt(((OrderDetails)obj1).getOrDetProductQty());
                    }
                    else { strType="NON"; }
                    int spaceCounter = 10 - ((OrderDetails)obj1).getOrDetProductPrice().length();
                    String space="", space1="";
                    for(int i = 0; i < spaceCounter; i++) { space += " "; }
                    int spaceCounter1 = 6 - ((OrderDetails)obj1).getOrDetProductQty().length();
                    for(int i = 0; i < spaceCounter1; i++) { space1 += " "; }
                    double totalPriceDouble = 0.00;
                    totalPriceDouble = (Math.round((Double.parseDouble(((OrderDetails)obj1).getOrDetProductPrice()) * Double.parseDouble(((OrderDetails)obj1).getOrDetProductQty())) * 100.0)) / 100.0;
                    System.out.println(strCounter + ((OrderDetails)obj1).getOrDetProductID() + " " + strType + "   RM" + ((OrderDetails)obj1).getOrDetProductPrice() + space + " " + ((OrderDetails)obj1).getOrDetProductQty() + space1 + " RM" + totalPriceDouble);
                }
            }

        } catch (EOFException ex) {
            temp[5] = String.valueOf(fragileCounter);
            temp[6] = String.valueOf(fragileCounter * fragileRate);
            temp[7] = String.valueOf((fragileCounter * fragileRate) + doubleTotalPrice);
            System.out.println("\nTOTAL FREGILE PRODUCTS:          " + fragileCounter);
            System.out.println("FREGILE RATE (RM 1.5):           RM " + fragileCounter * fragileRate);
            System.out.println("TOTAL CHARGES:                   RM " + ((fragileCounter * fragileRate) + doubleTotalPrice));
            System.out.println("\n----------------------------------------------------");
        } catch (ClassNotFoundException ex) { ex.printStackTrace(); }
        catch (FileNotFoundException ex) { ex.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois1 != null) {
                    ois1.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
        } else {
            System.out.println("\nOrder '" + id + "' is not found!\n");
        }
        return temp;
    }

    public void deleteOrder(String id) {
        boolean idFound = false;
        ArrayList<Order> tempOrder = new ArrayList<Order>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataOrder()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                if (!((Order)obj).getOrderID().equals(id)){
                    tempOrder.add((Order)obj);
                } else {
                    idFound = true;
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
        
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new Login().getDataOrder()));
            for(Order eachOrder: tempOrder){
                oos.writeObject(eachOrder);
            }
            tempOrder.clear();
            oos.flush();
            oos.close();
            
            if (idFound) {
                ArrayList<OrderDetails> tempOrderDetails = new ArrayList<OrderDetails>();
                ObjectInputStream ois1 = null;
                try {
                    ois1 = new ObjectInputStream(new FileInputStream(new Login().getDataOrderDetails()));
                    Object obj1 = null;
                    while ((obj1 = ois1.readObject()) != null) {
                        if (!((OrderDetails)obj1).getOrDetOrderID().equals(id)){
                            tempOrderDetails.add((OrderDetails)obj1);
                        }
                    }
                } catch (EOFException ex) {}
                catch (ClassNotFoundException ex) { ex.printStackTrace(); }
                catch (FileNotFoundException ex) { ex.printStackTrace(); }
                catch (IOException ex) { ex.printStackTrace(); }
                finally {
                    try {
                        if (ois1 != null) {
                            ois1.close();
                        }
                    } catch (IOException ex) { ex.printStackTrace(); }
                }
        
                ObjectOutputStream oos1 = null;
                try {
                    oos1 = new ObjectOutputStream(new FileOutputStream(new Login().getDataOrderDetails()));
                    for(OrderDetails eachOrderDetails: tempOrderDetails) {
                        oos1.writeObject(eachOrderDetails);
                    }
                    tempOrderDetails.clear();
                    oos1.flush();
                    oos1.close();
                } catch (Exception e) {}
                System.out.println("\nOrder '" + id + "' is successfully deleted!\n");
            } else {
                System.out.println("\nOrder '" + id + "' is not found!\n");
            }
        } catch (Exception e) {}
    }
        
    public void viewAllOrders() {
        int fragileCounter=0, count=0;
        double doubleTotalPrice=0;
        boolean idFound = false;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataOrder()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                count++;
                idFound = true;
                System.out.println(((Order)obj).toString());
                doubleTotalPrice = Double.parseDouble(((Order)obj).getOrderTotalPrice());
                ObjectInputStream ois1 = null;
                int intCounter=0;
                try {
                    ois1 = new ObjectInputStream(new FileInputStream(new Login().getDataOrderDetails()));
                    Object obj1 = null;
                    String strCounter="", strType="", strPrice="";
                    System.out.println("#NO #ID       #TYPE #PRICE       #QTY   #TOTAL PRICE");
                    while ((obj1 = ois1.readObject()) != null) {
                        if(((OrderDetails)obj1).getOrDetOrderID().equals(((Order)obj).getOrderID())) {
                            intCounter++;
                            if(intCounter <= 9) { strCounter=Integer.toString(intCounter) + "   "; }
                            else if(intCounter >= 100) { strCounter=Integer.toString(intCounter) + " "; }
                            else { strCounter=Integer.toString(intCounter) + "  "; }
                            if(((OrderDetails)obj1).getOrDetProductType().equals("FRAGILE")) {
                                strType="FRA";
                                fragileCounter += Integer.parseInt(((OrderDetails)obj1).getOrDetProductQty());
                            }
                            else { strType="NON"; }
                            int spaceCounter = 10 - ((OrderDetails)obj1).getOrDetProductPrice().length();
                            String space="", space1="";
                            for(int i = 0; i < spaceCounter; i++) { space += " "; }
                            int spaceCounter1 = 6 - ((OrderDetails)obj1).getOrDetProductQty().length();
                            for(int i = 0; i < spaceCounter1; i++) { space1 += " "; }
                            double totalPriceDouble = 0.00;
                            totalPriceDouble = (Math.round((Double.parseDouble(((OrderDetails)obj1).getOrDetProductPrice()) * Double.parseDouble(((OrderDetails)obj1).getOrDetProductQty())) * 100.0)) / 100.0;
                            System.out.println(strCounter + ((OrderDetails)obj1).getOrDetProductID() + " " + strType + "   RM" + ((OrderDetails)obj1).getOrDetProductPrice() + space + " " + ((OrderDetails)obj1).getOrDetProductQty() + space1 + " RM" + totalPriceDouble);
                        }
                    }
                } catch (EOFException ex) {
                    System.out.println("\nTOTAL FREGILE PRODUCTS:          " + fragileCounter);
                    System.out.println("FREGILE RATE (RM 1.5):           RM " + fragileCounter * fragileRate);
                    System.out.println("TOTAL CHARGES:                   RM " + ((fragileCounter * fragileRate) + doubleTotalPrice));
                    System.out.println("\n----------------------------------------------------");
                    fragileCounter=0;
                } catch (ClassNotFoundException ex) { ex.printStackTrace(); }
                catch (FileNotFoundException ex) { ex.printStackTrace(); }
                catch (IOException ex) { ex.printStackTrace(); }
                finally {
                    try {
                        if (ois1 != null) {
                            ois1.close();
                        }
                    } catch (IOException ex) { ex.printStackTrace(); }
                }
            }
        } catch (EOFException ex) {
            System.out.println("\nTotal " + count + " orders.");
        } catch (ClassNotFoundException ex) { ex.printStackTrace(); }
        catch (FileNotFoundException ex) { ex.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
        if (idFound == false) {
            System.out.println("\nOrder is not found!\n");
        }
    }
    
    public void addProduct(String name, String type, String price) {
        ArrayList<Product> tempProduct = new ArrayList<Product>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataProduct()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                tempProduct.add((Product)obj);
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
        
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new Login().getDataProduct()));
            Product product = new Product();
            product.setProductID("PID" + Integer.toString(generateNum(100000, 999999)));
            product.setProductName(name);
            product.setProductType(type);
            product.setProductPrice(price);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            product.setProductDate(dateFormat.format(date));

            boolean idExists = false;
            for(Product eachProduct:tempProduct){
                if(eachProduct.getProductID().equals(product.getProductID())) {
                    idExists = true;
                }
            }
            
            if (idExists == false) {
                tempProduct.add(product);
            } else {
                addProduct(name, type, price);
            }
            for(Product eachProduct: tempProduct){
                oos.writeObject(eachProduct);
            }
            System.out.println("\nProduct '" + product.getProductName() + "' is successfully added!");
            System.out.println(product.toString());
            product=null;
            tempProduct.clear();
            oos.flush();
            oos.close();
        } catch (Exception e) {}
    }
        
    public void searchProduct(String id) {
        boolean idFound = false;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataProduct()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                if(((Product)obj).getProductID().equals(id)){
                    idFound = true;
                    System.out.println("\nSearch result for '" + id + "':");
                    System.out.println(((Product)obj).toString());
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
        
        if (idFound == false) {
            System.out.println("\nProduct '" + id + "' is not found!\n");
        }
    }

    public void editProduct(String id, String name, String type, String price) {
        ArrayList<Product> tempProduct = new ArrayList<Product>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataProduct()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                if (!((Product)obj).getProductID().equals(id)){
                    tempProduct.add((Product)obj);
                } else {
                    System.out.println("\nProduct '" + id + "' is successfully updated!");
                    Product product = new Product();
                    product.setProductID(id);
                    product.setProductName(name);
                    product.setProductType(type);
                    product.setProductPrice(price);
                    product.setProductDate(((Product)obj).getProductDate());
                    tempProduct.add(product);
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
        
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new Login().getDataProduct()));
            for(Product eachProduct: tempProduct){
                oos.writeObject(eachProduct);
            }
            tempProduct.clear();
            oos.flush();
            oos.close();
        } catch (Exception e) {}
        searchProduct(id);
    }
        
    public void deleteProduct(String id) {
        boolean idFound = false;
        ArrayList<Product> tempProduct = new ArrayList<Product>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataProduct()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                if (!((Product)obj).getProductID().equals(id)){
                    tempProduct.add((Product)obj);
                } else {
                    idFound = true;
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
        
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new Login().getDataProduct()));
            for(Product eachProduct: tempProduct){
                oos.writeObject(eachProduct);
            }
            tempProduct.clear();
            oos.flush();
            oos.close();
            
            if (idFound) {
                System.out.println("\nProduct '" + id + "' is successfully deleted!\n");
            } else {
                System.out.println("\nProduct '" + id + "' is not found!\n");
            }
        } catch (Exception e) {}
    }

    public void viewProducts() {
        int count=0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataProduct()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                count++;
                System.out.println(((Product)obj));
            }
        } catch (EOFException ex) {
            System.out.println("\nTotal " + count + " products.");
        } catch (ClassNotFoundException ex) { ex.printStackTrace(); }
        catch (FileNotFoundException ex) { ex.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }
    
    public void addCustomer(String password, String name, String address, String contact) {
        ArrayList<Customer> tempCustomer = new ArrayList<Customer>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataUser()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                tempCustomer.add((Customer)obj);
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
        
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new Login().getDataUser()));
            Customer customer = new Customer();
            customer.setCusID("UID" + Integer.toString(generateNum(100000, 999999)));
            customer.setCusPassword(password);
            customer.setCusType("CUSTOMER");
            customer.setCusName(name);
            customer.setCusAddress(address);
            customer.setCusContact(contact);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            customer.setCusDate(dateFormat.format(date));

            boolean idExists = false;
            for(Customer eachCustomer:tempCustomer){
                if(eachCustomer.getCusID().equals(customer.getCusID())) {
                    idExists = true;
                }
            }
            
            if (idExists == false) {
                tempCustomer.add(customer);
            } else {
                addCustomer(password, name, address, contact);
            }
            for(Customer eachCustomer: tempCustomer){
                oos.writeObject(eachCustomer);
            }
            System.out.println("\nCustomer '" + customer.getCusName() + "' is successfully registered!");
            System.out.println(customer.toString());
            customer=null;
            tempCustomer.clear();
            oos.flush();
            oos.close();
        } catch (Exception e) {}
    }

    public void searchCustomer(String id) {
        boolean idFound = false;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataUser()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                if(((Customer)obj).getCusID().equals(id)){
                    idFound = true;
                    System.out.println("\nSearch result for '" + id + "':");
                    System.out.println(((Customer)obj).toString());
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
        
        if (idFound == false) {
            System.out.println("\nCustomer '" + id + "' is not found!\n");
        }
    }

    public void editCustomer(String id, String password, String name, String address, String contact) {
        ArrayList<Customer> tempCustomer = new ArrayList<Customer>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataUser()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                if (!((Customer)obj).getCusID().equals(id)){
                    tempCustomer.add((Customer)obj);
                } else {
                    System.out.println("\nCustomer '" + id + "' is successfully updated!");
                    Customer customer = new Customer();
                    customer.setCusID(id);
                    customer.setCusPassword(password);
                    customer.setCusType(((Customer)obj).getCusType());
                    customer.setCusName(name);
                    customer.setCusAddress(address);
                    customer.setCusContact(contact);
                    customer.setCusDate(((Customer)obj).getCusDate());
                    tempCustomer.add(customer);
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
        
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new Login().getDataUser()));
            for(Customer eachCustomer: tempCustomer){
                oos.writeObject(eachCustomer);
            }
            tempCustomer.clear();
            oos.flush();
            oos.close();
        } catch (Exception e) {}
        searchCustomer(id);
    }

    public void deleteCustomer(String id) {
        boolean idFound = false;
        ArrayList<Customer> tempCustomer = new ArrayList<Customer>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataUser()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                if (!((Customer)obj).getCusID().equals(id)){
                    tempCustomer.add((Customer)obj);
                } else {
                    idFound = true;
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
        
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new Login().getDataUser()));
            for(Customer eachCustomer: tempCustomer){
                oos.writeObject(eachCustomer);
            }
            tempCustomer.clear();
            oos.flush();
            oos.close();
            
            if (idFound) {
                System.out.println("\nCustomer '" + id + "' is successfully deleted!\n");
            } else {
                System.out.println("\nCustomer '" + id + "' is not found!\n");
            }
        } catch (Exception e) {}
    }
    
    public void viewCustomer() {
        int count=0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new Login().getDataUser()));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                count++;
                System.out.println(((Customer)obj).toString());
            }
        } catch (EOFException ex) {
            System.out.println("\nTotal " + count + " customers.");
        } catch (ClassNotFoundException ex) { ex.printStackTrace(); }
        catch (FileNotFoundException ex) { ex.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace(); }
        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }
}
