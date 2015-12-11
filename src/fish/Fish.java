/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fish;

import java.util.Stack;

/**
 *
 * @author km
 */
public class Fish {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] a = {4,3,2,1,5};
        int [] b = {0,1,0,0,0,};
        System.out.println(solution(a,b));
    }
    
    public static int solution(int[] A, int[] B) {
       int result = 0;
       int oppositeFishSize = 0;
       Stack sUp = new Stack();
       Stack sDown = new Stack();
       for(int i=0; i<B.length;i++){
           if(B[i]==0){
               if(oppositeFishSize == 0){
                   sUp.push(A[i]);
               }else{
                   while(A[i]>oppositeFishSize && oppositeFishSize>0){
                       sDown.pop();
                       if(sDown.empty()){
                           oppositeFishSize = 0;
                       }else{
                           oppositeFishSize = (int)sDown.peek();
                       }
                   }
                   if(oppositeFishSize==0){
                       sUp.push(A[i]);
                   }
               }    
           }else{
               sDown.push(A[i]);
               oppositeFishSize = A[i];
           }
       }
       result = sDown.size()+sUp.size();
       return result;
    }
    
}
