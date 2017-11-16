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
	private ArrayList<String> HolidayDate;
	private Double[] Modifier;
	public TicketPrice(){
		try {
			File DatabaseFile = new File("../../../../data/Modifiers.txt");
            this.Modifier = readModifiers(DatabaseFile);
		} catch (Exception e) {
			System.out.println("IOException > " + e.getMessage());
		}

		try {
			File DatabaseFile = new File("../../../../data/HolidayDate.txt");
			this.HolidayDate = readHolidayDates(DatabaseFile);
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

	public ArrayList<String> readHolidayDates(File DatabaseFile) throws IOException{
		ArrayList<String> HolidayDates = new ArrayList<String>();
		ArrayList<String> StringArray = read(DatabaseFile);
		for(int i=0; i<StringArray.size();i++){
			String st = StringArray.get(i);
			StringTokenizer star = new StringTokenizer(st, separator1);
			String holidaydate = star.nextToken().trim();
			HolidayDates.add(holidaydate);
		}
		return HolidayDates;
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
		if (HolidayDate.contains(date.toString()))
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

	public void setHolidayDate(ArrayList<String> HolidayDate) {
		this.HolidayDate = HolidayDate;
	}
	public ArrayList<String> getHolidayDate() {
		return this.HolidayDate;
	}
	public void addHolidayDate(String addedHolidayDate){
		this.HolidayDate.add(addedHolidayDate);
	}
	public void removeHolidayDate(String removedHolidayDate){
		this.HolidayDate.remove(removedHolidayDate);
	}
	
}
