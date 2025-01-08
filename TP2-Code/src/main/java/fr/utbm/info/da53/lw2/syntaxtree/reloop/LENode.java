package fr.utbm.info.da53.lw2.syntaxtree.reloop;

import fr.utbm.info.da53.lw2.syntaxtree.AbstractComparisonOperatorTreeNode;

public class LENode extends AbstractComparisonOperatorTreeNode {

    public LENode() {
        super();
    }

    /**
     * Translate the comparison result to a boolean value
     * @param comparisonResult
     */
    protected boolean translate(int comparisonResult) {
        return comparisonResult <= 0;
    }

    /**
     * Generate code for the lower or equal comparison
     * @param code
     * @return
     */
    @Override
    public String generate(ThreeAddressCode code) {
        // Generate code for the left operand and get the resulting temporary variable
        String leftResult = getLeftOperand().generate(code);

        // Generate code for the right operand and get the resulting temporary variable
        String rightResult = getRightOperand().generate(code);

        // Create a temporary variable for the result of the equality comparison
        String result = code.createTempVariable();

        // Add an LE instruction to the three-address code
        code.addRecord(new ThreeAddressRecord(
                ThreeAddressInstruction.LE, // Lower or equal comparison
                leftResult,                 // Left operand
                rightResult,                // Right operand
                result,                     // Result variable
                null,                       // No label
                "Compare " + leftResult + " <= " + rightResult
        ));

        // Return the result variable
        return result;
    }

    /**
     * Get the operator string
     * @return
     */
    public String getOperatorString() {
        return "<=";
    }
}
