package com.classcontent;

public class Loop {
	public static void main(String[] args) {
		// 在控制台输出1...10
		// while
		int i = 1;
		while (i < 11) {
			System.out.println(i);
			i++;
		}
		
		// do while
		int j = 1;
		do {
			System.out.println(j);
			j++;
		} while (j < 11);
		
		// for
		for (int k = 1; k < 11; k++) {
			System.out.println(k);
		}
		
		// for 嵌套
		// 99乘法表
		for (int k1 = 1; k1 < 10; k1++) {
			for (int k2 = 1; k2 <= k1; k2++) {
				System.out.print(k1 + "*" + k2 + "=" + (k1*k2) + "  ");
			}
			System.out.println("\n");
		}
		// 水仙花数 [各位数的立方和等于该数本身]
		for (int l = 100; l <= 999; l++) {
			// 求百位数
			int b = l / 100;
			// 求十位数
			int s = (l - b*100) / 10;
			// 求个位数
			int g = l - b*100 - s*10;
			if (l == g*g*g + s*s*s + b*b*b) {
				System.out.println(l + " ");
			}
		}
		
		// break
		for (int e = 0; e < 10; e++) {
			if(e == 5) {
				break;
			}
			System.out.println(e);
		}
		
		// continue
		for (int e = 0; e < 10; e++) {
			if(e == 5) {
				continue;
			}
			System.out.println(e);
		}
		
		// return
		for (int e = 0; e < 10; e++) {
			if(e == 5) {
				return;
			}
			System.out.println(e);
		}
		System.out.println("你不return就能看到我");
	}
}
