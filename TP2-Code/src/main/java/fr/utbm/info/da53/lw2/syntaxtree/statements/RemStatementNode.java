package fr.utbm.info.da53.lw2.syntaxtree.statements;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractStatementTreeNode;

/**
 * This class represents a REM (comment) statement in Tiny Basic.
 * It is a no-op (no operation) and is ignored during execution.
 */
public class RemStatementNode extends AbstractStatementTreeNode {
    private final String comment;

    public RemStatementNode(String comment) {
        this.comment = comment;
    }

    public RemStatementNode() {
        this.comment = null;
    }

    /**
     * Get the comment of the REM statement
     * @return
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set the comment of the REM statement
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }


    /**
     * Run the REM statement
     * @param executionContext
     * @return
     */
    @Override
    public ExecutionContext run(ExecutionContext executionContext) {
        return executionContext;
    }

    /**
     * Generate the three-address code for the RE% statement
     * @param code
     */
    @Override
    public void generate(ThreeAddressCode code) {
        if (this.comment == null) {
            // If no comment, print an empty line
            code.addRecord(new ThreeAddressRecord(
                    ThreeAddressInstruction.PRINT,
                    null, // No parameter
                    null, // No second parameter
                    null, // No result
                    null, // No label
                    "Rem an empty line"
            ));
        } else {
            // Generate the code for the comment
            String result = this.comment.generate(code);

            // Add a PRINT instruction for the result
            code.addRecord(new ThreeAddressRecord(
                    ThreeAddressInstruction.PRINT,
                    result, // The value to print
                    null, // No second parameter
                    null, // No result
                    null, // No label
                    "Rem the result of the comment"
            ));
        }
    }
    
    /**
     * Get the string representation of the REM statement
     * @return
     */
    @Override
    public String toString() {
        return "REM " + comment;
    }
}