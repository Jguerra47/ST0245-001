public class Array2
{
    public int countEvens(int[] nums) {
        int respuesta = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i]%2 == 0){
                respuesta++;
            }
        }
        return respuesta;
    }

    public int bigDiff(int[] nums) {
        int vG = nums[0];
        int vP = nums[0];
        for(int i=0; i<nums.length; i++){
            vG = Math.max(vG, nums[i]);
            vP = Math.min(vP, nums[i]);
        }
        return vG-vP;
    }

    public boolean lucky13(int[] nums) {
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == 1 || nums[i] == 3) {
                return false;
            }
        }
        return true;
    }

    public boolean no14(int[] nums) {
        boolean n1 = true;
        boolean n4 = true;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                n1 = false;
            }
            if(nums[i] == 4){
                n4 = false;
            }
        }
        return n1 || n4;
    }

    public boolean only14(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != 1 && nums[i] != 4){
                return false;
            }
        }
        return true;
    }
}
