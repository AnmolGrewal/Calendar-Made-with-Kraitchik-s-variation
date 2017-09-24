/**
 * 
 * @author Anmol Grewal
 * Gregorian Calendar App that displays the month for the particular year
 */
public class Calendar {
    //Private variable for Year only accessible inside methods of object
    private int Year;
    //Private variable for Month only accessible inside methods of object
    private int Month;
    //True and False for whether there is a leap year for that year
    private boolean leapYear;
    //Variable for how many \t before first actualDay starts
    private int Maxim;
    
    /**
     *  Takes in two parameters for object Calendar to create an Object for the particular year and month.
     * @param userYear
     * @param userMonth
     */
    public Calendar(int userYear, int userMonth){
        Year = userYear;
        Month = userMonth;
    }
    /**
     * Method overloading for first Calendar in PrintCalendar
     * set Year to 2017 and Month to February
     * Default Constructor for no input
     */
    public Calendar() {
        Year = 2017;
        Month = 2;
    }
    /**
     * Method of object Calendar that sets/changes the Year.
     * @param userYear
     */
    public void setYear(int userYear){
        Year = userYear;
    }
    
    /**
     * Method of object Calendar that sets/changes the Month.
     * @param userMonth
     */
    public void setMonth(int userMonth){
        Month = userMonth;
    }
    
    /**
     * Checks to see if Leap year or not based on Leap year Conditions
     * @param inputYear
     */
    private void leapYears(){
        if (Year % 4 == 0 && Year % 100 != 0){
            leapYear = true;
        }
        else if(Year % 400 == 0) {
            leapYear = true;
        }
        else {
            leapYear = false;
        }
    }

    /**
     * Used for output, changing integer value of Months to the
     * Corresponding Month in text
     */
    private void monthText(){
        switch (Month) {
            case 1:
                System.out.print("January");
                break;
            case 2:
                System.out.print("February");
                break;
            case 3:
                System.out.print("March");
                break;
            case 4:
                System.out.print("April");
                break;
            case 5:
                System.out.print("May");
                break;
            case 6:
                System.out.print("June");
                break;
            case 7:
                System.out.print("July");
                break;
            case 8:
                System.out.print("August");
                break;
            case 9:
                System.out.print("September");
                break;
            case 10:
                System.out.print("October");
                break;
            case 11:
                System.out.print("November");
                break;
            case 12:
                System.out.print("December");
                break;
            default:
                System.out.print("Invalid Month");
                break;
        }
    }
    
    /**
     * 
     * @return h1;
     */
    private int actualDay(){
        //Set a temporary Year variable so it doesn't affect actual calendar Year.
        int tempYear = Year;
        //Set a temporary Month variable so it doesn't affect actual calendar Year.
        int tempMonth = Month;
        //January is considered to be the 13th month of last year
        if (tempMonth == 1 ){
            tempMonth = 13;
             tempYear = Year - 1;
         }
        //February is considered to be the 14th month of last year
        else if (tempMonth == 2) {
             tempMonth = 14;
             tempYear = Year - 1;
        }
        //Variable required for Zeller's congruence
        int j = tempYear / 100;
        //Variable required for Zeller's congruence
        int k = tempYear % 100;
        int q = 1;
        //Zeller's congruence formula to find actualDay
        double h = (q + ((13 * (tempMonth + 1) / 5)) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
        //casts h back to an integer from a double
        int h1 = (int) h;
        return h1;
        /**
        When h1 is 0 it is Saturday
        When h1 is 1 it is Sunday
        when h1 is 2 it is Monday
        when h1 is 3 it is Tuesday
        when h1 is 4 it is Wednesday
        when h1 is 5 it is Thursday
        when h1 is 6 it is Friday
        */
    }
    
    /**
     * This method helps format calendar so the first day starts at the appropriate
     * column for the correct actualDay
     * @param actualDay
     */
    private void calendarSpaces(int actualDay){
        switch (actualDay){
        //It is 6 because it corresponds with Saturday, last day of week
        case 0:
            Maxim = 6;
            break;
        //Sunday first day of week so 0, so on so forth
        case 1:
            Maxim = 0;
            break;
        case 2:
            Maxim = 1;
            break;
        case 3:
            Maxim = 2;
            break;
        case 4:
            Maxim = 3;
            break;
        case 5:
            Maxim = 4;
            break;
        case 6:
            Maxim = 5;
            break;
        //Default value 6 just in case
        default:
            Maxim = 6;
            break;
        }
        //For loop for how many \t spaces before first actualDay of the Month
        for(int i = 0; i < Maxim; i++){
            System.out.print("\t");
        }
    }
    
    /**
     * Finds out the days in a Month and accounts for Leap year in February
     * @return daysMonth
     */
    private int daysInMonth(){
        int daysMonth;
        //Calls the leapYears method to check if leapyear
        leapYears(); 
        if (Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12){
            daysMonth = 31;
        }
        else if (Month == 4 || Month == 6 || Month == 9 || Month == 11) {
            daysMonth = 30;
        }
        else if (leapYear){
            daysMonth = 29;
        }
        else {
            daysMonth = 28;
        }
        return daysMonth;
    }
    
    /**
     * Formats and displays the output in format specified
     */
    public void printMonth(){
        //Calculates days in a month for the Month
        int daysInAMonth = daysInMonth();
        //Counter variable used to display days;
        int count = 1;
        //Used for formatting to center Text
        System.out.print("\t\t");
        //Displays The Month in text
        monthText();
        //Displays the year
        System.out.print("   " + Year + "\n");
        //Used for formatting the dashes
        for(int i = 0; i < 42; i++){
            System.out.print("-");
        }
        //Displays actualDays separated by \t
        System.out.println("\nSun\tMon\tTue\tWed\tThu\tFri\tSat");
        //Puts sufficient space to start on correct day
        calendarSpaces(actualDay());
        //Added Maxim to days in a month to account for \t added by calendarSpaces
        daysInAMonth += Maxim;
        //For loop that prints all days in a month from 1 to last day in the month
        for (int j = Maxim; j < daysInAMonth; j++){
            //Condition so a new line starts after a week ends
            if (j % 7 == 0 && j != 0){
                System.out.println("");
            }
            System.out.print(count + "\t");
            count++;
        }
        System.out.println("");
    }
}