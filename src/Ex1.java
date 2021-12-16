public class Ex1 {
    public static final int LENGTH = 1;
    public static final int ZERO = 0;
    public static final int CHECK_CONDITIONS = -1;
    public static final int DIVIDING_FACTOR = 10;
    public static final int DIVIDING_FACTOR2 = 2;
    public static final int CONDITION = 1;

    public static void main(String[] args) {
        int number = 12329;
        int[]numbers = {344,556,78,2589,221};
        System.out.println(alternatingNumber(number));
        System.out.println(indexOfAlternatingNumberThatSumDigitsIsSmaller(numbers));

    }

    public static boolean alternatingNumber(int number) {
        String num = Integer.toString(number);
        boolean isFirstEven = false;
        boolean isEven = false, isOdd = false;
        if(number > ZERO) {
            if (num.length() == LENGTH) {
                return true;
            }
            if (num.charAt(0) % DIVIDING_FACTOR2 == ZERO) {
                isFirstEven = true;
            }
            for (int i = 0; i < num.length(); i++) {
                if (isFirstEven) {
                    if (i % DIVIDING_FACTOR2 == ZERO) {
                        isEven = isEven(num,i);
                        if(!isEven){
                            break;
                        }
                    } else {
                        isOdd = isOdd(num,i);
                        if(!isOdd){
                            break;
                        }
                    }
                }
                else {
                    if (i % DIVIDING_FACTOR2 == ZERO) {
                        isOdd = isOdd(num, i);
                        if (!isOdd) {
                            break;
                        }
                    }
                    else {
                        isEven = isEven(num, i);
                        if (!isEven) {
                            break;
                        }
                    }
                }
            }
        }
        if(isEven && isOdd){
            return true;
        }

        return false;
    }

    public static boolean isEven(String num, int index){
        boolean isEven = false;
        if(num.charAt(index) % DIVIDING_FACTOR2 == ZERO){
            isEven = true;
        }
        return isEven;
    }

    public  static boolean isOdd(String num, int index){
        boolean isOdd = false;
        if(num.charAt(index) % DIVIDING_FACTOR2 != ZERO){
            isOdd = true;
        }
        return isOdd;
    }

    public static int indexOfAlternatingNumberThatSumDigitsIsSmaller(int[]arr){
        int min = sumDigits(firstAlternation(arr));
        int index = ZERO;
        if(firstAlternation(arr) != CHECK_CONDITIONS){
            for (int i = 0; i < arr.length; i++){
                if(arr[i] > ZERO) {
                    if (alternatingNumber(arr[i])) {
                        if (sumDigits(arr[i]) <= min) {
                            min = sumDigits(arr[i]);
                            index = i;
                        }
                    }
                }
                else {
                    System.out.println("The array contains a negative number");
                    return CHECK_CONDITIONS;
                }
            }
        }
        else {
            return CHECK_CONDITIONS;
        }
        return index;
    }

    public static int firstAlternation(int[]arr){
        for (int j = 0; j < arr.length;j++){
            if(alternatingNumber(arr[j])){
                return arr[j];
            }
        }
        return CHECK_CONDITIONS;
    }

    public static int sumDigits(int number){
        int sum = ZERO;
        while (number >= CONDITION){
            sum += number % DIVIDING_FACTOR;
            number /= DIVIDING_FACTOR;
        }
        return sum;
    }
}
