package fr.utbm.info.da53.lw2.syntaxtree.expression;

public class ExpressionEndNode {
    TermNode term;
    ExpressionEndNode expressionEnd;
    String operator; //Plus and Minus

    public ExpressionEndNode(TermNode term, ExpressionEndNode expressionEnd, String operator) {
        this.term = term;
        this.expressionEnd = expressionEnd;
        this.operator = operator;
    }
}
