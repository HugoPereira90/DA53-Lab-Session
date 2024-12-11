package fr.utbm.info.da53.lw2.syntaxtree.statements;

import fr.utbm.info.da53.lw2.context.ExecutionContext;
import fr.utbm.info.da53.lw2.error.InterpreterException;
import fr.utbm.info.da53.lw2.type.Value;
import fr.utbm.info.da53.lw2.syntaxtree.AbstractStatementTreeNode;

import java.util.List;
import java.util.Scanner;

/**
 * This class represents the INPUT statement in Tiny Basic.
 * It prompts the user for one or more numeric inputs, with optional text.
 */
public class InputStatementNode extends AbstractStatementTreeNode {
    private final List<String> variables;
    private final String optionalPrompt;

    /**
     * Constructor.
     *
     * @param variables The list of variable names to assign input values.
     * @param optionalPrompt The optional text to display as a prompt.
     */
    public InputStatementNode(List<String> variables, String optionalPrompt) {
        this.variables = variables;
        this.optionalPrompt = optionalPrompt;
    }

    @Override
    public void run(ExecutionContext executionContext) throws InterpreterException {
        Scanner scanner = new Scanner(System.in);

        // Display the optional prompt if present
        if (optionalPrompt != null && !optionalPrompt.isEmpty()) {
            System.out.print(optionalPrompt + " ");
        }

        // Read user inputs separated by commas or carriage returns
        System.out.println("Enter values for: " + String.join(", ", variables));
        String inputLine = scanner.nextLine();

        // Split input based on commas or whitespace (supporting CR and `,` separators)
        String[] inputValues = inputLine.split("[,\\s]+");

        if (inputValues.length < variables.size()) {
            System.out.println("Insufficient input values provided.");
        }

        // Assign values to variables
        for (int i = 0; i < variables.size(); i++) {
            String varName = variables.get(i);
            String inputValue = inputValues[i];

            // Parse the input as an integer
            try {
                int value = Integer.parseInt(inputValue);

                // Check if the variable is an array
                if (executionContext.isArray(varName)) {
                    // If it's an array, assign the value to the array's first available index
                    executionContext.assignArrayValue(varName, value);
                } else {
                    // Otherwise, assign the value to the variable
                    executionContext.setVariable(varName, new Value(value));
                }
            } catch (NumberFormatException e) {
                throw new InterpreterException("Invalid numeric input: " + inputValue);
            }
        }
    }

    @Override
    public String toString() {
        return "INPUT " + (optionalPrompt != null ? "\"" + optionalPrompt + "\" " : "")
                + String.join(", ", variables);
    }
}