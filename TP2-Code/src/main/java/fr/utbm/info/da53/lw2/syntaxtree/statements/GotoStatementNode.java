package fr.utbm.info.da53.lw2.syntaxtree.statements;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractStatementTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractValueTreeNode;

/**
 * This class represents the GOTO statement in Tiny Basic.
 * It causes the program to jump to a specific line.
 */
public class GotoStatementNode extends AbstractStatementTreeNode {
    private final AbstractValueTreeNode lineNumberExpression;

    public GotoStatementNode(AbstractValueTreeNode lineNumberExpression) {
        this.lineNumberExpression = lineNumberExpression;
    }

    public GotoStatementNode() {
        this.lineNumberExpression = null;
    }

    /**
     * Get the line number expression of the GOTO statement
     * @return
     */
    public AbstractValueTreeNode getLineNumberExpression() {
        return lineNumberExpression;
    }

    /**
     * Set the line number expression of the GOTO statement
     * @param lineNumberExpression
     */
    public void setLineNumberExpression(AbstractValueTreeNode lineNumberExpression) {
        this.lineNumberExpression = lineNumberExpression;
    }

    /**
     * Run the GOTO statement
     * @param executionContext
     * @return
     * @throws InterpreterException
     */
    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        // Evaluate the line number expression
        int lineNumber = lineNumberExpression.evaluate(executionContext).getValue(Integer.class);

        if (lineNumber < 0) {
            fail(executionContext, InterpreterErrorType.LINE_NOT_FOUND);
        }

        // Jump to the specified line
        executionContext.setNextLine(lineNumber);
        return executionContext;
    }

    /**
     * Generate the three-address code for the GOTO statement
     * @param code
     */
    @Override
    public void generate(ThreeAddressCode code) {
        if (this.expression == null) {
            throw new IllegalStateException("GOTO expression is missing.");
        }

        // Generate code for the expression and get the resulting variable
        String targetLineNumber = this.expression.generate(code);

        // Add a GOTO instruction with the line number
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.GOTO,
                targetLineNumber, // The Tiny Basic line number to jump to
                null, // No second parameter
                null, // No result
                null, // Label or mapping not resolved yet
                "Dynamic jump to Tiny Basic line " + targetLineNumber
        ));
    }

    /**
     * Get the string representation of the GOTO statement
     * @return
     */
    @Override
    public String toString() {
        return "GOTO " + lineNumberExpression.toString();
    }
}