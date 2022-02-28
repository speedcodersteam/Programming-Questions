// package me.karunarathne ;

public class Numbers {
    public static void main(String[] args) {
        countThisShit ( args [0] ) ;
    }

    private static void countThisShit (String input) {
        System.out.println (
            "The accumulation of " + 
            input + " is: " +
            finalThang ( accum (input) )
        ) ;
    }

    private static int accum (String input) {
        int sum = 0 ;
        for (char i : input.toCharArray()) {
            if (Character.isDigit(i)) {
                sum += Integer.valueOf( String.valueOf(i) ) ;
            }
        }

        return sum ;
    }

    private static int finalThang (int baseAccum) {
        char [] digits = String.valueOf(baseAccum).toCharArray() ;
        int sum = 0 ;
        for (char digit: digits) sum += Integer.valueOf(String.valueOf(digit)) ;
        
        if (sum >= 10) {
            return finalThang (sum) ;
        } 
        return sum ;
    }
}