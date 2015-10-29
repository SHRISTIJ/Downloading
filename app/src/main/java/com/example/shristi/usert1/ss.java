package com.example.shristi.usert1;

/**
 * Created by shristi on 29/10/15.
 */
public class ss {
    public String rev (String input)
    {	String s2="";

        char[] try1= input.toCharArray();
        //String s1="";
        for (int i=try1.length-1;i>=0;i--)
        {	s2=s2+try1[i];}
        // System.out.print(try1[i]);


        return s2;
    }
}
