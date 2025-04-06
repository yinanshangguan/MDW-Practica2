package usantatecla.movies.v23;

public class MovieBuilder {

	private String title;

	private Movie movie;

	
	public MovieBuilder() {
		title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}

	public MovieBuilder childrens() {
		this.movie = new ChildrenPrice(this.title);
		return this;
	}

	public MovieBuilder regular() {
		this.movie = new RegularPrice(this.title);
		return this;
	}

	public MovieBuilder newRelease() {
		this.movie = new NewReleasePrice(this.title);
		return this;
	}

	public Movie build() {
		return this.movie;
	}
}
