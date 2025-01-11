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

    public PrintStatementNode() {
        this.expression = null;
    }

    /**
     * Get the expression to print
     * @return
     */
    public AbstractValueTreeNode getExpression() {
        return expression;
    }

    /**
     * Set the expression to print
     * @param expression
     */
    public void setExpression(AbstractValueTreeNode expression) {
        this.expression = expression;
    }

    /**
     * Run the PRINT statement
     * @param executionContext
     * @return
     * @throws InterpreterException
     */
    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        // Evaluate the expression in the current execution context
        Value value = expression.evaluate(executionContext);

        if (value == null) {
            fail(executionContext, InterpreterErrorType.UNSET_VALUE);
        }

        // Print the evaluated value to the console
        System.out.println(value);
        return executionContext;
    }

    /**
     * Generate the three-address code for the PRINT statement
     * @param code
     */
    @Override
    public void generate(ThreeAddressCode code) {
        if (this.expression == null) {
            // If no expression, print an empty line
            code.addRecord(new ThreeAddressRecord(
                    ThreeAddressInstruction.PRINT,
                    null, // No parameter
                    null, // No second parameter
                    null, // No result
                    null, // No label
                    "Print an empty line"
            ));
        } else {
            // Generate the code for the expression
            String result = this.expression.generate(code);

            // Add a PRINT instruction for the result
            code.addRecord(new ThreeAddressRecord(
                    ThreeAddressInstruction.PRINT,
                    result, // The value to print
                    null, // No second parameter
                    null, // No result
                    null, // No label
                    "Print the result of the expression"
            ));
        }
    }


    /**
     * Get the string representation of the PRINT statement
     * @return
     */
    @Override
    public String toString() {
        return "PRINT " + expression.toString();
    }
}