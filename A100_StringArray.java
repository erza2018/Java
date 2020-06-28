
public class A100_StringArray
{
    public static void Problems()
    {
        Object[] o;

        //
        // Stack
        // - It's classic to match Parentheses using Stack
        //
        o = new Object[] {
             new L020_E_ValidParentheses(),
             new L032_H_LongestValidParentheses(),
        //     new L071_M_SimplifyPath(),
        };

        // //
        // // Classic reverse string, array
        // //
         o = new Object[] {
             new L344_E_ReverseString(),
             new L151_M_ReverseWordsInString(),
             new L345_E_ReverseVowelsOfAString(),
             new L189_E_RotateArray(),  // reverse all, then reverse each
         };

        // //
        // // Brutal Force
        // //
         o = new Object[] {
             new L028_E_StrStr(),
             new L055_M_JumpGame(),
             new L058_E_LengthOfLastWord(),
             new L014_E_LongestCommonPrefix(),
         };

        // //
        // // Anagram - sort with same result
        // //
         o = new Object[] {
        //     new L049_M_GroupAnagrams(),  // and track with dictionary
             new L242_E_IsAnagram(),
         };

        // //
        // // Swap position problems
        // //
         o = new Object[] {
             new L026_E_RemoveDuplicates(),
             new L027_E_RemoveElement(),
        //     new L041_H_FirstMissingPositive(),
        //     new L268_M_MissingNumber(),
             new L283_E_MoveZeros(),
         };

        // //
        // // Simple iteration through the array
        // //
         o = new Object[] {
        //     new L053_M_MaximumSubArray(),  // tracking special sum=0
             new L674_E_LongestContinuousIncreasingSubsequence(),
        //     new L676_M_MagicDictionary(),
         };

        // //
        // // Left-to-Right strategy
        // // Sometime, we can also do Right-to-Left, or do 2 passes from each side.
        // //
         o = new Object[] {
             new L011_M_ContainerWithMostWater(),
        //     new L042_H_TrappingRainWater(),
            
        //     new L075_M_SortColors(),
            
             new L125_E_ValidPalindrome(),
             new L680_E_ValidPalindrome2(),

        //     new L739_M_DailyTemperatures(),  // Iterate backward and tracking 

        //     new L135_H_Candy(),
        //     new L238_M_ProductExceptSelf(),

         };

        // //
        // // Dictionary or Hashset mapping (fast lookup)
        // //
         o = new Object[] {
        //     new L076_H_MinimumWindowSubstring(),  // also need to track/move Starting point
        //     new L030_H_SubstringWithConcatenationOfAllWords(), // dictionary mapping and tracking
             new L205_E_IsomorphicStrings(),  // dictionary mapping
             new L290_E_WordPattern(),
        //     new L677_M_MapSumPairs(),  // SortedDictionary
        //     new L128_H_LongestConsecutiveSequence(), // Hashtable for quick lookup
         };

    }
}
