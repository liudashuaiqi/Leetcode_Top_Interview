package topinterviewquestions;
//ac
//把s字符串全都转换成对应的数字,如果此数字比后面的大,就取正,否则,就取负
public class Problem_0013_RomanToInteger {
    public static int romanToInt(String s) {
        int[] nums = new int[s.length()];
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i)=='I'){
                nums[i] = 1;
            }else if(s.charAt(i)=='V'){
                nums[i] = 5;
            }else if(s.charAt(i)=='X'){
                nums[i] = 10;
            }else if(s.charAt(i) == 'L'){
                nums[i] = 50;
            }else if(s.charAt(i) == 'C'){
                nums[i] = 100;
            }else if(s.charAt(i) == 'D'){
                nums[i] = 500;
            }else if(s.charAt(i) == 'M'){
                nums[i] = 1000;
            }
        }
        int sum = 0;
        for(int i = 0;i < nums.length-1;i++){
            if(nums[i] < nums[i+1]){
                sum -= nums[i];
            }else {
                sum += nums[i];
            }
        }
        return sum+nums[nums.length-1];
    }
}
