public class Customer implements Runnable {
    private Ticketpool Ticketpool;
    private int CustomerReturnRate;
    private int quantity;

    public Customer(Ticketpool Ticketpool, int CustomerReturnRate, int quantity) {
        this.Ticketpool = Ticketpool;
        this.CustomerReturnRate = CustomerReturnRate;
        this.quantity = quantity;
    }
    @Override
    public void run(){
        for(int i = 0; i < quantity; i++){
            Ticket ticket = Ticketpool.getTicket();
            System.out.println("Ticket is " + i + ": " + ticket);
            try{
                Thread.sleep(CustomerReturnRate * 1000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
