package cats.prompt.type;

import cats.prompt.Prompt;
import cats.prompt.parser.Parser;

/**
 * User: cats
 * Date: 6/25/13
 * Time: 11:06 AM
 */
public class BytesPrompt extends Prompt<byte[]> {

    public BytesPrompt(final String prompt){
        super(prompt, Parser.BYTES_PARSER);
    }
}
