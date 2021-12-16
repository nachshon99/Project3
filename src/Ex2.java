public class Ex2 {
    public static final int INITIALIZE = 0;
    public static final int DIVIDING_FACTOR = 10;
    public static final int CONDITION = 1;

    public static void main(String[] args) {
        int[]arr1 = {32,67,29,15};
        int[]arr2 = {2,52};
        System.out.println(indexOfProximityLevelHigher(arr1,arr2));
    }

    public static int indexOfProximityLevelHigher(int[]arr1, int[]arr2){
        int proximityLevel1 = INITIALIZE;
        int index = INITIALIZE;
        int proximityLevel2 = INITIALIZE;
        for (int i = 0; i < arr1.length;i++){
            int currentInt = sumDigits(arr1[i]);
            for (int j = 0; j < arr2.length; j++){
                if(currentInt == sumDigits(arr2[j])){
                    proximityLevel1++;
                }
            }
            if(proximityLevel1 > proximityLevel2){
                proximityLevel2 = proximityLevel1;
                proximityLevel1 = INITIALIZE;
                index = i;
            }
        }
        if(proximityLevel2 == INITIALIZE){
            return INITIALIZE;
        }
        return index;
    }

    public static int sumDigits(int number){
        int sum = INITIALIZE;
        while (number >= CONDITION){
            sum += number % DIVIDING_FACTOR;
            number /= DIVIDING_FACTOR;
        }
        return sum;
    }
}
