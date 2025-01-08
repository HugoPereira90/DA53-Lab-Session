package fr.utbm.info.da53.lw2.syntaxtree.operator;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractBinaryOperatorTreeNode;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.type.NumberUtil;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.type.VariableType;

public class DivNode extends AbstractBinaryOperatorTreeNode {

    /**
     * @param leftOperand
     * @param rightOperand
     */
    public DivNode(AbstractValueTreeNode leftOperand, AbstractValueTreeNode rightOperand) {
        super(leftOperand, rightOperand);
    }

    /**
     * Excute the division operation
     * @param executionContext
     * @return
     * @throws InterpreterException
     */
    @Override
    protected Value compute(ExecutionContext executionContext, Value left, Value right) throws InterpreterException {
        if(left.getType() != VariableType.NUMBER || right.getType() != VariableType.NUMBER) {
            fail(executionContext, InterpreterErrorType.EXPECTING_NUMBER,getOperatorString() +" is only supported for numbers");
        }

        Number l = left.getValue(Number.class);
        Number r = right.getValue(Number.class);

        if (r.doubleValue() == 0) {
            fail(executionContext, InterpreterErrorType.DIVISION_BY_ZERO, "Division by zero");
        }

        return new Value(NumberUtil.toNumber(l.doubleValue() / r.doubleValue()));
    }

    /**
     * Generate the three-address code for the Division Operator
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

        // Add an DIVISION instruction to the three-address code
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.DIVISION,
                leftResult,   // Left operand
                rightResult,  // Right operand
                result,       // Result variable
                null,         // No label
                "Compute the division of " + leftResult + " and " + rightResult
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
        return "/";
    }
}
