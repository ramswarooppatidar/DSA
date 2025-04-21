package array.com;

public class ContainerMostWater {
	 public static int maxArea(int[] height) {
		 int start =0;
		 int end = height.length - 1;
		 int maxArea = 0;
		 while(start<end) {
			 int h = Math.min(height[start], height[end]);
			 int width = end - start;
			 int area = h * width;
			 if(maxArea < area) {
				 maxArea = area;
			 }
			 if(height[start] < height[end]) {
				 start++;
			 }else {
				 end--;
			 } 
		 }
		 return maxArea;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []height = {1,8,6,2,5,4,8,3,7};
		int maxArea = ContainerMostWater.maxArea(height);
		System.out.println("maxWater :"+maxArea);

	}

}
