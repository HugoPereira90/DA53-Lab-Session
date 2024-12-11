package fr.utbm.info.da53.lw2.syntaxtree.expression;

public class TermEndNode {
    FactorNode factor;
    TermEndNode termEnd;
    String operator; // Possible values: "MULTIPLY", "DIVIDE"

    public TermEndNode(FactorNode factor, TermEndNode termEnd, String operator) {
        this.factor = factor;
        this.termEnd = termEnd;
        this.operator = operator;
    }
}
