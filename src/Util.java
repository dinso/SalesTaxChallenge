import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Util {
    
    private static Set<String> exemptItems = null;
	static	{
		exemptItems = new HashSet<String>();
		exemptItems.add("book");
		exemptItems.add("pills");
		exemptItems.add("chocolate");
		exemptItems.add("pill");

    }

    public static boolean knowIsTaxExempt(String productName){
        // get count of how many times does the product name contains exempted pruducts.
        long count =  exemptItems.stream().filter(i->productName.contains(i)).count();
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    static public double nearest5Percent(double amount) {
		return new BigDecimal(Math.ceil(amount * 20)/20).setScale(2,RoundingMode.HALF_UP).doubleValue();

	}

    public static double roundPrice(double amount) {
		return new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();

	}

}
