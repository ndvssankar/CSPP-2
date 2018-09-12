import java.util.Scanner;

public class BookYourShow extends Show {

    private List<Show> shows;
    private List<String> tickets;

    public BookYourShow() {
        shows = new List<Show>();
        tickets = new List<String>();
    }

    public void addAShow(final Show show) {
        shows.add(show);
    }

    public Show getAShow(final String movieName,
                         final String dateTime) {
        for (int i = 0; i < shows.size(); i++) {
            if (movieName.equals(shows.get(i).getMovieName()) &&
                    dateTime.equals(shows.get(i).getDateTime())) {
                return shows.get(i);
            }
        }
        return null;
    }

    public void bookAShow(
        final String movieName,
        final String dateTime,
        final Patron patron,
        final String[] seats) {
        Show show = getAShow(movieName, dateTime);
        StringBuffer sb = new StringBuffer();
        if (show != null) {
            int count = 0;
            String[] showSeats = show.getSeats();
            for (int j=0; j<seats.length; j++) {
                for (int i=0; i<showSeats.length; i++) {
                    if (showSeats[i] != null && seats[j].equals(showSeats[i])) {
                        count += 1;
                        showSeats[i] = null;
                    }
                }
            }
            if(count != 0) {
                sb.append(patron.getMobileNumber() + " ");
                sb.append(movieName + " ");
                sb.append(dateTime);
                tickets.add(sb.toString());
                // System.out.println("Ticket : " + sb.toString());
            }
        }
    }

    public void printTicket(
        final String movieName,
        final String dateTime,
        final String mobileNumber) {
        String thisTicket = mobileNumber + " " + movieName + " " + dateTime;
        for (int i = 0; i < tickets.size(); i++) {
            // System.out.println("Ticket : " + tickets.get(i) + "This ticket " + thisTicket);
            if (tickets.get(i).equals(thisTicket)) {
                System.out.println(tickets.get(i));
            }
        }
    }

    public void showAll() {
        for (int i = 0; i<shows.size(); i++) {
            System.out.println(shows.get(i));
        }
    }
}