//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Ticketpool ticketpool = new Ticketpool(10);

        Vendor[] vendors = new Vendor[10];
        for (int i = 0; i < vendors.length; i++) {
            vendors[i] = new Vendor(20,5,ticketpool);
            Thread vendorThread = new Thread(vendors[i], "Vendor ID" +  i);
            vendorThread.start();
        }

        Customer[] customers = new Customer[10];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(ticketpool,6,5);
            Thread customerThread = new Thread(customers[i], "Customer ID" +  i);
            customerThread.start();
        }
    }
}