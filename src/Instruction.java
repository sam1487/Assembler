
public abstract class Instruction {

    /* All instructions are 32 bit*/
    protected int size = 32;
    protected String instruction;

    protected int opcode;

    public Instruction(String instruction) {
       this.instruction = instruction;
       decode(instruction);
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public abstract int encode();
    public abstract void decode(String instruction);

    public String toBinaryString() {

        return Integer.toBinaryString(encode());
    }

    public String toHexString() {
        String hex = Integer.toHexString(encode()).toUpperCase();
        int len = hex.length();
        for(int i = 0; i < 8 - len; ++i)
            hex = "0" + hex;

        return "0x" + hex;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Instruction)) return false;
        return encode() == ((Instruction)(obj)).encode();
    }
}
