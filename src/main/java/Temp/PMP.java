package Temp;

import java.util.Arrays;

public class PMP {
    public static void main(String[] args){
        System.out.println("Hello World!");

        int[] array = new int[3];
        int[] array2 = new int[3];

        array[0] = 1;
        array[1] = 2;
        array[2] = 3;

        String toS = junToString(array);
        System.out.println(toS);
        System.out.println(48/2*(9+3));

    }

    public static String junToString(int[] args){
        if(args == null) return null;

        int iMax = args.length;
        if(iMax == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int i = 0; i < iMax; ++i){
            sb.append(args[i]);
            if(i == iMax - 1) return sb.append("]").toString();

            sb.append(",");
        }
        return "";
    }


}
