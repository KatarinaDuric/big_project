import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    protected boolean checkin;

    public boolean isCheckin() {
        return checkin;
    }

    public void setCheckin(boolean checkin) {
        this.checkin = checkin;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    public boolean checkout;
    public boolean isSuccessful;

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public static boolean login() {
        System.out.println("Please enter your username and password in next two lines");
        Scanner sc = new Scanner(System.in);
        Database db = Database.getInstance();
        db.loadData();

        String username = sc.nextLine();
        String password = sc.nextLine();
        boolean isSuccessfull= false;
        for (Guest guest: db.guests) {

            if (username.equals(guest.username) && password.equals(guest.password)) {
                db.loggedUser = guest;
                isSuccessfull = true;
            }
        }
        for (Administrator administrator: db.administrators) {
            System.out.println("-------------");
            System.out.println(username);
            System.out.println(administrator.username);
            System.out.println(username.equals(administrator.username));
            System.out.println("-------------");
            System.out.println(password);
            System.out.println(administrator.password);
            System.out.println(password.equals(administrator.password));
            System.out.println("-------------");
            if (username.equals(administrator.username) && password.equals(administrator.password)) {
                db.loggedUser = administrator;
                isSuccessfull = true;

            }
        }
        for (Receptionist receptionist: db.receptionists) {
            if (username.equals(receptionist.username) && password.equals(receptionist.password)) {
                db.loggedUser = receptionist;
                isSuccessfull = true;

            }
        }
        System.out.println("login finished");
       return isSuccessfull;
    }

    public void showMenu(){
        Database db =  Database.getInstance();
        Scanner sc = new Scanner(System.in);
        if(db.loggedUser instanceof  Administrator){
            System.out.println("Would you like to create a new user?" + "\n" + "For signing in a receptionist press '(1)' and for singing in an administrator press '(2)'\n");
            String choice = sc.nextLine();
            if (choice.equals("1"))
                createReceptionist();
            if (choice.equals("2"))
                createAdmins();
            //ispisujes nmeni za admina
        }
        if(db.loggedUser instanceof  Receptionist){
            System.out.println("Creating a new guest.");
            createGuest();
        }
        if(db.loggedUser instanceof  Guest){
            String choice = sc.nextLine();
            System.out.println("Would you like to make a reservation request or withdraw a reservation?\n" "Type 'request', 'withdrawal', 'list_all' or 'no' for exiting the programme.");
            if (choice.equals("request")) {
                createReservation();
            }
            if(choice.equals("list_all")){
                for(Reservation reservation: db.reservations){
                    if(reservation.getcustomerUsername().equals(db.loggedUser.getUsername())){
                        db.saveReservations();
                    }
                }
            }
            if (choice.equals("withdrawal")) {
                System.out.println("Input id of reservation");
                int id =  Integer.parseInt(sc.nextLine());
                for(Reservation reservation:db.reservations){
                    if(id==reservation.getId()){
                        reservation.setReservation_status(Reservation_Status.DECLINED);
                    }
                }
                db.saveData();
            }
            if (choice.equals("no")) {
            }
        }

    }

    public static void createReceptionist() {
        Database db = Database.getInstance();
        Scanner sc = new Scanner(System.in);
        Receptionist receptionist = new Receptionist();
        System.out.println("Enter name:");
        receptionist.setName(sc.nextLine());
        System.out.println("Enter surname:");
        receptionist.setSurname(sc.nextLine());
        System.out.println("Enter sex:");
        receptionist.setSex(sc.nextLine());
        System.out.println("Enter date of birth:");
        receptionist.setDate_of_birth(sc.nextLine());
        System.out.println("Enter phone number");
        receptionist.setPhone_number(sc.nextLine());
        System.out.println("Enter address:");
        receptionist.setAddress(sc.nextLine());
        System.out.println("Enter username:");
        receptionist.setUsername(sc.nextLine());
        System.out.println("Enter password:");
        receptionist.setPassword(sc.nextLine());
        System.out.println("Enter qualification:");
        receptionist.setQualification(Qualification.valueOf(sc.nextLine()));
        System.out.println("Enter years of experience");
        receptionist.setYears_of_experience(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter salary");
        receptionist.setSalary(Integer.parseInt(sc.nextLine()));
        db.receptionists.add(receptionist);
        db.saveData();
    }
    public static void createAdmins() {
        Database db =  Database.getInstance();
        Scanner sc = new Scanner(System.in);
        Administrator administrator = new Administrator();
        System.out.println("Enter name:");
        administrator.setName(sc.nextLine());
        System.out.println("Enter surname:");
        administrator.setSurname(sc.nextLine());
        System.out.println("Enter sex:");
        administrator.setSex(sc.nextLine());
        System.out.println("Enter date of birth:");
        administrator.setDate_of_birth(sc.nextLine());
        System.out.println("Enter phone number");
        administrator.setPhone_number(sc.nextLine());
        System.out.println("Enter address:");
        administrator.setAddress(sc.nextLine());
        System.out.println("Enter username:");
        administrator.setUsername(sc.nextLine());
        System.out.println("Enter password:");
        administrator.setPassword(sc.nextLine());
        System.out.println("Enter qualification:");
        administrator.setQualification(Qualification.valueOf(sc.nextLine()));
        System.out.println("Enter years of experience");
        administrator.setYears_of_experience(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter salary");
        administrator.setSalary(Integer.parseInt(sc.nextLine()));
        db.administrators.add(administrator);
        db.saveData();
    }
    public static void createGuest() {
        Database db = Database.getInstance();
        Scanner sc = new Scanner(System.in);
        Guest guest = new Guest();
        System.out.println("Enter name:");
        guest.setName(sc.nextLine());
        System.out.println("Enter surname:");
        guest.setSurname(sc.nextLine());
        System.out.println("Enter sex:");
        guest.setSex(sc.nextLine());
        System.out.println("Enter date of birth:");
        guest.setDate_of_birth(sc.nextLine());
        System.out.println("Enter phone number");
        guest.setPhone_number(sc.nextLine());
        System.out.println("Enter address:");
        guest.setAddress(sc.nextLine());
        System.out.println("Enter email:");
        guest.setEmail(sc.nextLine());
        System.out.println("Enter passport number:");
        guest.setPassport_number(sc.nextLine());
        System.out.println("Enter qualification:");
        guest.setQualification(Qualification.valueOf(sc.nextLine()));
        System.out.println("Enter years of experience");
        guest.setYears_of_experience(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter salary");
        guest.setSalary(Integer.parseInt(sc.nextLine()));
        db.guests.add(guest);
        db.saveData();
    }

    public static void createReservation() {
        Database db = Database.getInstance();
        String username =  db.loggedUser.getUsername();
        Reservation reservation  = new Reservation();
        reservation.setReservation_status(Reservation_Status.ON_HOLD);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id:");
        reservation.setId(Integer.parseInt(sc.nextLine()));
        reservation.setcustomerUsername(username);
        System.out.println("Enter check-in day:");
        reservation.setCheckInDay(LocalDate.parse(sc.nextLine()));
        System.out.println("Enter check-out day:");
        reservation.setCheckOutDay(LocalDate.parse(sc.nextLine()));
        db.reservations.add(reservation);
        db.saveData();
    }


}
