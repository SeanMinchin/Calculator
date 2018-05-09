package calculator;

import java.util.Stack;

class InputParser {
    // shunting-yard algorithm
    // convert infix notation to postfix notation
    static String toPostfix(String infix) {
        Stack<String> stack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();

        for(String token : infix.split(" ")) {
            if(Conditions.isOperator(token)) {
                if(stack.isEmpty()) {
                    stack.push(token);
                } else {
                    while (!stack.isEmpty() && isHigherPrecedence(stack.peek(), token)) {
                        postfixExpression.append(stack.pop()).append(' ');
                    }
                    stack.push(token);
                }
            } else if(Conditions.isOpenParentheses(token)) {
                stack.push(token);
            } else if(Conditions.isClosedParentheses(token)) {
                while(!Conditions.isOpenParentheses(stack.peek())) {
                    postfixExpression.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else {
                postfixExpression.append(token).append(' ');
            }
        }

        while(!stack.isEmpty()) {
            postfixExpression.append(stack.pop()).append(' ');
        }
        return postfixExpression.toString();
    }

    // set the precedence for each operator, higher number means higher precedence
    private static int getPrecedence(String token) {
        switch (token) {
            case "^":
            case "$":
            case "#":
            case "@":
                return 3;
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }

    // compares the precedence for two operators
    private static boolean isHigherPrecedence(String string1, String string2) {
        int precedence1 = getPrecedence(string1);
        int precedence2 = getPrecedence(string2);

        if (precedence1 == precedence2) {
            return !Conditions.isRightAssociative(string1);
        }
        return precedence1 > precedence2;
    }
}