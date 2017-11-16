package com.moblima.movie;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.Scanner;

public class TicketPrice {
	private static String separator1 = "|";
	private GregorianCalendar DateShown;
	private static ArrayList<GregorianCalendar> HolidayDate;
	private int Age;
	private String MovieType;
	private String CinemaClass;
	private Double Price;
	private Double[] Modifier;
	GregorianCalendar DateComparator = new GregorianCalendar(this.DateShown.YEAR, this.DateShown.DAY_OF_MONTH, this.DateShown.YEAR);
	public TicketPrice(){
		try {
			File DatabaseFile = new File("../../../../data/ShowTimeList.txt");
            this.Modifier = readModifiers(DatabaseFile);
		} catch (Exception e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}

	public Double[] readModifiers(File DatabaseFile) throws IOException{
		ArrayList<String> StringArray = read(DatabaseFile);
		String st = StringArray.get(0);
		StringTokenizer star = new StringTokenizer(st, separator1); 
		Double BasePrice = Double.valueOf(star.nextToken().trim());
		Double HolidayPrice = Double.valueOf(star.nextToken().trim());
		Double ChildrenPrice = Double.valueOf(star.nextToken().trim());
		Double SeniorCitizenPrice = Double.valueOf(star.nextToken().trim());
		Double PremiumCinemaPrice = Double.valueOf(star.nextToken().trim());
		Double Price3DMovie = Double.valueOf(star.nextToken().trim());
		Double BlockBusterMoviePrice = Double.valueOf(star.nextToken().trim());
		Double[] modifiers = {BasePrice, HolidayPrice, ChildrenPrice, SeniorCitizenPrice, PremiumCinemaPrice, Price3DMovie, BlockBusterMoviePrice};
		return modifiers;
	}

	public static ArrayList<String> read(File DatabaseFile) throws IOException{
        ArrayList<String> data = new ArrayList<String>();
        Scanner sc = new Scanner(new FileInputStream(DatabaseFile));
        try {
            while (sc.hasNextLine()){
                data.add(sc.nextLine());
            }
        }
        finally {
            sc.close();
        }
        return data;
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
		Price = Modifier[0];
		if (HolidayDate.contains(DateComparator))
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
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public void setModifier(Double[] Modifier) {
		this.Modifier = Modifier;
	}
	public Double[] getModifier() {
		return this.Modifier;
	}
	public void setDate(GregorianCalendar DateShown) {
		this.DateShown = DateShown;
	}
	public GregorianCalendar getDate() {
		return this.DateShown;
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
	public static void removeHolidayDate(GregorianCalendar removedHolidayDate){
		TicketPrice.HolidayDate.remove(removedHolidayDate);
	}
	
}
