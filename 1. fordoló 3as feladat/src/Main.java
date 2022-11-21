import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) throws IOException {
        MultiArray list = new MultiArray();
        list = readFromfile();
        list = finishTheNumberTriangle(list);
        //System.out.println(list.get(20,0));
        System.out.println("Az a feladat megoldása: "+taskA(list));
        System.out.println("A b feladat megoldása: "+taskB(list));
        System.out.println("A c feladat megoldása: "+taskC(list));
        //System.out.println(list.get(2,1));
        writeToaFile(list);
    }

    public static MultiArray readFromfile()
    {
        MultiArray list = new MultiArray();
        try
        {
            File szamok = new File("szamok7.txt");
            Scanner myReader = new Scanner(szamok);
            int i = 0;
            while (myReader.hasNextInt()) {
                int data = myReader.nextInt();
                //System.out.println(data);
                list.add(i,data);
                i++;
            }
            myReader.close();
        }
        catch
        (FileNotFoundException e) {
            System.out.println("Valamit elbasztam sorry :c");
            e.printStackTrace();
        }
        //System.out.println(list.length());
        return list;
    }

    public static MultiArray finishTheNumberTriangle(MultiArray list)
    {
        MultiArray returnList = new MultiArray();
        returnList.addArray(list.getArray(0));
        for(int i = 1; i<=list.length();i++)
        {
            ArrayList<Integer> previous = list.getArray(i-1);
            ArrayList<Integer> now = list.getArray(i);
            for(int a = 0; a<=previous.size()-1; a++)
            {
                now.add(previous.get(a)-now.get(a));
            }
            returnList.addArray(now);
        }
        return  returnList;
    }





    public static int taskA(MultiArray list)
    {
        int i = 0;
        for(int a = 0;a<= list.getArray(5).size()-1;a++)
        {
            if(list.get( list.size()-6, a)<100||list.get(list.size()-6,a)>999){
                i++;}
            else if (list.get( list.size()-6, a)>-100||list.get(list.size()-6,a)<-999) {
                i++;
            }
        }
        //System.out.println(list.getArray(list.size()-6));
        return i;
    }
    public static int taskB(MultiArray list)
    {
        return list.get(0,0);
    }
    public static int taskC(MultiArray list)
    {
        ArrayList<Integer> osszegek = new ArrayList<>();
        int biggerThanOneAndAHalf = 0;
        for(int i = 0 ; i<= list.length();i++)
        {
            int osszeg = 0;
            for(int a = 0; a <= list.getArray(i).size()-1;a++)
            {
                osszeg+= list.get(i,a);
            }
            osszegek.add(osszeg);
        }
        for(int b = osszegek.size()-2;b>=0;b--)
        {
            if(osszegek.get(b)/(osszegek.get(b)+1)>1.5)
            {
                biggerThanOneAndAHalf++;
            }
        }
        return biggerThanOneAndAHalf;
    }

    public static void writeToaFile(MultiArray list) throws IOException {
        File megoldas = new File("megoldas.txt");
        megoldas.createNewFile();
        FileWriter w = new FileWriter(megoldas);
        for(int i = 0;i<= list.length();i++)
        {
            for(int a = 0;a<= list.innerArraySize(i)-1;a++)
            {
                String put = String.valueOf(list.get(i,a));
                w.write(put);
                w.write(" ");
                // System.out.println(put);
            }
            w.write("\n");
        }
        w.close();
    }

}
