package DSA.LeetCode;

//https://leetcode.com/problems/longest-repeating-character-replacement/description (424)

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k){
        int left = 0;
        int right = 0;
        int maxLenght = 0;
        int maxFreq = 0;
        int[] charMap = new int[26];

        while(right < s.length()){
            char rightChar = s.charAt(right);
            charMap[rightChar - 'A']++;

            maxFreq = Math.max(maxFreq, charMap[rightChar - 'A']);

            int len = right - left + 1;
            int changeable = len - maxFreq;
            while (changeable > k){
                char leftChar = s.charAt(left);

                charMap[leftChar - 'A']--;

                left++;

                len = right - left + 1;

                changeable = len - maxFreq;
            }

            maxLenght = Math.max(maxLenght, len);

            right++;
        }

        return  maxLenght;
    }
}
