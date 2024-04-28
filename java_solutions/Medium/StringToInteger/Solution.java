class Solution {
    public int myAtoi(String s) {

        // Check if the next char (1) is '-' or '+' and that will be the integer
        // positive or negative
        // if no sign then assume possitive

        // Read in the next characters until the next non-digit Or the end of the input
        // is reached and ignore it,.

        // Convert these digits into an integer

        // If the integer is out of the 32 bit signed integer range then clamp the
        // integer so that it remains in the range
        if (s.length() == 0) {
            return 0;
        }

        int pointer = 0;
        while (pointer < s.length() && s.charAt(pointer) == ' ') {
            pointer++;
        }

        if (pointer == s.length()) {
            return 0;
        }

        char sign;
        if (s.charAt(pointer) == '+' || s.charAt(pointer) == '-') {
            sign = s.charAt(pointer);
            pointer++;
        } else {
            sign = '+';
        }

        s = s.substring(pointer);
        pointer = 0;
        int ending = pointer;
        while (ending <= s.length()) {
            try {
                Integer.parseInt(s.substring(ending, ending + 1));
                ending++;
            } catch (Exception e) {
                break;
            }
        }

        if (ending == pointer) {
            return 0;
        }

        s = s.substring(pointer, ending);
        int num;
        try {
            num = Integer.parseInt(s);
        } catch (Exception e) {
            if (sign == '+') {
                num = Integer.MAX_VALUE;
            } else {
                num = Integer.MIN_VALUE;
            }
        }

        if (sign == '+') {
            return num;
        } else {
            return num * -1;
        }
    }
}