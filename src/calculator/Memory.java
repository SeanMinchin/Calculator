package calculator;

import java.util.Stack;

class Memory {
    private static Stack<Double> memory = new Stack<>();

    static void addToMemory(double d) {
        memory.add(d);
    }

    static void printLastValue() {
        if(!memory.isEmpty()) {
            if(Conditions.isInteger(memory.peek())) {
                System.out.println(memory.peek().intValue());
            } else {
                System.out.println(memory.peek());
            }
        } else {
            System.out.println("Error: memory is empty.");
        }
    }

    static void removeLastValue() {
        if(!memory.isEmpty()) {
            memory.pop();
        } else {
            System.out.println("Error: memory is empty.");
        }
    }

    static void clearHistory() {
        memory.clear();
    }

    static void displayHistory() {
        for(Double value : memory) {
            System.out.println(value);
        }
    }
}