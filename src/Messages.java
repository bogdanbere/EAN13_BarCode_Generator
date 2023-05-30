public class Messages {
    public static void askForCode(){
        System.out.println("Enter a code of maximum 9 digits:");
    }
    public static void enterACodeLEssThan9(){
        System.out.println("Incorrect code, your code should have less than 9 digits.");
    }
    public static void codeNotValid(){
        System.out.println("The code you entered is not valid. Please enter a code containing only digits.");
    }
    public static void askForNameOfProduct(){
        System.out.println("Enter the name of the product:");
    }
}
