import java.io.Serializable;

public class Order implements Serializable {
    private String orderID;
    private String orderCusID;
    private String orderAmount;
    private String orderTotalPrice;
    private String orderDate;
    
    public Order() {
    }
    
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    
    public void setOrderCusID(String orderCusID) {
        this.orderCusID = orderCusID;
    }
        
    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }
    
    public void setOrderTotalPrice(String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
    public String getOrderID() {
        return orderID;
    }
    
    public String getOrderCusID() {
        return orderCusID;
    }
        
    public String getOrderAmount() {
        return orderAmount;
    }
    
    public String getOrderTotalPrice() {
        return orderTotalPrice;
    }
        
    public String getOrderDate() {
        return orderDate;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\nORDER ID:                        ");
        buffer.append(orderID);
        buffer.append("\nCUSTOMER ID:                     ");
        buffer.append(orderCusID);
        buffer.append("\nTOTAL AMOUNT:                    ");
        buffer.append(orderAmount);
        buffer.append("\nTOTAL PRICE:                     RM ");
        buffer.append(orderTotalPrice);
        buffer.append("\nORDERED DATE:                    ");
        buffer.append(orderDate);
        buffer.append("\n");
        return buffer.toString();
    }
}
