import people.Personne;
import persons.IPerson;

import java.util.GregorianCalendar;

/**
 * Created by jonat on 06/04/2016.
 */
class PersonneAdapter extends Personne implements IPerson {

    PersonneAdapter(String lastname, String firstname, int year, int month, int day) {
        super(lastname, firstname, day, month, year);
    }

    @Override
    public boolean wasBorn(GregorianCalendar gregorianCalendar) {
        return !gregorianCalendar.before(this.dateNaissance);
    }
}
