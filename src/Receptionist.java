import java.util.Scanner;

public class Receptionist extends User {

    Scanner sc = new Scanner(System.in);
    Guest guest = new Guest();

    public int calculateSalary() {
        return (fromQualifiatontoInt(this.qualification)*5+years_of_experience);


    }




}
