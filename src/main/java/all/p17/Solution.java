package all.p17;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
    2 abc   3 def   4 ghi
    5 jkl   6 mno   7 pqrs
    8 tuv   9 wxyz
*/

public class Solution {
    private HashMap<Character, Character[]> phoneMap = new HashMap<Character, Character[]>() {{
        put('2', new Character[]{'a', 'b', 'c'});
        put('3', new Character[]{'d', 'e', 'f'});
        put('4', new Character[]{'g', 'h', 'i'});
        put('5', new Character[]{'j', 'k', 'l'});
        put('6', new Character[]{'m', 'n', 'o'});
        put('7', new Character[]{'p', 'q', 'r', 's'});
        put('8', new Character[]{'t', 'u', 'v'});
        put('9', new Character[]{'w', 'x', 'y', 'z'});
    }};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.length() == 0) {
            return res;
        } else {
            res.add("");
        }
        for (char c : digits.toCharArray()) {
            addCombination(res, c);
        }
        return res;
    }

    private void addCombination(LinkedList<String> res, char num) {
        int n = res.size();
        while (n > 0) {
            String pre = res.poll();
            for (char c : phoneMap.get(num)) {
                res.add(pre + c);
            }
            n--;
        }
    }


    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("4"));
    }
}
