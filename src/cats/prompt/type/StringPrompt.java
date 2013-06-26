package cats.prompt.type;

import cats.prompt.Prompt;
import cats.prompt.parser.Parser;

/**
 * User: cats
 * Date: 6/25/13
 * Time: 11:16 AM
 */
public class StringPrompt extends Prompt<String> {

    public StringPrompt(final String prompt){
        super(prompt, Parser.STRING_PARSER);
    }
}
