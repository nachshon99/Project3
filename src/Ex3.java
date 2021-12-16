public class Ex3 {
    public static final int INITIALIZE = 0;
    public static final int DIVIDING_FACTOR = 2;
    public static final int LENGTH_ARRAY = 15;

    public static void main(String[] args) {
        int[] factors = factorize(12600);
        for (int i = 0; i < factors.length; i++){
            System.out.print(factors[i] + ", ");
        }
    }

    public static int[] factorize (int num){
        int[]factors = new int[LENGTH_ARRAY];
        int lengthOfArray = INITIALIZE;
        int factorOfDivided = DIVIDING_FACTOR;
        int indexOfArray = INITIALIZE;
        if(num > INITIALIZE) {
            while (num >= factorOfDivided){
                if(num % factorOfDivided == INITIALIZE){
                    do{
                        factors[indexOfArray] = factorOfDivided;
                        lengthOfArray++;
                        indexOfArray++;
                        num /= factorOfDivided;
                    }while (num % factorOfDivided == INITIALIZE && num >= factorOfDivided);
                }
                factorOfDivided++;
            }
            int[] newFactors = new int[lengthOfArray];
            for (int i = 0; i < lengthOfArray; i++){
                newFactors[i] = factors[i];
            }
            return newFactors;
        }
        else {
            System.out.println("The number is negative!");
        }
        return factors;
    }
}
