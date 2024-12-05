import java.math.BigDecimal;

public class Vendor implements Runnable {
    private int Totaltickets;
    private int TicketRetrivelRate;
    private Ticketpool ticketpool;

    public Vendor(int Totaltickets, int TicketRetrivelRate, Ticketpool ticketpool) {
        this.Totaltickets = Totaltickets;
        this.TicketRetrivelRate = TicketRetrivelRate;
        this.ticketpool = ticketpool;
    }
    @Override
    public void run() {
        for(int i = 1; i < Totaltickets; i++) {
            Ticket ticket = new Ticket(i,"Event", new BigDecimal(1000));
            ticketpool.addTicket(ticket);
            try{
                Thread.sleep(TicketRetrivelRate * 1000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
