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
        if (pointer >= stack.length -1) {
            extendStackSize();
        }

        stack[pointer] = element;
        pointer = pointer + 1;
        empty = false;
    }

    public Token pop() {
        if (empty) {
            return null;
        }
        pointer--;

        if(pointer == 0) {
            empty = true;
        }
        return stack[pointer];
    }

    public Token top() {
        if (empty) {
            return null;
        }

        return (stack[pointer - 1]);
    }

    public int size() {
        if (empty) {
            return 0;
        }

        return (pointer);
    }

    public String debug(int i){
        Token token = stack[i];
        return token.getValue();
    }

    public boolean isEmpty() {
        return empty;
    }

    public int getPointer() {
        return pointer;
    }
}