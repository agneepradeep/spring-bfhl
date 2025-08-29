package com.example.spring_bfhl.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BfhlService {

    /**
     * Classifies input values into numbers (odd/even), alphabets, specials,
     * computes sum and builds concat_string as specified:
     * - collect all alphabetic characters (in original order),
     * - reverse that list,
     * - build alternating caps starting with UPPER for first char.
     */
    public Result process(List<String> data) {
        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        List<Character> allAlphaChars = new ArrayList<>();
        long sum = 0L;

        if (data != null) {
            for (String item : data) {
                if (item == null) {
                    specialCharacters.add(null);
                    continue;
                }
                String trimmed = item.trim();
                if (trimmed.matches("^[0-9]+$")) {
                    // numeric
                    try {
                        long val = Long.parseLong(trimmed);
                        sum += val;
                        if (val % 2 == 0) evenNumbers.add(trimmed);
                        else oddNumbers.add(trimmed);
                    } catch (NumberFormatException e) {
                        // if too large, treat as special
                        specialCharacters.add(item);
                    }
                } else if (trimmed.matches("^[A-Za-z]+$")) {
                    // pure alphabet string -> add uppercase to alphabets list
                    alphabets.add(trimmed.toUpperCase());
                    // collect original-chars preserving original case for concat logic
                    for (char c : trimmed.toCharArray()) {
                        allAlphaChars.add(c);
                    }
                } else {
                    // anything else is special character(s)
                    specialCharacters.add(item);
                    // But also if a token contains letters among other chars, we do NOT treat as alphabet
                }
            }
        }

        // Build concat_string: reverse collected alpha chars, alternating caps starting with upper
        Collections.reverse(allAlphaChars);
        StringBuilder concat = new StringBuilder();
        boolean upper = true;
        for (Character ch : allAlphaChars) {
            if (upper) concat.append(Character.toUpperCase(ch));
            else concat.append(Character.toLowerCase(ch));
            upper = !upper;
        }

        return new Result(oddNumbers, evenNumbers, alphabets, specialCharacters, String.valueOf(sum), concat.toString());
    }

    // internal simple holder
    public static class Result {
        public final List<String> oddNumbers;
        public final List<String> evenNumbers;
        public final List<String> alphabets;
        public final List<String> specialCharacters;
        public final String sum;
        public final String concatString;

        public Result(List<String> oddNumbers, List<String> evenNumbers, List<String> alphabets,
                      List<String> specialCharacters, String sum, String concatString) {
            this.oddNumbers = oddNumbers;
            this.evenNumbers = evenNumbers;
            this.alphabets = alphabets;
            this.specialCharacters = specialCharacters;
            this.sum = sum;
            this.concatString = concatString;
        }
    }
}
