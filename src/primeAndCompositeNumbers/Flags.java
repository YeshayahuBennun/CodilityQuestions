package primeAndCompositeNumbers;

/**
 * This file is a part of CodilityQuestions project.
 *
 * @author Yeshayahu Bennun
 * @version 1.0.0
 * @since 23/09/2021
 */
/*A non-empty array A consisting of N integers is given.

A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N
− 1 and A[P − 1] < A[P] > A[P + 1].

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
has exactly four peaks: elements 1, 3, 5 and 10.

You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a
figure below. You have to choose how many flags you should take with you. The goal is to set the maximum number of
flags on the peaks, according to certain rules.

Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be
greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.

For example, given the mountain range represented by array A, above, with N = 12, if you take:

two flags, you can set them on peaks 1 and 5;
three flags, you can set them on peaks 1, 5 and 10;
four flags, you can set only three flags, on peaks 1, 5 and 10.
You can therefore set a maximum of three flags in this case.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the maximum number of flags that can be set on the peaks of
the array.

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..400,000];
each element of array A is an integer within the range [0..1,000,000,000].*/
public class Flags {
    public int solution(int[] A) {
        int[] peaks = new int[A.length];
        int nextPeak = A.length;
        peaks[A.length - 1] = nextPeak;

        for (int i = A.length - 2; i > 0; --i) {
            if (A[i - 1] < A[i] && A[i + 1] < A[i])
                nextPeak = i;

            peaks[i] = nextPeak;
        }

        peaks[0] = nextPeak;
        int current_guess = 0;
        int next_guess = 0;

        while (canPlaceFlags(peaks, next_guess)) {
            current_guess = next_guess;
            next_guess += 1;
        }

        return current_guess;
    }

    private boolean canPlaceFlags(int[] peaks, int flagsToPlace) {
        int currentPosition = 1 - flagsToPlace;
        for (int i = 0; i < flagsToPlace; ++i) {
            if (currentPosition + flagsToPlace > peaks.length - 1)
                return false;
            currentPosition = peaks[currentPosition + flagsToPlace];

        }
        return currentPosition < peaks.length;
    }

    public static void main(String[] args) {
        System.out.println(new Flags().solution(new int[]{ 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 }));
    }

}
