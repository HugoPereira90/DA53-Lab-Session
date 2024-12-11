package fr.utbm.info.da53.lw2.syntaxtree.statements;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractStatementTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractValueTreeNode;

/**
 * This class represents the GOSUB statement in Tiny Basic.
 * It jumps to a subroutine and saves the current line number.
 */
public class GosubStatementNode extends AbstractStatementTreeNode {
    private final AbstractValueTreeNode lineNumberExpression;

    public GosubStatementNode(AbstractValueTreeNode lineNumberExpression) {
        this.lineNumberExpression = lineNumberExpression;
    }

    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        // Evaluate the line number to jump to
        int lineNumber = lineNumberExpression.evaluate(executionContext).getValue(Integer.class);
        // Jump to the specified line number

        executionContext = new ExecutionContext(executionContext);
        executionContext.setNextLine(lineNumber);
        return executionContext;
    }

    @Override
    public String toString() {
        return "GOSUB " + lineNumberExpression.toString();
    }
}