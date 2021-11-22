package test.java;

import main.java.Person;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonTest {

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/mm/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
        currentTime();
    }

    @DataProvider(name = "AgeProvider")
    public Object[][] AgeProvider() {
        return new Object[][]{
                {-1, false},
                {0, false},
                {6, false},
                {12, false},
                {13, true},
                {14, true},
                {15, true},
                {16, true},
                {17, true},
                {18, true},
                {19, false},
                {21, false}
        };
    }

    @Test(dataProvider = "AgeProvider")
    public void isTeenagerTest (int age, boolean expected){
        boolean result = Person.isTeenager(age);
        Assert.assertEquals(result, expected);
    }

    @AfterClass()
    public void afterClass() {
        System.out.println("After Clas");
        currentTime();
    }
}