package pojo;

public class ItemPrices {

    private String product;
    private int id;
    private String usd;
    private String eur;
    private String pnd;

    // si solo se usa para parsear de json a pojo no requiere constructor
    public ItemPrices(String _product, int _id, String _eur, String _usd, String _pnd){
        this.setProduct(_product);
        this.setId(_id);
        this.setUsd(_usd);
        this.setPnd(_pnd);
        this.setEur(_eur);
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEur() {
        return eur;
    }

    public void setEur(String eur) {
        this.eur = eur;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    public String getPnd() {
        return pnd;
    }

    public void setPnd(String pnd) {
        this.pnd = pnd;
    }


    @Override
    public String toString(){
        return (String.format("usd: %s and pnd: %s", usd,pnd));
    }
}
