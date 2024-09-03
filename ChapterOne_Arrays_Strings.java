import java.util.HashMap;
public class ChapterOne_Arrays_Strings{
    public static void main(String[] args){
        System.out.println(stringRotation("erbottlewat", "waterbottle"));        
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
public static String stringCompression(String a){ //could be more efficient I think, just count starting at first index of character
    String ans = "";
    int i = 0;
    while(i < a.length()){
        String curr = a.substring(i, i+1);
        int j = i+1;
        int count = 1;
        while(j < a.length() && a.substring(j, j+1).equals(curr)){
            count++;
            j++;
        }
        i = j;
        ans += (curr + Integer.toString(count));
    }
    if(a.length() <= ans.length()){
        return a;
    }
    return ans;
}
public static int[][] rotateMatrix(int[][] a){
    int N = a.length;
    int[][] ans = new int[N][N];
    /*
    [ 1  2  3  4 
    5  6  7  8 
    9 10 11 12 
    13 14 15 16]
    (a,b) -->(b, N-a) such that N = length of matrix, given N x N dimensions
    */
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            ans[j][N-i-1] = a[i][j];
        }
    }
    return ans;
}
public static int[][] zeroMatrix(int[][] a){
    int M = a.length;
    int N = a[0].length;
    int[][] ans = new int[M][N];
    for(int i = 0; i< M; i++){ //lol because it initializes to all zeroes it causes problems; set all values to 1
        for(int j =0; j < N; j++){
            ans[i][j] = 1;
        }
    }
    for(int i = 0; i< M; i++){ //preset zeroes in ans array to avoid duplicates
        for(int j =0; j < N; j++){
            if(a[i][j] == 0){
                for(int row = 0; row < M; row++){
                    ans[row][j] = 0;
                }
                for(int col = 0; col < N; col++){
                    ans[i][col] = 0;
                }
            }
        }
    }
    for(int i = 0; i< M; i++){ //fill in all the spots that zeroes are not in :D
        for(int j =0; j < N; j++){
            if(ans[i][j] == 0){
                continue;
            }
            else{
                ans[i][j] = a[i][j];
            }
        }
    }
    return ans;
}
public static boolean stringRotation(String s1, String s2){//theoretically, just brute force every single "cut" of the string
    for(int i =0; i< s1.length(); i++){
        String combined = s1.substring(i, s1.length()) + s1.substring(0, i);
        if(combined.equals(s2)){
            return true;
        }
    }
    return false;
}
public static boolean isSubstring(String sub, String full){ //for stringRotation, I didn't use it lol
    if(full.contains(sub)){
        return true;
    }
    return false;
}
}
