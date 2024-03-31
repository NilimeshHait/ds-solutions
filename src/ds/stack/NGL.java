package ds.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * Nearest Greater element to Left
 *
 * INPUT: [4,9,1,0,7,8,2]
 * OUTPUT: [-1, -1, 9, 1, 9, 9, 8]
 */
public class NGL {
    public static void main(String[] args) {
        ArrayList<Integer> elements=new ArrayList<>(Arrays.asList(4,9,1,0,7,8,2));
        Stack<Integer> st=new Stack<>();
        List<Integer> aaa=new ArrayList<>();
        for(int i=0;i<elements.size();i++){
            if(st.size()==0){
                aaa.add(-1);
            }else if(st.size()>0 && st.peek()>elements.get(i)) {
                aaa.add(st.peek());
            }
            else if(st.size()>0 && st.peek()<=elements.get(i)){
                while(st.size()>0 && st.peek()<=elements.get(i) ) {
                    st.pop();
                }
                if(st.size()==0){
                    aaa.add(-1);
                }
                if(st.size()>0 && st.peek()>=elements.get(i)){
                    aaa.add(st.peek());
                }
            }
            st.push(elements.get(i));

        }
        System.out.println(aaa);


    }
}
