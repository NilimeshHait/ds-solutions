package ds.stack;

import java.util.*;


/**
 * Nearest Greater element to Right
 *
 * INPUT: [4,9,1,0,7,8,2]
 * OUTPUT: [9, -1, 7, 7, 8, -1, -1]
 *
 */
public class NGR {
    public static void main(String[] args) {
        ArrayList<Integer> elements=new ArrayList<>(Arrays.asList(4,9,1,0,7,8,2));
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
        Collections.reverse(aaa);
        System.out.println(aaa);


    }
}
