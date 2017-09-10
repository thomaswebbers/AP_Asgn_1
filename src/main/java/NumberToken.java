public class NumberToken implements Token {
	private Double token;
	private int type, precedence;

	public NumberToken(Double inputToken) {
		token = inputToken;
		type = NUMBER_TYPE;
        precedence = -1;
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
}

