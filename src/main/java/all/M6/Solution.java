package all.M6;

class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            int currIndex = i;
            boolean addLeft = true;
            int leftIncrement = 2 * (numRows - 1 - i);
            int rightIncrement = 2 * i;
            while (currIndex < s.length()) {
                sb.append(s.charAt(currIndex));
                if (i == 0) {
                    if (leftIncrement == 0) {
                        return s;
                    }
                    currIndex += leftIncrement;
                } else if (i == numRows - 1) {
                    currIndex += rightIncrement;
                } else {
                    if (addLeft) {
                        currIndex += leftIncrement;
                        addLeft = false;
                    } else {
                        currIndex += rightIncrement;
                        addLeft = true;
                    }
                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.convert("PAYPALISHIRING",3)+"\nPAHNAPLSIIGYIR\n");
        System.out.println(so.convert("PAYPALISHIRING",4)+"\nPINALSIGYAHRPI");
        System.out.println(so.convert("A",1)+"\nA");

    }
}
