package fr.utbm.info.da53.lw2.syntaxtree.nodes;

import fr.utbm.info.da53.lw2.syntaxtree.*;

public class LineOfCodeNode extends AbstractSyntaxTreeNode {

    // Node for line number (optional)
    private AbstractValueTreeNode lineNumber;

    // The statement(s) in the line
    private AbstractStatementTreeNode statement;

    public LineOfCodeNode(AbstractValueTreeNode lineNumber, AbstractStatementTreeNode statement) {
        this.lineNumber = lineNumber;
        this.statement = statement;
    }

    public LineOfCodeNode(AbstractStatementTreeNode statement) {
        this.statement = statement;
    }
}

