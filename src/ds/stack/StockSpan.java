package ds.stack;

import java.util.*;

/**
 * INPUT: [30,10,20,60,40,30,20,80,90]
 * OUTPUT: [1, 1, 2, 4, 1, 1, 1, 8, 9]
 * Find the number of consecutive less stock to the left
 * For Above INPUT left side there is no stock value so output is 1 for 30.
 * For the next index value 1, there is no smaller stock to the left so output is 1 for 10.
 * For the next index value 2, there is 1 consecutive smaller stock to the left so output is 2 for 20 and so on...
 */

public class StockSpan {
    public static void main(String[] args) {
        ArrayList<Integer> stock=new ArrayList<>(Arrays.asList(30,10,20,60,40,30,20,80,90));
        ArrayList<Integer> result=new ArrayList<>();

        Stack<Map<String,Integer>> st=new Stack<>();
        for(int i=0;i<stock.size();i++){
            Map<String,Integer> map=new HashMap();
            if(st.size()==0){
                result.add(-1);
            }
            else if(st.size()>0 && st.peek().get("value")<=stock.get(i)){
                while(st.size()>0 && st.peek().get("value")<=stock.get(i)){
                    st.pop();
                }
                if(st.size()==0){
                    result.add(-1);
                }
                if(st.size()>0 && st.peek().get("value")>=stock.get(i)){
                    result.add(st.peek().get("index"));
                }
            } else if (st.size()>0 && st.peek().get("value")>stock.get(i)) {
                result.add(st.peek().get("index"));
            }
            map.put("value",stock.get(i));
            map.put("index",i);
            st.push(map);
        }
        List<Integer> finalResult=new ArrayList<>();
        for(int i=0;i<result.size();i++){
            finalResult.add(i-(result.get(i)));
        }
        System.out.println(finalResult);
    }
}
