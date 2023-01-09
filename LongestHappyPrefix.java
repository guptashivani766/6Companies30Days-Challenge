class LongestHappyPrefix 
{
	 public String longestPrefix(String s) {
          if (s.length() <= 1)
            return "";
        
        int[] lps = new int[s.length()];
        int len = 0;
        int i = 1;
        lps[0] = 0;
        
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0)
                    len = lps[len - 1];
                else 
                    lps[i++] = 0;
            }
        }
        
        
        return s.substring(0, lps[lps.length-1]);
    }
}
