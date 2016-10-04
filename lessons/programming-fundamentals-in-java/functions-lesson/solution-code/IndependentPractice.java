package ly.generalassemb;

public class IndependentPractice {

    public static void main(String[] args) {

    }

    // #1
    public static int divide152By(int num){
        return 152/num;
    }

    // #2
    public static double transmogrifier(int num1, int num2, int num3){
        return Math.pow(num1*num2,num3);
    }

    // #3
    public static boolean thirdAndFirst(String string1, String string2){
        char third = string1.toLowerCase().charAt(2);
        char first = string2.toLowerCase().charAt(0);
        if(third == first){
            return true;
        }else{
            return false;
        }
    }

    // #4
    public static String reverseString(String str){
        StringBuilder reversedString = new StringBuilder();
        reversedString.append(str);
        reversedString = reversedString.reverse();
        return reversedString.toString();
    }


}

