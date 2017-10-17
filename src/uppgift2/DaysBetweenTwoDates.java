package uppgift2;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//att läsa in datum (sträng) och få år, månad och dag (heltal) 

public class DaysBetweenTwoDates {
    
    
public long daysBetweenTwoDates(String input) throws ParseException{
        
        //*****Läsa in och parsa datum*****
        //input format is "yyyy-MM-dd"
        LocalDate startDate = LocalDate.parse(input);
        LocalDate endtDate = LocalDate.now();
        Long ddays = ChronoUnit.DAYS.between(startDate, endtDate);

        return ddays;       
    }

}
