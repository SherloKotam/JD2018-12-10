package by.it.subach.jd01_09;

abstract class Var implements Operation{
    private double value;

    public static Var createVar(String operand) {
        if(operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if(operand.matches(Patterns.MATRIX))
            return new Matrix(operand);

        //TODO replace errors

        System.err.print("переменная " + operand + " не определена");

        return null;


    }



    @Override
    public Var add(Var other) {
        System.out.println("Сложение " + this + " на " + other + " невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание " + this + " на " + other + " невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение " + this + " на " + other + " невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление " + this + " на " + other + " невозможно");
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }


}
