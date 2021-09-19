package timeComplexity;

/**
 * This file is a part of CodilityQuestions project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 19/09/2021
 */
/*A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.
Any integer P, such that 0 < P < N, splits this tape into two non−empty parts: A\[0], A\[1], …, A\[P − 1] and A\[P], A\[P + 1], …, A\[N − 1].
The difference between the two parts is the value of: |(A\[0] + A\[1] + … + A\[P − 1]) − (A\[P] + A\[P + 1] + … + A\[N − 1])|
In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

Write a function that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.

Example: A[0] = 3 A[1] = 1 A[2] = 2 A[3] = 4 A[4] = 3
We can split this tape in four places:
  P = 1, difference = |3 − 10| = 7
  P = 2, difference = |4 − 9| = 5
  P = 3, difference = |6 − 7| = 1
  P = 4, difference = |10 − 3| = 7
In this case I would return 1 as it is the smallest difference.

N is an int, range [2..100,000]; each element of A is an int, range [−1,000..1,000]. It needs to be O(n) time complexity,
*/
public class TapeEquilibrium {
    public int solution(int[]A){
        int leftSum=A[0];
        int rightSum=0;

        for(int x:A)rightSum+=x;
        rightSum-=leftSum;

        int diff = Math.abs(leftSum-rightSum);
        for (int i = 1; i < A.length; ++i) {
            leftSum+=A[i];
            rightSum-=A[i];
            int currentDiff = Math.abs(leftSum-rightSum);
            if(diff>currentDiff)diff = currentDiff;
        }
        return diff;
    }

   /* public static void main(String[] args) {
        System.out.println(new TapeEquilibrium().solution(new int[]{3,1,2,4,3}));
    }*/
}
