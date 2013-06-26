package cats.prompt;

import cats.prompt.parser.Parser;
import cats.prompt.restriction.Restriction;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * User: cats
 * Date: 6/25/13
 * Time: 9:39 AM
 */
public class Prompt<T>{

    public static final String CONFLICT_MESSAGE = "Conflicts with one/multiple restriction(s)";

    protected Parser<T> parser;
    protected List<Restriction<T>> restrictions;
    protected List<T> previousResponses;
    protected Scanner reader;
    protected String prompt;
    protected String conflictMessage;

    protected Prompt(final String prompt, final Parser<T> parser){
        this.prompt = prompt;
        this.parser = parser;

        conflictMessage = CONFLICT_MESSAGE;

        restrictions = new LinkedList<>();

        reader = new Scanner(System.in);

        previousResponses = new LinkedList<>();
    }

    protected Prompt(final String question){
        this(question, null);
    }

    public List<T> getPreviousResponses(){
        return Collections.unmodifiableList(previousResponses);
    }
    
    public T getLastResponse(){
        return previousResponses.isEmpty() ? null : previousResponses.get(previousResponses.size()-1);
    }

    public void setParser(final Parser<T> parser){
        this.parser = parser;
    }

    public Parser<T> getParser(){
        return parser;
    }

    public String getConflictMessage(){
        return conflictMessage;
    }

    public void setConflictMessage(final String conflictMessage){
        this.conflictMessage = conflictMessage;
    }

    public String getPrompt(){
        return prompt;
    }

    public void setPrompt(final String prompt){
        this.prompt = prompt;
    }

    public Restriction[] getRestrictions(){
        return restrictions.toArray(new Restriction[restrictions.size()]);
    }

    public boolean addRestriction(final Restriction<T> restriction){
        return restrictions.add(restriction);
    }

    public boolean removeRestriction(final Restriction<T> restriction){
        return restrictions.remove(restriction);
    }

    protected boolean isValidInput(final String input){
        return input != null && !input.isEmpty();
    }

    protected void loopRestrictions(final T result) throws Exception{
        for(final Restriction r : restrictions)
            if(!r.restrict(result))
                throw new Exception(conflictMessage);
    }

    public T getResponse(){
        if(parser == null || prompt == null)
            throw new IllegalArgumentException("parser == null or prompt == null");
        while(true){
            if(prompt != null)
                System.out.println(prompt);
            final String input = reader.nextLine();
            if(!isValidInput(input)){
                System.err.println("Invalid input");
                continue;
            }
            T response = null;
            try{
                response = parser.parse(input);
            }catch(Exception e){
                System.err.println("Error parsing: " + e.getMessage());
                continue;
            }
            try{
                loopRestrictions(response);
            }catch(Exception e){
                System.err.println("Error with restriction: " + e.getMessage());
                continue;
            }
            previousResponses.add(response);
            return response;
        }
    }

}
