# Assembler
 
The assembler is a Java application. It runs on JDK 1.7 or 1.6. All the files are in a single folder named Assembler. 
The main class is in Assembler.java. Assembler.java expects the input .asm file name to be provided as a command line parameter. The output is always a set of two files: out.bin, the binary object file, and out.hex, a textfile containing one-instruction-per-line hexadecimal representation of the binary instructions.

<h3> Running the code</h3>
<ol>
<li>In the terminal (command prompt) window, type: cd Assembler/src</li>
<li>Compile the java files: javac *.java</li>
<li>Run the Program class: java Assembler input.asm</li>
<li>Two output files will be produced: out.bin and out.hex. The out.hex file can be opened using any text editor.</li>
</ol>

<h3>Inside the code</h3>
<b>Assembler:</b> The main entry point for the assembler. It handles the file input, uses internal assembling
modules to generate the binary instructions code, and writes the output to a binary and hex file. 

<b>Instruction:</b> Anabstract class that defines the interface and basic functions for the instructions.

<b>RTypeInstruction:</b> Extends Instruction, and implements the abstract method encode and decode, and defines instruction-specific properties for an R-type instruction.

<b>ITypeInstruction:</b> Extends Instruction, and implements the abstract method encode and decode, and defines instruction-specific properties for an I-type instruction.


<b>JTypeInstruction:</b> Extends Instruction, and implements the required methods for handling a J-type instruction.

<b>Mappings:</b> Stores string-number mappings that instruction name has with op-code and function code.
