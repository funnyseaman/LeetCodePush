package all.p22;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new LinkedList<>();

        addParenthesis("(", 1, 0, n);

        return res;
    }

    private void addParenthesis(String p, int left, int right, int n) {
        if (right == n) {
            res.add(p);
            return;
        }
        if (left > right) {
            addParenthesis(p + ")", left, right + 1, n);
        }
        if (left < n) {
            addParenthesis(p + "(", left + 1, right, n);
        }
    }

    @Test
    public void test() {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(8));
    }
}
