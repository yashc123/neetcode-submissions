class MinStack {

    Deque<Integer> stack;
    Deque<Integer> orderStack;
    int minInteger = 0;
   

    public MinStack() {
        stack = new ArrayDeque<>();
        orderStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            orderStack.push(val);
        }
        else{
            orderStack.push(Math.min(val, orderStack.peek()));
        }
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
        orderStack.pop();


    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
       return orderStack.peek();
    }
}
