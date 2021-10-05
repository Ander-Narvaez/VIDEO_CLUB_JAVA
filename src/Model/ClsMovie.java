package Model;

/**
 *
 * @author anarvaezgo
 */
public class ClsMovie extends ClsReference {

    //Attributes
    private String aGender;
    private int aYear;
    private String aDirector;
    private String aInterpreters;

    /**
     * receives the attributes of the father and those of the movie
     *
     * @param aGender
     * @param aYear
     * @param aDirector
     * @param aInterpreters
     * @param aTitle
     * @param aType
     * @param aPriceRental
     * @param aRentalTerm
     * @param aRented
     */
    public ClsMovie(String aGender, int aYear, String aDirector, String aInterpreters, String aTitle, String aType, double aPriceRental, int aRentalTerm, String aRented) {
        super(aTitle, aType, aPriceRental, aRentalTerm, aRented);
        this.aGender = aGender;
        this.aYear = aYear;
        this.aDirector = aDirector;
        this.aInterpreters = aInterpreters;
    }

    /**
     * initialize own attributes
     */
    public ClsMovie() {
        this.aGender = "";
        this.aYear = 0;
        this.aDirector = "";
        this.aInterpreters = "";
    }

    /**
     * Getter and Setter
     *
     * @return
     */
    public String getaGender() {
        return aGender;
    }

    public void setaGender(String aGender) {
        this.aGender = aGender;
    }

    public int getaYear() {
        return aYear;
    }

    public void setaYear(int aYear) {
        this.aYear = aYear;
    }

    public String getaDirector() {
        return aDirector;
    }

    public void setaDirector(String aDirector) {
        this.aDirector = aDirector;
    }

    public String getaInterpreters() {
        return aInterpreters;
    }

    public void setaInterpreters(String aInterpreters) {
        this.aInterpreters = aInterpreters;
    }
}
