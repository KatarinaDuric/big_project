public class Administrator extends User {

    Receptionist receptionist  ;
    Cleaning_Lady cleaning_lady;


    public Administrator(){
        super();
        this.receptionist = new Receptionist();
        this.cleaning_lady = new Cleaning_Lady();
    }

    @Override
    protected int calculateSalary() {
        return (fromQualifiatontoInt(this.qualification)*3+years_of_experience);
    }
}
