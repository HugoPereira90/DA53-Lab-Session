package fr.utbm.info.da53.lw2.syntaxtree.reloop;

import fr.utbm.info.da53.lw2.syntaxtree.AbstractComparisonOperatorTreeNode;

public class NENode extends AbstractComparisonOperatorTreeNode {
    public NENode() {
        super();
    }

    @Override
    protected boolean translate(int comparisonResult) {
        return comparisonResult != 0;
    }

    @Override
    public String getOperatorString() {
        return "!=";
    }
}
