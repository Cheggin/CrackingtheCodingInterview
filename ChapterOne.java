import java.util.ArrayList;
import java.util.HashMap;

public class ChapterOne{
    public static void main(String[] args){
        System.out.println(oneAway("pale", "paesle"));
        
    }
    public static boolean isUnique(String a){ //for each character check if it has a duplicate
        for(int i = 0; i< a.length()-1; i++){
            for(int j = i+1; j < a.length(); j++){
                if(a.charAt(i) == a.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkPermutation(String a, String b){ //.replace() only replaces one characters, so using .replace() for both strings for each character in each string should result in two equal strings if they are permutations of one another
        if(a.length() != b.length()){
            return false;
        }
        for(int i = 0; i< a.length(); i++){
            String curr = a.substring(i, i+1);
            a = a.replace(curr, " ");
            b = b.replace(curr, " ");    
        }
        if(!(a.equals(b))){
            return false;
        }
        return true;
    }
    public static char[] URLify(char[] a, int length){ //use a separate array to add appropriate values(either %20 or the nonspace character)
        char[] ans = new char[length];
        int index = 0;
        for(char i: a){
            if(i != ' '){
                ans[index] = i;
                index++;
            }
            else{
                ans[index] = '%';
                ans[index+1] = '2';
                ans[index+2] = '0';
                index+=3;
            }
        }
        return ans;
    } 
    public static boolean palindromePermutation(String a){ //store all characters and their counts in a hashmap, look over it to see if there are more odds than 1(because you can only have 1 odd count in a palindrome) 
        int odds = 0;
        a = a.toLowerCase();
        a= a.replaceAll(" ", "");
        HashMap<Character, Integer> characters = new HashMap<>();
        for(int i =0; i < a.length(); i++){
            Character curr=  a.charAt(i);
            if(characters.containsKey(curr)){
                characters.put(curr, characters.get(curr) + 1);
            }
            else{
                characters.put(curr, 1);
            }
        }
        for(Character i: characters.keySet()){
            if(characters.get(i)%2 != 0){
                odds++;
                System.out.println((i));
            }
            if(odds > 1){
                return false;
            }
        }
        return true;
        
    }
    public static boolean oneAway(String a, String b){
        if(Math.abs(a.length() - b.length()) > 1){ //only one space for error available
            return false;
        }
        int differences = 0;
        if(a.length() == b.length()){ //if lengths are equal, you can only have one difference(e.g. pale, bale)
            for(int i =0; i< a.length(); i++){
                if(a.charAt(i) != b.charAt(i)){
                    differences++;
                }
            }
            return differences >1;
        }
        int inda = 0; //index for String a
        int indb = 0; //index for String b
        boolean skipped = false;
        while(inda < a.length() && indb < b.length()){ //while indexes in bounds
            if(a.charAt(inda) != b.charAt(indb)){
                if(skipped){ //you can only skip one character(e.g. pale, ple would skip 'a')
                    return false;
                }
                if(a.length() > b.length()){
                    inda++;
                }
                else{
                    indb++;
                }
                skipped = true;
            }
            else{
                inda++;
                indb++;
            }
        }
        return true;
    }
    public static String stringCompression(String a){
        String ans = "";
        


        if(a.length() <= ans.length()){
            return a;
        }
        return ans;
    }
}