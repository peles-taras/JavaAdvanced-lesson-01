package JavaAdvanced_lesson_01.JavaAdvanced_lesson_01;

import java.text.ParseException;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Cinema cinema = new Cinema();

		while (true) {
			menu();
			switch (sc.next()) {
			case "1":
				cinema.addMovie(cinema.moviesLibrary);
				break;
			case "2":
				cinema.showMovies();
				break;
			case "3":
				cinema.removeMovie(cinema.moviesLibrary);
				break;
			case "4":
				cinema.addSeance();
				break;
			case "5":
				cinema.showSeances();
				break;
			case "6":
				cinema.removeSeance();
				break;
			case "7":
				System.out.println("Shutting down program.");
				System.exit(0);
				break;
			default:
				break;

			}
		}
	}

	public static void menu() {
		System.out.println("1 - add movie");
		System.out.println("2 - show all movies");
		System.out.println("3 - remove movie");
		System.out.println("4 - add seance");
		System.out.println("5 - show seances");
		System.out.println("6 - remove seance");
		System.out.println("7 - exit program");
	}
}
