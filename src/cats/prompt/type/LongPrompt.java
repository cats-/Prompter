package cats.prompt.type;

import cats.prompt.Prompt;
import cats.prompt.parser.Parser;

/**
 * User: cats
 * Date: 6/25/13
 * Time: 11:02 AM
 */
public class LongPrompt extends Prompt<Long> {

    public LongPrompt(final String prompt){
        super(prompt, Parser.LONG_PARSER);
    }
}
