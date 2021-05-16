import java.io.Serializable;

public class InvoiceRow implements Serializable{
    private Long objectId;

    private Long quantity;
    private Product product;
    private Double price;

    private Double rowNetAmount;    // total without tax
    private Double rowGrossAmount;  // total with tax

    public Long getObjectId() {
        return objectId;
    }
    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }
    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getRowNetAmount() {
        return rowNetAmount;
    }
    public void setRowNetAmount(Double rowNetAmount) {
        this.rowNetAmount = rowNetAmount;
    }
    public Double getRowGrossAmount() {
        return rowGrossAmount;
    }
    public void setRowGrossAmount(Double rowGrossAmount) {
        this.rowGrossAmount = rowGrossAmount;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
  

    

}
