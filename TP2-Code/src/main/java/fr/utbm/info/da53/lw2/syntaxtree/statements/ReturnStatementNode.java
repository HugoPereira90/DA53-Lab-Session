package fr.utbm.info.da53.lw2.syntaxtree.statements;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractStatementTreeNode;

public class ReturnStatementNode extends AbstractStatementTreeNode {

    /**
     * Run the RETURN statement
     * @param executionContext
     * @return
     * @throws InterpreterException
     */
    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        ExecutionContext parent = executionContext.getParent();
        if (parent==null) {
            fail(executionContext, InterpreterErrorType.RETURN_OUTSIDE_SUB);
        }
        executionContext.close();
        return parent;
    }

    /**
     * Get the string representation of the RETURN statement
     * @return
     */
    @Override
    public String toString() {
        return "RETURN"; //$NON-NLS-1$
    }
}
