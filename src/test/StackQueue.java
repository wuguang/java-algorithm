package test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class StackQueue {

    public static void main(String [] args) throws Exception{
        testQueue();
    }
    public static void testQueue() throws Exception{
        MakeQueueWithStack myQueue = new MakeQueueWithStack();
        myQueue.push(1);
        System.out.println(myQueue.pop());
        myQueue.push(2);
        System.out.println(myQueue.pop());
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        myQueue.push(5);
        myQueue.push(6);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }

    public static void testStatck() throws Exception{
        MakeStackWithQueue myStack = new MakeStackWithQueue();
        myStack.push(1);
        System.out.println(myStack.pop());

        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        System.out.println(myStack.pop());
    }

    static class MakeQueueWithStack{
        Stack<Integer> stack01 = new Stack<>();
        Stack<Integer> stack02 = new Stack<>();

        public void push(int element){
            stack01.add(element);
        }

        public int pop() throws Exception{
            if(stack02.isEmpty()){
                while(!stack01.isEmpty()){
                    stack02.add(stack01.pop());
                }
            }
            if(stack02.isEmpty()){
                throw new Exception("队列里已没有内容了~~~");
            }
            return stack02.pop();
        }
    }

    static class  MakeStackWithQueue{
        Queue<Integer> queue01 = new LinkedList<Integer>();
        Queue<Integer> queue02 = new LinkedList<Integer>();
        int lenQ01 = 0;
        int lenQ02 = 0;
        //queue01 进入数据
        public boolean push(int element){
            queue01.offer(element);
            lenQ01 ++;
            return true;
        }

        public int pop() throws Exception{
            //queue01.offer(element);
            if(lenQ01 + lenQ02 == 0){
                throw new Exception("栈里已没有内容了，不可再出栈了");
            }else{
                //身份转换
                if(lenQ01 == 0){
                    queue01 = queue02;
                    lenQ01 = lenQ02;
                    queue02 = new LinkedList<Integer>();
                    lenQ02 = 0;
                    
                }
                while(lenQ01>1){
                    queue02.offer(queue01.poll());
                    lenQ02++;
                    lenQ01--;
                }
                lenQ01--;
                return queue01.poll();
            }
        }

    }
}
