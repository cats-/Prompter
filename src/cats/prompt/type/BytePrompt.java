package cats.prompt.type;

import cats.prompt.Prompt;
import cats.prompt.parser.Parser;

/**
 * User: cats
 * Date: 6/25/13
 * Time: 11:04 AM
 */
public class BytePrompt extends Prompt<Byte> {

    public BytePrompt(final String prompt){
        super(prompt, Parser.BYTE_PARSER);
    }
}
