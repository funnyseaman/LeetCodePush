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

public class Solution2 {
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

    private LinkedList<String> res;

    public List<String> letterCombinations(String digits) {
        res = new LinkedList<>();
        if (!digits.isEmpty()) {
            addCombination(digits, 0, "");
        }
        return res;
    }

    private void addCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        for (char c : phoneMap.get(digits.charAt(index))) {
            addCombination(digits, index + 1, s + c);
        }
    }


    @Test
    public void test() {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("4"));
    }
}
