package com.niocoder.niocoder;

/**
 * Created by admin on 2018/5/30.
 */
public class ErJinZhi {
   public static void main(String[] args) {
      int r = getNumber(5,7);
      System.out.println(r*5);
   }

   /**
    * 5*fix=result
    * @param fix
    * @param result
    * @return
    */
   public static int getNumber(int fix,int result){
      int min = Integer.MIN_VALUE;
      int max = Integer.MAX_VALUE;
      Long a = 2l*min;
      System.out.println("2*Integer.MIN_VALUE整型值为：" + a.intValue());
      Long b = 2l*max;
      System.out.println("2*Integer.MAX_VALUE整型值为：" + b.intValue());
      Long u = 0l;
      Long tmp;
      for (int i = 1 ; i< 10 ; i++){
         System.out.println("开始循环：i=" + i);
         tmp = i*a + result;
         System.out.println("长整型值为："+ tmp);
         if(tmp.intValue() == result){
            double tt = (tmp)/(fix*1.0);
            if(new Double(tt).intValue() == tt){
               u = (tmp)/(fix);
               if(u <= max && u>= min){
                  System.out.println("所求整数为：" + u);
                  break;
               }
            }

         }
      }
      return u.intValue();
   }
}