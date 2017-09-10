public class TokenListImpl implements TokenList{
	static final int DEFAULT_SIZE = 256;
	
	private Token[] tokens;
	private int pointer;
	
	
	public TokenListImpl() {
		this(DEFAULT_SIZE);
	}
	
	public TokenListImpl(int size) {
		tokens = new Token[size];
		pointer = 0;
	}
	
	private void extendListSize() {
		Token[] newList = new Token[tokens.length * 2];
		
		System.arraycopy(tokens, 0, newList, 0, tokens.length);
		tokens = newList;
	}
	
	/**
     * @pre -
     * @post The token 'token' has been added at the end of the TokenList, 
     *       preserving the previous order.
     */
	public void add(Token token ) {

	}

	/**
     * @pre index < size() and index > 0
     * @post The element at location 'index' has been removed, preserving the previous order. The size of the TokenList has been reduced by 1.
     */
    public void remove(int index) {

    }
	
	/**
     * @param index The index to be set
     * @param token The value to set the element at location index to.
     * @pre   index < size();
     * @post  The element at location 'index' has the value 'token', preserving the previous order.
     */
    public void set(int index, Token token) {

    }

    /**
     * @param index The index of the element to be returned.
     * @return The element and index index.
     * @pre index < size();
     * @post The element at index 'index' has been returned.
     */
    public Token get(int index) {
		return null;
    }

    /**
     * @pre -
     * @post The number of elements in the list has been returned.
     */
    public int size() {
    	return 0;
    }
}
