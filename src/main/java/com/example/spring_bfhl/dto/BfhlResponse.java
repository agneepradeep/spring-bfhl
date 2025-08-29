package com.example.spring_bfhl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonPropertyOrder({
        "is_success",
        "user_id",
        "email",
        "roll_number",
        "odd_numbers",
        "even_numbers",
        "alphabets",
        "special_characters",
        "sum",
        "concat_string"
})
public class BfhlResponse {

    @JsonProperty("is_success")
    private boolean success;

    private String userId;
    private String email;
    private String rollNumber;
    private List<String> oddNumbers;
    private List<String> evenNumbers;
    private List<String> alphabets;
    private List<String> specialCharacters;
    private String sum;
    private String concatString;

    public BfhlResponse() {}

    // getters and setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public List<String> getOddNumbers() { return oddNumbers; }
    public void setOddNumbers(List<String> oddNumbers) { this.oddNumbers = oddNumbers; }

    public List<String> getEvenNumbers() { return evenNumbers; }
    public void setEvenNumbers(List<String> evenNumbers) { this.evenNumbers = evenNumbers; }

    public List<String> getAlphabets() { return alphabets; }
    public void setAlphabets(List<String> alphabets) { this.alphabets = alphabets; }

    public List<String> getSpecialCharacters() { return specialCharacters; }
    public void setSpecialCharacters(List<String> specialCharacters) { this.specialCharacters = specialCharacters; }

    public String getSum() { return sum; }
    public void setSum(String sum) { this.sum = sum; }

    public String getConcatString() { return concatString; }
    public void setConcatString(String concatString) { this.concatString = concatString; }
}
