package calculator;

import java.util.Stack;

class Calculator {
    static void evaluatePostfix(String postfix) {
        Stack<Double> postfixEvaluationStack = new Stack<>();
        for(String token : postfix.split(" ")) {
            if(Conditions.isNumeric(token)) {
                postfixEvaluationStack.push(Double.valueOf(token));
            } else {
                double d1, d2;

                switch(token) {
                    case "+":
                        d1 = postfixEvaluationStack.pop();
                        d2 = postfixEvaluationStack.pop();
                        postfixEvaluationStack.push(d1 + d2);
                        break;
                    case "-":
                        d1 = postfixEvaluationStack.pop();
                        d2 = postfixEvaluationStack.pop();
                        postfixEvaluationStack.push(d2 - d1);
                        break;
                    case "*":
                        d1 = postfixEvaluationStack.pop();
                        d2 = postfixEvaluationStack.pop();
                        postfixEvaluationStack.push(d1 * d2);
                        break;
                    case "/":
                        d1 = postfixEvaluationStack.pop();
                        d2 = postfixEvaluationStack.pop();
                        postfixEvaluationStack.push(d2 / d1);
                        break;
                    case "^":
                        d1 = postfixEvaluationStack.pop();
                        d2 = postfixEvaluationStack.pop();
                        postfixEvaluationStack.push((Math.pow(d2, d1)));
                        break;
                    case "sqrt":
                        d1 = postfixEvaluationStack.pop();
                        postfixEvaluationStack.push(Math.sqrt(d1));
                        break;
                    case "log":
                        d1 = postfixEvaluationStack.pop();
                        postfixEvaluationStack.push(Math.log10(d1));
                        break;
                    case "ln":
                        d1 = postfixEvaluationStack.pop();
                        postfixEvaluationStack.push(Math.log(d1));
                        break;
                }
            }
        }
        Memory.addToMemory(postfixEvaluationStack.pop());
    }
}