import java.util.*;

/** Dependency-free regression and differential checks. Any failure exits nonzero. */
public final class InterviewSolutionsTest {
    private static int checks;
    private static void eq(Object actual, Object expected) {
        checks++;
        if (!Objects.deepEquals(actual, expected))
            throw new AssertionError("Check " + checks + ": expected " + render(expected) + ", got " + render(actual));
    }
    private static String render(Object value) {
        if (value instanceof int[]) return Arrays.toString((int[]) value);
        if (value instanceof Object[]) return Arrays.deepToString((Object[]) value);
        return String.valueOf(value);
    }
    private static void invalid(Runnable action) {
        checks++;
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Expected IllegalArgumentException");
    }
    private static Set<List<Integer>> subsets(List<List<Integer>> values) { return new HashSet<>(values); }
    private static Set<List<String>> groups(List<List<String>> values) { return new HashSet<>(values); }

    public static void main(String[] args) {
        eq(InterviewSolutions.reverseString("aakash"), "hsakaa");
        eq(InterviewSolutions.reverseString(""), "");
        eq(InterviewSolutions.revWords(" apple\tbanana   kiwi "), "kiwi banana apple");
        eq(InterviewSolutions.revWords("  \t"), "");
        eq(InterviewSolutions.revWordsWithCharater("apple banana kiwi"), "iwik ananab elppa");
        eq(InterviewSolutions.revWordsWithCharater(""), "");
        eq(InterviewSolutions.isPalindrome("abba"), true);
        eq(InterviewSolutions.isPalindrome("Abba"), false);
        eq(InterviewSolutions.isPalindrome(""), true);
        eq(InterviewSolutions.minnumber(new int[]{6,5,9,1,8}), 1);
        eq(InterviewSolutions.minnumber(new int[]{Integer.MIN_VALUE}), Integer.MIN_VALUE);
        invalid(() -> InterviewSolutions.minnumber(new int[]{}));
        eq(InterviewSolutions.secondMin(new int[]{1,1,3,5}), 3);
        eq(InterviewSolutions.secondMin(new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE}), Integer.MAX_VALUE);
        eq(InterviewSolutions.secondmax(new int[]{9,9,7,1}), 7);
        eq(InterviewSolutions.secondmax(new int[]{-1,-3,-2}), -2);
        invalid(() -> InterviewSolutions.secondMin(new int[]{1,1}));
        invalid(() -> InterviewSolutions.secondmax(new int[]{}));
        eq(InterviewSolutions.duplicateRemover("banana"), "ban");
        eq(InterviewSolutions.duplicateRemover(""), "");
        eq(InterviewSolutions.countLetters("aauuchhh"), Map.of('a',2,'u',2,'c',1,'h',3));
        eq(InterviewSolutions.countLetters(""), Map.of());
        eq(InterviewSolutions.CountMaxOcuuringCharater("aAabb"), Map.of('a',3));
        eq(InterviewSolutions.CountMaxOcuuringCharater("AaBB"), Map.of('a',2,'b',2));
        eq(InterviewSolutions.CountMaxOcuuringCharater(""), Map.of());
        eq(InterviewSolutions.twoSums(new int[]{1,2,3,5},4), new int[]{0,2});
        eq(InterviewSolutions.twoSums(new int[]{3,3},6), new int[]{0,1});
        eq(InterviewSolutions.twoSums(new int[]{Integer.MAX_VALUE,1},Integer.MIN_VALUE), new int[]{});
        eq(InterviewSolutions.sumof(new int[]{1,1,1},2), List.of(1,1,1,1,1,1));
        eq(InterviewSolutions.sumof(new int[]{1},2), List.of());
        eq(InterviewSolutions.firstNonRepeating("geeksforgeeks"), 'f');
        eq(InterviewSolutions.firstNonRepeating("aabb"), null);
        eq(InterviewSolutions.firstNonRepeating("_aa"), '_');
        eq(InterviewSolutions.firstUniqChar("geeksforgeeks"), 5);
        eq(InterviewSolutions.firstUniqChar(""), -1);
        eq(InterviewSolutions.stringCompression("aaabbvvfffddaa"), "a3b2v2f3d2a2");
        eq(InterviewSolutions.stringCompression(""), "");
        eq(InterviewSolutions.stringCompression("aaaaaaaaaaa"), "a11");
        int[] original={1,2,3,4,5};
        eq(InterviewSolutions.LeftRotate(original,1), new int[]{2,3,4,5,1});
        eq(original, new int[]{1,2,3,4,5});
        eq(InterviewSolutions.RightRotate(original,2), new int[]{4,5,1,2,3});
        eq(InterviewSolutions.RightRotate(original,7), new int[]{4,5,1,2,3});
        eq(InterviewSolutions.LeftRotate(new int[]{},3), new int[]{});
        invalid(() -> InterviewSolutions.RightRotate(original,-1));
        eq(InterviewSolutions.isBalanced("[{()}]"), true);
        eq(InterviewSolutions.isBalanced("([)]"), false);
        eq(InterviewSolutions.isBalanced("("), false);
        eq(InterviewSolutions.isBalanced(")"), false);
        eq(InterviewSolutions.isBalanced(""), true);
        eq(InterviewSolutions.isAnagram("listen","silent"), true);
        eq(InterviewSolutions.isAnagram("a","aa"), false);
        eq(groups(InterviewSolutions.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"})),
            Set.of(List.of("eat","tea","ate"),List.of("tan","nat"),List.of("bat")));
        eq(InterviewSolutions.groupAnagrams(new String[]{}), List.of());
        eq(InterviewSolutions.longestCommonPrefix(new String[]{"geeksforgeeks","geeks","geek","geezer"}), "gee");
        eq(InterviewSolutions.longestCommonPrefix(new String[]{"","a"}), "");
        eq(InterviewSolutions.longestCommonPrefix(new String[]{}), "");
        eq(InterviewSolutions.missingNumber(6,new int[]{1,2,3,4,6}), 5);
        eq(InterviewSolutions.missingNumber(1,new int[]{}), 1);
        invalid(() -> InterviewSolutions.missingNumber(5,new int[]{1,2,3,4,6}));
        eq(InterviewSolutions.lengthOfLongestSubstring("abcabcbb"), 3);
        eq(InterviewSolutions.longestSubstring("abcabcbb"), "abc");
        eq(InterviewSolutions.longestSubstring(""), "");
        eq(InterviewSolutions.longestPalindromeExpand("abcdabbacfd"), "abba");
        eq(InterviewSolutions.longestPallindromeSubstring("abcdabbacfd"), "abba");
        eq(InterviewSolutions.longestPalindromeExpand(""), "");
        eq(InterviewSolutions.getFirstIndexOfSubstring("hello","ll"), 2);
        eq(InterviewSolutions.getFirstIndexOfSubstring("abc","c"), 2);
        eq(InterviewSolutions.getFirstIndexOfSubstring("abc","abc"), 0);
        eq(InterviewSolutions.getFirstIndexOfSubstring("abc","d"), -1);
        eq(InterviewSolutions.getFirstIndexOfSubstring("a","aa"), -1);
        eq(InterviewSolutions.getFirstIndexOfSubstring("",""), 0);
        eq(InterviewSolutions.isRotation("waterbottle","erbottlewat"), true);
        eq(InterviewSolutions.isRotation("hello","olleh"), false);
        eq(InterviewSolutions.isRotation("",""), true);
        eq(InterviewSolutions.binarySearch(new int[]{1,2,4,5,7,8,9},8), 5);
        eq(InterviewSolutions.binarySearch(new int[]{},8), -1);
        eq(InterviewSolutions.characterReplacementBrute("AABABBA",1), 4);
        eq(InterviewSolutions.characterReplacementBrute("",0), 0);
        invalid(() -> InterviewSolutions.characterReplacementBrute("lowercase",1));
        eq(InterviewSolutions.nextGreaterElement(new int[]{2,1,2,4,3}), new int[]{4,2,4,-1,-1});
        eq(InterviewSolutions.nextGreaterElementBruteForce(new int[]{2,2}), new int[]{-1,-1});
        eq(InterviewSolutions.removeAdjDuplicates("abbaca"), "ca");
        eq(InterviewSolutions.removeAdjDuplicates("aaaa"), "");
        eq(InterviewSolutions.maxSubArraySumOfKWindow(new int[]{1,2,4,3,5,6,3},2), 11L);
        eq(InterviewSolutions.maxSubArraySumOfKWindow(new int[]{-3,-2,-5},2), -5L);
        eq(InterviewSolutions.maxSubArraySumOfKWindow(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE},2),4294967294L);
        invalid(() -> InterviewSolutions.maxSubArraySumOfKWindow(new int[]{},1));
        eq(InterviewSolutions.longestSubArray(new int[]{1,2,4,3,5,6,3},3), 2);
        eq(InterviewSolutions.longestSubArray(new int[]{5,-4,1},2), 3);
        int[][] intervals={{8,10},{1,3},{2,6},{9,12},{2,4}};
        eq(InterviewSolutions.mergeIntervalss(intervals), new int[][]{{1,6},{8,12}});
        eq(intervals[0], new int[]{8,10});
        eq(InterviewSolutions.mergeIntervalss(new int[][]{{1,2},{2,3}}), new int[][]{{1,3}});
        eq(InterviewSolutions.mergeIntervalss(new int[][]{}), new int[][]{});
        eq(InterviewSolutions.twoSumSorted(new int[]{1,3,4,5},7), new int[]{1,2});
        eq(InterviewSolutions.twoSumSorted(new int[]{1,2},9), new int[]{-1,-1});
        int[] duplicated={1,1,2,2,3};
        int length=InterviewSolutions.removeDuplicates(duplicated);
        eq(length,3);eq(Arrays.copyOf(duplicated,length),new int[]{1,2,3});
        eq(InterviewSolutions.removeDuplicates(new int[]{}),0);
        eq(InterviewSolutions.maxArea(new int[]{1,8,6,2,5,4,8,3,7}),49L);
        eq(InterviewSolutions.maxArea(new int[]{}),0L);
        eq(InterviewSolutions.maxArea(new int[]{Integer.MAX_VALUE,0,Integer.MAX_VALUE}),4294967294L);
        eq(subsets(InterviewSolutions.threeSum(new int[]{-1,0,1,2,-1,-4})),Set.of(List.of(-1,-1,2),List.of(-1,0,1)));
        eq(InterviewSolutions.threeSum(new int[]{0,0,0,0}),List.of(List.of(0,0,0)));
        int[] zeros={0,1,0,3,12};InterviewSolutions.moveZeroes(zeros);eq(zeros,new int[]{1,3,12,0,0});
        eq(InterviewSolutions.isSorted(new int[]{1,1,3}),true);
        eq(InterviewSolutions.isSorted(new int[]{1,3,2}),false);
        eq(InterviewSolutions.isSorted(new int[]{}),true);
        eq(InterviewSolutions.isSubsequence("abc","abfcd"),true);
        eq(InterviewSolutions.isSubsequence("acb","abc"),false);
        eq(InterviewSolutions.intersection(new int[]{1,2,2,3,4},new int[]{2,4,2}),List.of(2,4));
        eq(InterviewSolutions.intersection(new int[]{},new int[]{2}),List.of());
        eq(InterviewSolutions.findCommonIn3Array(new int[]{1,2,2,3},new int[]{2,2,3,4},new int[]{0,2,2,3}),List.of(2,3));
        eq(InterviewSolutions.findCommonIn3Array(new int[]{},new int[]{1},new int[]{1}),List.of());
        eq(InterviewSolutions.longestConsecutive(new int[]{100,4,200,1,3,2}),4);
        eq(InterviewSolutions.longestConsecutive(new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE}),1);
        eq(InterviewSolutions.longestConsecutive(new int[]{1,2,2,3}),3);
        eq(InterviewSolutions.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}),6L);
        eq(InterviewSolutions.trap(new int[]{1,2,3}),0L);
        eq(InterviewSolutions.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}),6L);
        eq(InterviewSolutions.maxSubArray(new int[]{-3,-2,-5}),-2L);
        invalid(() -> InterviewSolutions.maxSubArray(new int[]{}));
        eq(InterviewSolutions.mergeStrings("aabcx","cxfghj"),"aabcxfghj");
        eq(InterviewSolutions.mergeStrings("abc","abc"),"abc");
        eq(InterviewSolutions.mergeStrings("","x"),"x");
        eq(InterviewSolutions.largestNumber(new int[]{3,30,34,5,9}),"9534330");
        eq(InterviewSolutions.largestNumber(new int[]{0,0}),"0");
        eq(InterviewSolutions.largestNumber(new int[]{}),"");
        invalid(() -> InterviewSolutions.largestNumber(new int[]{-1}));
        eq(subsets(InterviewSolutions.getSubsets(new int[]{2,3})),Set.of(List.of(),List.of(2),List.of(3),List.of(2,3)));
        eq(InterviewSolutions.getSubsets(new int[]{}),List.of(List.of()));
        eq(InterviewSolutions.getSubsets(new int[]{2,3}).size(),4);
        eq(subsets(InterviewSolutions.maxsubsetsofsum(new int[]{2,3,5,6,8},10)),Set.of(List.of(2,3,5),List.of(2,8)));
        eq(subsets(InterviewSolutions.maxsubsetsofsum(new int[]{-1,1},0)),Set.of(List.of(),List.of(-1,1)));
        eq(InterviewSolutions.balancedRuns(new int[]{2,1,3,1,2}),1);
        eq(InterviewSolutions.balancedRuns(new int[]{0,0,0}),3);
        eq(InterviewSolutions.balancedRuns(new int[]{}),0);
        eq(InterviewSolutions.envChecker(List.of(List.of(1,2),List.of(1,2),List.of(2,3))),List.of(1,2,3));
        eq(InterviewSolutions.envChecker(List.of(List.of(1,2),List.of(1))),List.of(2,1));
        eq(InterviewSolutions.envChecker(List.of(List.of(1,2),List.of(1,2),List.of(2,3),List.of(1,3))),List.of());
        eq(InterviewSolutions.findSchedules("08??840",24,8),List.of("0804840","0813840","0822840","0831840","0840840"));
        eq(InterviewSolutions.findSchedules("08??840",24,4),List.of());
        eq(InterviewSolutions.findSchedules("0000000",0,0),List.of("0000000"));
        eq(InterviewSolutions.findSchedules("???????",0,8),List.of("0000000"));
        invalid(() -> InterviewSolutions.findSchedules("?",1,8));
        randomizedChecks();
        System.out.println("PASS: " + checks + " checks; all 51 question groups exercised.");
    }

    private static void randomizedChecks() {
        Random random=new Random(2024);
        for(int round=0;round<250;round++) {
            int n=random.nextInt(9);int[] a=new int[n];
            for(int i=0;i<n;i++) a[i]=random.nextInt(11)-5;
            eq(InterviewSolutions.nextGreaterElement(a),InterviewSolutions.nextGreaterElementBruteForce(a));
            int equilibrium=0;
            for(int i=0;i<n;i++) {
                long left=0,right=0;
                for(int j=0;j<i;j++)left+=a[j];
                for(int j=i+1;j<n;j++)right+=a[j];
                if(left==right)equilibrium++;
            }
            eq(InterviewSolutions.balancedRuns(a),equilibrium);
            if(n>0) {
                int k=1+random.nextInt(n);long expected=Long.MIN_VALUE;
                for(int i=0;i+k<=n;i++) {long sum=0;for(int j=i;j<i+k;j++)sum+=a[j];expected=Math.max(expected,sum);}
                eq(InterviewSolutions.maxSubArraySumOfKWindow(a,k),expected);
                expected=Long.MIN_VALUE;
                for(int i=0;i<n;i++) {long sum=0;for(int j=i;j<n;j++){sum+=a[j];expected=Math.max(expected,sum);}}
                eq(InterviewSolutions.maxSubArray(a),expected);
            }
            StringBuilder builder=new StringBuilder();
            for(int i=0;i<n;i++)builder.append((char)('a'+random.nextInt(3)));
            String s=builder.toString();
            String palindrome=InterviewSolutions.longestPalindromeExpand(s);
            eq(InterviewSolutions.isPalindrome(palindrome),true);
            eq(s.contains(palindrome),true);
            eq(palindrome.length(),InterviewSolutions.longestPallindromeSubstring(s).length());
            String needle=s.isEmpty()?"x":s.substring(random.nextInt(s.length()));
            eq(InterviewSolutions.getFirstIndexOfSubstring(s,needle),s.indexOf(needle));
        }
    }
}
