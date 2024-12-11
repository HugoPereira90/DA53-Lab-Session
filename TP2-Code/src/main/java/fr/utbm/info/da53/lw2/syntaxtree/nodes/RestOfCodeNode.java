package fr.utbm.info.da53.lw2.syntaxtree.nodes;

public class RestOfCodeNode {
    StatementNode statement;
    RestOfCodeNode restOfCode;

    public RestOfCodeNode(StatementNode statement, RestOfCodeNode restOfCode) {
        this.statement = statement;
        this.restOfCode = restOfCode;
    }
}
