package LC0468;

/**
 * @author zhanglei211 on 2021/11/4.
 */
class Solution {
    public String validIPAddress(String queryIP) {
        String[] split = queryIP.split("\\.");
        if (split.length == 4) {
            char c1 = queryIP.charAt(0);
            char c2 = queryIP.charAt(queryIP.length() - 1);
            if (c1 == '.' || c2 == '.') {
                return "Neither";
            }
            if (checkIpv4(split)) {
                return "IPv4";
            }
        }

        split = queryIP.split(":");

        if (split.length == 8) {
            char c1 = queryIP.charAt(0);
            char c2 = queryIP.charAt(queryIP.length() - 1);
            if (c1 == ':' || c2 == ':') {
                return "Neither";
            }
            if (checkIpv6(split)) {
                return "IPv6";
            }
        }
        return "Neither";
    }

    private boolean inRange(int num, int left, int right) {
        return num >= left && num <= right;
    }

    private boolean checkIpv4(String[] split) {
        for (String s : split) {
            int length = s.length();
            if (length == 1) {
                int num1 = s.charAt(0) - '0';
                if (!inRange(num1, 0, 9)) {
                    return false;
                }
            } else if (length == 2) {
                int num1 = s.charAt(0) - '0';
                int num2 = s.charAt(1) - '0';
                if (inRange(num1, 1, 9)) {
                    if (!inRange(num2, 0, 9)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (length == 3) {
                int num1 = s.charAt(0) - '0';
                int num2 = s.charAt(1) - '0';
                int num3 = s.charAt(2) - '0';
                if (num1 == 0) {
                    return false;
                } else if (num1 == 1) {
                    if (!inRange(num2, 0, 9)) {
                        return false;
                    }
                    if (!inRange(num3, 0, 9)) {
                        return false;
                    }
                } else if (num1 == 2) {
                    if (inRange(num2, 0, 4)) {
                        if (!inRange(num3, 0, 9)) {
                            return false;
                        }
                    } else if (num2 == 5) {
                        if (!inRange(num3, 0, 5)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean checkIpv6(String[] split) {
        for (String s : split) {
            int length = s.length();
            if (!inRange(length, 1, 4)) {
                return false;
            }
            char[] arr = s.toCharArray();
            for (char c : arr) {
                if (!(c - '0' >= 0 && c - '0' <= 9 || (c - 'a' >= 0 && c - 'a' <= 5)
                        || (c - 'A' >= 0 && c - 'A' <= 5))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
    }
}