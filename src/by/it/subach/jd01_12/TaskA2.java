package by.it.subach.jd01_12;

import javax.print.attribute.SetOfIntegerSyntax;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Integer [] arr1 = {1,1,1,1,2,2,2,3,3,3,4,4,5,5,5,5,6,6,6,7,7,7, 100, -1};
        Integer [] arr2= {4,4,4,4,5,5,5,6,6,6,9, 9,9,8,8,8,8};

        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(arr1));
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(arr2));



        System.out.println(set1);
        System.out.println(set2);

        Set<Integer> union = getUnion(set1, set2);
        System.out.println(union);

        Set<Integer> cross = getCross(set1, set2);
        System.out.println(cross);



    }

    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

}
