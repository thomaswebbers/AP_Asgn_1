public class TokenStackImpl implements TokenStack {
    private final static int INIT_SIZE = 256;

    private Token[] stack;
    private int pointer;
    private boolean empty;

    public TokenStackImpl() {
        stack = new Token[INIT_SIZE];
        pointer = 0;
        empty = true;
    }

    public void extendStackSize() {
        Token[] newStack = new Token[stack.length * 2];

        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public void push(Token element){

    }

    public Token pop() {
       return null;
    }

    public Token top() {
       return null;
    }

    public int size() {
        return 0;
    }

    public String debug(int i){
        Token token = stack[i];
        return token.getValue();
    }
}