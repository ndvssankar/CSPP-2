
public class BookYourShow {

	private List<Show> shows;
	private List<String> tickets;

	public BookYourShow() {
		shows = new List<Show>();
		tickets = new List<String>();
	}

	public void addAShow(Show show) {
		shows.add(show);
	}

	public void bookAShow(
		final String movieName,
		final String dateTime,
		final Patron patron,
		final String[] seats) {

		Show show = getAShow(movieName, dateTime);
		if (show == null) {
			System.out.println("No show");
		} else {
			String[] showSeats = show.getSeats();
			for (int i=0; i<showSeats.length; i++) {
				for (int j=0; j<seats.length; j++) {
					if (seats[j].equals(showSeats[i])) {
						showSeats[i] = "N/A";
					}
				}
			}
			StringBuffer sb = new StringBuffer();
			sb.append(patron.getMobileNumber() + " ");
			sb.append(movieName + " ");
			sb.append(dateTime);
			tickets.add(sb.toString());
		}
	}

	public void printTicket(
		final String movieName,
		final String dateTime,
		final String mobileNumber) {
		String ticket = mobileNumber + " " + movieName + " " + dateTime;
		if (tickets.contains(ticket)) {
			System.out.println(ticket);
			return;
		}
		System.out.println("Invalid");
	}

	public Show getAShow(
		final String movieName,
		final String dateTime) {

		for (int i=0; i<shows.size(); i++) {
			Show show = shows.get(i);
			if (show.getMovieName().equals(movieName) && show.getDateTime().equals(dateTime)) {
				return show;
			}
		}
		return null;
	}

	public void showAll() {
		for(int i=0; i<shows.size(); i++) {
			StringBuffer sb = new StringBuffer();
			Show show = shows.get(i);
			sb.append(show + ",[");
			String[] seats = show.getSeats();
			for (int j = 0; j < seats.length-1; j++) {
				sb.append(seats[j] + ",");
			}
			sb.append(seats[seats.length-1] + "]");
			System.out.println(sb.toString());
		}
	}
}

