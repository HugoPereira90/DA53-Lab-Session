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

    public GosubStatementNode() {
        this.lineNumberExpression = null;
    }

    /**
     * Get the line number expression of the GOSUB statement
     * @return
     */
    public AbstractValueTreeNode getLineNumberExpression() {
        return lineNumberExpression;
    }

    /**
     * Set the line number expression of the GOSUB statement
     * @param lineNumberExpression
     */
    public void setLineNumberExpression(AbstractValueTreeNode lineNumberExpression) {
        this.lineNumberExpression = lineNumberExpression;
    }

    /**
     * Run the GOSUB statement
     * @param executionContext
     * @return
     * @throws InterpreterException
     */
    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpreterException {
        // Evaluate the line number to jump to
        int lineNumber = lineNumberExpression.evaluate(executionContext).getValue(Integer.class);

        if (lineNumber < 0) {
            fail(executionContext, InterpreterErrorType.LINE_NOT_FOUND);
        }

        // Jump to the specified line number
        executionContext = new ExecutionContext(executionContext);
        executionContext.setNextLine(lineNumber);
        return executionContext;
    }

    /**
     * Generate the three-address code for the GOSUB statement
     * @return
     */
    @Override
    public void generate(ThreeAddressCode code) {
        if (this.expression == null) {
            throw new IllegalStateException("GOSUB expression is missing.");
        }

        // Generate code for the expression and get the resulting variable
        String targetLineNumber = this.expression.generate(code);

        // Generate a label for the return address
        String returnLabel = code.createLabel();

        // Save the return address in the code
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.LABEL,
                returnLabel, // Label for returning after the subroutine
                null, // No second parameter
                null, // No result
                null, // No dynamic label needed here
                "Return address for GOSUB"
        ));

        // Add the GOSUB instruction to jump to the target line
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.GOSUB,
                targetLineNumber, // Tiny Basic line number of the subroutine
                null, // No second parameter
                null, // No result
                null, // Label or mapping not resolved yet
                "Dynamic jump to Tiny Basic line " + targetLineNumber + " for subroutine"
        ));
    }

    /**
     * Get the string representation of the GOSUB statement
     * @return
     */
    @Override
    public String toString() {
        return "GOSUB " + lineNumberExpression.toString();
    }
}