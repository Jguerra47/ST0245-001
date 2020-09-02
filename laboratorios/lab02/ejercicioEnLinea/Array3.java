public class Array3
{
    public int maxSpan(int[] nums) {
        int span = 0;
        int aux = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    aux = Math.abs(i-j)+1;
                    span = Math.max(aux,span);
                }
            }
        }
        return span;
    }

    public int maxMirror(int[] nums) {
        int aux = 0;
        int cont = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j >= 0; j--) {
                for (int k = 0; k < nums.length-i && k <= j; k++){
                    if (nums[i+k] == nums[j-k]){
                        aux++;
                        cont = Math.max(cont, aux);
                    }
                    else {
                        aux = 0;
                        break;
                    }
                }
                aux = 0;
            }
        }
        return cont;
    }

    public int countClumps(int[] nums) {
        int clump = 0;
        int cont = 0;

        for (int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                cont++;
            }

            if(nums[i] != nums[i+1] || i == nums.length-2){
                if(cont > 0){
                    clump++;
                    cont = 0;
                }
            }
        }
        return clump;
    }
}
