import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * main
 */
public class main {

    public static void main(String[] args) {
        
        System.out.println("Please Enter number of invoice rows:");
        Scanner sc = new Scanner(System.in);
        int rowNumber = sc.nextInt();

        System.out.println("Please Enter your input Invoice Rows to calculate in below format:");
        System.out.println("<quantity><space><item_name><space>at<space><price>:\n");

        List<String> rows = new ArrayList<>();

        for(int i=0; i<rowNumber; i++){
            rows.add(System.console().readLine());
        }
        sc.close();
        Set<InvoiceRow> invoiceRows = InvoiceRowUtil.invoiceRowSerializer(rows);
        Invoice calculatedInvoice = InvoiceRowUtil.calculatInvoiceRows(invoiceRows);

        System.out.println(calculatedInvoice.printString());

    }
}