import persons.Person;

import java.util.GregorianCalendar;

/**
 * Created by gaetan on 06/04/16.
 */
public class TestPerson extends TestIPerson {

    public void initialize(){
        john = new Person("Gronathan","Platteau",new GregorianCalendar(1994, 11, 25));
    }
}
