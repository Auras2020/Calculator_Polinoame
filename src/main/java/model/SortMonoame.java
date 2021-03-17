package model;

import java.util.Comparator;

public class SortMonoame implements Comparator<Monom> {
    @Override
    public int compare(Monom o1, Monom o2) {
        return o2.getPutere()-o1.getPutere();
    }
}
