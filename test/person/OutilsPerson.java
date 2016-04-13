import persons.IPerson;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author ROCHE Gaetan & PLATTEAU Jonathan
 */

class OutilsPerson {

    /**
     *
     * @param allPersons ArrayList
     * @param date GregorianCalendar
     * @param ageMin int
     * @param ageMax int
     * @return ArrayList<IPerson> dont l'age est compris entre ageMin et ageMax
     */
    ArrayList<IPerson> getPersonInterval(ArrayList<IPerson> allPersons, GregorianCalendar date, int ageMin, int ageMax){
        if(ageMin>ageMax)
            throw new IllegalArgumentException();
        ArrayList<IPerson> res = new ArrayList<>();
        for(IPerson person : allPersons) {
            try {
                if (person.getAge(date) <= ageMax && person.getAge(date) >= ageMin)
                    res.add(person);
            } catch (Exception ignored) {}
        }
        return res;
    }

    /**
     *
     * @param allPersons ArrayList<IPerson>
     * @param date GregorianCalendar
     * @return int l'age de la personne la plus vieille à la date donnée
     */
    int researchOlder(ArrayList<IPerson> allPersons, GregorianCalendar date){
        int ageMax = 0;
        for(IPerson person : allPersons)
            try {
                if (person.getAge(date) > ageMax)
                    ageMax = person.getAge(date);
            }catch(Exception ignored) {}
        return ageMax;
    }
}
