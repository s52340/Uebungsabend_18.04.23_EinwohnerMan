package meinVersuch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EinwohnerManager {


    public static void main(String[] args) throws DataFileException {
        ArrayList<Einwohner> einwohners = new EinwohnerManager().load();
        //System.out.println(load);

        for (Einwohner einwohner : einwohners) {
            System.out.println(einwohner);
        }

        Collections.sort(einwohners);
        for (Einwohner einwohner: einwohners){
            System.out.println(einwohner);  //??
        }
    }


/*
    public ArrayList<Einwohner> load(){
        ArrayList<Einwohner> arrayList = new ArrayList<>();

        File f = new File("C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\EinwohnerManager\\testdata-einwohner.csv");

        try(BufferedReader br = new BufferedReader(new FileReader(f))){

            String line;
            while ((line = br.readLine()) != null){

                String[] teilchen = new String[5];
                int Stelle = 0;
                for (int i = 0; i < line.length(); i++) {
                    if ( line.charAt(i) == ','){
                        Stelle ++;
                    }
                    teilchen[Stelle] = teilchen[Stelle] + line.charAt(i);
                }

                int nummeR = Integer.parseInt(teilchen[0]);
                String namE= teilchen[1];
                String lanD = teilchen[2];
                int jahR = Integer.parseInt(teilchen[4]);

                Einwohner einwohner = new Einwohner(nummeR,namE,lanD,jahR);
                arrayList.add(einwohner);
            }


        }
        catch (IOException e){
            try {
                throw new DataFileException("ErrorDataFile", e);
            }
            catch (DataFileException ex) {
                throw new RuntimeException(ex);
            }
        }


        return arrayList;
    }
    Mein Versuch Ende
*/
    public ArrayList<Einwohner> load() throws DataFileException {
        String file = "\"C:\\Campus02\\2.Semester\\Erweiterte Themen der Softwareentwicklung\\Übungsbeispiele\\EinwohnerManager\\testdata-einwohner.csv\"";
        try (BufferedReader br = new BufferedReader(
                new FileReader(file))
        ){
            ArrayList<Einwohner> einwohnerList = new ArrayList<>();

            String line;
            //einlesen Zeile für Zeile

            System.out.println( br.readLine()); //ließt erste Zeile - wollen wir ignorieren

            while ((line = br.readLine()) != null){
                String[] einwohnerData = line.split(";");
                // 1;Bici Thal; Stmk; 2002;
                //--> split (";")
                //einwohnerData[0] = 1;
                //einwohnerData[1] Bici Thal

                if (einwohnerData.length != 4){
                    throw new DataFileException("Datensatz nicht gültig - nicht vollständig");
                }
                int id = Integer.parseInt(einwohnerData[0]);

               Einwohner einwohner = new Einwohner(id, einwohnerData[1], einwohnerData[2], Integer.parseInt(einwohnerData[4]));
                einwohnerList.add(einwohner);

            }
            //sortiere Liste mit Comparable
            //einwohnerList.sort(new GeburtsjahrDescNameAscComperator());

            //mit Lambda sortieren
           /* einwohnerList.sort(einwohner, t1) -> {
                         hier fehlt viel - io kopiert
            }
            */

            //sortieren mittels  comparing  //hier in natürlicher reihenfolge
            einwohnerList.sort(Comparator.comparing(Einwohner::getGeburtsjahr)
                    .reversed()  //umdrehen - weil absteigend sotrieren
                    .thenComparing(Einwohner::getName)  // wenn gleiches geburtsjahr - nach Name sortieren
            );


            return einwohnerList;

        } catch (FileNotFoundException e) {
            throw new DataFileException("File not found", e);  //checked E müssen sofort behandelt werden
        } catch (IOException e) {
            throw new DataFileException("Cannot read file", e);
        }
    }




}
