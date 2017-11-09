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
	
}
