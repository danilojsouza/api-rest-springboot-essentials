package br.com.devdojo.error;

public class CustomErrorType {
    private String ErrorMessage;

    public CustomErrorType(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }
}
