package JavaAdvanced_lesson_01.JavaAdvanced_lesson_01;

public class Movie {
	private String title;
	Time Duration;

	public Movie(String title, Time duration) {
		super();
		this.title = title;
		Duration = duration;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "" + title + ", duration- " + Duration + "";
	}

}
