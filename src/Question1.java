import java.util.HashMap;

public class Question1 {

    public int[] Sum(int[] nums, int target){
        HashMap<Integer,Integer>map=new HashMap<>();
        int[]a=new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                a[0]=map.get(target-nums[i]);
                a[1]=i;
                break;
            }
            map.put(nums[i],i);
        }

        return a;
    }
}
