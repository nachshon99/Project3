import java.util.Scanner;

public class Ex8 {
    public static final int INITIALIZE = 0;
    public static final int ARRAY_SIZE = 40;
    public static final int STOP_CONDITION2 = 2;
    public static final int STOP_CONDITION4 = 4;
    public static final char SPACE = ' ';

    public static void main(String[] args) {
        String[] userInput = inputAttempts();
        for (int i = 0; i < userInput.length;i++){
            System.out.print(userInput[i] +", ");
        }
        System.out.println();
        String[] substring = containedSubStrings("hello");
        for (int i = 0; i < substring.length;i++){
            System.out.print(substring[i] + ", ");
        }
        System.out.println();
        String[]checkPopularSubstring = {"hello","held", "he"};
        System.out.println(popularSubstring(checkPopularSubstring));
    }

    public static String[] inputAttempts(){
        Scanner scanner = new Scanner(System.in);
        String saveValue = "";
        String getString = "";
        String inputString;
        int indexOfArray = INITIALIZE , countOfString = INITIALIZE;
        do {
            System.out.println("Enter Strings until the length smaller than 4");
            inputString = scanner.nextLine();
            saveValue += inputString + SPACE;
            countOfString++;
        } while (inputString.length() >= STOP_CONDITION4);
        String[] newInputUser = new String[countOfString];
        for (int i = 0; i < saveValue.length();i++){
            if(saveValue.charAt(i) != SPACE){
                getString += saveValue.charAt(i);
            }else {
                newInputUser[indexOfArray] = getString;
                indexOfArray++;
                getString = "";
            }

        }
        return newInputUser;
    }

    public static String[] containedSubStrings(String userInput){
        String[] substring = new String[ARRAY_SIZE];
        int indexToArray = INITIALIZE;
        String substringOfUserInput = "";
        int indexToEnd = userInput.length();
        if(userInput.length() == STOP_CONDITION2){
            substring[indexToArray] = userInput;
        }else {
            while (userInput.length() != STOP_CONDITION2) {
                while (indexToEnd >= STOP_CONDITION2) {
                    for (int i = 0; i < indexToEnd; i++) {
                        char currentChar = userInput.charAt(i);
                        substringOfUserInput += currentChar;
                    }
                    substring[indexToArray] = substringOfUserInput;
                    indexToArray++;
                    indexToEnd--;
                    substringOfUserInput = "";
                }
                userInput = removeFirstLetter(userInput);
                indexToEnd = userInput.length();
                if (userInput.length() == STOP_CONDITION2) {
                    substring[indexToArray] = userInput;
                }
            }
        }
        String[] newSubstring = new String[indexToArray+1];
        int index = INITIALIZE;
        while (substring[index] != null){
            newSubstring[index] = substring[index];
            index++;
        }
        return newSubstring;
    }

    public static String removeFirstLetter(String str){
        String stringWithoutLastLetter = "";
        for (int i = 1; i < str.length(); i++){
            stringWithoutLastLetter += str.charAt(i);
        }
        return stringWithoutLastLetter;
    }

    public static String popularSubstring(String[] strings){
        String[] substrings1 = new String[ARRAY_SIZE];
        int countOfSubstringInstances = INITIALIZE;
        int popularSubstring = INITIALIZE;
        int indexOfArray = INITIALIZE;
        String saveValue = "";
        for (int i = 0; i < strings.length;i++){
            String[] substring2 = containedSubStrings(strings[i]);
            for (int j = 0; j < substring2.length; j++){
                substrings1[indexOfArray] = substring2[j];
                indexOfArray++;
            }
        }
        String[] newArrayOfSubstring = new String[indexOfArray];
        for (int i = 0; i < substrings1.length;i++){
            if(substrings1[i] != null) {
                newArrayOfSubstring[i] = substrings1[i];
            }else {
                break;
            }
        }
        for (int i = 0; i < newArrayOfSubstring.length;i++){
            String currentSubstring = newArrayOfSubstring[i];
            for (int j = 0; j < newArrayOfSubstring.length;j++){
                if(isEqual(currentSubstring ,newArrayOfSubstring[j])){
                    countOfSubstringInstances++;
                }
            }
            if(popularSubstring < countOfSubstringInstances) {
                popularSubstring = countOfSubstringInstances;
                saveValue = currentSubstring;
            }
            countOfSubstringInstances = INITIALIZE;

        }
        return saveValue;
    }

    public static boolean isEqual(String str1, String str2){
        boolean equal = false;
        if(str1.length() == str2.length()){
            for (int i = 0; i < str1.length();i++){
                if(str1.charAt(i) == str2.charAt(i)){
                    equal = true;
                }
                else{
                    equal = false;
                    break;
                }
            }
        }
        return equal;

    }
}

