import persons.IPerson;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by gaetan on 06/04/16.
 */
public class OutilsPerson {

    /**
     *
     * @param allPersons ArrayList
     * @param date GregorianCalendar
     * @param ageMin int
     * @param ageMax int
     * @return ArrayList<IPerson> dont l'age est compris entre ageMin et ageMax
     */
    public ArrayList<IPerson> getPersonInterval(ArrayList<IPerson> allPersons, GregorianCalendar date, int ageMin, int ageMax){
        if(ageMin>ageMax)
            throw new IllegalArgumentException();
        ArrayList<IPerson> res = new ArrayList<>();
        for(IPerson person : allPersons)
            if(person.getAge(date) <= ageMax && person.getAge(date)>= ageMin)
                res.add(person);
        return res;
    }

    /**
     *
     * @param allPersons ArrayList<IPerson>
     * @param date GregorianCalendar
     * @return int l'age de la personne la plus vieille à la date donnée
     */
    public int researchOlder(ArrayList<IPerson> allPersons, GregorianCalendar date){
        int ageMax = 0;
        for(IPerson person : allPersons)
            if(person.getAge(date) > ageMax)
                ageMax = person.getAge(date);
        return ageMax;
    }
}
