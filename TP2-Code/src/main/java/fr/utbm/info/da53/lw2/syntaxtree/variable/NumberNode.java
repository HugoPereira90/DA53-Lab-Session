package fr.utbm.info.da53.lw2.syntaxtree.variable;

import fr.utbm.info.da53.lw2.syntaxtree.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.type.Value;

/**
 * This class represents a number in the syntax tree.
 * It is a leaf node, meaning it has no children.
 *
 * @version 1.0
 */
public class NumberNode extends AbstractValueTreeNode {
    private final String value;

    public NumberNode(String value) {
        this.value = value;
    }

    /**
     * Evaluate the number node.
     *
     * @param executionContext the execution context
     * @return the value of the number node
     */
    @Override
    public Value evaluate(ExecutionContext executionContext) {
        return new Value(value);
    }

    /**
     * Generate the three-address code for the number node.
     *
     * @param code the three-address code where the generated code is stored
     * @return the name of the temporary variable that holds the value of the number
     */
    @Override
    public String generate(ThreeAddressCode code) {
        if (this.number == null) {
            throw new IllegalStateException("Identifier is missing or not set.");
        }

        // Check if the number exists in the symbol table
        if (code.getSymbolTable().get(this.number.toString()) == null) {
            throw new IllegalStateException("Undefined identifier: " + this.number);
        }

        // Return the number as it directly refers to the variable
        return this.number.toString();
    }

    /**
     * Get the string representation of the number node.
     *
     * @return the string representation of the number node
     */
    @Override
    public String toString() {
        return value;
    }
}

