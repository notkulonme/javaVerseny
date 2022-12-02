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
            if (lepes == 4) {
                validLepes = true;
                csucsok.add("A");
            }
            if (lepes == 2) {
                validLepes = true;
                csucsok.add("C");
            }
            if (lepes == 3) {
                validLepes = true;
                csucsok.add("F");
            }
            if (validLepes == false) {
                valid = false;
            }

        }

        if (csucs.equals("B")) {
            if (lepes == 1) {
                validLepes = true;
                csucsok.add("B");
            }
            if (lepes == 2) {
                validLepes = true;
                csucsok.add("B");
            }
            if (lepes == 3) {
                validLepes = true;
                csucsok.add("E");
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
            }
            if (lepes == 2) {
                validLepes = true;
                csucsok.add("H");
            }
            if (lepes == 6) {
                validLepes = true;
                csucsok.add("A");
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
            }
            if (lepes == 2) {
                validLepes = true;
                csucsok.add("G");
            }
            if (lepes == 6) {
                validLepes = true;
                csucsok.add("B");
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
            }
            if (lepes == 5) {
                validLepes = true;
                csucsok.add("F");
            }
            if (lepes == 6) {
                validLepes = true;
                csucsok.add("C");
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
            }
            if (lepes == 5) {
                validLepes = true;
                csucsok.add("E");
            }
            if (lepes == 6) {
                validLepes = true;
                csucsok.add("D");
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
            }
            if (lepes == 5) {
                validLepes = true;
                csucsok.add("A");
            }
            if (lepes == 3) {
                validLepes = true;
                csucsok.add("H");
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
            }
            if (lepes == 5) {
                validLepes = true;
                csucsok.add("B");
            }
            if (lepes == 3) {
                validLepes = true;
                csucsok.add("G");
            }
            if (validLepes == false) {
                valid = false;
            }
        }
    }




}
