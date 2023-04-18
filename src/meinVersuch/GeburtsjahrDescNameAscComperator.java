package meinVersuch;

import java.util.Comparator;

public class GeburtsjahrDescNameAscComperator implements Comparator<Einwohner> {
    @Override
    public int compare(Einwohner einwohner, Einwohner t1) {
        int res = Integer.compare(t1.getGeburtsjahr(), einwohner.getGeburtsjahr());
        if (res == 0){
            return einwohner.getName().compareTo(t1.getName());
        }
        return res;
    }
}
