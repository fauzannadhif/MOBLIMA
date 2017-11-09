import java.util.ArrayList;



public class Movie {

	private String Title;
	private String Status;
	private String Synopsis;
	private String Director;
	private String Type;
	private ArrayList<String> Cast;
	private Float OverallRating;
	private ArrayList<Integer> Rating;
	private ArrayList<String> Review;
	private String AgeRating;
	
	public Movie(String Title){
		this.Title = Title;
		//TODO: FileIO
	}
	
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getSynopsis() {
		return Synopsis;
	}

	public void setSynopsis(String synopsis) {
		Synopsis = synopsis;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public ArrayList<String> getCast() {
		return Cast;
	}

	public void setCast(ArrayList<String> cast) {
		Cast = cast;
	}

	public Float getOverallRating() {
		return OverallRating;
	}

	public ArrayList<Integer> getRating() {
		return Rating;
	}

	public void addRating(Integer newRating) {
		this.Rating.add(newRating);
		this.OverallRating = (OverallRating*(Rating.size()-1)+newRating)/Rating.size();
	}

	public ArrayList<String> getReview() {
		return Review;
	}

	public void addReview(String review) {
		this.Review.add(review);
	}

	public String getAgeRating() {
		return AgeRating;
	}

	public void setAgeRating(String ageRating) {
		AgeRating = ageRating;
	}

}
