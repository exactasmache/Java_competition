import java.util.ArrayList;
import java.util.List;

class SuggestWithMerge {
    private void merge(String[] a, String[] l, String[] r) {
        int left = l.length, right = r.length; 
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].compareTo(r[j]) < 0)
                a[k++] = l[i++];
            else
                a[k++] = r[j++];
        }
        
        while (i < left)
            a[k++] = l[i++];
        
        while (j < right)
            a[k++] = r[j++];
    }
    
    private void mergeSort(String[] a) {
        int n = a.length;
        if (n < 2)
            return;
        
        int mid = n / 2;
        String[] l = new String[mid];
        String[] r = new String[n - mid];

        for (int i = 0; i < mid; i++)
            l[i] = a[i];
        
        for (int i = mid; i < n; i++)
            r[i - mid] = a[i];
        
        mergeSort(l);
        mergeSort(r);

        merge(a, l, r);
    }
    
    private String[] arrayListToArray(ArrayList<String> arr) {
        String str[] = new String[arr.size()]; 
        for (int j = 0; j < arr.size(); j++)
            str[j] = arr.get(j);
        return str;
    }
    
    private String[] filterAndMergeSort(String[] a, String f) {
        int n = a.length;
        if (n < 2)
            return a;
        
        int mid = n / 2;
        ArrayList<String> l = new ArrayList<String>();
        ArrayList<String> r = new ArrayList<String>();
        
        for (int i = 0; i < mid; i++) {
            if (a[i].startsWith(f))
                l.add(a[i]);
        }
        
        for (int i = mid; i < n; i++) {
            if (a[i].startsWith(f))
                r.add(a[i]);
        }
        String[] left = arrayListToArray(l);
        String[] right = arrayListToArray(r);
        a = new String[left.length + right.length];
        mergeSort(left);
        mergeSort(right);
        
        merge(a, left, right);
        return a;
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (searchWord.length() == 0 || products.length == 0)
            return new ArrayList<>();
        
        // We sort the array.-
        // Arrays.sort(products);
        products = filterAndMergeSort(products, searchWord.substring(0,1));
        
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