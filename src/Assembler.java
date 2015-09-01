import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Assembler {
    String[] asmCode;
    String[] machineCode;
    Instruction[] instructions;
    String hexFileName = "out.hex";
    String binaryFileName = "out.bin";

    public static void main(String[] args)  {

        if(args.length == 0) {
            System.out.println("Input file name was not provided.");
            System.exit(0);
        }

        String inputFileName = args[0];
        ArrayList<String> lines = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(new FileInputStream(inputFileName));
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }

            Assembler assembler = new Assembler();
            assembler.assemble(lines);
            assembler.writeToHex();
            assembler.writeToBinary();
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("File was not found on the same directory. Please make sure the input file is in the same path as the program");
        }
    }

    private void assemble(ArrayList<String> lines) {
        asmCode = new String[lines.size()];
        machineCode = new String[lines.size()];
        instructions = new Instruction[lines.size()];

        for(int i = 0; i < lines.size(); ++i) {
            asmCode[i] = lines.get(i);
            instructions[i] = getInstructionFromASM(asmCode[i]);
        }
    }

    // Factory method to create the appropriate instruction
    private Instruction getInstructionFromASM(String asmLine) {
        asmLine = asmLine.trim();
        for(String s : new String[]{"add", "sub", "slt", "and", "or"}) {
            if(asmLine.startsWith(s)) return new RTypeInstruction(asmLine);
        }

        for(String s : new String[]{"lw", "sw", "beq"}) {
            if(asmLine.startsWith(s)) return new ITypeInstruction(asmLine);
        }
        if(asmLine.startsWith("j")) {
            return new JTypeInstruction(asmLine);
        }

        throw new UnsupportedOperationException("Instruction not supported by the assember");
    }

    private void writeToHex() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(hexFileName));
            String output = "";
            for(Instruction i : instructions) {
                output += i.toHexString() + "\n";
            }
            bw.write(output);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeToBinary() {
        try {
            DataOutputStream oos = new DataOutputStream(new FileOutputStream(binaryFileName));
            for(Instruction i : instructions) {
                oos.writeInt(i.encode());
            }
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
