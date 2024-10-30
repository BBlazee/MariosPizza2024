import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;

public class Order implements Serializable {

    private int orderID;
    private String customer;
    private String pizzas;
    private double calculateTotal;
    private String status;


    public Order() {
    }
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }


    public String getCustomer() {
        return customer;
    }

    public void setFirstName(String customer) {
        this.customer = customer;
    }

    public String getPizzas() {
        return pizzas;
    }

    public void setLastName(String pizzas) {
        this.pizzas = pizzas;
    }


    //Overriding toString to be able to print out the object in a readable way
    //when it is later read from the file.
    public String toString() {

        StringBuffer buffer = new StringBuffer();
        buffer.append(orderID);
        buffer.append("\n");
        buffer.append(customer);
        buffer.append("\n");
        buffer.append(pizzas);
        buffer.append("\n");

        return buffer.toString();
    }
}


public static void serializeDataOut(Order ish)throws IOException{
    String fileName= "database.txt";
    FileOutputStream fos = new FileOutputStream(fileName);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(ish);
    oos.close();
}

public static Order serializeDataIn(){
    String fileName= "database.txt";
    FileInputStream fin = new FileInputStream(fileName);
    ObjectInputStream ois = new ObjectInputStream(fin);
    Order order = (Order) ois.readObject();
    ois.close();
    return order;
}

/*
ObjectOutputStream oos = new ObjectOutputStream(fos);
oos.write(Order);

ObjectInputStream ois = new ObjectInputStream(fos);
IHandler iHandler = (IHandler) ois.readObject();
*/

