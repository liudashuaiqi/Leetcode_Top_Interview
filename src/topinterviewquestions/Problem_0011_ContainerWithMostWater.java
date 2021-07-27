package topinterviewquestions;
//蓄水容器 training003->class02
//ac
public class Problem_0011_ContainerWithMostWater {
    //哪个杆子小,就结算谁,求的是总的最大水量有没有可能继续往上提升,并不是求的每一个杆子的最优解,挺难想！
    //关于可能性舍弃的问题,在训练营1~5期见过3道
    public static int maxArea(int[] h) {
        int l = 0;
        int r = h.length-1;
        int max = 0;
        while(l < r){
            max = Math.max(max,Math.min(h[l],h[r])*(r-l));
            if(h[l] > h[r]){
                r--;
            }else {
                l++;
            }
        }
        return max;
    }
}
