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

    /**
     * Run the IF statement
     * @param executionContext
     * @return
     * @throws InterpreterException
     */
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


    /**
     * Generate code for the IF statement
     * @param code
     */
    @Override
    public void generate(ThreeAddressCode code){
        // Generate code for the condition and get the resulting variable
        String conditionResult = this.condition.generate(code);

        // Generate labels
        String thenLabel = code.createLabel();
        String endLabel = code.createLabel();
        String elseLabel = (this.elseStatement != null) ? code.createLabel() : null;

        // Add conditional jump based on the condition
        if (elseLabel != null) {
            code.addRecord(new ThreeAddressRecord(
                    ThreeAddressInstruction.IFFALSE,
                    conditionResult,
                    null, // No second parameter
                    null, // No result
                    elseLabel, // Jump to ELSE if condition is false
                    "Jump to ELSE block if condition is false"
            ));
        } else {
            code.addRecord(new ThreeAddressRecord(
                    ThreeAddressInstruction.IFFALSE,
                    conditionResult,
                    null, // No second parameter
                    null, // No result
                    endLabel, // Jump to END if condition is false
                    "Jump to END block if condition is false"
            ));
        }

        // Generate code for THEN block
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.LABEL,
                thenLabel,
                null, // No second parameter
                null, // No result
                null, // No label
                "Start of THEN block"
        ));
        this.thenStatement.generate(code);

        // Add a jump to the end label if ELSE exists
        if (elseLabel != null) {
            code.addRecord(new ThreeAddressRecord(
                    ThreeAddressInstruction.GOTO,
                    null, // No parameter
                    null, // No second parameter
                    null, // No result
                    endLabel, // Jump to END
                    "Skip ELSE block"
            ));
        }

        // Generate code for ELSE block if it exists
        if (this.elseStatement != null) {
            code.addRecord(new ThreeAddressRecord(
                    ThreeAddressInstruction.LABEL,
                    elseLabel,
                    null, // No second parameter
                    null, // No result
                    null, // No label
                    "Start of ELSE block"
            ));
            this.elseStatement.generate(code);
        }

        // Add the end label
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.LABEL,
                endLabel,
                null, // No second parameter
                null, // No result
                null, // No label
                "End of IF-THEN-ELSE block"
        ));
    }

    /**
     * Get the string representation of the IF statement
     * @return
     */
    @Override
    public String toString() {
        return "IF " + condition.toString() + " THEN " + thenStatement.toString() + (elseStatement != null ? " ELSE " + elseStatement.toString() : "");
    }
}
