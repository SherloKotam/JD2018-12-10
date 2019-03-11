package by.it.titkovskaya.jd01.jd01_10;
/*
TaskA1. Создайте собственную аннотацию Param, которая описывает параметры для некоторой
процедуры тестирования произвольного метода с сигнатурой (int a, int b), помеченного такой
аннотацией. Пример использования:
@Param(a=2, b=5)
public double avg(int a, int b) { ... }.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {

    int a();
    int b();

}
