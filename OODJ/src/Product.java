import java.io.Serializable;

public class Product implements Serializable {
    private String productID;
    private String productName;
    private String productType;
    private String productPrice;
    private String productDate;
    
    public Product() {
    }
    
    public void setProductID(String productID) {
        this.productID = productID;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
        
    public void setProductType(String productType) {
        this.productType = productType;
    }
    
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }
    
    public String getProductID() {
        return productID;
    }
    
    public String getProductName() {
        return productName;
    }
        
    public String getProductType() {
        return productType;
    }
    
    public String getProductPrice() {
        return productPrice;
    }
        
    public String getProductDate() {
        return productDate;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n - PRODUCT ID:    ");
        buffer.append(productID);
        buffer.append("\n - PRODUCT NAME:  ");
        buffer.append(productName);
        buffer.append("\n - PRODUCT TYPE:  ");
        buffer.append(productType);
        buffer.append("\n - PRODUCT PRICE: RM ");
        buffer.append(productPrice);
        buffer.append("\n - ADDED TIME:    ");
        buffer.append(productDate);
        buffer.append("\n\n----------------------------------------------------");
        return buffer.toString();
    }
}
