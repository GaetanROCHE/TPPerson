import persons.Person;

import java.util.GregorianCalendar;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */
public class TestPerson extends TestIPerson {

    public void initialize(){
        john = new Person("Gronathan","Platteau",new GregorianCalendar(1994, 11, 25));
    }
}
