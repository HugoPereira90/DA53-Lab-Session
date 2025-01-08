package fr.utbm.info.da53.lw2.syntaxtree.variable;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.type.Value;

public class StringNode extends AbstractValueTreeNode {
    private final String value;

    public StringNode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    /**
     * Evaluate the string node.
     *
     * @param executionContext the execution context
     * @return the value of the string
     */
    @Override
    public Value evaluate(ExecutionContext executionContext) throws InterpreterException {
        return new Value(value);
    }

    /**
     * Generate the three-address code for the string node.
     *
     * @param code the three-address code where the generated code is stored
     * @return the name of the temporary variable that holds the value of the string
     */
    @Override
    public String generate(ThreeAddressCode code) {
        if (this.value == null) {
            throw new IllegalStateException("String value is null.");
        }

        // Create a temporary variable to store the string
        String tempVar = code.createTempVariable();

        // Add an assignment instruction to assign the string value to the temporary variable
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.ASSIGN, // Assignment operation
                "\"" + this.value.replace("\"", "\\\"") + "\"", // The escaped string value
                null,                           // No second parameter
                tempVar,                        // Temporary variable to hold the string
                null,                           // No label
                "Assign string value \"" + this.value + "\" to " + tempVar
        ));

        // Return the temporary variable
        return tempVar;
    }
}
