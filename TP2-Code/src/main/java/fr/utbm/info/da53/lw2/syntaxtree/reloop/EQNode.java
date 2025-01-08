package fr.utbm.info.da53.lw2.syntaxtree.reloop;

import fr.utbm.info.da53.lw2.syntaxtree.AbstractComparisonOperatorTreeNode;

public class EQNode extends AbstractComparisonOperatorTreeNode {
    public EQNode() {
        super();
    }

    /**
     * Translate the comparison result to a boolean value
     * @param comparisonResult
     */
    @Override
    protected boolean translate(int comparisonResult) {
        return comparisonResult == 0;
    }

    /**
     * Get the operator string
     * @return
     */
    @Override
    public String getOperatorString() {
        return "==";
    }
}
