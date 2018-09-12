import java.util.Scanner;

public class Patron {

    private String userName;
    private String mobileNumber;

    public Patron() {
        
    }

    public Patron(final String userName, final String mobileNumber) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
     
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
     
    public String getUserName() {
        return userName;
    }
     
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String toString() {
        return this.getUserName() + " : " + this.getMobileNumber();
    }
}
