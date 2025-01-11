package fr.utbm.info.da53.lw2.syntaxtree.statements;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractStatementTreeNode;

public class ReturnStatementNode extends AbstractStatementTreeNode {

    public ReturnStatementNode() {
    }

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
     * Generate the three-address code for the RETURN statement
     * @param code
     */
    @Override
    public void generate(ThreeAddressCode code) {
        // Add a RETURN instruction to the three-address code
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.RETURN,
                null, // No parameter
                null, // No second parameter
                null, // No result
                null, // No label
                "Return to the caller of the subroutine"
        ));
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
