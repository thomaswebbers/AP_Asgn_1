public class TokenImpl implements Token {
	private static final String OPERATOR_LIST = "+-*/^";
    private static final String PARENTHESIS_LIST = "()";

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POWER = '^';

	private char token;
	private int type, precedence;

	public TokenImpl(char inputToken) {
		token = inputToken;
        precedence = 0;
		parseType();
	}

	/**
     * @pre -
     * @post The value associated with this token has been returned a String.
     */
    public String getValue() {
    	return String.valueOf(token);
    }

    /**
     * @pre -
     * @post The type of this object, represented as an int, has been returned.
     */
    public int getType() {
    	return type;
    }

    /**
     * @pre -
     * @post The precedence of the token, represented by an int, 
     * has been returned. Higher int's signify a higher precedence. 
     * If token type does not need a precedence,
     * the result of this method is -1.
     */
    public int getPrecedence() {
    	return precedence;
    }

    public static String getOperatorList(){
        return OPERATOR_LIST;
    }

    public static String getParenthesisList(){
        return PARENTHESIS_LIST;
    }

    private void parseType() {
    	if (OPERATOR_LIST.contains(String.valueOf(token))) {
    		type = OPERATOR_TYPE;
            parseOperator();
    	}
    	else if (PARENTHESIS_LIST.contains(String.valueOf(token))) {
    		type = PARENTHESIS_TYPE;
            precedence = 3;
    	}
    }

    private void parseOperator() {
        switch (token) {
            case ADDITION:
                precedence = 0;
                break;
            case SUBTRACTION:
                precedence = 0;
                break;
            case MULTIPLICATION:
                precedence = 1;
                break;
            case DIVISION:
                precedence = 1;
                break;
            case POWER:
                precedence = 2;
                break;
        }
    }

}

