package hashTable;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
//        Map<Character, String> phoneMap = Map.of(
//                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
//                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
//        );
        Map<Character, String> phoneMap = new HashMap<>();
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
        List<String> strings = l.letterCombinations("23");
    }
}
