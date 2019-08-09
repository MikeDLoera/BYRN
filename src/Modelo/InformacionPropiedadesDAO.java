
package Modelo;

/**
 *
 * @author CST-UTJ
 */
public class InformacionPropiedadesDAO {
    private Estates estate;

    public InformacionPropiedadesDAO(Estates estate) {
        this.estate = estate;
    }

    public Estates getEstate() {
        return estate;
    }

    public void setEstate(Estates estate) {
        this.estate = estate;
    }
    
}
