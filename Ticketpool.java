import java.util.LinkedList;
import java.util.Queue;

public class Ticketpool {
    private int maxTicketCapacity;
    private Queue<Ticket> tickets;
    public Ticketpool(int maxTicketCapacity){
        this.maxTicketCapacity = maxTicketCapacity;
        tickets = new LinkedList<Ticket>();
    }
    public synchronized void addTicket(Ticket ticket){
        while (tickets.size() > maxTicketCapacity){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
        this.tickets.add(ticket);
        notifyAll();
        System.out.println("Ticket added by"+ Thread.currentThread().getName() +"current size is " + tickets.size());
    }
    public synchronized Ticket getTicket(){
        while(!tickets.isEmpty()){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Ticket ticket = tickets.poll();
        notifyAll();
        System.out.println("Ticket bought by"+ Thread.currentThread().getName() +" current size is " + tickets.size());
        return ticket;
    }
}
