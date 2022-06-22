public class Cleaning_Lady extends User{



    public int calculateSalary() {
        return (fromQualifiatontoInt(this.qualification)* 7 + years_of_experience);
    }
}
