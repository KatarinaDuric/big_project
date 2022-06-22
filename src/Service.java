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

    public void login() {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = sc.nextLine();
//        if (String(inputUsername) == user && String(inputPassword) == password) {
//            System.out.println("You have logged in.");
//        } else {
//            System.out.println("Error.");
//        }


    }
}
