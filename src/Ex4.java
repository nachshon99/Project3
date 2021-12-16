public class Ex4 {
    public static void main(String[] args) {
        int[]arr = {8,3,5,4,6,7};
        int[]arr1 = {14,13,12,11,10};
        System.out.println(isFullArray(arr));
        System.out.println(isFullArrayDescending(arr1));
    }

    public static boolean isFullArray(int[]arr){
        int currentInt = minValue(arr);
        boolean fullArray = false;
        for (int i = 0; i < arr.length;i++){
            for (int j = 0; j < arr.length;j++){
                if(currentInt == arr[j]){
                    fullArray = true;
                    currentInt++;
                    break;
                }
                else {
                    fullArray = false;
                }
            }
        }
        return fullArray;
    }

    public static boolean isFullArrayDescending(int[]arr){
        int currentInt = maxValue(arr);
        boolean fullArray = false;
        for (int i = 0; i < arr.length;i++){
            if(currentInt == arr[i]){
                fullArray = true;
                currentInt--;
            }else {
                fullArray = false;
                break;
            }
        }
        return fullArray;
    }

    public static int maxValue(int[]arr){
        int max = arr[0];
        for (int i = 1; i < arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int minValue(int[]arr){
        int min = arr[0];
        for (int i = 0; i < arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

}
