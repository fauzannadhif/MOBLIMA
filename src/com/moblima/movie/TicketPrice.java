package com.moblima.movie;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.Scanner;

public class TicketPrice {
	private static String separator1 = "|";
	private static ArrayList<GregorianCalendar> HolidayDate;
	private Double[] Modifier;
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
	
	public Double getPrice(GregorianCalendar date, int age, String cinemaclass, String movietype) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyymmdd");
		fmt.setCalendar(date);
		Double Price = Modifier[0];
		if (HolidayDate.contains(date))
			Price+=Modifier[1];
		if (age<6)
			Price -= Modifier[2];
		if (age>55)
			Price += Modifier[3];
		if (cinemaclass=="PREMIUM")
			Price+= Modifier[4];
		if (movietype=="3D MOVIE")
			Price+= Modifier[5];
		if (movietype=="Blockbuster")
			Price+= Modifier[6];
		return Price;
	}

	public void setModifier(Double[] Modifier) {
		this.Modifier = Modifier;
	}
	public Double[] getModifier() {
		return this.Modifier;
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
