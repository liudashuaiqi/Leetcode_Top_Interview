package topinterviewquestions;
//ac
//对于每一个字符串来说,跟第一个字符串去比较，抓取最小的公共前缀即为答案。
public class Problem_0014_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String s = strs[0];
        int min = Integer.MAX_VALUE;
        for(String str:strs){
            int x = 0;
            int y = 0;
            while(x < s.length() && y < str.length()){
                if(s.charAt(x)==str.charAt(y)){
                    x++;
                    y++;
                }else{
                    break;
                }
            }
            min = Math.min(min,x);
            if(min == 0){
                return "";
            }
        }
        return s.substring(0,min);
    }
}
