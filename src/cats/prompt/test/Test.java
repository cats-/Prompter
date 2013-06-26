package cats.prompt.test;

import cats.prompt.type.DoublePrompt;

/**
 * User: cats
 * Date: 6/25/13
 * Time: 10:39 AM
 */
public class Test {

    public static void main(String args[]){
        final DoublePrompt lengthPrompt = new DoublePrompt("Enter the length of the rectangle");
        lengthPrompt.addRestriction(v -> v > 0);
        final double length = lengthPrompt.getResponse();
        final DoublePrompt widthPrompt = new DoublePrompt("Enter the width of the rectangle");
        widthPrompt.addRestriction(v -> v > 0);
        final double width = widthPrompt.getResponse();
        final double result = length * width;
        System.out.println("area: " + result);
    }

}
