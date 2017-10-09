import java.beans.Expression;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements CalculatorInterface {
    private DoubleStack doubleStack;
    private static final double lowerBound = Double.NEGATIVE_INFINITY;
    private static final double upperBound = Double.POSITIVE_INFINITY;

    Main(){
        doubleStack = new DoubleStackImpl();
    }


    public TokenList readTokens(String input) {
        TokenList tokenList = new TokenListImpl();
        Scanner in = new Scanner(input);

        while (in.hasNext()) {
            Token token;
            
            if (in.hasNextDouble()) {
                token = new NumberToken(in.nextDouble());
            }

            else {
                String character = in.next();
                token = new TokenImpl(character.charAt(0));
            }

            tokenList.add(token);
        }
        
        return tokenList;
    }


    public Double rpn(TokenList tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).getType() == 1) {
                Double number = Double.parseDouble(tokens.get(i).getValue());
                doubleStack.push(number);
            }
            else if (tokens.get(i).getType () == 2) {
                parseOperator(tokens.get(i).getValue().charAt(0));
            }
        }

        return doubleStack.pop();
    }

   public TokenList shuntingYard(TokenList tokens) {
        TokenList output  = new TokenListImpl();
        TokenStack tokenStack = new TokenStackImpl();
        Token topOfStack = tokenStack.top();

        for(int i = 0; i < tokens.size(); i++){
            Token currentToken = tokens.get(i);

            if(currentToken.getType() == 1){
                output.add(currentToken);
            }

            else if(currentToken.getType() == 2){
                if(tokenStack.size() > 0){
                    while (topOfStack.getPrecedence() >= currentToken.getPrecedence() && topOfStack.getType() == 2) {
                        output.add(tokenStack.pop());
                        if(tokenStack.size() > 0){
                            topOfStack = tokenStack.top();
                        }

                        else{
                            break;
                        }
                    }
                }
                tokenStack.push(currentToken);
                topOfStack = tokenStack.top();
            }

            if(currentToken.getValue().equals("(")){
                tokenStack.push(currentToken);
                topOfStack = tokenStack.top();
            }

            if(currentToken.getValue().equals(")")){
                if(tokenStack.size() > 0) {
                    while (!topOfStack.equals("(")) {
                        if (topOfStack.getType() == 2) {
                            output.add(tokenStack.pop());
                            if(tokenStack.size() > 0){
                                topOfStack = tokenStack.top();
                            }
                        }
                        else{
                            tokenStack.pop();
                            topOfStack = tokenStack.top();
                            break;
                        }
                    }
                }
            }
        }

        while(tokenStack.size() > 0){
            output.add(tokenStack.pop());
        }
   return output;
   }

    private void parseOperator(char operator) {
        switch (operator) {
            case '+':
                Operations.add(doubleStack);
                break;
            case '-':
                Operations.subtract(doubleStack);
                break;
            case '*':
                Operations.multiply(doubleStack);
                break;
            case '/':
                Operations.divide(doubleStack);
                break;
            case '^':
                Operations.power(doubleStack);
                break;
        }
    }

    private void start() {
        // Create a scanner on System.in (console/terminal input)
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(System.out);


        StringBuilder tokenString = new StringBuilder(20);
        Scanner expression = new Scanner(in.nextLine());
        while (expression.hasNext()) {
            boolean withinRange = true;

            if(expression.hasNextDouble()){
                Double number = expression.nextDouble();
                withinRange = checkRange(lowerBound, upperBound, number);

                if (!withinRange) {
                    out.println("ERROR DOUBLE TOO LARGE PLEASE FILL IN DOUBLE BETWEEN upper lower bound : example 42");
                }
                tokenString.append(number.toString() + " ");
            }

            else{
                String nonNumber = expression.next();
                if (TokenImpl.getOperatorList().contains(nonNumber) || TokenImpl.getParenthesisList().contains(nonNumber)) {
                    tokenString.append(nonNumber + " ");
                }

                else {
                    out.println("ERROR INPUT IS NOT VALID OPERATOR OR PARENTHESIS");
                    System.exit(1);
                }
            }
        }
        TokenList line = shuntingYard(readTokens(tokenString.toString()));
        out.println(rpn(line));
    }

    private boolean checkRange(double lowerBound, double upperBound, double x){
        if(x >= lowerBound && x <= upperBound){
            return true;
        }
        return false;
    }

        private static boolean intervallContains(int low, int high, int n) {
                return n >= low && n <= high;
        }

        // While there is input, read line and parse it.
        //Aren't we already using in.hasnext in the token list AKA its not needed here?
        


    public static void main(String[] argv) {
        new Main().start();
    }
}
