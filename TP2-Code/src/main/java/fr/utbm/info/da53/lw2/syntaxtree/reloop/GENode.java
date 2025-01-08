package fr.utbm.info.da53.lw2.syntaxtree.reloop;

import fr.utbm.info.da53.lw2.syntaxtree.AbstractComparisonOperatorTreeNode;

public class GENode extends AbstractComparisonOperatorTreeNode {

    public GENode() {
        super();
    }

    /**
     * Translate the comparison result to a boolean value
     * @param comparisonResult
     */
    protected boolean translate(int comparisonResult) {
        return comparisonResult >= 0;
    }

    /**
     * Get the operator string
     * @return
     */
    public String getOperatorString() {
        return ">=";
    }
}
