package fr.utbm.info.da53.lw2.syntaxtree.reloop;

import fr.utbm.info.da53.lw2.syntaxtree.AbstractComparisonOperatorTreeNode;

public class NENode extends AbstractComparisonOperatorTreeNode {
    public NENode() {
        super();
    }

    /**
     * Translate the comparison result to a boolean value
     * @param comparisonResult
     */
    @Override
    protected boolean translate(int comparisonResult) {
        return comparisonResult != 0;
    }

    /**
     * Generate code for the not equal comparison
     * @param code
     */
    @Override
    public String generate(ThreeAddressCode code) {
        // Generate code for the left operand and get the resulting temporary variable
        String leftResult = getLeftOperand().generate(code);

        // Generate code for the right operand and get the resulting temporary variable
        String rightResult = getRightOperand().generate(code);

        // Create a temporary variable for the result of the equality comparison
        String result = code.createTempVariable();

        // Add an NE instruction to the three-address code
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.NE, // Not equal comparison
                leftResult,                 // Left operand
                rightResult,                // Right operand
                result,                     // Result variable
                null,                       // No label
                "Compare " + leftResult + " != " + rightResult
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
        return "!=";
    }
}
