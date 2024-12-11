package fr.utbm.info.da53.lw2.syntaxtree.nodes;

public class CodeNode {
    LineOfCodeNode lineOfCode;
    RestOfCodeNode restOfCode;

    public CodeNode(LineOfCodeNode lineOfCode, RestOfCodeNode restOfCode) {
        this.lineOfCode = lineOfCode;
        this.restOfCode = restOfCode;
    }
}
