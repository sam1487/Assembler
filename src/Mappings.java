import java.util.HashMap;

public class Mappings {
    private static HashMap<String, Integer> functionCodes;
    private static HashMap<String, Integer> opcodes;
    static {
        functionCodes = new HashMap<String, Integer>();
        opcodes = new HashMap<String, Integer>();

        functionCodes.put("add", 32);
        functionCodes.put("sub", 34);
        functionCodes.put("slt", 42);
        functionCodes.put("and", 36);
        functionCodes.put("or", 37);

        opcodes.put("lw", 35);
        opcodes.put("sw", 43);
        opcodes.put("beq", 4);
        opcodes.put("j", 2);

    }
    public static int getFunctionCode(String instructionName) {
        return functionCodes.get(instructionName);
    }

    public static int getOpcode(String instructionName) {
        return opcodes.get(instructionName);
    }

}
