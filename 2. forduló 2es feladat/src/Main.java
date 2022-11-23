import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MultiArray list = readFromFile();
        taskA(list);
        taskB(list);
    }

    public static MultiArray readFromFile()
    {
        MultiArray beolvasott = new MultiArray();
        ArrayList<String> sorok = new ArrayList<>();
        try {
            File lepesek = new File("lepesek.txt");
            Scanner myReader = new Scanner(lepesek);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine()+" ";
                //System.out.println(data);
                sorok.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //System.out.println(sorok);
        for(int a = 0;a<=sorok.size()-1;a++)
        {
            String adat = "";
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int i = 0;i != sorok.get(a).length();i++)
            {

                if(sorok.get(a).charAt(i)==' ')
                {
                    //System.out.println(adat);
                    int elem = Integer.parseInt(adat);
                    innerList.add(elem);
                    adat="";
                }
                else
                {
                    adat += sorok.get(a).charAt(i);
                    //System.out.println(adat);
                }
            };
            beolvasott.addArray(innerList);
        }
        return beolvasott;
    }

    public static void taskA(MultiArray list)
    {
        var megoldas = 0;
        for(int a = 0; a!= list.size();a++)
        {
            ArrayList<Integer> sor = list.getArray(a);
            for (int i = 0; i != 10; i++)
            {
                Integer szam = sor.get(i);
                if(szam == 33 || szam == 34 || szam == 43 || szam == 44)
                {
                    megoldas++;
                    break;
                }
            }
        }
        System.out.println("Az A feladata megoldása: "+megoldas);
    }

    public static void taskB(MultiArray list)
    {
        int jó = 0;
        for(int i = 0; i<= list.length();i++)
        {
            ArrayList<Integer> sor = list.getArray(i);
            int sz1 = sor.get(0);
            int sz2 = sor.get(sor.size()-1);
            String sz1á = String.valueOf(sz1);
            String sz2á = String.valueOf(sz2);
            int e1 = Integer.parseInt(sz1á.substring(0,1));
            int e2 = Integer.parseInt(sz2á.substring(0,1));
            int u1 = Integer.parseInt(sz1á.substring(1,2));
            int u2 = Integer.parseInt(sz2á.substring(1,2));

            if(e1+2==e2&&(u1-1==u2||u1+1==u2)) jó++;
            else if(e1-2==e2&&(u1-1==u2||u1+1==u2)) jó++;
            else if(u1-2==u2&&(e1-1==e2||e1+1==e2)) jó++;
            else if(u1+2==u2&&(e1-1==e2||e1+1==e2)) jó++;
        }
        System.out.println("A B feladat megoldása: "+ jó);
    }
}
