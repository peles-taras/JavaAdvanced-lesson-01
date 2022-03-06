package JavaAdvanced_lesson_01.JavaAdvanced_lesson_01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {

	Cinema cin = new Cinema();
	Schedule sched = new Schedule();

	Set<Seance> seances = new TreeSet<>((new SeanceComparator()));
	TreeMap<Days, Schedule> schedules = new TreeMap<>();
	ArrayList<Movie> moviesLibrary = new ArrayList<>();

	@AfterEach
	public void after() {
		seances.clear();
		schedules.clear();
		moviesLibrary.clear();
		cin = new Cinema();
		sched = new Schedule();
	}

	@Test
	@DisplayName("Adding seance test")
	public void AddSeanceTest() {
		assertNotNull(sched.addSeance(new Movie("Title", new Time(15, 30)), new Schedule()));
	}

	@Test
	@DisplayName("Remove seance. enter '1' on console")
	public void removeSeanceTest() {
		seances.add(new Seance(new Movie("1", new Time(1, 30)), new Time(15, 30)));
		sched.removeSeance(seances);
		assertEquals(0, seances.size());
	}

	@Test
	@DisplayName("add movie test")
	public void addMovieTest() {
		cin.addMovie(moviesLibrary);
		assertNotNull(moviesLibrary);
	}

	@Test
	@DisplayName("Remove movie test. Enter 'name' on console")
	public void removeMovieTest() {
		moviesLibrary.add(new Movie("name", new Time(1, 30)));
		cin.removeMovie(moviesLibrary);
		assertEquals(0, moviesLibrary.size());
	}
}
