/**
 * Sanqiang Zhao Www.131X.Com Dec 22, 2012
 */
package LeetCode.OnlineJudge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Q57_MinWindowSubString {

    public String MinimumWindowSubstring(String S, String T) {
        int s_length = S.length(), t_length = T.length();
        HashMap<Character, Queue<Integer>> tab = new HashMap<>();
        int i, min_start = 0, min_length = s_length, ch_count = 0;
        for (i = 0; i < t_length; i++) {
            if (!tab.containsKey(T.charAt(i))) {
                Queue<Integer> q = new LinkedList<>();
                tab.put(T.charAt(i), q);
            }
            tab.get(T.charAt(i)).add(-1);
        }

        for (i = 0; i < s_length; ++i) {
            char ch = S.charAt(i);
            if (tab.containsKey(ch)) {
                Queue<Integer> q = tab.get(ch);
                if (q.peek() == -1) {
                    ++ch_count;
                }
                q.poll();
                q.add(i);
                if (t_length == ch_count) {
                    int start = s_length;
                    for (Queue<Integer> queue : tab.values()) {
                        if (queue.peek() < start) {
                            start = queue.peek();
                        }
                    }
                    int len = i - start + 1;
                    if (len < min_length) {
                        min_length = len;
                        min_start = start;
                    }
                }
            }
        }
        return S.substring(min_start, min_start + min_length);
    }

    public static void main(String[] args) {
        String S = "abwwwaxxxxab";
        String T = "aab";
        String text = new Q57_MinWindowSubString().MinimumWindowSubstringMy(S, T);
        System.out.println(text);
    }

    public String MinimumWindowSubstringMy(String S, String T) {
        HashMap<Character, Queue<Integer>> checker = new HashMap<>();
        int s_len = S.length(), t_len = T.length(), min_s = 0, min_len = Integer.MAX_VALUE, matched = 0, s = 0, e = 0;
        for (int i = 0; i < t_len; i++) {
            char ch = T.charAt(i);
            if (!checker.containsKey(ch)) {
                Queue<Integer> temp = new LinkedList<>();
                checker.put(ch, temp);
            }
            checker.get(ch).add(-1);
        }
        for (int i = 0; i < s_len; i++) {
            char ch = S.charAt(i);
            if (checker.containsKey(ch)) {
                if (checker.get(ch).peek() == -1) {
                    ++matched;
                }
                checker.get(ch).poll();
                checker.get(ch).add(i);
                if (matched == t_len) {
                    int start = s_len;
                    for (Queue<Integer> queue : checker.values()) {
                        if (queue.peek() < start) {
                            start = queue.peek();
                        }
                    }
                    int cur_len = i - start + 1;
                    if (cur_len < min_len) {
                        min_len = cur_len;
                        min_s = start;
                    }
                }
            }
        }
        return S.substring(min_s, min_s + min_len);
    }
}
