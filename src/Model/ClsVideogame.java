package Model;

/**
 *
 * @author anarvaezgo
 */
public class ClsVideogame extends ClsReference {

    //Attributes
    private String aStyle;
    private String aPlatform;

    /**
     * receives the attributes of the father and those of the videogame
     *
     * @param aStyle
     * @param aPlatform
     * @param aTitle
     * @param aType
     * @param aPriceRental
     * @param aRentalTerm
     * @param aRented
     */
    public ClsVideogame(String aStyle, String aPlatform, String aTitle, String aType, double aPriceRental, int aRentalTerm, String aRented) {
        super(aTitle, aType, aPriceRental, aRentalTerm, aRented);
        this.aStyle = aStyle;
        this.aPlatform = aPlatform;
    }

    /**
     * initialize own attributes
     */
    public ClsVideogame() {
        this.aStyle = "";
        this.aPlatform = "";
    }

    /**
     * Getter and Setter
     *
     * @return
     */
    public String getaStyle() {
        return aStyle;
    }

    public void setaStyle(String aStyle) {
        this.aStyle = aStyle;
    }

    public String getaPlatform() {
        return aPlatform;
    }

    public void setaPlatform(String aPlatform) {
        this.aPlatform = aPlatform;
    }

}
