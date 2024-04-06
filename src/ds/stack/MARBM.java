package ds.stack;

import java.util.*;

/**
 * Max area Rectangle in Binary Matrix
 * Input:
 * 0 1 0 1 0 0
 * 1 1 1 0 1 0
 * 1 1 1 1 0 1
 * 1 0 1 1 0 1
 *
 * Output: 6
 *
 */
public class MARBM {

    public static void main(String[] args) {
        MARBM marbm=new MARBM();
        int row=4;
        int col=6;
        int inputMatrix[][]={{0,1,0,1,0,0},{1,1,1,0,1,0},{1,1,1,1,0,1},{1,0,1,1,0,1}};
        int maxArea=0;
        Integer arrValue[]=new Integer[col];
        for(int i=0;i<row;i++){
           List<Integer> data=new ArrayList<>();
           for(int j=0;j<col;j++) {
               if ( i==0 ) {
                   arrValue[j] = inputMatrix[i][j];
               } else if(inputMatrix[i][j] != 0 ) {
                   arrValue[j] = arrValue[j] + inputMatrix[i][j];
               }else{
                   arrValue[j] = 0;
               }
           }
           data=new ArrayList<>(Arrays.asList((arrValue)));
           int result=marbm.getMaxArea(data);
           if(result>maxArea){
               maxArea=result;
           }
        }
        System.out.println(maxArea);
    }

    public int getMaxArea(List<Integer> data){
        List<Integer> nslIndx=new ArrayList<>();
        List<Integer> nsrIndx=new ArrayList<>();
        Stack<Map<String,Integer>> st=new Stack<>();

        for(int i=0;i<data.size();i++){
            Map<String,Integer> value=new HashMap<>();
            if(st.size()==0){
                nslIndx.add(-1);
            }
            else if(st.size()>0 && st.peek().get("value")>=data.get(i)){
                while (st.size()>0 && st.peek().get("value")>=data.get(i)){
                    st.pop();
                }
                if(st.size()==0){
                    nslIndx.add(-1);
                }
                if(st.size()>0 && st.peek().get("value")<=data.get(i)){
                    nslIndx.add(st.peek().get("index"));
                }
            }
            else if(st.size()>0 && st.peek().get("value")<data.get(i)){
                nslIndx.add(st.peek().get("index"));
            }
            value.put("value",data.get(i));
            value.put("index",i);
            st.push(value);
        }
        st.empty();
        for(int i=data.size()-1;i>=0;i--){
            Map<String,Integer> value1=new HashMap<>();
            if(st.size()==0){
                nsrIndx.add(data.size());
            }
            else if(st.size()>0 && st.peek().get("value")>=data.get(i)){
                while(st.size()>0 && st.peek().get("value")>=data.get(i)){
                    st.pop();
                }
                if(st.size()==0){
                    nsrIndx.add(data.size());
                }
                if(st.size()>0 && st.peek().get("value")<=data.get(i)){
                    nsrIndx.add(st.peek().get("index"));
                }
            }
            else if(st.size()>0 && st.peek().get("value")<data.get(i)){
                nsrIndx.add(st.peek().get("index"));
            }
            value1.put("value",data.get(i));
            value1.put("index",i);
            st.push(value1);
        }
        Collections.reverse(nsrIndx);
        int maxVal=0;
        for(int i=0;i<data.size();i++){
            if(data.get(i)*(nsrIndx.get(i)-nslIndx.get(i)-1)>maxVal){
                maxVal=data.get(i)*(nsrIndx.get(i)-nslIndx.get(i)-1);
            }
        }
        return maxVal;
    }
}
