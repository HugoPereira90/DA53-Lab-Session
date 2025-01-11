package fr.utbm.info.da53.lw2.syntaxtree.statements;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractStatementTreeNode;

/**
 * This class represents the END statement in Tiny Basic.
 * It terminates the program execution.
 */
public class EndStatementNode extends AbstractStatementTreeNode {

    public EndStatementNode() {
    }

    /**
     * Run the END statement
     * @param executionContext
     * @return
     */
    @Override
    public ExecutionContext run(ExecutionContext executionContext) {
        // Terminate the program execution
        executionContext.getInterpreter().exit();

        return executionContext;
    }

    /**
     * Generate the three-address code for the END statement
     * @param code
     */
    @Override
    public void generate(ThreeAddressCode code) {
        // Add an EXIT instruction to the three-address code
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.END,
                null, // No parameter
                null, // No second parameter
                null, // No result
                null, // No label
                "Terminate the program execution"
        ));
    }

    /**
     * Get the string representation of the END statement
     * @return
     */
    @Override
    public String toString() {
        return "END";
    }
}
