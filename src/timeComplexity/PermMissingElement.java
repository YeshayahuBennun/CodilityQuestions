package timeComplexity;

/**
 * This file is a part of CodilityQuestions project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 19/09/2021
 */

/**
 * A zero-indexed array A consisting of N different integers is given.
 * The array contains integers in the range [1 * (N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 * that, given a zero-indexed array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 * A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5
 *
 * the function should return 4, as it is the missing element.
 * Assume that:
 *
 * N is an integer within the range [0..100,000]; the elements of A are all distinct; each element of array A is an
 * integer within the range [1..(N + 1)].*/

public class PermMissingElement {
    public int solution(int[] A) {
        long actualSum = 0;
        for (int number : A) {
            actualSum += number;
        }

        long maxNumber = A.length + 1;
        long expectedSum = (maxNumber * (maxNumber + 1) / 2);

        return (int) (expectedSum - actualSum);
    }

  /*  public static void main(String[] args) {
        System.out.println(new PermMissingElement().solution(new int[]{2,3,1,5}));
        System.out.println(new PermMissingElement().solution(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(new PermMissingElement().solution(new int[]{}));
    }*/
}
