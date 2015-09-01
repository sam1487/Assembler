public class RTypeInstruction extends Instruction {
    protected int rs, rd, rt;
    protected int shamt, function;

    public RTypeInstruction(String instruction) {
        super(instruction);
    }

    @Override
    public void decode(String instruction) {
        instruction = instruction.replaceAll("\\$", "");
        instruction = instruction.replaceAll(",", " ");

        String[] tokens = instruction.split("\\s+");
        String instructionName = tokens[0].trim().toLowerCase();

        this.opcode = 0;
        this.rd = Integer.parseInt(tokens[1]);
        this.rs = Integer.parseInt(tokens[2]);
        this.rt = Integer.parseInt(tokens[3]);
        this.shamt = 0;
        this.function = Mappings.getFunctionCode(instructionName);
    }

    @Override
    public int encode() {
        int toret = 0;
        toret |= opcode << 26;
        toret |= this.rs << 21;
        toret |= this.rt << 16;
        toret |= this.rd << 11;
        toret |= this.shamt << 6;
        toret |= this.function;


        return toret;
    }

    @Override
    public String toString() {
        return "R-type: " + this.instruction;
    }


}
