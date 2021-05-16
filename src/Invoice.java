import java.io.Serializable;
import java.util.Set;

public class Invoice implements Serializable {
    
    private Long objectId;

    private Set<InvoiceRow> invoiceRows;
    private Double netAmount;
    private Double grossAmount;
    private Double taxAmount;

    
    public Long getObjectId() {
        return objectId;
    }
    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }
    public Set<InvoiceRow> getInvoiceRows() {
        return invoiceRows;
    }
    public void setInvoiceRows(Set<InvoiceRow> invoiceRows) {
        this.invoiceRows = invoiceRows;
    }
    public Double getNetAmount() {
        return netAmount;
    }
    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }
    public Double getGrossAmount() {
        return grossAmount;
    }
    public void setGrossAmount(Double grossAmount) {
        this.grossAmount = grossAmount;
    }
    public Double getTaxAmount() {
        return Util.nearest5Percent(taxAmount);
    }
    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String printString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nOutput: \n");
        for (InvoiceRow invoiceRow : invoiceRows) {
            sb.append(invoiceRow.getQuantity()+" "+invoiceRow.getProduct().getProductName() +": "+invoiceRow.getRowGrossAmount()+"\n");
        }
        sb.append("Sales Tax: "+taxAmount+"\n");
        sb.append("Total: "+Util.roundPrice(grossAmount)+"\n");
        return sb.toString();
    }

}
