package com.moblima.movie;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import com.moblima.Manager.ServerInterface;

/**
 * Represents a ticket price.
 */
public class TicketPrice {
	private static String separator1 = "|";

	/**
	 * List of holiday dates
	 */
	private ArrayList<String> HolidayDate;

	/**
	 * List of modifiers of this ticket price
	 */
	private Double[] Modifier;

	private ServerInterface DBinterface = ServerInterface.getINSTANCE();

	/**
	 * Default constructor, which constructs 
	 * connection to database.
	 */
	public TicketPrice(){
		try {
			File DatabaseFile = new File("data\\Modifiers.txt");
            this.Modifier = readModifiers(DatabaseFile);
		} catch (Exception e) {
			System.out.println("IOException > " + e.getMessage());
		}

		try {
			File DatabaseFile = new File("data\\HolidayDate.txt");
			this.HolidayDate = readHolidayDates(DatabaseFile);
		} catch (Exception e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}

	/**
	 * Reads the modifiers from database.
	 */
	public Double[] readModifiers(File DatabaseFile) throws IOException{
		ArrayList<String> StringArray = DBinterface.ReadFile(DatabaseFile);
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

	/**
	 * Reads the holiday date from database.
	 */
	public ArrayList<String> readHolidayDates(File DatabaseFile) throws IOException{
		ArrayList<String> HolidayDates = new ArrayList<String>();
		ArrayList<String> StringArray = DBinterface.ReadFile(DatabaseFile);
		for(int i=0; i<StringArray.size();i++){
			String st = StringArray.get(i);
			StringTokenizer star = new StringTokenizer(st, separator1);
			String holidaydate = star.nextToken().trim();

			HolidayDates.add(holidaydate);
		}
		return HolidayDates;
	}

	/**
	 * Calculate the price of this ticket price
	 * and returns it
	 * @param date the showtime's date.
	 * @param age the user's age.
	 * @param cinemaclass the showtime's cinema's class.
	 * @param movietype the showtime's movie's type. 
	 */
	public Double getPrice(GregorianCalendar date, int age, String cinemaclass, String movietype) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		fmt.setCalendar(date);
		String DateInString = fmt.format(date.getTime());
		Double Price = Modifier[0];
		if (HolidayDate.contains(DateInString))
			Price+=Modifier[1];
		if (age<6)
			Price -= Modifier[2];
		if (age>55)
			Price += Modifier[3];
		if (cinemaclass.equals("PREMIUM"))
			Price+= Modifier[4];
		if (movietype.equals("3D"))
			Price+= Modifier[5];
		if (movietype.equals("Blockbuster"))
			Price+= Modifier[6];
		return Price;
	}

	/**
	 * Changes the modifier of this ticket price.
	 * @param Modifier the new ticket price's modifier.
	 */
	public void setModifier(Double[] Modifier) {
		this.Modifier = Modifier;
	}

	/**
	 * Gets the modifier of this ticket price.
	 * @return this ticket price's modifiere.
	 */
	public Double[] getModifier() {
		return this.Modifier;
	}

	/**
	 * Changes the list of holiday dates.
	 * @param HolidayDate the new holiday date.
	 */
	public void setHolidayDate(ArrayList<String> HolidayDate) {
		this.HolidayDate = HolidayDate;
	}

	/**
	 * Gets the list of holiday dates.
	 * @return the list of holiday date.
	 */
	public ArrayList<String> getHolidayDate() {
		return this.HolidayDate;
	}

	/**
	 * Adds a new holiday date to the list.
	 * @param addedHolidayDate the new holiday daye.
	 */
	public void addHolidayDate(String addedHolidayDate){
		this.HolidayDate.add(addedHolidayDate);
	}

	/**
	 * Removes a holiday date from the list.
	 * @param removedHolidayDate holiday date to be removed
	 */
	public void removeHolidayDate(String removedHolidayDate){
		this.HolidayDate.remove(removedHolidayDate);
	}
	
}
