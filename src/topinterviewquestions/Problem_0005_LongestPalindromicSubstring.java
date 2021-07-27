package topinterviewquestions;
//ac
//Manacher Algorithm
public class Problem_0005_LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        char[] str = manacherString(s);
        int R = -1;
        int C = -1;
        int res = Integer.MIN_VALUE;
        int[] pArr = new int[str.length];
        for(int i = 0;i < pArr.length;i++){
            pArr[i] = R > i? Math.min(pArr[2*C-i],R-i):1;

            while(i+pArr[i] < str.length && i-pArr[i] > -1){
                if(str[i+pArr[i]] == str[i-pArr[i]]){
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i+pArr[i] > R){
                R = i+pArr[i];
                C = i;
            }
            res = Math.max(res,R-i);
        }
        char[] resString = new char[res-1];
        //左通过下标变换得到,下标变换有点难写
        for(int i = 0;i < pArr.length;i++){
            if(pArr[i] == res){
                int index = i-res+2;
                for(int j = 0;j < resString.length;j++){
                    resString[j] = str[index];
                    index+=2;
                }
                break;
            }
        }

        return String.valueOf(resString);
    }
    public static char[] manacherString(String s){
        char[] charArr = s.toCharArray();
        char[] res = new char[charArr.length*2+1];
        int index = 0;
        for(int i = 0;i < res.length;i++){
            res[i] = (i&1)==0? '#':charArr[index++];
        }
        return res;
    }
}
