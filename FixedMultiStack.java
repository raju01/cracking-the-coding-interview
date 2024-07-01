import java.util.EmptyStackException;

public class FixedMultiStack {
    private int numberOfStack=3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;
    public FixedMultiStack(int stackSize){
        stackCapacity =stackSize;
        values=new int[stackSize*numberOfStack];
        sizes = new int[numberOfStack];
    }

    /* Push values onto stack */
    public void push(int stackNum, int value) throws  RuntimeException {
        /* check that we have space for the next element */
        if(isFull(stackNum)){
            throw new RuntimeException("Stack is Full");
        }
        /* Increment stack pointer then update the top values */
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }




    /* return if stack is empty*/
    public boolean isEmpty(int stackNum){
        return sizes[stackNum]==0;
    }

    /* return if stack is full*/
    public  boolean isFull(int stackNum){
        return sizes[stackNum]==stackCapacity;
    }

    /* return index of top of stack */
    private int indexOfTop(int stackNum){
        int offset = stackNum*stackCapacity;
        int size = sizes[stackNum];
        return offset+size-1;
    }

    public static void main(String[] args) {
        FixedMultiStack fixedMultiStack = new FixedMultiStack(4);
        fixedMultiStack.push(1,10);
        fixedMultiStack.push(1,20);
        fixedMultiStack.push(0,30);
    }


}
