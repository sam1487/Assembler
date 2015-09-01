
public class ITypeInstruction extends Instruction {

    protected int rs, rt, address;

    public ITypeInstruction(String instruction) {
        super(instruction);
    }

    @Override
    public int encode() {
        int toret = 0;

        toret |= opcode << 26;
        toret |= this.rs << 21;
        toret |= this.rt << 16;
        toret |= this.address;

        return toret;
    }

    @Override
    public void decode(String instruction) {

        // Get rid of so many characters, so that we can just handle the spaces only
        instruction = instruction.replace("(", " ");
        instruction = instruction.replace(")", "");
        instruction = instruction.replaceAll(",", " ");
        instruction = instruction.replaceAll("\\$", "");

        String[] tokens = instruction.split("\\s+");
        String instructionName = tokens[0].trim().toLowerCase();

        this.opcode = Mappings.getOpcode(instructionName);
        this.rt = Integer.parseInt(tokens[1]);

        if (instructionName.equals("beq")) {
            this.rs = Integer.parseInt(tokens[2]);
            this.address = Integer.parseInt(tokens[3]);
        }
        else {
            this.rs = Integer.parseInt(tokens[3]);
            this.address = Integer.parseInt(tokens[2]);
        }
    }

    @Override
    public String toString() {
        return "I-type: " + this.instruction;
    }

}
