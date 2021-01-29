package ComparatorTest;

import java.util.Comparator;

class PersonAgeComparator implements Comparator<PersonLong> {

    public int compare(PersonLong a, PersonLong b){

        if(a.getAge()> b.getAge())
            return 1;
        else if(a.getAge()< b.getAge())
            return -1;
        else
            return 0;
    }
}
