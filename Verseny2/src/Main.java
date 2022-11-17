import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

public class Main
    {
    public static void main(String[] args) {
        ArrayList<String> Forgalom = new ArrayList<String>();
        ArrayList<Car> carList = new ArrayList<Car>();

        Forgalom = readFromFile();
        System.out.println(Forgalom);
        Character space = Forgalom.get(0).charAt(7);
        carList = toCarList(Forgalom,space);
    }

    public static ArrayList<String> readFromFile()
    {
        ArrayList<String> Lista = new ArrayList<String>();
        try {
            File forgalom = new File("forgalom.txt");
            Scanner myReader = new Scanner(forgalom);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine()+"\t";
                Lista.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return Lista;
    }
    public static ArrayList<Car> toCarList(ArrayList<String> Forgalom, Character space)
    {
        Car kocsi = new Car();
        ArrayList<Car> carList = new ArrayList<Car>();
        String alma = Forgalom.get(0);
        String adat = "";
        ArrayList<String> adatok = new ArrayList<String>();

        for (int a =0; a<=Forgalom.size()-1;a++) {
            for (int i = 0; i <= Forgalom.get(a).length() - 1; i++) {
                if (Forgalom.get(a).charAt(i) != space) {
                    adat += Forgalom.get(a).charAt(i);
                } else {
                    adatok.add(adat);
                    adat = "";
                }
            }
            //System.out.println( adatok.size());
            kocsi.rendszam = adatok.get(0);
            kocsi.FH=Integer.parseInt(adatok.get(1));
            kocsi.FM=Integer.parseInt(adatok.get(2));
            kocsi.SH=Integer.parseInt(adatok.get(3));
            kocsi.SM=Integer.parseInt(adatok.get(4));
            kocsi.utszakasz=Integer.parseInt(adatok.get(5));
            carList.add(kocsi);
            adatok.removeAll(adatok);
        }
        return  carList;
    }
}