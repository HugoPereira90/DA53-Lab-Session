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
     * Get the string representation of the REM statement
     * @return
     */
    @Override
    public String toString() {
        return "REM " + comment;
    }
}