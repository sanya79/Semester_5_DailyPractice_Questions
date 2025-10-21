import java.util.ArrayList;  
import java.util.List;  

class Solution {  
    static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };  

    public List<String> letterCombinations(String digits) {  
        List<String> ll = new ArrayList<>();  
        if (digits.length() == 0) {  
            return ll;  
        }  
        Print(digits, "", ll); 
        return ll;        
    }  

    public static void Print(String ques, String ans, List<String> ll) {  
        if (ques.length() == 0) {  
            ll.add(ans);  
            return;  
        }  
        char ch = ques.charAt(0);  
        String getString = key[ch - '0'];   
        for (int i = 0; i < getString.length(); i++) {  
            
            Print(ques.substring(1), ans + getString.charAt(i), ll);  
        }  
    }  
}