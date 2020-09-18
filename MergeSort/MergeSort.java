
public class MergeSort {
	 void sort(int[] arr,int l,int r) {
	        if(l >= r || arr == null) {
	            return;
	        }
	        int m = (l + r) >> 1;
	        sort(arr, l, m);
	        sort(arr, m + 1, r);
	        merge(arr,l,r,m);
	        
	    }
	    void merge(int[] arr,int l,int r,int m) {
	        int[] temp = new int[arr.length];
	        int index=0;
	        for(int i = l,j = m+1;i <= m || j <= r;index++) {
	            if(i <= m && j <= r) {
	                temp[index] = arr[i] < arr[j] ? arr[i++] : arr[j++];
	            }else if(i > m) {
	                temp[index] = arr[j++];
	            }else if(j > r) {
	                temp[index] = arr[i++];
	            }
	        }
	        for(int i = l;i <= r;i++) {
	            arr[i] = temp[i-l];
	        }
	    }
}
