package array.com;

public class ArrayPushLeftRight {
	public static void pushZeroLeft(int arr[]) {
		int stop =0;
		int run =0;
		while(run <=arr.length -1) {
			if(arr[run] != 0) {
				int temp = arr[run];
				arr[run] = arr[stop];
				arr[stop] = temp;
				stop++;
			}
			run++;
			for(int a : arr) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
	}
	public  static void pushZeroRight(int arr[]) {
		int stop =arr.length - 1;
		int run = arr.length - 1;
		while(run >= 0) {
			if(arr[run] != 0) {
				int temp = arr[run];
				arr[run] = arr[stop];
				arr[stop] = temp;
				stop--;
			}
			run--;
			for(int a : arr) {
				System.out.print(a+" ");
			}
			System.out.print("   : run "+run + " stop :"+stop);
			System.out.println();
		}
		for(int a : arr) {
			System.out.print(a+", ");
		}
	}
	
	public static void pushEvenLeft(int arr[]) {
		int stop = 0;
		int run =0;
		while(run <= arr.length -1) {
			if(arr[run] % 2 == 0) {
				int temp = arr[run];
				arr[run] = arr[stop];
				arr[stop] = temp;
				stop++;
			}
			run++;
			for(int a : arr) {
				System.out.print(a+", ");
			}
			System.out.println();
		}
	}
	public static void pushEvenRight(int arr[]) {
		int stop = 0;
		int run =0;
		while(run <= arr.length -1) {
			if(arr[run] % 2 != 0) {
				int temp = arr[run];
				arr[run] = arr[stop];
				arr[stop] = temp;
				stop++;
			}
			run++;
			for(int a : arr) {
				System.out.print(a+", ");
			}
			System.out.println();
		}
	}
	public static void pushNegativeLeft(int arr[]) {
		int stop=0;
		int run=0;
		while(run <= arr.length - 1) {
			if(arr[run] < 0) {
				int temp = arr[run];
				arr[run] = arr[stop];
				arr[stop] = temp;
				stop++;
			}
			run++;
			for(int a : arr) {
				System.out.print(a+", ");
			}
			System.out.println();
		}
	}
	//order is preserved
	public static void pushNegativeRight(int arr[]) {
		int stop=0;
		int run=0;
		while(run <= arr.length - 1) {
			if(arr[run] > 0) {
				int temp = arr[run];
				arr[run] = arr[stop];
				arr[stop] = temp;
				stop++;
			}
			run++;
			for(int a : arr) {
				System.out.print(a+", ");
			}
			System.out.println();
		}
	}
	public static void push2right1middle0left(int arr[]) {
		int start =0;
		int mid =0;
		int end = arr.length -1;
		while(mid<=end) {
			if(arr[mid] == 2) {
				int temp = arr[end];
				arr[end] = arr[mid];
				arr[mid] = temp;
				end--;
			}
			else if(arr[mid] == -1) {
				int temp = arr[mid];
				arr[mid] = arr[start];
				arr[start] = temp;
				start++;
			}else {
				mid++;
			}
		}
		for(int a : arr) {
			System.out.print(a+" ");
		}
		
	}
	public static void push2left0middle1right(int arr[]) {
		int start =0;
		int mid =0;
		int end = arr.length -1;
		while(mid<=end) {
			if(arr[mid] == -1) {
				int temp = arr[end];
				arr[end] = arr[mid];
				arr[mid] = temp;
				end--;
			}
			else if(arr[mid] == 2) {
				int temp = arr[mid];
				arr[mid] = arr[start];
				arr[start] = temp;
				start++;
				mid++;
			}else {
				mid++;
			}
		}
		for(int a : arr) {
			System.out.print(a+" ");
		}
		
	}
	
	


	public static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[]= {2,6,0,2,5,7,0,0,1,0};
//		ArrayProblems.pushZeroLeft(arr);
//		ArrayProblems.pushZeroRight(arr);
		
//		int arr[]= {2,6,3,13,5,7,10,22,11,19};
//		ArrayProblems.pushEvenLeft(arr);
		
//		int arr[]= {2,6,-3,13,5,7,-10,22,11,-19};
//		ArrayPushLeftRight.pushNegativeLeft(arr);
		
//		int arr[]= {2,6,-3,13,5,7,-10,22,11,-19};
//		ArrayProblems.pushNegativeRight(arr);
		
//		int arr[]= {0,2,-1,2,2,0,-1,-1,2,0,-1,2,-1,0,0,-1,0,2,2,-1,-1,0,0,2,0,-1};
//		ArrayPushLeftRight.push2right1middle0left(arr);
	
		System.out.println();
		int arr[]= {0,2,-1,2,2,0,-1,-1,2,0,-1,2,-1,0,0,-1,0,2,2,-1,-1,0,0,2,0,-1};
		ArrayPushLeftRight.push2left0middle1right(arr);


	}

}
