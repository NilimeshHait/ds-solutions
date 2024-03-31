package ds.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * Nearest Smaller element to Left
 *
 * INPUT: [4,9,1,0,7,8,2]
 * OUTPUT: [-1, 4, -1, -1, 0, 7, 0]
 */
public class NSL {
    public static void main(String[] args) {
        ArrayList<Integer> elements=new ArrayList<>(Arrays.asList(4,9,1,0,7,8,2));
        Stack<Integer> st=new Stack<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<elements.size();i++){
            if(st.size()==0){
                result.add(-1);
            }else if(st.size()>0 && st.peek()<elements.get(i)) {
                result.add(st.peek());
            }
            else if(st.size()>0 && st.peek()>=elements.get(i)){
                while(st.size()>0 && st.peek()>=elements.get(i) ) {
                    st.pop();
                }
                if(st.size()==0){
                    result.add(-1);
                }
                if(st.size()>0 && st.peek()<=elements.get(i)){
                    result.add(st.peek());
                }
            }
            st.push(elements.get(i));

        }
        System.out.println(result);


    }
}
