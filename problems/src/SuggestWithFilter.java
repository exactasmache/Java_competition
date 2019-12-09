import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SuggestWithFilter {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (searchWord.length() == 0 || products.length == 0)
            return new ArrayList<>();
        
        String f = "" + searchWord.charAt(0);
        products = Arrays.stream(products).filter(p -> p.startsWith(f)).toArray(String[]::new);
		Arrays.sort(products);
        
        List<List<String>> ret = new ArrayList<>();
        String filter = "";
        int lastFound = 0;
        for (int c = 0; c < searchWord.length(); c++) {
            filter += searchWord.charAt(c);
            List<String> subRet = new ArrayList<String>();
            for (int i = lastFound; i < products.length; i++) {
                // find for the first that fits:
                if (products[i].startsWith(filter)) {
                    //add this and the next 3 words to subRet. Careful with the edge case!
                    subRet.add(products[i]);
                    lastFound = i;
                    for (int j = 1; j < 3 && i+j < products.length; j++) {
                        if (products[i+j].startsWith(filter))
                            subRet.add(products[i+j]);
                        else
                            break;
                    }
                    break;
                }
            }
            ret.add(subRet);
        }
        
        return ret;
    }
}