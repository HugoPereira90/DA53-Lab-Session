package fr.utbm.info.da53.lw2.syntaxtree.operator;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractBinaryOperatorTreeNode;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.type.VariableType;

public class MultNode extends AbstractBinaryOperatorTreeNode {

    /**
     * @param leftOperand
     * @param rightOperand
     */
    public MultNode(AbstractValueTreeNode leftOperand, AbstractValueTreeNode rightOperand) {
        super(leftOperand, rightOperand);
    }

    public MultNode() {
        super();
    }


    /**
     * Excute the multiplication operation
     * @param executionContext
     * @return
     * @throws InterpreterException
     */
    @Override
    protected Value compute(ExecutionContext executionContext, Value left, Value right) throws InterpreterException {
        if(left.getType() != VariableType.NUMBER || right.getType() != VariableType.NUMBER) {
            fail(executionContext, InterpreterErrorType.EXPECTING_NUMBER,getOperatorString() +" is only supported for numbers");
        }

        Number l = left.getValue(Number.class).doubleValue();
        Number r = right.getValue(Number.class).doubleValue();

        Number result = l.doubleValue() * r.doubleValue();

        return new Value(result);
    }

    /**
     * Generate the three-address code for the Multiplication Operator
     * @param code
     */
    @Override
    public String generate(ThreeAddressCode code) {
        // Generate code for the left operand and get the resulting temporary variable
        String leftResult = getLeftOperand().generate(code);

        // Generate code for the right operand and get the resulting temporary variable
        String rightResult = getRightOperand().generate(code);

        // Create a temporary variable for the result of the addition
        String result = code.createTempVariable();

        // Add an MULTIPLICATION instruction to the three-address code
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.MULTIPLICATION,
                leftResult,   // Left operand
                rightResult,  // Right operand
                result,       // Result variable
                null,         // No label
                "Compute the multiplication of " + leftResult + " and " + rightResult
        ));

        // Return the result variable
        return result;
    }

    /**
     * Get the operator string
     * @return
     */
    @Override
    public String getOperatorString() {
        return "*";
    }
}
