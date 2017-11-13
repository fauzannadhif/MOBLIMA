package com.moblima.movie;

public class TicketPrice {
	private Boolean isHoliday;
	private int Age;
	private String MovieType;
	private String CinemaClass;
	private Double Price;
	private static Double[] Modifier={4.0,2.0,2.0,2.0,2.0,2.0,2.0};
	public TicketPrice(Boolean isHoliday,int Age,String MovieType,String CinemaClass){
		this.isHoliday=isHoliday;
		this.Age=Age;
		this.MovieType=MovieType;
		this.CinemaClass=CinemaClass;
		this.Price=Modifier[0];
		if (isHoliday)
			Price+=Modifier[1];
		if (Age<6)
			Price -= Modifier[2];
		if (Age>55)
			Price += Modifier[3];
		if (CinemaClass=="PREMIUM")
			Price+= Modifier[4];
		if (MovieType=="3D MOVIE")
			Price+= Modifier[5];
		if (MovieType=="Blockbuster")
			Price+= Modifier[6];
	}
	
	public Boolean getIsHoliday() {
		return isHoliday;
	}
	public void setIsHoliday(Boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getMovieType() {
		return MovieType;
	}
	public void setMovieType(String movieType) {
		MovieType = movieType;
	}
	public String getCinemaClass() {
		return CinemaClass;
	}
	public void setCinemaClass(String cinemaClass) {
		CinemaClass = cinemaClass;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public static void setModifier(Double[] Modifier){
		if (Modifier.length != 7){
			return;
		}
		TicketPrice.Modifier = Modifier;
	}
	public static Double[] getModifier(){
		return TicketPrice.Modifier;
	}
	
}
