import java.util.Arrays;

public class MergeSort {
	private int[] vector;

	public MergeSort(int[] vector) {
		this.vector = vector;
	}

	@Override
	public String toString() {
		return Arrays.toString(vector);
	}

	public int[] getVector() {
		return vector;
	}

	public void merge(int p, int q, int r) {
		int n1 = q - p ;
		int n2 = r - q;
		int[] L;
		int[] R;
		int i;
		int j;
		L = new int[n1 + 1];
		R = new int[n2 + 1];

		for (i = 0; i < n1; i++) {
			L[i] = vector[p + i];
		}

		for (j = 0; j < n2; j++) {
			R[j] = vector[q + j + 1];
		}

		L[n1] = Integer.MAX_VALUE;

		R[n2] = Integer.MAX_VALUE;

		i = j = 0;
		
		for (int k = p; k <= r; k++) {
			if (L[i] <= R[j]) {
				vector[k] = L[i];
				i++;
			} else {
				vector[k] = R[j];
				j++;
			}
		}
	}

	public void sort(int p, int r) {
		int q;
		if (p < r) {
			q = Math.floorDiv((p + r), 2);
			sort(p, q);
			sort(p, q);
			merge(p, q, r);
		}
	}	
}