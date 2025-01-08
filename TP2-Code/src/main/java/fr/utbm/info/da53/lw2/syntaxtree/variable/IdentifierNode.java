package fr.utbm.info.da53.lw2.syntaxtree.variable;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractValueTreeNode;

/**
 * This class represents a variable identifier in the syntax tree.
 * It retrieves the variable value from the context.
 *
 * @version 1.0
 */
public class IdentifierNode extends AbstractValueTreeNode {
    private final String identifier;

    public IdentifierNode(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Evaluate the identifier node.
     *
     * @param executionContext the execution context
     * @return the value of the variable
     */
    @Override
    public Value evaluate(ExecutionContext executionContext) {
        return executionContext.getSymbolTableEntry(identifier).getValue();
    }

    /**
     * Generate the three-address code for the identifier node.
     *
     * @param code the three-address code where the generated code is stored
     * @return the name of the temporary variable that holds the value of the identifier
     */
    @Override
    public String generate(ThreeAddressCode code) {
        if (this.identifier == null || this.identifier.isEmpty()) {
            throw new IllegalStateException("Identifier is missing or not set.");
        }

        // Check if the identifier exists in the symbol table
        if (code.getSymbolTable().get(this.identifier) == null) {
            throw new IllegalStateException("Undefined identifier: " + this.identifier);
        }

        // Return the identifier as it directly refers to the variable
        return this.identifier;
    }


    /**
     * Get the string representation of the identifier node.
     *
     * @return the string representation of the identifier node
     */
    @Override
    public String toString() {
        return identifier;
    }
}