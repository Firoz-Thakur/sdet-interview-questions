import java.util.*;

/** Reconstructed and corrected solutions; see questions/ for contracts. */
public final class InterviewSolutions {
    private InterviewSolutions() {}

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String revWords(String s) {
        if (s.isBlank()) return "";
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static String revWordsWithCharater(String s) {
        if (s.isBlank()) return "";
        String[] words = s.trim().split("\\s+");
        StringJoiner result = new StringJoiner(" ");
        for (int i = words.length - 1; i >= 0; i--) result.add(reverseString(words[i]));
        return result.toString();
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int minnumber(int[] a) {
        if (a.length == 0) throw new IllegalArgumentException("Array must not be empty");
        int min = a[0];
        for (int value : a) min = Math.min(min, value);
        return min;
    }

    public static int secondMin(int[] a) {
        TreeSet<Integer> values = new TreeSet<>();
        for (int value : a) values.add(value);
        if (values.size() < 2) throw new IllegalArgumentException("Need two distinct values");
        return values.higher(values.first());
    }

    public static int secondmax(int[] a) {
        TreeSet<Integer> values = new TreeSet<>();
        for (int value : a) values.add(value);
        if (values.size() < 2) throw new IllegalArgumentException("Need two distinct values");
        return values.lower(values.last());
    }

    public static String duplicateRemover(String a) {
        Set<Character> ab = new LinkedHashSet<>();
        for (int i = 0; i < a.length(); i++) {
            ab.add(a.charAt(i));
        }
        StringBuilder s = new StringBuilder();
        for (char c : ab) {
            s.append(c);
        }
        return s.toString();
    }

    public static Map<Character, Integer> countLetters(String s) {
        Map<Character, Integer> a = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (a.containsKey(s.charAt(i))) {
                a.put(s.charAt(i), a.get(s.charAt(i)) + 1);
            } else {
                a.put(s.charAt(i), 1);
            }
        }
        return a;
    }

    public static Map<Character, Integer> CountMaxOcuuringCharater(String s) {
        Map<Character, Integer> counts = new TreeMap<>();
        for (char ch : s.toLowerCase(Locale.ROOT).toCharArray()) counts.merge(ch, 1, Integer::sum);
        Map<Character, Integer> result = new LinkedHashMap<>();
        int maximum = counts.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        counts.forEach((ch, count) -> { if (count == maximum) result.put(ch, count); });
        return result;
    }

    public static int[] twoSums(int[] nums, int target) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long diff = (long) target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put((long) nums[i], i);
        }
        return new int[]{};
    }

    public static List<Integer> sumof(int[] a, int s) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if ((long) a[i] + a[j] == s) {
                    result.add(a[i]);
                    result.add((a[j]));
                }
            }
        }
        return result;
    }

    public static Character firstNonRepeating(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1)
                return e.getKey();
        }
        return null;
    }

    public static int firstUniqChar(String s) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            boolean found = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {

                return i;
            }
        }
        return -1;
    }

    public static String stringCompression(String s) {
        StringBuilder ss = new StringBuilder();
        int c = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                c++;
            } else {
                ss.append(s.charAt(i - 1));
                ss.append(c);
                c = 1;
            }
        }
        return ss.toString();
    }

    public static int[] LeftRotate(int[] arr, int k) {
        if (k < 0) throw new IllegalArgumentException("k must be nonnegative");
        int n = arr.length;
        int[] result = new int[n];
        if (n == 0) return result;
        k %= n;
        for (int i = 0; i < n; i++) result[i] = arr[(int) (((long) i + k) % n)];
        return result;
    }

    public static int[] RightRotate(int[] arr, int k) {
        if (k < 0) throw new IllegalArgumentException("k must be nonnegative");
        if (arr.length == 0) return new int[0];
        return LeftRotate(arr, (arr.length - k % arr.length) % arr.length);
    }

    public static boolean isBalanced(String str) {
        Stack<Character> st = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char latestOpenedPar = st.pop();
                if (latestOpenedPar == '{' && ch != '}') {
                    return false;
                } else if (latestOpenedPar == '(' && ch != ')') {
                    return false;
                } else if (latestOpenedPar == '[' && ch != ']') {
                    return false;
                }
            }
        }
        return st.size() == 0;
    }

    public static Boolean isAnagram(String a, String b) {
        char a_[] = a.toCharArray();
        char b_[] = b.toCharArray();
        Arrays.sort(a_);
        Arrays.sort(b_);
        return Arrays.equals(a_, b_);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);

        }
        return new ArrayList<>(map.values());
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static int missingNumber(int n, int[] arr) {
        if (n < 1 || arr.length != n - 1) throw new IllegalArgumentException("Need n-1 values");
        int answer = n;
        for (int i = 0; i < arr.length; i++) answer ^= (i + 1) ^ arr[i];
        return answer;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static String longestSubstring(String s) {
        if (s == null || s.length() == 0) return "";
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0, startIndex = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    public static String longestPalindromeExpand(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static String longestPallindromeSubstring(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (isPalindrome(substring) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }
        return longest;
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static int getFirstIndexOfSubstring(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) return i;
        }
        return -1;
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String combined = s1 + s1;
        return combined.contains(s2);
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int characterReplacementBrute(String s, int k) {
        if (k < 0 || !s.matches("[A-Z]*")) throw new IllegalArgumentException("Need uppercase A-Z and nonnegative k");
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            int maxFreq = 0;
            for (int j = i; j < n; j++) {
                count[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, count[s.charAt(j) - 'A']);
                int window = j - i + 1;
                if (window - maxFreq <= k) {
                    maxLen = Math.max(maxLen, window);
                }
            }
        }
        return maxLen;
    }

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public static int[] nextGreaterElementBruteForce(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    arr[i] = nums[j];
                    break;
                }
            }
        }
        return arr;
    }

    public static String removeAdjDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }

    public static long maxSubArraySumOfKWindow(int[] a, int k) {
        if (k <= 0 || k > a.length) throw new IllegalArgumentException("Invalid window size");
        long sum = 0;
        for (int i = 0; i < k; i++) sum += a[i];
        long best = sum;
        for (int i = k; i < a.length; i++) {
            sum += (long) a[i] - a[i - k];
            best = Math.max(best, sum);
        }
        return best;
    }

    public static int longestSubArray(int[] arr, int k) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    public static int[][] mergeIntervalss(int[][] intervals) {
        int[][] sorted = Arrays.stream(intervals).map(int[]::clone).toArray(int[][]::new);
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] current : sorted) {
            if (merged.isEmpty() || current[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(current.clone());
            } else {
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], current[1]);
            }
        }
        return merged.toArray(int[][]::new);
    }

    public static int[] twoSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            long sum = (long) nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static long maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        long maxArea = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            long area = (long) h * width;
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }

    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) if (arr[i - 1] > arr[i]) return false;
        return true;
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static List<Integer> intersection(int[] a, int[] b) {
        Set<Integer> remaining = new HashSet<>();
        for (int value : a) remaining.add(value);
        List<Integer> result = new ArrayList<>();
        for (int value : b) if (remaining.remove(value)) result.add(value);
        return result;
    }

    public static List<Integer> findCommonIn3Array(int[] a, int[] b, int[] c) {
        int i = 0, j = 0, k = 0;
        List<Integer> result = new ArrayList<>();
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) result.add(a[i]);
                i++; j++; k++;
            } else {
                int smallest = Math.min(a[i], Math.min(b[j], c[k]));
                if (a[i] == smallest) i++;
                if (b[j] == smallest) j++;
                if (c[k] == smallest) k++;
            }
        }
        return result;
    }

    public static int longestConsecutive(int[] arr) {
        Set<Integer> values = new HashSet<>();
        for (int value : arr) values.add(value);
        int best = 0;
        for (int value : values) {
            if (value != Integer.MIN_VALUE && values.contains(value - 1)) continue;
            int current = value, length = 1;
            while (current != Integer.MAX_VALUE && values.contains(current + 1)) { current++; length++; }
            best = Math.max(best, length);
        }
        return best;
    }

    public static long trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        long water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    water += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

    public static long maxSubArray(int[] nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Array must not be empty");
        long max = nums[0], sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        return max;
    }

    public static String mergeStrings(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        for (int i = minLen; i > 0; i--) {
            if (s1.substring(s1.length() - i).equals(s2.substring(0, i))) {
                return s1 + s2.substring(i);
            }
        }
        return s1 + s2;
    }

    public static String largestNumber(int[] nums) {
        if (nums.length == 0) return "";
        for (int value : nums) if (value < 0) throw new IllegalArgumentException("Nonnegative values only");
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        if (arr[0].equals("0")) return "0";
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }
        return result.toString();
    }

    public static List<List<Integer>> getSubsets(int[] a) {
        List<List<Integer>> result = new ArrayList<>();
        collectSubsets(a, 0, new ArrayList<>(), result);
        return result;
    }
    private static void collectSubsets(int[] a, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == a.length) { result.add(new ArrayList<>(current)); return; }
        current.add(a[index]);
        collectSubsets(a, index + 1, current, result);
        current.remove(current.size() - 1);
        collectSubsets(a, index + 1, current, result);
    }

    public static List<List<Integer>> maxsubsetsofsum(int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> subset : getSubsets(nums)) {
            long sum = 0;
            for (int value : subset) sum += value;
            if (sum == target) result.add(subset);
        }
        return result;
    }

    public static int balancedRuns(int[] times) {
        long right = 0, left = 0;
        for (int value : times) right += value;
        int count = 0;
        for (int value : times) {
            right -= value;
            if (left == right) count++;
            left += value;
        }
        return count;
    }

    public static List<Integer> envChecker(List<List<Integer>> allowed) {
        List<Integer> result = new ArrayList<>();
        if (!assignEnvironments(allowed, 0, new HashSet<>(), result)) return Collections.emptyList();
        return result;
    }
    private static boolean assignEnvironments(List<List<Integer>> allowed, int index, Set<Integer> used, List<Integer> result) {
        if (index == allowed.size()) return true;
        for (int value : allowed.get(index)) {
            if (!used.add(value)) continue;
            result.add(value);
            if (assignEnvironments(allowed, index + 1, used, result)) return true;
            result.remove(result.size() - 1);
            used.remove(value);
        }
        return false;
    }

    public static List<String> findSchedules(String pattern, int workHours, int dayHours) {
        if (pattern.length() != 7 || dayHours < 0 || dayHours > 9 || workHours < 0)
            throw new IllegalArgumentException("Need seven days, nonnegative total, and daily limit 0..9");
        int known = 0;
        for (char ch : pattern.toCharArray()) {
            if (ch == '?') continue;
            if (ch < '0' || ch > '9') throw new IllegalArgumentException("Use digits or ?");
            if (ch - '0' > dayHours) return Collections.emptyList();
            known += ch - '0';
        }
        List<String> result = new ArrayList<>();
        backtrack(pattern.toCharArray(), 0, workHours - known, dayHours, result);
        return result;
    }

    public static void backtrack(char[] schedule, int index, int remainingHours, int dayHours, List<String> results) {
        if (index == schedule.length) {
            if (remainingHours == 0) {
                results.add(new String(schedule));
            }
            return;
        }
        if (remainingHours < 0) {
            return;
        }
        if (schedule[index] != '?') {
            backtrack(schedule, index + 1, remainingHours, dayHours, results);
            return;
        }
        for (int hours = 0; hours <= dayHours; hours++) {
            if (hours <= remainingHours) {
                schedule[index] = (char) (hours + '0');
                backtrack(schedule, index + 1, remainingHours - hours, dayHours, results);
                schedule[index] = '?';
            }
        }
    }
}
