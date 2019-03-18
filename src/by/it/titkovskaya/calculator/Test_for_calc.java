package by.it.titkovskaya.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_for_calc {
    @Test
    public void A_scalar_add() throws Exception {
        Parser parser = new Parser();
        String actual = parser.calc("A=2+5.3");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected value: 7.3");
        assertEquals("Received value is incorrect","7.3", actual);
    }

    @Test
    public void A_scalar_mul() throws Exception {
        Parser parser = new Parser();
        String actual = parser.calc("B=A*3.5");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected value: 25.55");
        System.out.println();
        assertEquals("Received value is incorrect","25.55", actual);

    }

    @Test
    public void A_scalar_with_negative() throws Exception {
        Parser parser = new Parser();
        System.out.println("Input: B1=B+0.11*-5");
        String actual = parser.calc("B1=B+0.11*-5");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected value: 25.0");
        System.out.println();
        assertEquals("Received value is incorrect", "25.0", actual);
    }

    @Test
    public void A_scalar_div() throws Exception {
        Parser parser = new Parser();
        System.out.println("Input: B2=A/2-1");
        String actual = parser.calc("B2=A/2-1");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected value: 2.65");
        System.out.println();
        assertEquals("Received value is incorrect", "2.65", actual);
    }

    @Test
    public void B_operation_simple() throws Exception {
        Parser parser = new Parser();
        System.out.println("Input: C=B+(A*2)");
        String actual = parser.calc("C=B+(A*2)");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected value: 40.15");
        System.out.println();
        assertEquals("Received value is incorrect", "40.15", actual);
    }

    @Test
    public void B_operation_with_priority() throws Exception {
        Parser parser = new Parser();
        System.out.println("Input: D=((C-0.15)-20)/(7-5)");
        String actual = parser.calc("D=((40.15-0.15)-20)/(7-5)");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected value: 10.0");
        System.out.println();
        assertEquals("Received value is incorrect", "10.0", actual);
    }

    @Test
    public void B_operation_with_vectors() throws Exception {
        Parser parser = new Parser();
        System.out.println("Input: E={2,3}*(D/2)");
        String actual = parser.calc("E={2,3}*(10.0/2)");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected value: {10.0, 15.0}");
        System.out.println();
        assertEquals("Received value is incorrect", "{10.0, 15.0}", actual);
    }

    @Test
    public void C_matrix_sum() throws Exception {
        Parser parser = new Parser();
        System.out.println("Input: Z=({{1,2},{8,3}}+{{17.0, 8.0}, {32.0, 25.0}})*2");
        String actual = parser.calc("Z=({{1,2},{8,3}}+{{17.0,8.0},{32.0,25.0}})*2");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected value: {{36.0, 20.0}, {80.0, 56.0}}");
        System.out.println();
        assertEquals("Received value is incorrect", "{{36.0, 20.0}, {80.0, 56.0}}", actual);
    }

    @Test
    public void C_matrix_sub() throws Exception {
        Parser parser = new Parser();
        System.out.println("Input: X=({{1,2},{8,3}}+{{17.0, 8.0}, {32.0, 25.0}})*2");
        String actual = parser.calc("X=({{1,2},{8,3}}-{{17.0,8.0},{32.0,25.0}})*(-6+2)");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected value: {{64.0, 24.0}, {96.0, 88.0}}");
        System.out.println();
        assertEquals("Received value is incorrect", "{{64.0, 24.0}, {96.0, 88.0}}", actual);
    }

    @Test
    public void C_matrix_mul_vector() throws Exception {
        Parser parser = new Parser();
        System.out.println("Input: Y=10+{{1,2},{8,3}}*{17.0, 8.0}");
        String actual = parser.calc("Y=10+{{1,2},{8,3}}*{17.0, 8.0}");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected value: {43.0, 170.0}");
        System.out.println();
        assertEquals("Received value is incorrect", "{43.0, 170.0}", actual);
    }

    @Test
    public void Test_scalar_toString() throws Exception {
        Parser parser = new Parser();
        String actual = parser.calc("a={2,5,8}");
        System.out.println("Создание переменной a типа Vector на основе массива {2,5,8}");
        Vector vector = new Vector("{2,5,8}");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected output: {2,5,8}");
        System.out.println();
        assertEquals("Incorrect output", "{2.0, 5.0, 8.0}",vector.toString());
    }

    @Test
    public void Test_vector_toString() throws Exception {
        Parser parser = new Parser();
        String actual = parser.calc("b={2,5,8}");
        System.out.println("Создание переменной a типа Vector на основе массива {2,5,8}");
        Vector vector = new Vector("{2,5,8}");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected output: {2,5,8}");
        System.out.println();
        assertEquals("Incorrect output", "{2.0, 5.0, 8.0}",vector.toString());
    }

    @Test
    public void Test_matrix_toString() throws Exception {
        Parser parser = new Parser();
        String actual = parser.calc("c={{2,5,8},{3,4,7}}");
        System.out.println("Создание переменной a типа Vector на основе массива {{2,5,8},{3,4,7}}");
        Matrix matrix = new Matrix("{{2,5,8},{3,4,7}}");
        System.out.println("Actual output: " + actual);
        System.out.println("-----------------------------");
        System.out.println("Expected output: {{2.0, 5.0, 8.0}, {3.0, 4.0, 7.0}}");
        System.out.println();
        assertEquals("Incorrect output", "{{2.0, 5.0, 8.0}, {3.0, 4.0, 7.0}}",matrix.toString());
    }

}