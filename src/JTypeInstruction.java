
public class JTypeInstruction extends Instruction {
    protected int address;

    public JTypeInstruction(String instruction) {
        super(instruction);
    }

    @Override
    public int encode() {
        int toret = 0;
        toret |= this.opcode << 26;
        toret |= this.address;

        return toret;
    }

    @Override
    public void decode(String instruction) {
        String[] tokens = instruction.split("\\s+");

        this.opcode = Mappings.getOpcode(tokens[0]);
        this.address = Integer.parseInt(tokens[1]);
    }

    @Override
    public String toString() {
        return "J-type: " + this.instruction;
    }
}
