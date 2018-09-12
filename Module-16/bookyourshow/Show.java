import java.util.Scanner;

public class Show {

    private String movieName;
    private String dateTime;
    private String[] seats;

    public Show() {

    }

    public Show(final String movieName, final String dateTime,
        final String[] seats) {
        this.movieName = movieName;
        this.dateTime = dateTime;
        this.seats = seats;
    }

    public String[] getSeats() {
        return seats;
    }
     
    public void setSeats(String[] seats) {
        this.seats = seats;
    }
     
    public String getDateTime() {
        return dateTime;
    }
     
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
     
    public String getMovieName() {
        return movieName;
    }
     
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String toString() {
        return this.getMovieName() + "," + this.getDateTime();
    }
}
