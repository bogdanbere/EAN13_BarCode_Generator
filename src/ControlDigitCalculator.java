public class ControlDigitCalculator {
    public String controlDigit(String code)
    {
        int odd = 0;
        int even = 0;
        int cDigit = 0;
        for (int i = 0; i < code.length(); i++)
        {
            if ((int)code.charAt(i) % 2 == 0)
            {
                even += (int)code.charAt(i);
            }
            else
            {
                odd += (int)code.charAt(i);
            }
        }
        odd *= 3;
        int total = odd + even;
        if (total % 10 == 0)
        {
            cDigit = 0;
        }
        else
        {
            cDigit = 10 - (total % 10);
        }
        String stringcDigit = String.valueOf(cDigit);

        return code = stringcDigit + code;
    }
}

