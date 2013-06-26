package cats.prompt.parser;

/**
 * User: cats
 * Date: 6/25/13
 * Time: 10:36 AM
 */
public interface Parser<T> {

    public static final Parser<Integer> INTEGER_PARSER = value -> Integer.parseInt(value);
    public static final Parser<Double> DOUBLE_PARSER = value -> Double.parseDouble(value);
    public static final Parser<Long> LONG_PARSER = value -> Long.parseLong(value);
    public static final Parser<Short> SHORT_PARSER = value -> Short.parseShort(value);
    public static final Parser<Byte> BYTE_PARSER = value -> Byte.parseByte(value);
    public static final Parser<Float> FLOAT_PARSER = value -> Float.parseFloat(value);
    public static final Parser<String> STRING_PARSER = value -> value;
    public static final Parser<byte[]> BYTES_PARSER = value -> {
        try{
            return value.getBytes("UTF-8");
        }catch(Exception e){
            return new byte[0];
        }
    };

    public T parse(final String input);
}
