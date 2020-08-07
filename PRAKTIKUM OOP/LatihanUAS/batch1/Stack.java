public class Stack {
    private static final int EMPTY_STACK_INDEX = -1;
    private int[] datas;
    private int top;

    public Stack(int size) {
        this.datas = new int[size];
        this.top = -1;
    }
    
    public Stack() {
        this(10);
    }

    public void push(int x) {
        if(top == datas.length - 1) {
            return;
        }
        top += 1;
        this.datas[top] = x;
    }

    public void push(int[] x) {
        for(int elmt : x) {
            if(top == datas.length - 1) {
                return;
            }
            top += 1;
            this.datas[top] = elmt;
        }
    }

    public int pop() {
        if(this.top == EMPTY_STACK_INDEX) {
            return 0;
        }
        else {
            this.top -= 1;
            return this.datas[top + 1];
        }
    }

    public void test() {
        Stack stack = new Stack(3);
        stack.push(10);
        stack.push(2);
        int[] arr = {1,2,3};
        stack.push(arr);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}