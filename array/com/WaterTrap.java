package array.com;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class WaterTrap {

	public static int trap(int arr[]) {
		int n = arr.length;
		int ans=0;
		int l =0, r=n-1;
		int lmax=0, rmax=0;
		while(l < r) {
			lmax = Math.max(lmax, arr[l]);
			rmax = Math.max(rmax, arr[r]);
			
			if(lmax < rmax) {
				ans += lmax - arr[l];
				l++;
			}else {
				ans+= rmax - arr[r];
				r--;
			}
		}
		return ans;
	}
	public static int trap2(int arr[]) {
		int left[] = new int[arr.length];
		int right[] = new int[arr.length];
		int n = arr.length;
		
		left[0] = arr[0];
		for(int i =1; i<n; i++) {
			left[i] = Math.max(left[i-1], arr[i]);
		}
		right[n-1] = arr[n-1];
		for(int j = n - 2; j>=0; j--) {
			right[j] = Math.max(arr[j], right[j+1]);
		}
		int ans=0;
		for(int i=0; i<n; i++) {
			ans+= Math.min(left[i], right[i])-arr[i];
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(arr));
		System.out.println(trap2(arr));
		
		int arr2[] = {4,2,0,3,2,5};
		System.out.println(trap(arr2));
		System.out.println(trap2(arr2));

	}

}
