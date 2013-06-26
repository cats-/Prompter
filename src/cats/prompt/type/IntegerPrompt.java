package cats.prompt.type;

import cats.prompt.parser.Parser;
import cats.prompt.Prompt;

/**
 * User: cats
 * Date: 6/25/13
 * Time: 10:46 AM
 */
public class IntegerPrompt extends Prompt<Integer> {

    public IntegerPrompt(final String prompt){
        super(prompt, Parser.INTEGER_PARSER);
    }
}
