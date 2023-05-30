import java.util.Scanner;

public class InitialCode {
    private int initialCodeLength = 9;

    public String initialCodeDone(){
        String code = userInsertedCode();
        String codeAfterSeven = "";
        if (!onlyNumbersValidation(code)){
            Messages.codeNotValid();
            initialCodeDone();
        }
        else if (!validateLessThan(code)){
            Messages.enterACodeLEssThan9();
            initialCodeDone();
        }
        else{
            codeAfterSeven = addSeven(code);
        }
        return codeAfterSeven;
    }

    // Ask user for input and store the input in a variable
    private String userInsertedCode(){
        Scanner scanner = new Scanner(System.in);
        Messages.askForCode();
        String code = scanner.nextLine();
        return code;
    }
    // Validate that user entered only numbers
    private boolean onlyNumbersValidation(String code){
        if (!code.matches("[0-9]+")){
            return false;
        }
        return true;
    }
    // Checks if user entered a code with over 9 digits
    private boolean validateLessThan(String code){
        if (code.length() > initialCodeLength){
            return false;
        }
        return true;
    }
    // Validates that the code is less than initialCodeLength and adds as many "7" as needed to reach length of 9
    private String addSeven(String code){
        if (code.length() < initialCodeLength){
            while (code.length() < 9)
                code += "7";
        }
        return code;
    }
}
