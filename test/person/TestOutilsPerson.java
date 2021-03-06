import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import persons.IPerson;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class TestOutilsPerson {
    private ArrayList<IPerson> persons;
    private GregorianCalendar date;
    private OutilsPerson tool;

    @Before
    public void initialize(){
        persons = new ArrayList<>();
        date = new GregorianCalendar(2005, 4, 15);
        IPerson person = Mockito.mock(IPerson.class);
        Mockito.when(person.getAge(date)).thenReturn(2);
        persons.add(person);
        person = Mockito.mock(IPerson.class);
        Mockito.when(person.getAge(date)).thenReturn(26);
        persons.add(person);
        person = Mockito.mock(IPerson.class);
        Mockito.when(person.getAge(date)).thenThrow(new IllegalArgumentException());
        persons.add(person);
        person = Mockito.mock(IPerson.class);
        Mockito.when(person.getAge(date)).thenReturn(45);
        persons.add(person);
        tool = new OutilsPerson();
    }

    @Test
    public void testGetPersonInterval(){
        ArrayList<IPerson> res = tool.getPersonInterval(persons, date, 25, 50);
        Assert.assertEquals(2, res.size());
        Assert.assertEquals(26, res.get(0).getAge(date));
        Assert.assertEquals(45, res.get(1).getAge(date));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPersonIntervalError(){
        tool.getPersonInterval(persons, date, 50, 25);
    }

    @Test
    public void testResearchOlder(){
        Assert.assertEquals(45, tool.researchOlder(persons, date));
    }

    @Test
    public void testAnonymousResearchOlder(){
        Assert.assertEquals(45, tool.researchOlder(persons, date));
        for(IPerson p : persons) {
            Mockito.verify(p, Mockito.atLeastOnce()).getAge(date);
            Mockito.verify(p, Mockito.never()).getFirstName();
            Mockito.verify(p, Mockito.never()).getName();
        }
    }
}
