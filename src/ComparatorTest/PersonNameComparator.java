package ComparatorTest;

import java.util.Comparator;

class PersonNameComparator implements Comparator<PersonLong> {

    public int compare(PersonLong a, PersonLong b){

        return a.getName().compareTo(b.getName());
    }
}
