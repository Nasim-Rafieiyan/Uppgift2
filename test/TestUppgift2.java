
import java.text.ParseException;
import junit.framework.TestCase;
import org.junit.Test;
import uppgift2.DaysBetweenTwoDates;
import uppgift2.FöreDettaKund;
import uppgift2.NuvarandeMedlem;

//Test-Driven Development, TDD
public class TestUppgift2 {

    DaysBetweenTwoDates gd = new DaysBetweenTwoDates();

    //Första enhetstest
    @Test
    public final void TestDaysBetweenTwoDates() throws ParseException {

        //(Today:2017-10-17) - (Input:2017-10-10) = 7
        //If you want to run the test right, you shoud change "7"
        TestCase.assertTrue(gd.daysBetweenTwoDates("2017-10-10") == 7);
        TestCase.assertFalse(gd.daysBetweenTwoDates("2017-10-10") == 2);
    }

    //Andra enhetstest
    @Test
    public final void TestnuvarandeMedlem() {

        NuvarandeMedlem nm = new NuvarandeMedlem();

        TestCase.assertEquals(nm.getText(), "En nuvarande medlem!\nKunden har ett giltigt årskort!");
    }

    //Tredje enhetstest
    @Test
    public final void TestföreDettaKund() {

        FöreDettaKund fd = new FöreDettaKund();

        TestCase.assertEquals(fd.getText(), "En före detta kund\nKunden har INTE ett giltigt årskort!");
    }

}
