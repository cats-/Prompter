package cats.prompt.type;

import cats.prompt.Prompt;
import cats.prompt.parser.Parser;

/**
 * User: cats
 * Date: 6/25/13
 * Time: 10:49 AM
 */
public class DoublePrompt extends Prompt<Double> {

    public DoublePrompt(final String prompt){
        super(prompt, Parser.DOUBLE_PARSER);
    }
}
