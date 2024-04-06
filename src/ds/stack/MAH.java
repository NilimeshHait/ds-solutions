package ds.stack;

import java.util.*;

/**
 * Maximum area Histogram.
 * input: [3,2,1,6,9,4,2,1]
 * output: 12
 *
 */

public class MAH {
    public static void main(String[] args) {

        List<Integer> input=new ArrayList<>(Arrays.asList(3,2,1,6,9,4,2,1));
        List<Integer> indxNSL=new ArrayList<>();
        List<Integer> indxNSR=new ArrayList<>();
        Stack<Map<String,Integer>> st=new Stack<>();

        for(int i=0;i<input.size();i++){
            Map<String,Integer> data=new HashMap<>();
            if(st.size()==0){
                indxNSL.add(-1);
            }
            else if(st.size()>0 && st.peek().get("value")>= input.get(i)){
                while(st.size()>0 && st.peek().get("value")>= input.get(i)){
                    st.pop();
                }
                if(st.size()==0){
                    indxNSL.add(-1);
                }
                if(st.size()>0 && st.peek().get("value")<=input.get(i)){
                    indxNSL.add(st.peek().get("index"));
                }
            }
            else if(st.size()>0 && st.peek().get("value")<input.get(i)){
                indxNSL.add(st.peek().get("index"));
            }
            data.put("value",input.get(i));
            data.put("index",i);
            st.push(data);
        }
        st.empty();
        //System.out.println(indxNSL);
        for (int i=input.size()-1;i>=0;i--){
            Map<String,Integer> data1=new HashMap<>();
            if(st.size()==0){
                indxNSR.add(input.size());
            }
            else if(st.size()>0 && st.peek().get("value")>=input.get(i)){
                while (st.size()>0 && st.peek().get("value")>=input.get(i)){
                    st.pop();
                }
                if(st.size()==0){
                    indxNSR.add(input.size());
                }
                if(st.size()>0 && st.peek().get("value")<=input.get(i)){
                    indxNSR.add(st.peek().get("index"));
                }
            }
            else if(st.size()>0 && st.peek().get("value")<=input.get(i)){
                indxNSR.add(st.peek().get("index"));
            }
            data1.put("value",input.get(i));
            data1.put("index",i);
            st.push(data1);
        }
        Collections.reverse(indxNSR);
        //System.out.println(indxNSR);

        List<Integer> width=new ArrayList<>();
        int maxArea=0;
        for(int i=0;i<input.size();i++){
            if(input.get(i)*(indxNSR.get(i)-indxNSL.get(i)-1) >maxArea){
                maxArea=input.get(i)*(indxNSR.get(i)-indxNSL.get(i)-1);
            }
            width.add(indxNSR.get(i)-indxNSL.get(i)-1);
        }
        //System.out.println(width);
        System.out.println(maxArea);
    }
}
