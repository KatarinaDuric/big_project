
public class Main {

    public static void main(String[] args) {
        //login menu
        //Loading data on the beginning
        Database db = Database.getInstance();
        Service service =  new Service();
        boolean successful = service.login();
        if (successful) {
            service.showMenu();
        }
        db.loadData();


    }

}