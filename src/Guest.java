public class Guest extends User{
    protected String email;
    protected String passport_number;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    @Override
    protected int calculateSalary() {
        return 0;
    }
}
