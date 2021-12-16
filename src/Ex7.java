
import java.util.Scanner;

public class Ex7 {

    public static final int INITIALIZE_ELEMENTS = 0;
    public static final int FACTOR_TO_DOUBLING = 2;
    public static final int EXPONENT = 2;
    public static final int FACTOR_TO_DOUBLING_QUADRATIC_EQUATION = 4;
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char EQUAL = '=';
    public static final char ZERO = '0';
    public static final char X = 'x';
    public static final char POW = '^';
    public static final char TWO = '2';
    public static final int COUNT_OPERATORS2 = 2;
    public static final int COUNT_OPERATORS3 = 3;
    public static final int COUNT_EQUALS = 1;
    public static final int ARRAY_SIZE = 4;
    public static final int STOP_CONDITIONS = 3;
    public static final int INDEX_TO_START = 1;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a=INITIALIZE_ELEMENTS,b=INITIALIZE_ELEMENTS,c=INITIALIZE_ELEMENTS;
        System.out.println("Enter a Quadratic Equation: ");
        String userInput = scanner.nextLine();
        if(isExistOperators(userInput)) {
            String[] quadraticEquation = splitByOperators(userInput);
            if (isCorrectInput(quadraticEquation)) {
                a = Integer.parseInt(extractNumbers(quadraticEquation[0]));
                b = Integer.parseInt(extractNumbers(quadraticEquation[1]));
                c = Integer.parseInt(extractNumbers(quadraticEquation[2]));
                calculateQuadraticEquation(a,b,c);
            }else {
                System.out.println("not correct");
            }
        }else {
            System.out.println("not correct");
        }
    }

    public static double calculateX(int a,int b, double delta){
        double x = (-b + delta)/(FACTOR_TO_DOUBLING*a);
        return x;
    }

    public static void calculateQuadraticEquation(int a, int b, int c){
        double x1,x2;
        double delta = Math.pow(b,EXPONENT)-(FACTOR_TO_DOUBLING_QUADRATIC_EQUATION*a*c);
        if(delta < 0){
            System.out.println("There is no solution!");
        }
        else if(delta == 0){
            delta = Math.sqrt(delta);
            System.out.println("There is one solution:");
            x1 = calculateX(a,b,delta);
            System.out.println("X= "+x1);
        }
        else {
            delta = Math.sqrt(delta);
            System.out.println("There are two solutions:");
            x1 = calculateX(a,b,delta);
            x2 = calculateX(a,b,-delta);
            System.out.println("X1= "+ x1);
            System.out.println("X2= "+ x2);
        }
    }

    public static boolean isCorrectInput(String[] quadraticEquation) {
        boolean correct = false;
        for (int i = 0; i < quadraticEquation.length; i++) { //מיקום במערך
            char currentChar = quadraticEquation[i].charAt(0);
            if (i == 0) {
                if (currentChar == MINUS) {
                    if (isDigit(quadraticEquation[i].charAt(1))) {
                        if (isExistXSquared(quadraticEquation[i])) {
                            correct = true;
                        } else {
                            correct = false;
                            break;
                        }
                    } else {
                        correct = false;
                        break;
                    }
                } else if (isDigit(currentChar)) {
                    if (isExistXSquared(quadraticEquation[i])) {
                        correct = true;
                    } else {
                        correct = false;
                        break;
                    }
                } else if (currentChar == X) {
                    break;
                } else {
                    correct = false;
                    break;
                }
            }
            if (i == 1) {
                if (currentChar == MINUS || currentChar == PLUS) {
                    if (isDigit(quadraticEquation[i].charAt(1))) {
                        if (isExistX(quadraticEquation[i])) {
                            correct = true;
                        } else {
                            correct = false;
                        }
                    } else {
                        correct = false;
                    }
                } else if (currentChar == X) {
                    break;
                } else {
                    correct = false;
                    break;
                }
            }
            if (i == 2) {
                if (currentChar == PLUS || currentChar == MINUS) {
                    if (isDigit(quadraticEquation[i].charAt(1))) {
                        correct = true;
                    } else {
                        correct = false;
                        break;
                    }
                } else {
                    correct = false;
                    break;
                }
            }
            if (i == 3) {
                if (currentChar == EQUAL && quadraticEquation[i].charAt(1) == ZERO) {
                    correct = true;
                } else {
                    correct = false;
                }
                break;
            }
            if (!correct) {
                break;
            }
        }
        return correct;
    }

    public static String extractNumbers(String userInput){
        char x = X;
        String receiveNumber = "";
        for (int i = 0; i < userInput.length();i++){
            char currentChar = userInput.charAt(i);
            if(isDigit(currentChar) || currentChar == MINUS || currentChar == PLUS){
                if(currentChar != PLUS) {
                    receiveNumber += currentChar;
                }
            }
            else {
                break;
            }
        }
        return receiveNumber;
    }

    public static boolean isExistOperators(String userInput){
        boolean isExistOperators = false;
        int countOfPlusOrMinus = INITIALIZE_ELEMENTS;
        int countOfEqual = INITIALIZE_ELEMENTS;
        for (int i = 0; i < userInput.length();i++){
            char currentChar = userInput.charAt(i);
            if(currentChar == PLUS || currentChar == MINUS){
                countOfPlusOrMinus++;
            }else if(currentChar == EQUAL){
                countOfEqual++;
            }
        }
        if((countOfPlusOrMinus == COUNT_OPERATORS2 || countOfPlusOrMinus == COUNT_OPERATORS3) && countOfEqual == COUNT_EQUALS){
            isExistOperators = true;
        }
        return isExistOperators;
    }

    public static String[] splitByOperators(String userInput){
        String[] quadraticEquation = new String[ARRAY_SIZE];
        String valueToArray = "";
        int indexOfArray = INITIALIZE_ELEMENTS;
        if(userInput.charAt(0) == MINUS){
            valueToArray += userInput.charAt(0);
            userInput = returnStringFromTheIndex(userInput,INDEX_TO_START);
        }else if(userInput.charAt(0) == PLUS){
            userInput = returnStringFromTheIndex(userInput,INDEX_TO_START);
        }
        while (indexOfArray != STOP_CONDITIONS){
            for (int j = 0; j < userInput.length();j++) {
                char currentChar = userInput.charAt(j);
                if (currentChar != PLUS && currentChar != MINUS) {
                    if(currentChar == EQUAL){
                        quadraticEquation[indexOfArray] = valueToArray;
                        indexOfArray++;
                        quadraticEquation[indexOfArray] = returnStringFromTheIndex(userInput,j);
                        break;
                    }else {
                        valueToArray += currentChar;
                    }
                }
                else {
                    quadraticEquation[indexOfArray] = valueToArray;
                    indexOfArray++;
                    userInput = returnStringFromTheIndex(userInput,j+INDEX_TO_START);
                    valueToArray = ""+currentChar;
                    break;
                }
            }
        }
        return quadraticEquation;
    }

    public static String returnStringFromTheIndex(String str, int index){
        String stringAfterIndex = "";
        for (int i = index; i < str.length();i++){
            stringAfterIndex += str.charAt(i);
        }
        return stringAfterIndex;
    }

    public static boolean isExistXSquared(String userInput){
        boolean existX = false, existPow = false , existTwo = false;
        boolean isExistXSquared = false;
        for (int i = 0; i <userInput.length();i++){
            char currentChar = userInput.charAt(i);
            if(currentChar == X){
                existX = true;
            }
            if(currentChar == POW){
                existPow = true;
            }
            if(currentChar == TWO){
                existTwo = true;
            }
        }
        if(existX && existPow && existTwo){
            for (int i = 0; i < userInput.length();i++) {
                char currentChar = userInput.charAt(i);
                if (currentChar == X && userInput.charAt(i + 1) == POW && userInput.charAt(i + 2) == TWO) {
                    isExistXSquared = true;
                    break;
                } else {
                    isExistXSquared = false;
                }
            }
        }
        else {
            isExistXSquared = false;
        }
        return isExistXSquared;
    }

    public static boolean isExistX(String userInput){
        boolean existX = false;
        for (int i = 0; i < userInput.length();i++){
            if(userInput.charAt(i) == X){
                existX = true;
            }
        }
        return existX;
    }

    public static boolean isDigit(char ch){
        boolean digit = false;
        char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
        for(int i = 0; i < digits.length;i++){
            if(ch == digits[i]){
                digit = true;
            }
        }
        return digit;
    }


}
