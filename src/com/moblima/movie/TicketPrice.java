package com.moblima.movie;

import java.util.GregorianCalendar;
import java.util.ArrayList;

public class TicketPrice {
	private GregorianCalendar Date;
	private static ArrayList<GregorianCalendar> HolidayDate;
	private int Age;
	private String MovieType;
	private String CinemaClass;
	private Double Price;
	private static Double[] Modifier={4.0,2.0,2.0,2.0,2.0,2.0,2.0};
	public TicketPrice(GregorianCalendar Date,int Age,String MovieType,String CinemaClass){
		this.Date=Date;
		this.Age=Age;
		this.MovieType=MovieType;
		this.CinemaClass=CinemaClass;
		this.Price=Modifier[0];
		if (HolidayDate.contains(Date))
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
	public static void setModifier(Double[] Modifier) {
		if (Modifier.length != 7){
			return;
		}
		TicketPrice.Modifier = Modifier;
	}
	public static Double[] getModifier() {
		return TicketPrice.Modifier;
	}
	public void setDate(GregorianCalendar Date) {
		this.Date = Date;
	}
	public GregorianCalendar getDate() {
		return this.Date;
	}
	public static void setHolidayDate(ArrayList<GregorianCalendar> HolidayDate) {
		TicketPrice.HolidayDate = HolidayDate;
	}
	public static ArrayList<GregorianCalendar> getHolidayDate() {
		return TicketPrice.HolidayDate;
	}
	public static void addHolidayDate(GregorianCalendar addedHolidayDate){
		TicketPrice.HolidayDate.add(addedHolidayDate);
	}
	
}
