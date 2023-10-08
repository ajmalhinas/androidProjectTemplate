/*
 * To change this school, choose Tools | Templates
 * and open the school in the editor.
 */
package school.util;

import java.math.BigDecimal;

/**
 *
 * @author ajmal
 */
public class Cal {



    /**
     * currency addition. Return value is scaled to 2 decimal points
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal ca(BigDecimal a, BigDecimal b) {
        return a.add(b).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * currency subtraction. Return value is scaled to 2 decimal points
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal cs(BigDecimal a, BigDecimal b) {
        return a.subtract(b).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }


    /**
     * safe division prevents divided by zero error
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal sd(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO.setScale(2);
        } else {
            return a.divide(b, 10, BigDecimal.ROUND_HALF_EVEN);
        }
    }

    /**
     * currency division divided results are scaled to 2 decimals
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal cd(BigDecimal a, BigDecimal b) {
        return sd(a, b).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * currency multiplication multiplied results are scaled to 2 decimals
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal cm(BigDecimal a, BigDecimal b) {
        return a.multiply(b).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * qty multiplication multiplied results are scaled to 3 decimals
     *
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal qm(BigDecimal a, BigDecimal b) {
        return a.multiply(b).setScale(3, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * check 2 BigDecimal values are equal
     */
    public static boolean eq(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) == 0;
    }

    /**
     * check 2 BigDecimal values are not equal
     */
    public static boolean neq(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) != 0;
    }

    /**
     * check a is greater than b
     */
    public static boolean gt(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) > 0;
    }

    /**
     * check a is greater than or equal to b
     */
    public static boolean gte(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) >= 0;
    }

    /**
     * check a is less than or equal to b
     */
    public static boolean lte(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) <= 0;
    }

}
