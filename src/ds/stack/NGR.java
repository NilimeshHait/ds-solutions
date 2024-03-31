package ds.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NGR {
    public static void main(String[] args) {
        ArrayList<Integer> elements=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Stack<Integer> result=new Stack<>();
        List<Integer> aaa=new ArrayList<>();
        for(int i=elements.size()-1;i>=0;i--){
            if(result.size()==0){
                aaa.add(-1);
            }else if(result.size()>0 && result.peek()>elements.get(i)) {
                aaa.add(result.peek());
            }
            else if(result.size()>0 && result.peek()<=elements.get(i)){
                while(result.size()>0 && result.peek()<=elements.get(i)) {
                    result.pop();
                }
                if(result.size()==0){
                    aaa.add(-1);
                }
                if(result.size()>0 && result.peek()>=elements.get(i)){
                    aaa.add(result.peek());
                }
            }
            result.push(elements.get(i));

        }
        System.out.println(aaa.reversed());


    }
}
