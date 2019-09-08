package imperative;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Maksims Medveckis 171RDB030 3.kurs 1.grupa
 */
public class PerfectNumber {

    public enum STATE {
        ABUNDANT, DEFICIENT, PERFECT
    }

    public static Set<Integer> divisors(int n) {
        Set<Integer> integerSet = new HashSet<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                integerSet.add(i);
                integerSet.add(n / i);
            }
        }

        return integerSet;
    }

    public static STATE process(int n) {
        Set<Integer> divisorsOfN = divisors(n);

        int sumOfDivisorsOfN = divisorsOfN.stream()
                .filter(e -> !e.equals(n))
                .reduce(0, Integer::sum);

        if (sumOfDivisorsOfN < n) {
            return STATE.DEFICIENT;
        } else if (sumOfDivisorsOfN == n) {
            return STATE.PERFECT;
        } else {
            return STATE.ABUNDANT;
        }
    }
}
