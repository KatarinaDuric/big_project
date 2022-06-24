import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

class Database {
    private static Database s = null;
    public ArrayList<Guest> guests = new ArrayList<Guest>();
    public ArrayList<Administrator> administrators = new ArrayList<Administrator>();
    public ArrayList<Receptionist> receptionists = new ArrayList<Receptionist>();

    public ArrayList<Reservation> reservations =  new ArrayList<>();

    public User loggedUser;


    private Database() {

    }

    public static Database getInstance() {
        if (s==null) {
            s = new Database();
            return s;
        } else {
            return s;
        }
    }

    public  void loadData(){
        loadAdmins();
        loadGuests();
        loadReceptionists();
    }




    public  void loadAdmins() {
        Administrator administrator = new Administrator();
        try {
            Scanner scanner = new Scanner(new File(".\\src\\files\\admins.txt"));
            //TODO dopunitti znaci splitovati i popuniti informacije u projektu
            while (scanner.hasNextLine()) {
                String object = scanner.nextLine();
                String[] administrators = object.strip().split(",");
                administrator.setName(administrators[0]);
                administrator.setSurname(administrators[1]);
                administrator.setSex(administrators[2]);
                administrator.setDate_of_birth(administrators[3]);
                administrator.setPhone_number(administrators[4]);
                administrator.setAddress(administrators[5]);
                administrator.setUsername(administrators[6]);
                administrator.setPassword(administrators[7]);
                administrator.setQualification(Qualification.valueOf(administrators[8]));
                administrator.setYears_of_experience(Integer.parseInt(administrators[9]));
                administrator.setSalary(Integer.parseInt(administrators[10]));
                this.administrators.add(administrator);
            }
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error while reading file.");
        }
    }

        public  void loadGuests() {
            Guest guest = new Guest();
            try {
                Scanner scanner = new Scanner(new File(".\\src\\files\\guests.txt"));
                while (scanner.hasNextLine()) {
                    String object2 = scanner.nextLine();
                    String[] guests = object2.strip().split(",");
                    guest.setName(guests[0]);
                    guest.setSurname(guests[1]);
                    guest.setSex(guests[2]);
                    guest.setDate_of_birth(guests[3]);
                    guest.setPhone_number(guests[4]);
                    guest.setAddress(guests[5]);
                    guest.setEmail(guests[6]);
                    guest.setPassport_number(guests[7]);
                    guest.setQualification(Qualification.valueOf(guests[8]));
                    guest.setYears_of_experience(Integer.parseInt(guests[9]));
                    guest.setSalary(Integer.parseInt(guests[10]));
                    this.guests.add(guest);
                }
            }catch (Exception e){
                e.printStackTrace();
                    System.out.println("Error while reading file.");
            }
    }
    public  void loadReceptionists() {
            Receptionist receptionist = new Receptionist();
            try {
                Scanner scanner = new Scanner(new File(".\\src\\files\\receptionists.txt"));
                while (scanner.hasNextLine()) {
                    String object3 = scanner.nextLine();
                    String[] receptionists = object3.strip().split(",");
                    receptionist.setName(receptionists[0]);
                    receptionist.setSurname(receptionists[1]);
                    receptionist.setSex(receptionists[2]);
                    receptionist.setDate_of_birth(receptionists[3]);
                    receptionist.setPhone_number(receptionists[4]);
                    receptionist.setAddress(receptionists[5]);
                    receptionist.setUsername(receptionists[6]);
                    receptionist.setPassword(receptionists[7]);
                    receptionist.setQualification(Qualification.valueOf(receptionists[8]));
                    receptionist.setYears_of_experience(Integer.parseInt(receptionists[9]));
                    receptionist.setSalary(Integer.parseInt(receptionists[10]));
                    this.receptionists.add(receptionist);
                }
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Error while reading file.");
            }
    }

    public void savePeopleToFile(){
        String guestsToSave = "";
        String adminsToSave = "";
        String receptionistsToSave = "";
        for(Guest guest: guests) {
            guestsToSave += guest.getName() + "," + guest.getSurname() + "," + guest.getSex() + "," + guest.getDate_of_birth() + "," +
                        guest.getPhone_number() + "," + guest.getAddress() + "," + guest.getEmail() + "," + guest.getPassport_number() + "," +
                        guest.getQualification() + "," + guest.getYears_of_experience() + "," + guest.getSalary() + "\n";
            }
        for(Receptionist receptionist: receptionists) {
            receptionistsToSave += receptionist.getName() + "," + receptionist.getSurname() + "," + receptionist.getSex() + "," + receptionist.getDate_of_birth() + "," +
                    receptionist.getPhone_number() + "," + receptionist.getAddress() + "," + receptionist.getUsername() + "," + receptionist.getPassword() + "," +
                    receptionist.getQualification() + "," + receptionist.getYears_of_experience() + "," + receptionist.getSalary() + "\n";
        }
        for(Administrator administrator: administrators) {
            adminsToSave += administrator.getName() + "," + administrator.getSurname() + "," + administrator.getSex() + "," + administrator.getDate_of_birth() + "," +
                    administrator.getPhone_number() + "," + administrator.getAddress() + "," + administrator.getUsername() + "," + administrator.getPassword() + "," +
                    administrator.getQualification() + "," + administrator.getYears_of_experience() + "," + administrator.getSalary() + "\n";
        }

        try {
            Path path
                    = Paths.get(".\\src\\files\\guests.txt");
            Files.writeString(path, guestsToSave,
                    StandardCharsets.UTF_8);
            path  = Paths.get(".\\src\\files\\admins.txt");
            Files.writeString(path, adminsToSave,
                    StandardCharsets.UTF_8);
            path =   Paths.get(".\\src\\files\\receptionists.txt");
                    Files.writeString(path, receptionistsToSave,
                    StandardCharsets.UTF_8);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.print("Invalid Path");
        }
    }

    public void saveReservations() {
        Database db = new Database();
        String reservationsToSave = "";
        for(Reservation reservation: db.reservations) {
            reservationsToSave += reservation.getId() + "," + reservation.getcustomerUsername() + "," + reservation.getCheckInDay() + "," + reservation.getCheckOutDay() + "\n";
            try {
                Path path
                        = Paths.get(".\\src\\files\\reservations.txt");
                Files.writeString(path, reservationsToSave,
                        StandardCharsets.UTF_8);
            }
            catch (IOException ex) {
                ex.printStackTrace();
                System.out.print("Invalid Path");
            }
        }
    }

    public void saveData() {
        savePeopleToFile();
        saveReservations();

    }
}