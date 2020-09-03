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
    
    public int[] fix34(int[] nums) {
        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] == 3){
                for(int j = 0; j < nums.length; j++){
                    if(nums[j] == 4 && nums[j-1]!=3){
                        int aux = nums[i+1];
                        nums[i+1] = nums[j];
                        nums[j] = aux;
                        break;
                    }
                }
            }
        }
        return nums;
    }

    public int[] fix45(int[] nums) {
        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] == 4){

                for(int j = 1; j < nums.length; j++){
                    if((nums[j] == 5 && nums[j-1] != 4)){
                        int aux = nums[i+1];
                        nums[i+1] = nums[j];
                        nums[j] = aux;
                        break;
                    }
                    else if(nums[0] == 5){
                        int aux = nums[i+1];
                        nums[i+1] = nums[0];
                        nums[0] = aux;
                        break;
                    }
                }
            }
        }
        return nums;
    }
}
