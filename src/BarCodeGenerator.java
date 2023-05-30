import java.io.FileWriter;

public class BarCodeGenerator {
    private void initializeBit(int bit[])
    {
        for (int i= 0; i < 96; i++)
            bit[i] = 0;
    }

    private void L(int valueAt, int bit[], int position)
    {
        switch (valueAt)
        {
            case 0: // 0001101
                bit[position + 3] = bit[position + 4] = bit[position + 6] = 1;
                break;
            case 1: // 0011001
                bit[position + 2] = bit[position + 3] = bit[position + 6] = 1;
                break;
            case 2: // 0010011
                bit[position + 2] = bit[position + 5] = bit[position + 6] = 1;
                break;
            case 3: // 0111101
                bit[position + 1] = bit[position + 2] = bit[position + 3] = bit[position + 4] = bit[position + 6] = 1;
                break;
            case 4: // 0100011
                bit[position + 1] = bit[position + 5] = bit[position + 6] = 1;
                break;
            case 5: // 0110001
                bit[position + 1] = bit[position + 2] = bit[position + 6] = 1;
                break;
            case 6: // 0101111
                bit[position + 1] = bit[position + 3] = bit[position + 4] = bit[position + 5] = bit[position + 6] = 1;
                break;
            case 7: // 0111011
                bit[position + 1] = bit[position + 2] = bit[position + 3] = bit[position + 5] = bit[position + 6] = 1;
                break;
            case 8: // 0110111
                bit[position + 1] = bit[position + 2] = bit[position + 4] = bit[position + 5] = bit[position + 6] = 1;
                break;
            case 9: // 0001011
                bit[position + 3] = bit[position + 5] = bit[position + 6] = 1;
                break;
        }
    }
    private void G(int valueAt, int bit[], int position)
    {
        switch (valueAt)
        {
            case 0: // 0100111
                bit[position + 1] = bit[position + 4] = bit[position + 5] = bit[position + 6] = 1;
                break;
            case 1: // 0110011
                bit[position + 1] = bit[position + 2] = bit[position + 5] = bit[position + 6] = 1;
                break;
            case 2: //0011011
                bit[position + 2] = bit[position + 3] = bit[position + 5] = bit[position + 6] = 1;
                break;
            case 3: //0100001
                bit[position + 1] = bit[position + 6] = 1;
                break;
            case 4: //0011101
                bit[position + 2] = bit[position + 3] = bit[position + 4] = bit[position + 6] = 1;
                break;
            case 5: // 0111001
                bit[position + 1] = bit[position + 2] = bit[position + 3] = bit[position + 6] = 1;
                break;
            case 6: //0000101
                bit[position + 4] = bit[position + 6] = 1;
                break;
            case 7: //  0010001
                bit[position + 2] = bit[position + 6] = 1;
                break;
            case 8: //  0001001
                bit[position + 3] = bit[position + 6] = 1;
                break;
            case 9: // 0010111
                bit[position + 2] = bit[position + 4] = bit[position + 5] = bit[position + 6] = 1;
                break;
        }
    }

    private void R(int valueAt, int bit[], int position)
    {
        switch (valueAt)
        {
            case 0: //		1110010
                bit[position] = bit[position + 1] = bit[position + 2] = bit[position + 5] = 1;
                break;
            case 1: //		1100110
                bit[position] = bit[position + 1] = bit[position + 4] = bit[position + 5] = 1;
                break;
            case 2: //		1101100
                bit[position] = bit[position + 1] = bit[position + 3] = bit[position + 4] = 1;
                break;
            case 3: //		1000010
                bit[position] = bit[position + 5] = 1;
                break;
            case 4: //		1011100
                bit[position] = bit[position + 2] = bit[position + 3] = bit[position + 4] = 1;
                break;
            case 5: //		1001110
                bit[position] = bit[position + 3] = bit[position + 4] = bit[position + 5] = 1;
                break;
            case 6: //		1010000
                bit[position] = bit[position + 2] = 1;
                break;
            case 7: //		1000100
                bit[position] = bit[position + 4] = 1;
                break;
            case 8: //		1001000
                bit[position] = bit[position + 3] = 1;
                break;
            case 9: //		1110100
                bit[position] = bit[position + 1] = bit[position + 2] = bit[position + 4] = 1;
                break;
        }
    }

    public void generateBarCode(String code, String name)
    {
        int[] bit = new int[96];
        initializeBit(bit);
        bit[0] = bit[2] = 1;
        L(code.charAt(1), bit, 3);
        G(code.charAt(2), bit, 10);
        G(code.charAt(3), bit, 17);
        L(code.charAt(4), bit, 24);
        L(code.charAt(5), bit, 31);
        G(code.charAt(6), bit, 38);
        bit[45] = bit[47] = bit[49] = 0;
        bit[46] = bit[48] = 1;
        R(code.charAt(7), bit, 56);
        R(code.charAt(8), bit, 63);
        R(code.charAt(9), bit, 70);
        R(code.charAt(10), bit, 77);
        R(code.charAt(11), bit, 84);
        R(code.charAt(12), bit, 91);
        bit[92] = bit[94] = 1;
        bit[93] = 0;
        int x1 = 0, y2 = 65, i = 0;

        try {
            FileWriter writer = new FileWriter("code.html");
            writer.write("<!DOCTYPE html>\n");
            writer.append("<html><body><center>\n");
            writer.append("<h5>" + name + "</h5>");
            writer.append("<svg height=\\\"70\\\" width=\\\"200\\\">\n");
            writer.append("<line x1=\"" + x1 + "\" y1=\"0\" x2=\"" + x1
                    + "\" y2=\"" + y2
                    + "\" style=\"stroke:rgb(0,0,0); stroke-width:2\"/>\n");
            while (i < 96) {
                if (bit[i] == 0 || bit[i] == 2 || bit[i] == 46 || bit[i] == 48 || bit[i] == 92 || bit[i] == 94) {
                    y2 = 65;
                    writer.append("<line x1=\"" + x1 + "\" y1=\"0\" x2=\"" + x1
                            + "\" y2=\"" + y2 + "\" style=\"stroke:rgb(0,0,0); stroke-width:2\"/>\n");
                } else {
                    y2 = 50;
                    writer.append("<line x1=\"" + x1 + "\" y1=\"0\" x2=\"" + x1
                            + "\" y2=\"" + y2 + "\" style=\"stroke:rgb(0,0,0); stroke-width:3\"/>\n");
                }
                x1 += 4;
                i++;
            }
            writer.append("<text x=\"0\" y=\"85\" style=\"letter-spacing:1em;\">" + code + "</text>");
            writer.append("</svg>\n");
            writer.append("</center></body></html>\n");
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Code generated successfully");
    }
}
