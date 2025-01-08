package fr.utbm.info.da53.lw2.syntaxtree.operator;

import fr.utbm.info.da53.lw2.syntaxtree.AbstractBinaryOperatorTreeNode;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterErrorType;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractValueTreeNode;
import fr.utbm.info.da53.lw2.type.NumberUtil;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.type.VariableType;

public class SubNode extends AbstractBinaryOperatorTreeNode {

    public SubNode(AbstractValueTreeNode leftOperand, AbstractValueTreeNode rightOperand) {
        super(leftOperand, rightOperand);
    }

    /**
     * Excute the subtraction operation
     * @param executionContext
     * @return
     * @throws InterpreterException
     */
    @Override
    protected Value compute(ExecutionContext executionContext, Value left, Value right) throws InterpreterException {

        // Check the types of the operands to ensure they are numbers
        if(left.getType() != VariableType.NUMBER || right.getType() != VariableType.NUMBER) {
            fail(executionContext, InterpreterErrorType.EXPECTING_NUMBER,getOperatorString() +" is only supported for numbers");
        }

        // Perform the operation
        Number l = left.getValue(Number.class);
        Number r = right.getValue(Number.class);
        return new Value(NumberUtil.toNumber(l.doubleValue() - r.doubleValue()));
    }

    @Override
    public String getOperatorString() {
        return "-"; //$NON-NLS-1$
    }
}
