package myquiz;

public class User {
    String ID;
    String firstName;
    String lastName;
    String email;
    boolean isHost;


    public User(String ID, String firstName, String lastName, String email, boolean isHost) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isHost = isHost;
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isHost() {
        return isHost;
    }

    @Override
    public String toString() {
        return "Welcome to the quiz app! \n" + firstName +" " + lastName + "\n" + email;
        }

}






