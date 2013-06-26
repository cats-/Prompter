package cats.prompt.type;

import cats.prompt.Prompt;
import cats.prompt.parser.Parser;

/**
 * User: cats
 * Date: 6/25/13
 * Time: 11:03 AM
 */
public class ShortPrompt extends Prompt<Short> {

    public ShortPrompt(final String prompt){
        super(prompt, Parser.SHORT_PARSER);
    }
}
