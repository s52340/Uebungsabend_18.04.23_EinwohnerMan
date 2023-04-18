package meinVersuch;

import java.util.Objects;

public class Einwohner implements Comparable<Einwohner>{
    private int id;
    private String name;
    private String bundesland;
    private int geburtsjahr;


    public Einwohner(int id, String name, String bundesland, int geburtsjahr) {
        this.id = id;
        this.name = name;
        this.bundesland = bundesland;
        this.geburtsjahr = geburtsjahr;
    }

    public Einwohner(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    public int getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(int geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
    }

    @Override
    public String toString() {
        return "Einwohner{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", bundesland:'" + bundesland + '\'' +
                ", geburtsjahr:" + geburtsjahr +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Einwohner einwohner = (Einwohner) o;
        return id == einwohner.id && geburtsjahr == einwohner.geburtsjahr && Objects.equals(name, einwohner.name) && Objects.equals(bundesland, einwohner.bundesland);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, bundesland, geburtsjahr);
    }

    @Override
    public int compareTo(Einwohner einwohner) {
        int res = this.name.compareTo(einwohner.getName());
        if (res == 0){
            return Integer.compare(this.getId(), einwohner.getId());
        }
        return res;
    }
}
