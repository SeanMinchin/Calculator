package calculator;

import java.util.Set;

class Conditions {
    private static final Set<String> OPERATORS = Set.of("+", "-", "/", "*", "^", "sqrt", "log", "ln");

    static boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    static boolean isNumeric(String token) {
        try {
            Double.parseDouble(token);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    static boolean isOpenParentheses(String token) {
        return token.equals("(");
    }

    static boolean isClosedParentheses(String token) {
        return token.equals(")");
    }

    private static boolean isLegalToken(String token) {
        return isOperator(token) || isNumeric(token) || isOpenParentheses(token) || isClosedParentheses(token);
    }

    static boolean isRightAssociative(String token) {
        return token.equals("^");
    }

    // checks if the tokens in the user input are legal operators, operands, or parentheses
    static boolean isLegalInput(String[] infix) {
        for(int i = 0; i < infix.length - 1; ++i) {
            if(!Conditions.isLegalToken(infix[i])) {
                System.out.println("ERROR: " + infix[i] + " is illegal input.\n");
                return false;
            }
            if((infix[i].equals("sqrt") || infix[i].equals("log") || infix[i].equals("ln")) && Double.parseDouble(infix[i + 1]) < 0) {
                System.out.println("ERROR: out of domain exception for " + infix[i] + "(" + infix[i + 1] + ")\n");
                return false;
            }
            if((infix[i].equals("log") || infix[i].equals("ln")) && Double.parseDouble(infix[i + 1]) == 0.0) {
                System.out.println("ERROR: out of domain exception for " + infix[i] + "(" + infix[i + 1] + ")\n");
                return false;
            }
        }
        return true;
    }

    static boolean isInteger(double d) {
        return d % 1 == 0;
    }
}