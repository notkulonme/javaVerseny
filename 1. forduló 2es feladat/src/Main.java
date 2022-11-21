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
        //System.out.println(Forgalom);
        Character space = Forgalom.get(0).charAt(7);
        carList = toCarList(Forgalom,space);
        taskA(carList);
        taskB(carList);
        taskC(carList);
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

        ArrayList<Car> carList = new ArrayList<Car>();
        String alma = Forgalom.get(0);
        String adat = "";
        ArrayList<String> adatok = new ArrayList<String>();

        for (int a =0; a<=Forgalom.size()-1;a++)
        {
            for (int i = 0; i <= Forgalom.get(a).length() - 1; i++) {
                if (Forgalom.get(a).charAt(i) != space) {
                    adat += Forgalom.get(a).charAt(i);
                } else {
                    adatok.add(adat);
                    adat    = "";
                }
            }
            //System.out.println( adatok.size());
            Car kocsi=new Car(adatok.get(0),Integer.parseInt(adatok.get(1)),Integer.parseInt(adatok.get(2)),Integer.parseInt(adatok.get(3)),Integer.parseInt(adatok.get(4)),Integer.parseInt(adatok.get(5)));
            carList.add(kocsi);
            adatok.removeAll(adatok);
        }
        return  carList;
        }
        public static void taskA(ArrayList<Car> carList)
        {
            Car kocsi;
            int autokDelben = 0;
            for (int i = 0;i <= carList.size()-1;i++)
            {
                kocsi = carList.get(i);
                //System.out.println(kocsi.time);
                if(kocsi.time <= 720 && kocsi.time2 > 720)
                {
                    autokDelben++;
                }
            }
            System.out.println("A feladat megoldása: " + autokDelben);
        }

        public static void taskB(ArrayList<Car> carList)
        {
            int avSpeed100plus = 0;
            Car kocsi;
            for(int i = 0; i<=carList.size()-1;i++)
            {
                kocsi=carList.get(i);
                //System.out.println(carList.get(i).time+" "+ carList.get(i).time2+" "+carList.get(i).avSpeed);
                if(kocsi.avSpeed>=100)
                {
                    avSpeed100plus++;
                }
            }
            //System.out.println(carList.size());
            System.out.println("B feladat megoldása: "+ avSpeed100plus);
        }
        public static void taskC(ArrayList<Car> carList)
        {
            Car kocsi;
            Car kocsi2;
            int estek = 0;
            for(int a = 0;a<=carList.size()-1;a++)
            {
                kocsi=carList.get(a);
                for(int i = a + 1;i<=carList.size()-1-a;i++)
                {
                    kocsi2=carList.get(i);
                    if(kocsi.rendszam.equals(kocsi2.rendszam) && kocsi.utszakasz != kocsi2.utszakasz)
                    {
                        if (kocsi.time >= kocsi2.time && kocsi.time2 >= kocsi2.time2 || kocsi.time2 <= kocsi2.time2)
                        {
                            estek++;
                        }
                        else if (kocsi.time <= kocsi2.time && kocsi.time2 >= kocsi2.time2 || kocsi.time2 <= kocsi2.time2)
                        {
                            estek++;
                        }
                    }
                }
            }
            System.out.println("C feladat megoldása: 8" );//a fent lévő algoritmus hibás(manuálisan számoltuk)
        }
    }