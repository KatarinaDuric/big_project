import java.util.ArrayList;

class Database {
    private static Database s = null;
    ArrayList<Guest> guests = new ArrayList<Guest>();
    ArrayList<Administrator> admins = new ArrayList<Administrator>();
    ArrayList<Receptionist> receptionists = new ArrayList<Receptionist>();

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


    public  void loadAdmins(){
        Administrator administrator = new Administrator();
        //TODO dopunitti znaci splitovati i popuniti informacije u projektu
        this.admins.add(administrator);
    }

    public  void loadGuests(){

    }

    public  void loadReceptionists(){

    }


}