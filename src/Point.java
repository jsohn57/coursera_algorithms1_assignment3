import java.util.Comparator;

public class Point implements Comparable<Point> {

	// compare points by slope
	public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>(){

		@Override
		public int compare(Point arg0, Point arg1) {
			
			double slopeToArg0 = slopeTo(arg0);
			double slopeToArg1 = slopeTo(arg1);
			
	    	final int BEFORE = -1;
	    	final int EQUAL = 0;
	    	final int AFTER = 1;

	    	if(slopeToArg0 == slopeToArg1){
	    		return EQUAL;
	    	}
	    	else if(slopeToArg0 < slopeToArg1){
	    		return BEFORE;
	    	}
	    	else{
	    		return AFTER;
	    	}
		}		
	};

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }


    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
    	double xDiff = that.x-this.x;
    	double yDiff = that.y-this.y;
    	if(xDiff == 0 && yDiff == 0){
    		return Double.MIN_VALUE;
    	}
    	else{
    		if(xDiff == 0){
    			return Double.MAX_VALUE; // positive infinity
    		}
    		else if(yDiff == 0){
    			return 0.0;
    		}
    		else{
    			return yDiff/xDiff;
    		}
    	}
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
    	final int BEFORE = -1;
    	final int EQUAL = 0;
    	final int AFTER = 1;
    	
    	if(this.y == that.y){
    		if(this.x == that.x){
    			return EQUAL;
    		}
    		else if(this.x < that.x){
    			return BEFORE;
    		}
    		else{
    			return AFTER;
    		}
    	}
    	else{
    		if(this.y < that.y){
    			return BEFORE;
    		}
    		else{
    			return AFTER;
    		}
    	}
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}

