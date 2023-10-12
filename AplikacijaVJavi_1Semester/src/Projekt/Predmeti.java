package Projekt;

/**
 *
 * @author Gregor
 */
public class Predmeti {

    public Predmeti() {     //Konstruktor

        ID = "";
        Ime_predmeta = "";
        Letnik = 0;
        Semester = "";
        Ime_nosilca = "";
        ECTS = 0;
        Obveznosti = new String[st_obveznosti];
        Teza_predmetov = new String[st_obveznosti];
        Ocene = new String[st_obveznosti];
        Vrsta_obveznosti = new String[st_obveznosti];
        Ocena = 0;

    }

    public String getID() {
        return ID;
    }

    public void setID(String a) {
        ID = a;
    }

    public String getImePredmeta() {
        return Ime_predmeta;
    }

    public void setImePredmeta(String a) {
        Ime_predmeta = a;
    }

    public int getLetnik() {
        return Letnik;
    }

    public void setLetnik(int a) {
        Letnik = a;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String a) {
        Semester = a;
    }

    public String getImeNosilca() {
        return Ime_nosilca;
    }

    public void setImeNosilca(String a) {
        Ime_nosilca = a;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int a) {
        ECTS = a;
        IzracunajPridobljenECTS();
    }

    public void setObveznosti(String a) {
        if (a == "0") {
            Obveznosti = null;
        } else {
            Obveznosti = a.split(",");
        }

    }

    public String getObveznosti() {
        if (Obveznosti == null) {
            return ("0");
        } else {
            return (String.join(",", Obveznosti));
        }
    }

    public void setTezaPredmetov(String a) {
        if (a == "0") {
            Teza_predmetov = null;
        } else {
            Teza_predmetov = a.split(",");
        }

    }

    public String getTezaPredmetov() {
        if (Teza_predmetov == null) {
            return ("0");
        } else {
            return (String.join(",", Teza_predmetov));
        }
    }

    public void setOcene(String a) {
        if (a == "0") {
            Ocene = null;
        } else {
            Ocene = a.split(",");
        }

    }

    public String getOcene() {
        if (Ocene == null) {
            return ("0");
        } else {
            return (String.join(",", Ocene));
        }

    }

    public void setStObveznosti(int a) {
        st_obveznosti = a;
    }

    public int getStObveznosti() {
        return st_obveznosti;
    }

    public void setVrstaObveznosti(String a) {
        if (a == "0") {
            Vrsta_obveznosti = null;
        } else {
            Vrsta_obveznosti = a.split(",");
        }
    }

    public String getVrstaObveznosti() {
        if (Vrsta_obveznosti == null) {
            return ("0");
        } else {
            return (String.join(",", Vrsta_obveznosti));
        }
    }

    public double getOcena() {
        if (Obveznosti == null || Teza_predmetov == null || Ocene == null || Vrsta_obveznosti == null) {
            return (0);
        }
        setOcena();
        return Ocena;
    }

    private void setOcena() {       //Izračun končne ocene predmeta
       
        if (Obveznosti == null || Teza_predmetov == null || Ocene == null || Vrsta_obveznosti == null); else {
            Ocena = 0;

            int kolokvij = 0;
            double kolokvij_skupno = 0;
            double ocena_izpita = 0;
            boolean izpit = false;

            for (int i = 0; i < st_obveznosti; i++) {
                if (Vrsta_obveznosti[i].compareTo("1") == 0) //Računanje kolokvijev
                {
                    kolokvij++;
                    kolokvij_skupno += (Double.parseDouble(Ocene[i]) * ((Double.parseDouble(Teza_predmetov[i])) / 100));

                }
                if (Vrsta_obveznosti[i].compareTo("2") == 0) //Računanje izpita
                {
                    ocena_izpita = (Double.parseDouble(Ocene[i]) * ((Double.parseDouble(Teza_predmetov[i])) / 100));
                    izpit = true;

                }
            }

            if (kolokvij > 0) {
                Ocena = (kolokvij_skupno);
                //System.out.println(Ocena);
                //System.out.println(kolokvij);

                if (izpit == true && ocena_izpita > Ocena) //Z izpitom dosežena boljša ocena
                {
                    Ocena = ocena_izpita;

                    for (int i = 0; i < st_obveznosti; i++) {
                        if (Vrsta_obveznosti[i].compareTo("1") == 0 || Vrsta_obveznosti[i].compareTo("2") == 0); else {
                            Ocena += (Double.parseDouble(Ocene[i]) * ((Double.parseDouble(Teza_predmetov[i])) / 100));
                        }

                    }
                } else {
                    for (int i = 0; i < st_obveznosti; i++) //Z kolokvijem boljša ocena
                    {
                        if (Vrsta_obveznosti[i].compareTo("1") == 0 || Vrsta_obveznosti[i].compareTo("2") == 0); else {
                            Ocena += (Double.parseDouble(Ocene[i]) * ((Double.parseDouble(Teza_predmetov[i])) / 100));
                            //System.out.println(Ocene[i]);
                        }

                    }
                }
            } else //Ni kolokvijev
            {
                for (int i = 0; i < st_obveznosti; i++) {
                    Ocena += (Double.parseDouble(Ocene[i]) * ((Double.parseDouble(Teza_predmetov[i])) / 100));
                }
            }
            //System.out.println(Ocena);
        }
    }

    boolean getPredmetOpravljen() {
        setPredmetOpravljen();
        return predmet_opravljen;
    }

    void setPredmetOpravljen() {    //Izračuna ali je predmet opravljen
        int kolokvij = 0;
        int st_kol = 0;

        for (int i = 0; i < st_obveznosti; i++) {
            if (Vrsta_obveznosti[i].compareTo("1") == 0) {
                if (Integer.parseInt(Ocene[i]) < 30) {
                    //System.out.println("Napaka");
                    predmet_opravljen = false;
                    break;
                }

                kolokvij += Integer.parseInt(Ocene[i]);
                st_kol++;
            } else {

                if ((Ocena) < 50 || (Double.parseDouble(Ocene[i]) < 50)) {
                    //System.out.println("Napaka");
                    predmet_opravljen = false;
                    break;

                } else if (Ocena >= 50) {
                    predmet_opravljen = true;
                }
            }
        }

        if (st_kol > 0) {
            if ((kolokvij / st_kol) >= 50) {
                predmet_opravljen = true;
            }
            //System.out.println(kolokvij/st_kol);
        }

        for (int a = 0; a < st_obveznosti; a++) {
            if (Vrsta_obveznosti[a].compareTo("2") == 0 && Integer.parseInt(Ocene[a]) >= 50) {
                predmet_opravljen = true;
            }
        }

    }

    void IzracunajPridobljenECTS() {    
        if (Ocena >= 50 && predmet_opravljen == true) {
            PridobljenECTS = ECTS;
        } else {
            PridobljenECTS = 0;
        }
    }

    public int getPridobljenECTS() {
        return PridobljenECTS;
    }

    private String[] Obveznosti, Teza_predmetov, Ocene, Vrsta_obveznosti;
    //private int[] Teza_predmetov,Ocene;
    private String ID, Ime_predmeta, Semester, Ime_nosilca;
    private int Letnik, ECTS, st_obveznosti = 100, PridobljenECTS;
    private double Ocena;
    boolean predmet_opravljen;

}
