import java.util.Random;
import java.util.Scanner;

public class Ex9 {
    public static final int MAX_OPTION = 4;
    public static final int MIN_OPTION = 1;
    public static final int LOSE_POINTS = 3;
    public static final int TWENTY_CHANCES = 20;
    public static final int FIFTEEN_CHANCES = 15;
    public static final int TEN_CHANCES = 10;
    public static final int ADD_TO_RANDOM = 5;
    public static final int INITIALIZE = 0;
    public static final int COUNT_DIGIT = 1;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[]code = secretCode();
        int guess;
        printMenu();
        int countOfPossibleGuess = chooseOption();
        boolean isOverGame = false;

        do {
                System.out.println("Enter a guess digits between 1-6: ");
                guess = scanner.nextInt();
            while (!isInputCorrect(guess) || isDigitOutOfRange(guess) || !isCorrectLength(guess)){
                if(!isInputCorrect(guess) && isCorrectLength(guess)){
                    countOfPossibleGuess -= LOSE_POINTS;
                    System.out.println("You were fined 2 guesses!");
                    if(countOfPossibleGuess <= INITIALIZE){
                        lose(code);
                        System.out.println();
                        isOverGame = true;
                        break;
                    }
                }
                System.out.println("Enter again:");
                guess = scanner.nextInt();
            }
            countOfPossibleGuess --;
            if(countOfPossibleGuess <= INITIALIZE){
                isOverGame = true;
            }
        }while (!isCorrectGuess(code,guess) && !isOverGame);
        if(countOfPossibleGuess <= INITIALIZE && isInputCorrect(guess)){
            lose(code);
        }

    }

    public static void lose(int[]code){
        System.out.println("You lose!");
        for (int i = 0; i < code.length; i++){
            System.out.print(code[i]+ " ") ;
        }
    }

    public static void printMenu(){
        System.out.println("Welcome to guessing game!");
        System.out.println();
        System.out.println("Please select an option:");
        System.out.println("press 1 - Easy level : 20 chances");
        System.out.println("press 2 - Medium level : 15 chances");
        System.out.println("press 3 - Hard level : 10 chances");
        System.out.println("press 4 - Surprise level : 5-25 chances");
    }

    public static int chooseOption(){
        Scanner scanner = new Scanner(System.in);
        int option;
        int countOption = 0;
        do {
            System.out.println("Choose option: ");
            option = scanner.nextInt();
        }while (option >MAX_OPTION || option < MIN_OPTION);
        switch (option){
            case 1: {
                countOption = TWENTY_CHANCES;
                break;
            }
            case 2:{
                countOption = FIFTEEN_CHANCES;
                break;
            }
            case 3:{
                countOption = TEN_CHANCES;
                break;
            }
            case 4:{
                Random random = new Random();
                countOption = random.nextInt(TWENTY_CHANCES)+ADD_TO_RANDOM;
                break;
            }
        }
        return countOption;

    }

    // האם האורך תקין
    public static boolean isCorrectLength(int number){
        boolean correctLength = false;
        String guess = Integer.toString(number);
        if (guess.length() == MAX_OPTION){
            correctLength = true;
        }
        return correctLength;
    }
     //האם הערך תקין
    public static boolean isInputCorrect(int number){
        boolean correctInput = false;
        String guess = Integer.toString(number);
        int countOfDigitInGuess = INITIALIZE;
        for (int i = 0; i < guess.length(); i++) {
            char currentInt = guess.charAt(i);
            for (int j = 0; j < guess.length(); j++) {
                if (currentInt == guess.charAt(j)) {
                    countOfDigitInGuess++;
                }
            }
            if (countOfDigitInGuess == COUNT_DIGIT) {
                correctInput = true;
                countOfDigitInGuess = INITIALIZE;
            } else {
                correctInput = false;
                break;
            }
        }

        return correctInput;
    }

    public static int[] secretCode(){
        Random random = new Random();
        int[] code = new int[MAX_OPTION];
        int digitOfCode;
        for (int i = 0; i < code.length;i++){
            do{
                digitOfCode = random.nextInt(6)+1;
            }while (isExistInArray(code,digitOfCode));
            code[i] = digitOfCode;
        }
        return code;
    }
    // בודק אם הקוד נכון וכמה ניחושים מדוייקים וחלקיים
    public static boolean isCorrectGuess(int[]arr, int number){
        boolean correctGuess = false;
        int countOfAccurate = 0;
        int countOfPartialGuess = 0;
        for (int i = arr.length-1; i >= 0;i--){
            if(number%10 == arr[i]){
                countOfAccurate++;


            }else{
                for (int j = arr.length-1; j >= 0;j--){
                    if(number%10 == arr[j]){
                        countOfPartialGuess++;
                        break;
                    }

                }
            }
            number /= 10;
        }
        if(countOfAccurate == 4){
            correctGuess = true;
            System.out.println("You win!");
        }else {
            System.out.println("Accurate: " + countOfAccurate);
            System.out.println("Partial: " + countOfPartialGuess);
        }
        return correctGuess;
    }

    public static boolean isExistInArray (int[] arr, int number){
        boolean exist = false;
        for (int i = 0; i < arr.length;i++){
            if(number == arr[i]){
                exist = true;
            }
        }
        return exist;
    }

    public static boolean isDigitOutOfRange(int number){
        boolean outOfRange = true;
        String guess = Integer.toString(number);
        for(int i = 0; i < guess.length(); i++){

            if(guess.charAt(i) == '1' || guess.charAt(i) == '2' || guess.charAt(i) == '3' ||
                    guess.charAt(i) == '4' || guess.charAt(i) == '5' || guess.charAt(i) == '6'){
                outOfRange = false;
            }
            else {
                outOfRange = true;
                break;
            }
        }
        return outOfRange;
    }

}
