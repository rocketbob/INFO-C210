import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GregorianCalendar {
	static LocalDate localDate = LocalDate.now();
	protected int currentYear = Integer.parseInt(DateTimeFormatter.ofPattern("yyy").format(localDate));
	protected int currentMonth = Integer.parseInt(DateTimeFormatter.ofPattern("MM").format(localDate));
	protected int currentDay = Integer.parseInt(DateTimeFormatter.ofPattern("dd").format(localDate));
	protected int yearSelected;
	protected boolean leapYear;
	int[] monthNumDays  = {31,28,31,30,31,30,31,31,30,31,30,31};
	int[] monthOffsets = new int[12]; // these are created by setOffSets() method
	int ReferenceOffset = 1;
	
	// default constructor
	public GregorianCalendar() {
		this.yearSelected = currentYear;
		setMonthNumDays();  // if it is a a leap year add a day to February
		setOffsets(); // take year of interest, and create offsets for each month
	}
	// constructor with selected year
	public GregorianCalendar(int yearSelected) {
		this.yearSelected = yearSelected;
		setMonthNumDays();  // if it is a a leap year add a day to February
		setOffsets();  // take year of interest, and create offsets for each month
	}

	public void setMonthNumDays() {
		if (isLeapYear(yearSelected)) {
			this.monthNumDays[1] = 29;
		} 
	}
	
	    // creates offsets for each month
	public void setOffsets() {
		int numDays = 0;
		int tempYear = 0;  // temporary storage for algorithm
		int refYear = 2017;  // we use this year because the offset is 0 (Jan 1 starts on Sunday)
		int refOffset = 0;  // this value will be the Jan 1 offset for what ever year
		boolean yearIsLower = false;

		int absoluteValue = Math.abs(refYear - yearSelected);  // tells how many years from reference 2018
		// are we going up or down
        if (refYear < yearSelected) {  
        	tempYear = (refYear + yearSelected) - yearSelected;  // we are positive
        } else {
        	tempYear = (refYear + yearSelected) - refYear;  // we are negative
        	yearIsLower = true;
        }
        // the real work done here
        	for (int i = 0; i < absoluteValue; i++) {  // number of iterations needed
        		if(isLeapYear(tempYear)) {
        			// this is a leap year add 366
        			numDays += 366;
          		} else {
          			// this is a common year add 365
        			numDays += 365;
        		}
        		tempYear++;
        	}
        	refOffset = (numDays) % 7;  // If the year in question is larger than the 
        	                            // reference of 2017 then do a modulus 7
        	if(yearIsLower) {           // If the year in question is smaller than the
                if(refOffset != 0) {    // reference of 2017 then subtract the answer to
        		refOffset = (7 - refOffset); // that modulus 7, from 7 unless the answer is 0
                }                          // in that case, do nothing.
        	}
		// make the offsets for each month for the rest of the year
		monthOffsets[0] = refOffset; // this is the January offset, a reference for the rest
		for (int i = 0; i < 11; i++) {  // leap years already accounted for by this point
			monthOffsets[i+1] = (monthOffsets[i] + monthNumDays[i]) % 7;
		}
	}

	// determine if it is a leap year
	public boolean isLeapYear(int choseYear) {
		leapYear = false;
		if(choseYear % 4 == 0) {
			leapYear = true;
			if(choseYear % 100 == 0) {
				leapYear = false;
				if(choseYear %400 == 0) {
					leapYear = true;
				}
			}
		}
		return leapYear;
	}


}
