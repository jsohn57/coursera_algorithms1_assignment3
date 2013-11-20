import java.util.*;


public class Fast {
	
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Point>> answers = new ArrayList<ArrayList<Point>>();
		
		String fileName = "input6.txt";
		In fileStream = new In(fileName);
		int N = fileStream.readInt();
		
		StdOut.println("N = " + N);
		List<Point> pArray = new ArrayList<Point>();

		for(int i = 0; i < N; i++){
			int x = fileStream.readInt();
			int y = fileStream.readInt();
			
			pArray.add(new Point(x, y));			
		}
		
		// sort pArray by the natural ordering
		Collections.sort(pArray);
		
		// O(N)
		for(int i = 0; i < N; i++){
			Point ref = pArray.get(i);			
			// O(N^2)
			List<Point> argArray = new ArrayList<Point>(pArray);

			// O(N^2*log(N))

			Collections.sort(argArray, ref.SLOPE_ORDER);
			double refSlope = Double.NEGATIVE_INFINITY;
			ArrayList<Point> al = new ArrayList<Point>();
			
			// add reference point
			int size = argArray.size();
			for(int t = 0; t < size; t++){
				Point p = argArray.get(t);
				double slope = ref.slopeTo(p);
				if(slope == Double.NEGATIVE_INFINITY){
					al.add(p);
				}
				else{
					if(refSlope != slope){
						if((al.size() >= 4)){
							if(ref.compareTo(al.get(1)) < 0){
								answers.add(al);
							}
						}
						refSlope = slope;
						al = new ArrayList<Point>();
						al.add(ref);
						al.add(p);
					}
					else{
						al.add(p);
					}
				}
			}
		}
		
		int size = answers.size();
		for(int k = 0; k < size; k++){
			ArrayList<Point> answer = answers.get(k);
			int len = answer.size();
			for(int p = 0; p < len; p++){
				StdOut.print(answer.get(p));
				if(p < len-1){
					StdOut.print("-->");
				}
				else{
					StdOut.println();
				}
			}
		}
	}
}
