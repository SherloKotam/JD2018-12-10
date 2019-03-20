package by.it.titkovskaya.jd01.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
        System.out.println(step2(step1(n)));
        int[][] ints = step3(step1(n));
        for (int[] innerArray : ints) {
            for (int data : innerArray) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        boolean isNFound = false;
        boolean isMinusNFound = false;
        while (!isNFound || !isMinusNFound) {
            isNFound = false;
            isMinusNFound = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                    if (mas[i][j] == n) {
                        isNFound = true;
                    } else if (mas[i][j] == -n) {
                        isMinusNFound = true;
                    }
                }
            }
        }
        for (int[] innerArray : mas) {
            for (int data : innerArray) {
                System.out.println(data);
            }
        }
        return mas;
    }

    private static int step2(int[][] mas) {
        int sum = 0;
        for (int[] ma : mas) {
            for (int j = 0; j < ma.length; j++) {
                int colFirst, colSec;
                if (ma[j] >= 0) {
                    colFirst = j;
                    for (int k = colFirst + 1; k < ma.length; k++) {
                        if (ma[k] >= 0) {
                            colSec = k;
                            if ((colSec - colFirst) > 1) {
                                for (int m = colFirst + 1; m < colSec; m++) {
                                    sum += ma[m];
                                }
                                j = ma.length;
                                k = ma.length;
                            } else {
                                j = ma.length;
                                k = ma.length;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] mas) {
        boolean[] delCol = new boolean[mas[0].length];
        boolean[] delRow = new boolean[mas.length];
        int max = Integer.MIN_VALUE;
        for (int[] ma : mas) {
            for (int aMa : ma) {
                if (aMa > max)
                    max = aMa;
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    delCol[j] = true;
                    delRow[i] = true;
                }
            }
        }
        int rowCount = 0;
        for (boolean value : delRow) if (!value) rowCount++;
        int colCount = 0;
        for (boolean value : delCol) if (!value) colCount++;
        int[][] res = new int[rowCount][colCount];

        int ir = 0;
        int jr = 0;
        for (int i = 0; i < mas.length; i++) {
            if (!delRow[i]) {
                for (int j = 0; j < mas[i].length; j++) {
                    if (!delCol[j]) {
                        res[ir][jr++] = mas[i][j];
                    }
                }
                ir++;
                jr = 0;
            }
        }
        return res;
    }
}


/*

while (Arrays.asList(mas).contains(-n) && Arrays.asList(mas).contains(n))
System.out.println(mas[i][j]);

        for (int[] innerArray : mas) {
            for (int data : innerArray) {
                System.out.print(data + " ");
            }
            System.out.println();
        }

        boolean isNFound = false;
        boolean isMinusNFound = false;
        while (!isNFound && !isMinusNFound){
            System.out.println("Генерация чисел");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) ((Math.random() * (2 * n + 2)) - (n+1));
                    if (mas[i][j] == n) {
                        isNFound = true;
                    }else if (mas[i][j] == -n) {
                        isMinusNFound = true;
                    }
                    System.out.println(mas[i][j]);
                }
            }
            System.out.println("Конец генерации");
        }

for (int k = colFirst+1; k < mas[i].length; k++) {
                        if (mas[i][k]>=0){
                            colSec=k;
                            if ((colSec-colFirst)>1){
                                for (int m = colFirst+1; m < colSec; m++) {
                                    sum += mas[i][m];
                                }
                            } else break;
                        }
                    }

         for (int[] innerArray: mas) {
            for (int data: innerArray) {
                sum+=data;
            }
        }
 */