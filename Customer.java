public class Customer
{
    private int id;
    private String name;
    private String phoneNumber;
    private boolean vip;
    private String address;
    private int orderCount;
    
    public Customer(int id, String name,String phoneNumber, boolean vip, String address, int orderCount) 
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.vip = vip;
        this.address = address;
        this.orderCount = orderCount;
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
    
     public boolean isVip() 
    {
        return vip;
    }
    
    public String getAddress()
    {
        return address;
    }

    public int getOrderCount() 
    {
        return orderCount;
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

    public void setVip(boolean vip) 
    {
        this.vip = vip;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public void setOrderCount(int orderCount) 
    {
        this.orderCount = orderCount;
    }
    
    public double applyDiscount(double price)
    {
        if (vip)
        {
            return price * 0.9;
        }
        return price;
    }

    public void incrementOrderCount()
    {
        this.orderCount++;
    }
}