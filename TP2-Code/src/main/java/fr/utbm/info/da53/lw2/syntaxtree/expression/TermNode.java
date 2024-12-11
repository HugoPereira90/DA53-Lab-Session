package fr.utbm.info.da53.lw2.syntaxtree.expression;

public class TermNode {
    FactorNode factor;
    TermEndNode termEnd;

    public TermNode(FactorNode factor, TermEndNode termEnd) {
        this.factor = factor;
        this.termEnd = termEnd;
    }
}
