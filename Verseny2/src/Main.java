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
                String data = myReader.nextLine();
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
        int kor = 1;
        String rendszam = " ";
        int FH;
        int FM;
        int SH;
        int SM;

        for (int a =0; a<=Forgalom.size()-1;a++)
        {
            for (int i = 0; i <= Forgalom.get(a).length() - 1; i++)
            {
                if (Forgalom.get(a).charAt(i) != space)
                {
                    System.out.println(alma.charAt(i));
                }
            }
        }
        return  carList;
    }
}