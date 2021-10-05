package Model;

/**
 *
 * @author anarvaezgo
 */
public class ClsReference {

    //Attributes
    private String aTitle;
    private String aType;
    private double aPriceRental;
    private int aRentalTerm;
    private String aRented;

    /**
     * build to load reference type object
     *
     * @param aTitle
     * @param aType
     * @param aPriceRental
     * @param aRentalTerm
     * @param aRented
     */
    public ClsReference(String aTitle, String aType, double aPriceRental, int aRentalTerm, String aRented) {
        this.aTitle = aTitle;
        this.aType = aType;
        this.aPriceRental = aPriceRental;
        this.aRentalTerm = aRentalTerm;
        this.aRented = aRented;
    }

    /**
     * initialize attributes
     */
    public ClsReference() {
        this.aTitle = "";
        this.aType = "";
        this.aPriceRental = 0.0;
        this.aRentalTerm = 0;
        this.aRented = "";
    }

    /**
     * Getter and Setter
     * @return 
     */

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public String getaType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    public double getaPriceRental() {
        return aPriceRental;
    }

    public void setaPriceRental(double aPriceRental) {
        this.aPriceRental = aPriceRental;
    }

    public int getaRentalTerm() {
        return aRentalTerm;
    }

    public void setaRentalTerm(int aRentalTerm) {
        this.aRentalTerm = aRentalTerm;
    }

    public String getaRented() {
        return aRented;
    }

    public void setaRented(String aRented) {
        this.aRented = aRented;
    }

    @Override
    public String toString() {
        return "Cls_Reference{" + "aTitle=" + aTitle + ", aType=" + aType + ", aPriceRental=" + aPriceRental + ", aRentalTerm=" + aRentalTerm + ", aRented=" + aRented + '}';
    }

}
