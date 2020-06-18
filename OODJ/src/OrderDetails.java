import java.io.Serializable;

public class OrderDetails implements Serializable  {
    private String orDetOrderID;
    private String orDetProductID;
    private String orDetProductQty;
    private String orDetProductType;
    private String orDetProductPrice;
    
    public OrderDetails() {
    }
    
    public void setOrDetOrderID(String orDetOrderID) {
        this.orDetOrderID = orDetOrderID;
    }
    
    public void setOrDetProductID(String orDetProductID) {
        this.orDetProductID = orDetProductID;
    }
        
    public void setOrDetProductQty(String orDetProductQty) {
        this.orDetProductQty = orDetProductQty;
    }
    
    public void setOrDetProductType(String orDetProductType) {
        this.orDetProductType = orDetProductType;
    }

    public void setOrDetProductPrice(String orDetProductPrice) {
        this.orDetProductPrice = orDetProductPrice;
    }
    
    public String getOrDetOrderID() {
        return orDetOrderID;
    }
    
    public String getOrDetProductID() {
        return orDetProductID;
    }
        
    public String getOrDetProductQty() {
        return orDetProductQty;
    }
    
    public String getOrDetProductType() {
        return orDetProductType;
    }
        
    public String getOrDetProductPrice() {
        return orDetProductPrice;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n - ORDER ID:      ");
        buffer.append(orDetOrderID);
        buffer.append("\n - PRODUCT ID:    ");
        buffer.append(orDetProductID);
        buffer.append("\n - QUANTITY:      ");
        buffer.append(orDetProductQty);
        buffer.append("\n - PRODUCT TYPE:  RM ");
        buffer.append(orDetProductType);
        buffer.append("\n - PRODUCT PRICE: ");
        buffer.append(orDetProductPrice);
        buffer.append("\n\n----------------------------------------------------");
        return buffer.toString();
    }
}
