package uppgift2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class InputOutput {

    public InputOutput() throws ParseException {

        String kundensInputInfo
                = JOptionPane.showInputDialog(null,
                        "Kundens Info:\npersonnummer eller förnamn efternam:",
                        "Best Gym Ever", JOptionPane.QUESTION_MESSAGE);

        String filePath = "src\\uppgift2\\Customers.txt";
        Path inFilePath;

        String firstLine;
        String secondLine;
        String[] personInformationTexfile;
        boolean bPn, bnamn;

        try {
            inFilePath = Paths.get(filePath);
            Scanner fileScanner = new Scanner(inFilePath);

            String s = "";
            while (fileScanner.hasNext()) {
                firstLine = fileScanner.nextLine();
                personInformationTexfile = firstLine.split(",");
                secondLine = fileScanner.nextLine();

                bPn = kundensInputInfo.equals(personInformationTexfile[0].trim());
                bnamn = kundensInputInfo.equalsIgnoreCase(personInformationTexfile[1].trim());
                boolean or = bPn || bnamn;
                boolean nor = !(bPn || bnamn);

                if (or) {
                    //s = "EN kund!";
                    String input = secondLine.trim();
                    DaysBetweenTwoDates dbtd = new DaysBetweenTwoDates();
                    long days = dbtd.daysBetweenTwoDates(input);
                    System.out.printf("Personen har köpt årskortet %d dagar sedan.\n", days);

                    //Har personen ett giltigt årskort eller inte?
                    //att ta det datumet som kunden har köpt årskortet 
                    //och jämföra med med datum just nu.
                    if (days <= 365) {
                        NuvarandeMedlem nm = new NuvarandeMedlem();
                        JOptionPane.showMessageDialog(null, nm.getText(),
                                "Best Gym Ever", JOptionPane.INFORMATION_MESSAGE);
                        //När en betalande kund dyker upp sparas det ner kundens
                        //namn, personnummer och datum i en egen, annan fil
                        LocalDate DateNow = LocalDate.now();
                        FileWriter fw = new FileWriter("tränatkund.txt", true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fw);
                        bufferedWriter.write(firstLine + "  " + DateNow);
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                    } else {
                        FöreDettaKund fdk = new FöreDettaKund();
                        JOptionPane.showMessageDialog(null, fdk.getText(),
                                "Best Gym Ever", JOptionPane.INFORMATION_MESSAGE);
                    }
                    //break;
                    System.exit(0);
                } else if (nor) {
                    s = "Personen aldrig har varit medlem.";
                }

            }//while-loop

            JOptionPane.showMessageDialog(null, s,
                    "Best Gym Ever", JOptionPane.INFORMATION_MESSAGE);

        } catch (FileNotFoundException e) {
            System.out.println("Filen kunde inte hittas");
            System.out.flush();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Det gick inte att skriva till fil");
            System.out.flush();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Något gick fel");
            System.out.flush();
            System.exit(0);
        }

    }

}
