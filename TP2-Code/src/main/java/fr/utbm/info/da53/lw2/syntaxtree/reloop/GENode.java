package fr.utbm.info.da53.lw2.syntaxtree.reloop;

import fr.utbm.info.da53.lw2.syntaxtree.AbstractComparisonOperatorTreeNode;

public class GENode extends AbstractComparisonOperatorTreeNode {

    public GENode() {
        super();
    }

    protected boolean translate(int comparisonResult) {
        return comparisonResult >= 0;
    }

    public String getOperatorString() {
        return ">=";
    }
}
