import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}

class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        Deque<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        int i;
        for (i = 0; i < k; ++i)
        {
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
        }
        for (; i < n; ++i)
        {
            list.add(arr[queue.peek()]);
            while ((!queue.isEmpty()) && queue.peek() <= i - k)
                queue.removeFirst();
            while ((!queue.isEmpty()) && arr[i] >= arr[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
        }
        list.add(arr[queue.peek()]);
        return list;
    }
}
