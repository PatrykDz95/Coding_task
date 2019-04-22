package main.ubs.invocation;

import java.util.Collections;
import java.util.LinkedList;

public class InvocationTracer {

    private static final LinkedList<String> inputLinkedList = new LinkedList<>();
    public static void main(String[] args) {
        add("cat");
        int stringCount = count("cat");
        System.out.println("stringCount will be equal to " + stringCount);
    }

    public static void add(String input){
        inputLinkedList.add(input);
    }

    public static int count(String input){
        return Collections.frequency(inputLinkedList, input);
    }

}
