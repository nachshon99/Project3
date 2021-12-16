import java.util.Scanner;

public class Ex5 {
    public static final int INITIALIZE = 0;

    public static void main(String[] args) {
        //"take this text and test it eee";
        System.out.println(exchangeLetters());

    }

    public static String exchangeLetters(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String userInput = scanner.nextLine();
        String saveValue= userInput;
        int add = INITIALIZE;
        char highChar =highSignalFrequency(userInput);
        char secondHighSignalFrequency;
        for (int i = 0; i < userInput.length();i++){
            if(userInput.charAt(i) == highChar){
                saveValue = printLettersBeforeIndex(saveValue,i-add) + printLettersAfterIndex(saveValue,i-add+1) ;
                add++;
            }
        }
        secondHighSignalFrequency = highSignalFrequency(saveValue);
        saveValue = userInput;
        for (int i = 0; i < userInput.length();i++){
            if(userInput.charAt(i) == highChar){
                saveValue = printLettersBeforeIndex(saveValue,i) + secondHighSignalFrequency + printLettersAfterIndex(saveValue,i+1);
            }
            else if(userInput.charAt(i) == secondHighSignalFrequency){
                saveValue = printLettersBeforeIndex(saveValue,i) + highChar + printLettersAfterIndex(saveValue,i+1);
            }
        }
        return saveValue;
    }

    public static char highSignalFrequency(String str){
        int countOfLetter = INITIALIZE;
        int highCount = INITIALIZE;
        char highLetter = str.charAt(0);
        for (int i = 0; i < str.length();i++){
            char currentLetter = str.charAt(i);
            for (int j = 0; j < str.length();j++){
                if(currentLetter == str.charAt(j)){
                    countOfLetter++;
                }
            }
            if(countOfLetter >= highCount){
                highCount = countOfLetter;
                highLetter = currentLetter;
            }
            countOfLetter = INITIALIZE;
        }
        return highLetter;
    }

    public static  String printLettersAfterIndex(String str, int index){
        String st = "";
        for (int i = index; i < str.length();i++){
            st +=str.charAt(i);
        }
        return st;
    }

    public static String printLettersBeforeIndex(String str, int index){
        String st = "";
        for (int i=0; i<index; i++){
            st += str.charAt(i);
        }
        return st;
    }

}
