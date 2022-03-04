package me.karunarathne.ProgrammingQuestions ;

import java.util.Scanner;
import java.util.Stack;

public class Eval {
    private static Scanner scanner = null ;
    public static void main(String[] args) {
        try {
            scanner = new Scanner (System.in) ;
            while (true) {
                if (! mainLoop ()) break ;
            }
        } finally {
            scanner.close();
        }
    }

    private static boolean mainLoop() {
        String infixedInput = queryUser () ;
        if (infixedInput.equalsIgnoreCase("q")) return false ;

        evaluateExp (transformToPostFix ( infixedInput )) ;
        return true ;
    }

    private static String transformToPostFix(String input) {
        Expression expression = new Expression(input) ;
        return expression.getPostfix() ;
    }

    private static void evaluateExp(String expression) {
        System.out.println(expression);
        // PostfixSolver solver = new PostfixSolver (expression) ;
        // System.out.println (solver.evaluate()) ;
    }

    private static String queryUser () {
        System.out.print ("Enter your expression (Q to quit) >  ") ;
        String input = null ;
        try {
            input = scanner.nextLine() ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return input ;
    }

}

class PostfixSolver {
    private String expression ;

    public PostfixSolver (String expression) {
        this.expression = expression ;
    }

    private int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
             
            if(c == ' ') { 
                continue;
            } else if(Character.isDigit(c)) {
                int n = 0;
                
                while(Character.isDigit(c)) {
                    n = n*10 + (int)(c-'0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;

                stack.push(n);
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                
                switch(c) {
                    case '+':
                        stack.push(val2+val1);
                        break;
                     
                    case '-':
                        stack.push(val2- val1);
                        break;
                     
                    case '/':
                        stack.push(val2/val1);
                        break;
                     
                    case '*':
                        stack.push(val2*val1);
                        break;
                }
            }
        }
        return stack.pop();
    }
    
    public int evaluate () {
        return evaluatePostfix (expression) ;
    }
}

//TODO - add spaces too
class Expression {
    private String result ;

    public Expression (String expression) {
        result = new String("");
        infixToPostfix (expression) ;
    }

    public String getPostfix () {
        return result ;
    }

    private String infixToPostfix(String exp) {
        Stack <Character> stack = new Stack <> () ;
         
        for (int i = 0; i<exp.length(); ++i) {
            char c = exp.charAt (i) ;
            
            if (Character.isLetterOrDigit (c)) {
                result += c;
            } else if (c == '(') {
                stack.push (c) ;
            } else if (c == ')') {
                while (! stack.isEmpty() && (stack.peek() != '(')) {
                    result += stack.pop () ;
                }
                stack.pop () ;
            } else {
                while (! stack.isEmpty () && ( precedence(c) <= precedence (stack.peek()))) {
                    result += stack.pop () ;
                }
                stack.push (c) ;
            }
        }

        while (! stack.isEmpty ()) {
            if(stack.peek () == '(') {
                return "expression is invalid";
            }
            result += stack.pop();
        }
        return result;
    }

    private int precedence (char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
