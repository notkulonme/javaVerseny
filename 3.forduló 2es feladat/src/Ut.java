import java.util.ArrayList;

public class Ut
{
    boolean valid = true;
    String Fcsucs;
    String kezdopont;
    ArrayList<Integer> lepesek = new ArrayList<>();
    ArrayList<String> csucsok = new ArrayList<>();
    ArrayList<String> szelek = new ArrayList<>();

    public Ut() {}

    public void AddCsucs(String csucs) {
        csucsok.add(csucs);
    }

    public void AddSzel(String szel) {
        szelek.add(szel);
    }

    public void AddLepes(int elem) {
        lepesek.add(elem);
    }

    public void getNextCsucs(String csucs, int lepes)
    {
        boolean validLepes = false;

        if (csucs.equals("A")) {
            if (lepes == 1) {
                validLepes = true;
                csucsok.add("B");
                szelek.add("AB");
            }
            if (lepes == 2) {
                validLepes = true;
                csucsok.add("D");
                szelek.add("AD");
            }
            if (lepes == 3) {
                validLepes = true;
                csucsok.add("E");
                szelek.add("AE");
            }
            if (validLepes == false) {
                valid = false;
            }

        }

        if (csucs.equals("B")) {
            if (lepes == 4) {
                validLepes = true;
                csucsok.add("A");
                szelek.add("AB");
            }
            if (lepes == 3) {
                validLepes = true;
                csucsok.add("F");
                szelek.add("BF");
            }
            if (lepes == 2) {
                validLepes = true;
                csucsok.add("C");
                szelek.add("BC");
            }
            if (validLepes == false) {
                valid = false;
            }
        }


        if (csucs.equals("E"))
        {
            if (lepes == 1) {
                validLepes = true;
                csucsok.add("F");
                szelek.add("EF");
            }
            if (lepes == 2) {
                validLepes = true;
                csucsok.add("H");
                szelek.add("EH");
            }
            if (lepes == 6) {
                validLepes = true;
                csucsok.add("A");
                szelek.add("AE");
            }
            if (validLepes == false) {
                valid = false;
            }
        }


        if (csucs.equals("F"))
        {
            if (lepes == 4) {
                validLepes = true;
                csucsok.add("E");
                szelek.add("EF");
            }
            if (lepes == 2) {
                validLepes = true;
                csucsok.add("G");
                szelek.add("FG");
            }
            if (lepes == 6) {
                validLepes = true;
                csucsok.add("B");
                szelek.add("BF");
            }
            if (validLepes == false) {
                valid = false;
            }
        }


        if (csucs.equals("G"))
        {
            if (lepes == 4) {
                validLepes = true;
                csucsok.add("H");
                szelek.add("GH");
            }
            if (lepes == 5) {
                validLepes = true;
                csucsok.add("F");
                szelek.add("FG");
            }
            if (lepes == 6) {
                validLepes = true;
                csucsok.add("C");
                szelek.add("CG");
            }
            if (validLepes == false) {
                valid = false;
            }
        }

        if (csucs.equals("H"))
        {
            if (lepes == 1) {
                validLepes = true;
                csucsok.add("G");
                szelek.add("GH");
            }
            if (lepes == 5) {
                validLepes = true;
                csucsok.add("E");
                szelek.add("EH");
            }
            if (lepes == 6) {
                validLepes = true;
                csucsok.add("D");
                szelek.add("DH");
            }
            if (validLepes == false) {
                valid = false;
            }
        }


        if (csucs.equals("D"))
        {
            if (lepes == 1) {
                validLepes = true;
                csucsok.add("C");
                szelek.add("CD");
            }
            if (lepes == 5) {
                validLepes = true;
                csucsok.add("A");
                szelek.add("AD");
            }
            if (lepes == 3) {
                validLepes = true;
                csucsok.add("H");
                szelek.add("DH");
            }
            if (validLepes == false) {
                valid = false;
            }
        }

        if (csucs.equals("C"))
        {
            if (lepes == 4) {
                validLepes = true;
                csucsok.add("D");
                szelek.add("CD");
            }
            if (lepes == 5) {
                validLepes = true;
                csucsok.add("B");
                szelek.add("BC");
            }
            if (lepes == 3) {
                validLepes = true;
                csucsok.add("G");
                szelek.add("CG");
            }
            if (validLepes == false) {
                valid = false;
            }
        }
    }

    public int taskB()
    {
        //System.out.println(csucsok.contains("A"));
        if (csucsok.contains("A")&&csucsok.contains("B")&&csucsok.contains("C")&&csucsok.contains("D")&&csucsok.contains("E")&&csucsok.contains("F")&&csucsok.contains("G")&&csucsok.contains("H"))
        {
            return 1;
        }
        else return 0;
    }

    public int taskC()
    {
        if(szelek.contains("AB")&&szelek.contains("AD")&&szelek.contains("AE")&&szelek.contains("BC")&&szelek.contains("BF")&&szelek.contains("EF")&&szelek.contains("EH")&&szelek.contains("FG")&&szelek.contains("GH")&&szelek.contains("DH")&&szelek.contains("CD")&&szelek.contains("CG"))
            return 1;
        else return  0;
    }

}