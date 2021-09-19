package arrays;

/**
 * This file is a part of CodilityQuestions project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 20/09/2021
 */

/*A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is shifted
right by one index, and the last element of the array is also moved to the first place.

For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]. The goal is to rotate array A K times;
that is, each element of A will be shifted to the right by K indexes.

Write a function that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A
rotated K times.

For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
*/
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        int[] result = new int[A.length];

        for (int i = 0; i < result.length; ++i) {
            result[(i + K) % A.length] = A[i];
        }
        return result;
    }

  /*  public static void main(String[] args) {
        System.out.println(Arrays.toString(new CyclicRotation().solution(new int[]{7,2,8,3,5},2)));
        System.out.println(Arrays.toString(new CyclicRotation().solution(new int[]{7,2,8,3,5},5)));
    }*/

}
