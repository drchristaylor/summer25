package wk7;

public class Driver {
    public static void main(String[] args) {
        PureStack<String> stack = new Stack<>();
        stack.push("Will");
        stack.push("not");
        stack.push("work");
        System.out.println(stack.pop());
    }
}
