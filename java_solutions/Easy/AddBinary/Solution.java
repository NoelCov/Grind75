class Solution {
    // Space Complexity O(n) where n is a + b
    // Time Complexity O(n) where n is the length of the longest string.
    public String addBinary(String a, String b) {
        int carry = 0;
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (aPointer >= 0 || bPointer >= 0) {
            int sum = carry;

            if (aPointer >= 0) {
                sum += (int) a.charAt(aPointer) - '0';
            }

            if (bPointer >= 0) {
                sum += (int) b.charAt(bPointer) - '0';
            }

            sb.append(sum % 2);
            carry = sum / 2;

            aPointer--;
            bPointer--;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}