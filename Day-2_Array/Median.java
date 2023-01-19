public class Median {
    static int median(int[] a, int start, int end) {
        int n = end - start + 1;
        
        if (n % 2 == 0) {
            return (a[start + (n / 2)]
                    + a[start + (n / 2 - 1)])
                    / 2;
        } else {
            return a[start + n / 2];
        }
    }
    
    static int findMedian(int[] a1, int[] a2, int start_a1,
            int start_a2, int end_a1, int end_a2) {
        if (end_a1 - start_a1 == 1) {
            return (Math.max(a1[start_a1],
                    a2[start_a2])
                    + Math.min(a1[end_a1], a2[end_a2]))
                    / 2;
        }
        int m1 = median(a1, start_a1, end_a1);
        int m2 = median(a2, start_a2, end_a2);

        if (m1 == m2) {
            return m1;
        }
        
        else if (m1 < m2) {
            return findMedian(
                    a1, a2, (end_a1 + start_a1 + 1) / 2,
                    start_a2, end_a1,
                    (end_a2 + start_a2 + 1) / 2);
        }

        else {
            return findMedian(
                    a1, a2, start_a1,
                    (end_a2 + start_a2 + 1) / 2,
                    (end_a1 + start_a1 + 1) / 2, end_a2);
        }
    }

    public static void main(String args[]) {
        int a1[] = { 1, 2, 3, 6 };
        int a2[] = { 4, 6, 8, 10 };

        System.out.println(
                "The median of two sorted arrays is: " + findMedian(a1, a2, 0, 0, a1.length - 1, a2.length - 1));
    }
}