import java.io.Serializable;

public class Customer implements Serializable {
    private String cusID;
    private String cusPassword;
    private String cusType;
    private String cusName;
    private String cusAddress;
    private String cusContact;
    private String cusDate;
    
    public Customer() {
    }
    
    public void setCusID(String cusID) {
        this.cusID = cusID;
    }
    
    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }
        
    public void setCusType(String cusType) {
        this.cusType = cusType;
    }
    
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
        
    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }
    
    public void setCusContact(String cusContact) {
        this.cusContact = cusContact;
    }
        
    public void setCusDate(String cusDate) {
        this.cusDate = cusDate;
    }
    
    public String getCusID() {
        return cusID;
    }
    
    public String getCusPassword() {
        return cusPassword;
    }
        
    public String getCusType() {
        return cusType;
    }
    
    public String getCusName() {
        return cusName;
    }
        
    public String getCusAddress() {
        return cusAddress;
    }
            
    public String getCusContact() {
        return cusContact;
    }
                
    public String getCusDate() {
        return cusDate;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n - USER ID:   ");
        buffer.append(cusID);
        buffer.append("\n - PASSWORD:  ");
        buffer.append(cusPassword);
        buffer.append("\n - USER TYPE: ");
        buffer.append(cusType);
        buffer.append("\n - FULL NAME: ");
        buffer.append(cusName);
        buffer.append("\n - ADDRESS:   ");
        buffer.append(cusAddress);
        buffer.append("\n - CONTACT:   ");
        buffer.append(cusContact);
        buffer.append("\n - DATE-TIME: ");
        buffer.append(cusDate);
        buffer.append("\n\n----------------------------------------------------");
        return buffer.toString();
    }
}
