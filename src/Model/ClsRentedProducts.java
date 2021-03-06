package Model;

import java.util.Date;

/**
 *
 * @author anarvaezgo
 */
public class ClsRentedProducts {

    //Attributes
    private ClsClient aClient;
    private ClsReference aProduct;
    private String aRentalDate;
    private String aReturnDate;
    private double aAmount;

    /**
     * rent a product
     *
     * @param aClient
     * @param aProduct
     * @param aRentalDate
     * @param aReturnDate
     * @param aAmount
     */
    public ClsRentedProducts(ClsClient aClient, ClsReference aProduct, String aRentalDate, String aReturnDate, double aAmount) {
        this.aClient = aClient;
        this.aProduct = aProduct;
        this.aRentalDate = aRentalDate;
        this.aReturnDate = aReturnDate;
        this.aAmount = aAmount;
    }

    /**
     * initialize own attributes
     */
    public ClsRentedProducts() {
        this.aClient = aClient;
        this.aProduct = aProduct;
        this.aRentalDate = aRentalDate;
        this.aReturnDate = aReturnDate;
        this.aAmount = 0.0;
    }

    /**
     * Getter and Setter
     *
     * @return
     */
    public ClsClient getaClient() {
        return aClient;
    }

    public void setaClient(ClsClient aClient) {
        this.aClient = aClient;
    }

    public ClsReference getaProduct() {
        return aProduct;
    }

    public void setaProduct(ClsReference aProduct) {
        this.aProduct = aProduct;
    }

    public String getaRentalDate() {
        return aRentalDate;
    }

    public void setaRentalDate(String aRentalDate) {
        this.aRentalDate = aRentalDate;
    }

    public String getaReturnDate() {
        return aReturnDate;
    }

    public void setaReturnDate(String aReturnDate) {
        this.aReturnDate = aReturnDate;
    }

    public double getaAmount() {
        return aAmount;
    }

    public void setaAmount(double aAmount) {
        this.aAmount = aAmount;
    }
}
