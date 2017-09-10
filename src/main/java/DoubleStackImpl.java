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

    public void push(Double number){

    }

    public Double pop(){

        return  null;
    }

    public Double top(){

        return null;
    }

    public int size(){

        return 0;
    }
}