public class StringUtils {

    public Boolean isAnagram(String s1, String s2){
        Boolean isAnagr = true;
        for(char c : s1.toCharArray()){
            if(!s2.contains(c+"")){
                isAnagr = false;
            }
        }

        return isAnagr;
    }
}
