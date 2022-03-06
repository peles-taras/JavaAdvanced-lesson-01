package JavaAdvanced_lesson_01.JavaAdvanced_lesson_01;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

public class Cinema {

	TreeMap<Days, Schedule> schedules = new TreeMap<>();
	ArrayList<Movie> moviesLibrary = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	Schedule s = new Schedule();

	public void addMovie(ArrayList<Movie> moviesLibrary) {
		System.out.println("Enter movie name");
		String movieName = sc.next();
		System.out.println("Enter movie duration(hour)");
		int movieDurationHour = sc.nextInt();
		System.out.println("Enter movie duration(min)");
		int movieDurationMin = sc.nextInt();
		if (movieDurationMin > 59) {
			System.out.println("Error. Wrong time(min) format");

		} else if (movieDurationHour > 23) {
			System.out.println("Error. Wrong time(hour) format");
		} else {
			moviesLibrary.add(new Movie(movieName, new Time(movieDurationHour, movieDurationMin)));
			System.out.println("Movie  " + movieName + " - added to library");
		}
	}

	public void showMovies() {
		int count = 1;
		if (moviesLibrary.size() == 0) {
			System.out.println("Movie library is empty");
		} else {
			for (Movie movie : moviesLibrary) {
				System.out.println("Movie " + count++ + ": " + movie);
			}
		}
	}

	public void removeMovie(ArrayList<Movie> moviesLibrary) {
		System.out.println("List of movies available to remove (Enter 'name' on console for JUNIT test)");
//		showMovies();
		String movieName = sc.next();
		Optional<Movie> findFirst = moviesLibrary.stream().filter(m -> m.getTitle().equalsIgnoreCase(movieName))
				.findFirst();
		if (findFirst.isPresent()) {
			moviesLibrary.remove(findFirst.get());
			schedules.values()
					.forEach(s -> s.seances.removeIf(seance -> seance.movie.getTitle().equalsIgnoreCase(movieName)));
			System.out.println("Movie " + movieName + " - removed");
		} else {
			System.out.println("Error");
		}
	}

	public void addSeance() {
		System.out.println("Cinema works from 9:00 to 22:00");
		System.out.println("Enter day of the week (Monday, Tuesday, etc.)");
		String dayOFW = sc.next();
		if (Days.valueOf(dayOFW.toUpperCase()) != null) {
			Days valueOf = Days.valueOf(dayOFW.toUpperCase());
			System.out.println("Movies available:");
			showMovies();
			String movieName = sc.next();
			Optional<Movie> findFirst = moviesLibrary.stream().filter(m -> m.getTitle().equalsIgnoreCase(movieName))
					.findFirst();
			if (findFirst.isPresent()) {
				int indexOf = moviesLibrary.indexOf(findFirst.get());
				schedules.put(valueOf, s.addSeance(moviesLibrary.get(indexOf), s));
			}
		} else {
			System.out.println("Error");
		}
	}

	public void showSeances() {
		int count = 1;
		if (schedules.size() < 1) {
			System.out.println("No seances available");
			System.exit(0);
		} else {
			for (Entry<Days, Schedule> entry : schedules.entrySet()) {
				Days key = entry.getKey();
				Schedule val = entry.getValue();
				if (val != null) {
					System.out.println(count + ". " + key + val + "");
					count++;
				}
			}
		}
	}

	public void removeSeance() {
		showSeances();
		System.out.println("Enter seance duration(hour) to remove");
		int time = sc.nextInt();
		System.out.println("Enter seance duration(min) to remove");
		int min = sc.nextInt();
		schedules.values().forEach(
				v -> v.seances.removeIf(t -> t.getStartTime().getHour() == time && t.getStartTime().getMin() == min));
		System.out.println("Seance with duration " + time + ":" + min + " - removed");
	}

	@Override
	public String toString() {
		return "Cinema schedules=" + schedules + ", moviesLibrary=" + moviesLibrary + "";
	}

}
