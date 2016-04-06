import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import persons.IPerson;

import java.util.GregorianCalendar;

/**
 * Created by gaetan on 06/04/16.
 */
public abstract class TestIPerson {

    IPerson john;

    @Before
    public void initialize(){
    }

    @Test
    public void testWasBornTrue(){
        Assert.assertTrue(john.wasBorn(new GregorianCalendar()));
    }

    @Test
    public void testWasBornCurrently(){
        Assert.assertTrue(john.wasBorn(new GregorianCalendar(1994, 11, 25)));
    }

    @Test
    public void testWasBornFalse(){
        Assert.assertFalse(john.wasBorn(new GregorianCalendar(1994, 11, 20)));
    }

    @Test
    public void testGetAge(){
        Assert.assertEquals(john.getAge(new GregorianCalendar(2017, 1, 11)), 22);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeError(){
        john.getAge(new GregorianCalendar(1993, 5, 11));
    }

    @Test
    public void testGetAgeZero(){
        Assert.assertEquals(0, john.getAge(new GregorianCalendar(1994, 24, 11)));
    }
}
