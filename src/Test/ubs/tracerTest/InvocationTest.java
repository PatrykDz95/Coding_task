package Test.ubs.tracerTest;

import main.ubs.invocation.InvocationTracer;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class InvocationTest {
    final LinkedList<String> inputLinkedList = new LinkedList<>();
    InvocationTracer tracer;

    @Test
     void addingZeroElementsShouldReturnZero(){
        assertEquals(0, tracer.count(""));
    }

    @Test
     void addingOneElementShouldReturnOne(){
        tracer = new InvocationTracer();
        tracer.add("cat");
        assertEquals(1, tracer.count("cat"));
    }

    @Test
     void addingTwoTheSameElementsShouldReturnTwo(){
        tracer = new InvocationTracer();
        tracer.add("dog");
        tracer.add("dog");
        assertEquals(2, tracer.count("dog"));
    }
}