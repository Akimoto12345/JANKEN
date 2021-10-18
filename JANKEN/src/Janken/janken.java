package Janken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class janken {
	//
	public static void main(String args[]) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(reader);
		
		int  gu = 0;
		int pa = 1;
		int cyoki = 2;
		int youhand = 0;
		
		Random randam = new Random();
		int randamvalue = randam.nextInt(3);
	
		
			
			System.out.println("じゃんけんを開始します。");
			
			String str = String.format("何を出しますか？(%d:[グー],%d:[パー],%d:[チョキ])",gu,pa,cyoki);
			
			 System.out.println(str);
					 
			String youinput1 = br.readLine();
			youhand = Integer.parseInt(youinput1);
				
			for(;;) {
						
				if(youhand == gu || youhand == pa || youhand == cyoki) {
					System.out.println(youhand);
					break;
				}else if (youhand != gu || youhand != pa || youhand != cyoki){
					String error = String.format(str + "が入力(%d:[グー],%d:[パー],%d:[チョキ])を入力してください",gu,pa,cyoki);
					System.out.println(error);
				}
			}
			
			if(randamvalue == 0) {
				System.out.println("相手はグー");
			}else if(randamvalue == 1) {
				System.out.println("相手はパー");
			}else if(randamvalue == 2) {
				System.out.println("相手はチョキ");
			}
					
			if(youhand == gu) {
				if(randamvalue == gu) {
					System.out.println("あいこです。");
				}else if(randamvalue == pa) {
					System.out.println("相手の勝ちです。");
				}else if(randamvalue == cyoki) {
					System.out.println("あなたの勝ちです。");
				}
			}
			if(youhand == pa) {
				if(randamvalue == gu) {
					System.out.println("あなたの勝ちです。");
				}else if(randamvalue == pa) {
					System.out.println("あいこです");
				}else if (randamvalue == cyoki) {
					System.out.println("あなたの負けです");
				}
			}
			if(youhand == cyoki) {
				if(randamvalue == gu) {
					System.out.println("あなたの負けです。");
				}else if(randamvalue == pa) {
					System.out.println("あなたのかちです");
				}else if (randamvalue == cyoki) {
					System.out.println("あいこです");
				}
			}
	}
}