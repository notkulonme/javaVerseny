import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        readFromFile();
    }

    public static void readFromFile()
    {
        ArrayList<Ut> utakLista = new ArrayList<>();
        ArrayList<Ut> validUtakLista = new ArrayList<>();
        ArrayList<String> sorok = new ArrayList<>();


        try {
            File utak = new File("utak.txt");
            Scanner reader = new Scanner(utak);
            while (reader.hasNextLine()) {
                String sor = reader.nextLine() + " ";
                //System.out.println(sor);
                sorok.add(sor);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //System.out.println(sorok);
        //System.out.println(sorok.get(sorok.size()-1));
        for(int i = 0 ; i<= sorok.size()-1;i++)
        {
            Ut ut = procesReadedData(sorok.get(i));
            utakLista.add(ut);
        }
        for(int i = 0; i< utakLista.size();i++)
        {
            if(utakLista.get(i).valid)
            {
                validUtakLista.add(utakLista.get(i));
            }
        }

        //System.out.println(validUtakLista.get(0).csucsok);
        System.out.println(validUtakLista.size());
    }

    public static Ut procesReadedData(String sor)
    {
        Ut ut = new Ut();
        sor = sor.substring(3);
        ut.Fcsucs = sor.substring(0,1);
        sor = sor.substring(2);
        //System.out.println(ut.Fcsucs);
        ut.AddCsucs(ut.Fcsucs);
       //System.out.println(sor);

        String adat = "";
        for (int i = 0;i < sor.length();i++)
        {

            if(sor.charAt(i)==' ')
            {
                //System.out.println(adat);
                int elem = Integer.parseInt(adat);
                adat = "";
                ut.AddLepes(elem);
            }
            else
            {
                adat += sor.charAt(i);
                //System.out.println(adat);
            }
        }

        //System.out.println(ut.lepesek+" "+ut.lepesek.size());
        //System.out.println(ut.csucsok.get(0));
        for(int i = 0; i < ut.lepesek.size();i++)
        {
            //System.out.println(i);
            if(ut.valid)
            {
                ut.getNextCsucs(ut.csucsok.get(i),ut.lepesek.get(i));
            }
            else break;
        }
        return ut;
    }
}