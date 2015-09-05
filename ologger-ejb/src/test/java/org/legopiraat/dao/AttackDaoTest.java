package org.legopiraat.dao;

import org.junit.Test;

/**
 * Created by LegoPiraat on 30-8-2015.
 */
public class AttackDaoTest {


    @Test
    public void test() {
        String normal = "Paul";

        String reverseString = reverse(normal);

        System.out.println(reverseString);
    }

    private String reverse(String normal) {

        String reverseString = "";

        if (normal.length() != 0) {


            return normal.charAt(normal.length() -1) + reverse(normal.substring(0, normal.length() - 1));
        }


        return reverseString;
    }

}
