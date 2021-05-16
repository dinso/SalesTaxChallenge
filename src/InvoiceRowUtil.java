import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvoiceRowUtil {

    
    
    /**
     * Takes in a list of string of input in format <quantity><space><item_name><space>at<space><price> 
     * and extracts values from string and returns a List of object with the data
     * @param inputs
     * @return
     */
    public static Set<InvoiceRow> invoiceRowSerializer(List<String> inputs){
        Set<InvoiceRow> results = new HashSet<>();
        String regex = "([0-9]+)\\s([imported]*[a-zA-Z\\s]+)\\sat\\s([0-9]+\\.*[0-9]+)";

        for (String input : inputs) {
            Pattern p = Pattern.compile(regex);
            Matcher matcher = p.matcher(input);

            if(matcher.find()){
                InvoiceRow oneRow = new InvoiceRow();
                oneRow.setQuantity(Long.valueOf(matcher.group(1)));
                oneRow.setProduct(new Product(matcher.group(2)));
                oneRow.setPrice(Double.valueOf(matcher.group(3)));
               
                results.add(oneRow);
            }       

        }
        return results;
    }


    public static Invoice calculatInvoiceRows(Set<InvoiceRow> invoiceRows){
        Invoice invoiceCalculated = new Invoice();
        Double invoiceTaxAmount = 0d;
        Double invoiceGrossAmount = 0d;
        for (InvoiceRow invoiceRow : invoiceRows) {
            Double netAmount = invoiceRow.getQuantity() * invoiceRow.getPrice();
            Double rowTaxAmount = netAmount * invoiceRow.getProduct().getBasicTaxRate();
            // additional tax added only if import duty applicable
            if(invoiceRow.getProduct().isImportDutyApplicable()){
                rowTaxAmount = rowTaxAmount + (rowTaxAmount * invoiceRow.getProduct().getImportDutyRate());
            }

            Double grossAmountRow = netAmount + rowTaxAmount;

            invoiceRow.setRowNetAmount(netAmount);
            invoiceRow.setRowGrossAmount(grossAmountRow);
            invoiceTaxAmount += rowTaxAmount;
            invoiceGrossAmount += grossAmountRow;
        }

        invoiceCalculated.setTaxAmount(invoiceTaxAmount);
        invoiceCalculated.setGrossAmount(invoiceGrossAmount);
        invoiceCalculated.setInvoiceRows(invoiceRows);
        return invoiceCalculated;
    }

}
