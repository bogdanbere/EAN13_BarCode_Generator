public class BarCode {
    public static void main(String[] args){
        ProductName pn = new ProductName();
        InitialCode ic = new InitialCode();
        CodeAfterAddingRo ro = new CodeAfterAddingRo();
        ControlDigitCalculator cd = new ControlDigitCalculator();
        BarCodeGenerator bg = new BarCodeGenerator();

        String name = pn.name();
        String code = ic.initialCodeDone();
        String codeWithRo = ro.addRoCode(code);
        String finalCode = cd.controlDigit(codeWithRo);
        System.out.println(finalCode);
        bg.generateBarCode(finalCode, name);
    }
}
