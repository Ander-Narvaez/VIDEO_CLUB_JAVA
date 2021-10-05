package Model;


/**
 *
 * @author anarvaezgo
 */
public class ClsClient {

    //Attributes
    private int aId;
    private String aName;
    private String aAddres;
    private int aTelephone;

    public ClsClient(int aId, String aName, String aAddres, int aTelephone) {
        this.aId = aId;
        this.aName = aName;
        this.aAddres = aAddres;
        this.aTelephone = aTelephone;
    }

    /**
     * initialize own attributes
     */
    public ClsClient() {
        this.aId = 0;
        this.aName = "";
        this.aAddres = "";
        this.aTelephone = 0;
    }

    /**
     * Getter and Setter
     *
     * @return
     */

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaAddres() {
        return aAddres;
    }

    public void setaAddres(String aAddres) {
        this.aAddres = aAddres;
    }

    public int getaTelephone() {
        return aTelephone;
    }

    public void setaTelephone(int aTelephone) {
        this.aTelephone = aTelephone;
    }

    @Override
    public String toString() {
        return "ClsClient{" + "aId=" + aId + ", aName=" + aName + ", aAddres=" + aAddres + ", aTelephone=" + aTelephone + '}';
    }
}
