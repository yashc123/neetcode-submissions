class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int next = stack.pop();
                int next2 = stack.pop();
                if(tokens[i].equals("+")){
                    stack.push(next + next2);
                }
                else if(tokens[i].equals("-")){
                    stack.push(next2 - next);
                }
                else if(tokens[i].equals("*")){
                    stack.push(next * next2);
                }
                else{
                    stack.push(next2 / next);
                }
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.peek();
    }
}
