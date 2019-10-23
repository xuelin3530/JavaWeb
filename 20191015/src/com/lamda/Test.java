package com.lamda;

public class Test {

	public static void main(String[] args) {
//		IMyInterface obj = new MyImplement();
//		obj.show();
//		
//		IMyInterface obj2 = new IMyInterface() {
//			public void show() {				
//				System.out.println("My Implement2~~~~~~~~");
//			}
//		};
//		obj2.show();
//		
//		IMyInterface obj3 = ()->System.out.println("My Implement3***********");
//		obj3.show();
		
		test(new MyImplement());
		test(new IMyInterface() {
			public void show() {
				System.out.println("IMyInterface 2~~~");
			}
		});
		test(()->System.out.println("IMyInterface 3*********"));
		
		showAdd(10, (num)->{return 10*num;});
		showAdd(10, (num)->{return 5+num;});
		
	}
	
	private static void test(IMyInterface  inter) {
		inter.show();
	}
	
	private static void showAdd(int num, IMyInterfac2 inter2) {
		int rs = inter2.add(num);
		System.out.println("rs="+rs);
	}

}
