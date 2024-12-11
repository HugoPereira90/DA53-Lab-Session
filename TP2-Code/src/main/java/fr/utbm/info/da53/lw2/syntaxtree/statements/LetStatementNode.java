package fr.utbm.info.da53.lw2.syntaxtree.statements;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractStatementTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractValueTreeNode;

/**
 * This class represents the LET statement in Tiny Basic.
 * It assigns a value to a variable.
 */
public class LetStatementNode extends AbstractStatementTreeNode {
    private final String variable;
    private final AbstractValueTreeNode expression;

    public LetStatementNode(String variable, AbstractValueTreeNode expression) {
        this.variable = variable;
        this.expression = expression;
    }

    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        // Evaluate the expression
        Value value = expression.evaluate(executionContext);
        // Store the value in the execution context
        executionContext.setVariable(variable, value);
        return executionContext;
    }

    @Override
    public String toString() {
        return "LET " + variable + " = " + expression.toString();
    }
}
