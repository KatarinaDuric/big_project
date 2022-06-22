public class Administrator extends User {

    Receptionist receptionist = new Receptionist();
    Cleaning_Lady cleaning_lady = new Cleaning_Lady();


    @Override
    protected int calculateSalary() {
        return (fromQualifiatontoInt(this.qualification)*3+years_of_experience);
    }
}
