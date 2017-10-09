public class DoubleStackImpl implements DoubleStack {
    private final static int INIT_SIZE = 256;

    private Double[] stack;
    private int pointer;
    private boolean empty;

    public DoubleStackImpl() {
        stack = new Double[INIT_SIZE];
        pointer = 0;
        empty = true;
    }

    public void extendStackSize() {
        Double[] newStack = new Double[stack.length * 2];

        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public void push(Double element){
        if (pointer >= stack.length -1) {
            extendStackSize();
        }

        stack[pointer] = element;
        pointer++;
        empty = false;
    }

    public Double pop() {
        if (empty) {
            return null;   
        }

        pointer--;

        if(pointer == 0) {
            empty = true;
        }

        return stack[pointer];
    }

    public Double top() {
        if (empty) {
            return null;
        }

        return (stack[pointer - 1]);
    }

    public int size() {
        if (empty) {
            return 0;
        }

        return (pointer - 1);
    }

    public boolean isEmpty() {
        return empty;
    }

    public int getPointer() {
        return pointer;
    }
}