package fr.utbm.info.da53.lw2.syntaxtree.statements;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractStatementTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractValueTreeNode;

/**
 * This class represents an IF statement in Tiny Basic.
 * It evaluates a condition and runs the appropriate statement.
 */
public class IfStatementNode extends AbstractStatementTreeNode {
    private final AbstractValueTreeNode condition;
    private final AbstractStatementTreeNode thenStatement;
    private final AbstractStatementTreeNode elseStatement;

    public IfStatementNode(AbstractValueTreeNode condition, AbstractStatementTreeNode thenStatement, AbstractStatementTreeNode elseStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        // Evaluate the condition
        Value conditionValue = condition.evaluate(executionContext);
        Value TRUE = new Value(true);

        // Execute the "then" block if the condition is true, otherwise execute the "else" block
        if (conditionValue.compareTo(TRUE) == 0) {
            thenStatement.run(executionContext);
        } else if (elseStatement != null) {
            elseStatement.run(executionContext);
        }
        return executionContext;
    }

    @Override
    public String toString() {
        return "IF " + condition.toString() + " THEN " + thenStatement.toString() + (elseStatement != null ? " ELSE " + elseStatement.toString() : "");
    }
}
