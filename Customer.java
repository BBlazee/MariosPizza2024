/**
 * Write a description of class Customer here.
 *
 * Brestir Nielsen
 * 21.10.2024
 */
public class Customer
{
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private boolean vip;
    private String address;
    
    public Customer(int id, String name,String phoneNumber,String email, boolean vip, String address) 
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.vip = vip;
        this.address = address;
    }
    
    public int getId() 
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    
    public String getEmail() 
    {
        return email;
    }
    
     public boolean isVip() 
    {
        return vip;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setPhoneNumber(String phoneNumber) 
    {
        if (phoneNumber == null || phoneNumber.isEmpty())
        {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        
        this.phoneNumber = phoneNumber;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setVip(boolean vip) 
    {
        this.vip = vip;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }
    
    public double applyDiscount(double price)
    {
        if (vip)
        {
            return price * 0.9;
        }
        return price;
    }
}