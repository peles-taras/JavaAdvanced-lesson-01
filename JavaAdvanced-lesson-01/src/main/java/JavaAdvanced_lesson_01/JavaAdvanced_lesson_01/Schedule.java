package JavaAdvanced_lesson_01.JavaAdvanced_lesson_01;

import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {

	Set<Seance> seances = new TreeSet<>((new SeanceComparator()));
	Scanner sc = new Scanner(System.in);

	public Schedule addSeance(Movie movie, Schedule schedule) {
		System.out.println("Enter seance start time(hour). Working hours 09:00 - 22:00");
		int startTimeHour = sc.nextInt();
		System.out.println("Enter seance start time(min)");
		int startTimeMin = sc.nextInt();
		if (startTimeHour > 21 || startTimeHour < 9) {
			System.out.println("Error. Working hours 09:00 - 22:00");
			System.exit(0);
		} else if (startTimeMin > 59) {
			System.out.println("Error. Wrong time(min) format");
			System.exit(0);
		} else {
			seances.add(new Seance(movie, new Time(startTimeHour, startTimeMin)));
			System.out.println("Seance added.");
			return schedule;
		}
		return null;

	}

	public void removeSeance(Set<Seance> seances) {
		System.out.println("Enter movie name to remove from seances (Enter '1' on console for JUNIT test)");
		showSeance();
		String movieName = sc.next();
		Optional<Seance> findFirst = seances.stream().filter(s -> s.getMovie().getTitle().equalsIgnoreCase(movieName))
				.findFirst();
		if (findFirst.isPresent()) {
			seances.remove(findFirst.get());
			System.out.println("Seance with movie " + movieName + " - removed");
		}

		else {
			System.out.println("Error");
		}

	}

	public void showSeance() {
		for (Seance seance : seances) {
			System.out.println(seance);
		}
	}

	@Override
	public String toString() {
		return " - " + seances + "";
	}
}

class SeanceComparator implements Comparator<Seance> {
	@Override
	public int compare(Seance o1, Seance o2) {
		return o1.movie.getTitle().compareTo(o2.getMovie().getTitle());
	}
}
