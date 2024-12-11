package fr.utbm.info.da53.lw2.syntaxtree.expression;

public class FactorNode {
    ExpressionNode expression;
    VariableNode variable;

    public FactorNode(ExpressionNode expression) {
        this.expression = expression;
    }

    public FactorNode(VariableNode variable) {
        this.variable = variable;
    }
}
