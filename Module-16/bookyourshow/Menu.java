public class Menu {
  public static void main(String[] args) {
    BookYourShow book = new BookYourShow();

    String movieName = "Mission Impossible";
    String datetime = "Aug 18, 2015 17:30";
    String[] seats = {"A1","A2","A3","B1","B2","B3","C1","C2"};
    
    Show show = new Show(movieName, datetime, seats);
    book.addAShow(show);
    //System.out.println(show);

    movieName = "Mission Impossible";
    datetime = "Aug 18, 2015 10:30";
    show = new Show(movieName, datetime, seats);
    book.addAShow(show);

    movieName = "Inside Out";
    datetime = "Aug 18, 2015 15:30";
    show = new Show(movieName, datetime, seats);
    book.addAShow(show);

    Show result = book.getAShow("Mission Impossible", "Aug 18, 2015 17:30");
    if(result == null)
      System.out.println("No shows available!");
    else
      System.out.println(result);

    Patron p = new Patron("Praveen", "9989968765");
    String[] s = {"B1", "B2"};
    result.bookAShow(p, s);

    Patron r = new Patron("Varshini", "888888888");
    result.bookAShow(r, s);

    result.printTickets(p);
    result.printTickets(r);
    
    //book.printShows();
  }
}