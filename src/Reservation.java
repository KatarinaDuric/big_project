import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;


public class Reservation {
    private String customerUsername;
    
    private int id;
    private Reservation_Status reservation_status;

    public String getcustomerUsername() {
        return customerUsername;
    }

    public void setcustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public Reservation_Status getReservation_status() {
        return reservation_status;
    }

    public void setReservation_status(Reservation_Status reservation_status) {
        this.reservation_status = reservation_status;
    }

    public LocalDate getCheckInDay() {
        return checkInDay;
    }

    public void setCheckInDay(LocalDate checkInDay) {
        this.checkInDay = checkInDay;
    }

    public LocalDate getCheckOutDay() {
        return checkOutDay;
    }

    public void setCheckOutDay(LocalDate checkOutDay) {
        this.checkOutDay = checkOutDay;
    }

    private LocalDate checkInDay;
    private LocalDate checkOutDay;

    public Reservation() {
    }

    public Reservation(int event_number, String customerUsername, LocalDate day) {
        this.customerUsername = customerUsername;
        this.checkOutDay = checkOutDay;
        this.checkInDay = checkInDay;
    }
    public void readingTheInput() {
        Scanner sc = new Scanner(System.in);
        customerUsername = sc.nextLine();
        sc.useDelimiter("/");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int dayinmonth = sc.nextInt();
        this.checkInDay = LocalDate.of(dayinmonth, month, year);
        this.checkOutDay = LocalDate.of(dayinmonth, month, year);
    }

    public int compareReservation() {
        Reservation reservation1 = new Reservation();
        if (checkInDay.isBefore(reservation1.checkInDay) &&) {

        }
    }

    public void writingOut() {
        PrintWriter output = new PrintWriter();
        output

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}