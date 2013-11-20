
public class Brute {

	public static void main(String[] args) {
		String fileName = "input8.txt";
		In fileStream = new In(fileName);
		int N = fileStream.readInt();
		
		StdOut.println("N = " + N);
		Point [] pArray = new Point[N];

		//Point ref = new Point(1,1);
		for(int i = 0; i < N; i++){
			int x = fileStream.readInt();
			int y = fileStream.readInt();
			
			pArray[i] = new Point(x, y);			
		}
		
		
		for(int i = 0; i < N; i++){
			Point p0 = pArray[i];
			for(int j = 0; j < N; j++){
				Point p1 = pArray[j];
				double slope1 = p0.slopeTo(p1); 
				for(int k = 0; k < N; k++){
					Point p2 = pArray[k]; 
					double slope2 = p0.slopeTo(p2); 
					for(int t = 0; t < N; t++){
						Point p3 = pArray[t];
						double slope3 = p0.slopeTo(p3);
						if((slope1 == slope2) && (slope2 == slope3) && (p0.compareTo(p1) < 0) && (p1.compareTo(p2) < 0) && (p2.compareTo(p3) < 0)){
							StdOut.println(p0.toString() + " --> " + p1.toString() + " --> " + p2.toString() + " --> " + p3.toString()); 
						}
					}
				}
			}
		}
	}
}
