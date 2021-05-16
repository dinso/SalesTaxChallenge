import java.io.Serializable;

public class Product implements Serializable{
   
    private Long objectId;
    private String productName;
    private Double basicTaxRate = 0.1d;
    private Double importDutyRate = 0.05d;
    private boolean isTaxExempt;
    private boolean isImportDutyApplicable;

    public Product(String productName) {
        this.productName = productName;
        if(productName.contains("imported")){
            this.importDutyRate = 0.05d;
            this.isImportDutyApplicable = true;
        }else{
            this.importDutyRate = 0d;
            this.isImportDutyApplicable = false;
        }

        this.isTaxExempt = Util.knowIsTaxExempt(productName);

    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getBasicTaxRate() {
        return basicTaxRate;
    }

    public void setBasicTaxRate(Double basicTaxRate) {
        this.basicTaxRate = basicTaxRate;
    }

    public Double getImportDutyRate() {
        return importDutyRate;
    }

    public void setImportDutyRate(Double importDutyRate) {
        this.importDutyRate = importDutyRate;
    }

    public boolean isTaxExempt() {
        return isTaxExempt;
    }

    public void setTaxExempt(boolean isTaxExempt) {
        this.isTaxExempt = isTaxExempt;
    }

    public boolean isImportDutyApplicable() {
        return isImportDutyApplicable;
    }

    public void setImportDutyApplicable(boolean isImportDutyApplicable) {
        this.isImportDutyApplicable = isImportDutyApplicable;
    }

    
}
