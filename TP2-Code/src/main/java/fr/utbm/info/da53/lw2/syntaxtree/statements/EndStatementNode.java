package fr.utbm.info.da53.lw2.syntaxtree.statements;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractStatementTreeNode;

/**
 * This class represents the END statement in Tiny Basic.
 * It terminates the program execution.
 */
public class EndStatementNode extends AbstractStatementTreeNode {

    @Override
    public ExecutionContext run(ExecutionContext executionContext) {
        // Terminate the program execution
        executionContext.getInterpreter().exit();

        return executionContext;
    }

    @Override
    public String toString() {
        return "END";
    }
}
