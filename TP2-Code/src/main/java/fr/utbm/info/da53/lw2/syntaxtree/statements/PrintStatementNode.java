package fr.utbm.info.da53.lw2.syntaxtree.statements;




import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractStatementTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractValueTreeNode;

/**
 * This class represents the PRINT statement in Tiny Basic.
 * It prints the result of the expression to the console.
 */
public class PrintStatementNode extends AbstractStatementTreeNode {
    private final AbstractValueTreeNode expression;

    public PrintStatementNode(AbstractValueTreeNode expression) {
        this.expression = expression;
    }

    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        // Evaluate the expression in the current execution context
        Value value = expression.evaluate(executionContext);
        // Print the evaluated value to the console
        System.out.println(value);
        return executionContext;
    }

    @Override
    public String toString() {
        return "PRINT " + expression.toString();
    }
}