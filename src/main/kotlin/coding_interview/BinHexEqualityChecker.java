package coding_interview;

public class BinHexEqualityChecker {
    public static boolean compareBinToHex(String binary, String hex) {
        int n1 = convertFromBase(binary, 2);
        int n2 = convertFromBase(hex, 16);
        if(n1 < 0 || n2 < 0)
            return false;
        return n1 == n2;
    }

    private static int convertFromBase(String number, int base) {
        if(base < 2 || (base > 10 && base != 16)) return -1;
        int value = 0;
        for(int i = number.length() - 1; i >= 0; i--) {
            int digit = digitToValue(number.charAt(i));
            if(digit < 0 || digit >= base) {
                return -1;
            }
            int exp = number.length() - 1 - i;
            value += digit * Math.pow(base, exp);
        }
        return value;
    }

    private static int digitToValue(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'F') {
            return 10 + c - 'A';
        } else if (c >= 'a' && c <= 'f') {
            return 10 + c - 'a';
        } else {
            return -1;
        }
    }
}
