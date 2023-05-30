import java.util.Scanner;

public class ProductName {
    public String name(){
        Scanner scanner = new Scanner(System.in);
        Messages.askForNameOfProduct();
        String productName = scanner.nextLine();
        return productName;
    }
}
