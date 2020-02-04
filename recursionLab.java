public class recursionLab{
	public static void main(String args[]){
		circle2(.25);
	}

	public static void circle1(double r){
		if(r < 1){
			StdDraw.circle(0.5,0.5,r);
			circle1(r*1.2);
		}
	}
	public static void circle2(double r, double x){ 
		if(r > 0.0001){
			StdDraw.circle(2*r,0.5,r);
			circle2(r/2,3.0*r);
			circle2(r/2,-1.0*r);
		}
	}


}