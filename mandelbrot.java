public class mandelbrot{
	public static void main(String[] args){
		StdDraw.setCanvasSize(800,300);
		StdDraw.setXscale(0,800);
		StdDraw.setYscale(0,300);
        StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(600,150,200,150);
        StdDraw.show();
		StdDraw.setPenRadius(.01);
		mandel(-2,2,-1.5,1.5,1, new ComplexNumber(0,0), 0);
        StdDraw.show();
		zoom();
	}

public static void zoom() {
		double lastX = 200; double lastY = 150;
    	double trackX = 200; double trackJX = 200;
    	double trackY = 150; double trackJY = 150;
    	double time = 1; double timeJ = 0;
    	double previousx = 2; double previousJx = 2; 
    	double previousy = 1.5; double previousJy = 1.5;
        double centerX = 0; double centerY=0;
        double centerJX = 0; double centerJY=0;
   	 	double newX = 0; double newJX = 0;
   		double newY = 0; double newJY = 0;
   		double penRad = 0.02;	
   		double printX = 0; double printY = 0;
        boolean recRun = true;
        while (recRun = true) {
        	if (StdDraw.mouseX()<401){
        		printX = ComplexNumber.scale(StdDraw.mouseX(), 0, 400, centerX - previousx,  centerX + previousx);
        		printY = ComplexNumber.scale(StdDraw.mouseY(), 0, 300, centerY - previousy, centerY + previousy);
        	} else if (StdDraw.mouseX()> 400){
        		printX = ComplexNumber.scale(StdDraw.mouseX(), 400, 800, centerJX - previousJx,  centerJX + previousJx);
        		printY = ComplexNumber.scale(StdDraw.mouseY(), 0, 300, centerJY - previousJy, centerJY + previousJy);
        	}

        	System.out.println("x: " + printX + " y: " + printY);

            if (StdDraw.mousePressed()) {
            	lastX = StdDraw.mouseX();
            	lastY = StdDraw.mouseY();

            	if (lastX<401) {
            		if (lastX != trackX || lastY != trackY) {
            			newX = ComplexNumber.scale(lastX, 0, 400, newX - previousx,  newX + previousx);
      					newY = ComplexNumber.scale(lastY, 0, 300, newY - previousy, newY + previousy);
            			trackX = lastX;
            			trackY = lastY;
            		}
            		//mandel(newJX - previousJx, newJX + previousJx , newJY - previousJy, newJY + previousJy, timeJ+1, new ComplexNumber(newX, newY),1);
        		} else if (lastX>400) {
            		if (lastX != trackJX || lastY != trackJY) {
            			newJX = ComplexNumber.scale(lastX, 400, 800, newJX - previousJx,  newJX + previousJx);
            			newJY = ComplexNumber.scale(lastY, 0, 300, newJY - previousJy, newJY + previousJy);
            			trackJX = lastX;
            			trackJY = lastY;
            		}
        		}
            	//mandel(newJX - previousJx, newJX + previousJx , newJY - previousJy, newJY + previousJy, timeJ+1, new ComplexNumber(newX, newY),1);
            } else if (StdDraw.isKeyPressed(73)) {
            	zoomSetup(lastX);
            	if (lastX < 401) {
                    recRun = false;
                    centerX = newX;
                    centerY = newY;
            		time++;
            		previousx = previousx/2;
            		previousy = previousy/2;
            		mandel(newX - previousx, newX + previousx , newY - previousy, newY + previousy, time, new ComplexNumber(0,0),0);
                    StdDraw.show();	
                    recRun = true;
            	} else if (lastX > 400) {
                    recRun = false;
                    centerJX = newJX;
                    centerJY = newJY;
            		timeJ++;
            		previousJx = previousJx/2;
            		previousJy = previousJy/2;
            		mandel(newJX - previousJx, newJX + previousJx , newJY - previousJy, newJY + previousJy, timeJ, new ComplexNumber(newX, newY),1);
                    StdDraw.show(); 
                    recRun = true;
            		}	
            } else if (StdDraw.isKeyPressed(79)) {
            	if (lastX < 401) {
                    recRun = false;
                    centerX = newX;
                    centerY = newY;
            		time--;
            		previousx = previousx*2;
            		previousy = previousy*2;	
           			mandel(newX - previousx, newX + previousx , newY - previousy, newY + previousy, time, new ComplexNumber(0,0),0);
                    StdDraw.show();
                    recRun = true; 
            	} else if (lastX > 400) {
                    recRun = false;
                    centerJX = newJX;
                    centerJY = newJY;
            		timeJ--;
            		previousJx = previousJx*2;
            		previousJy = previousJy*2;	
            		System.out.println(newJX - previousJx);
            		mandel(newJX - previousJx, newJX + previousJx , newJY - previousJy, newJY + previousJy, timeJ, new ComplexNumber(newX, newY),1);
                    StdDraw.show(); 
                    recRun = true;
            	}	
            }	
        }
    }

public static void zoomSetup(double x){
	if(x<401){
		StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(200,150,200,150);
	} else if(x>400){
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(600,150,200,150);

	}
}


public static void mandel(double x1, double x2, double y1, double y2, double zoom, ComplexNumber cons, int choice){
	int ans;
	ComplexNumber z0;
	if(choice == 0){
		for (double x = x1; x<=x2; x+=(0.02/Math.pow(2,zoom))){
			for(double y = y1; y<=y2; y+=(0.02/Math.pow(2,zoom))){
				ans = check(cons, new ComplexNumber(x,y), 0);
				color(ans,0);
				ComplexNumber.leftGraph(new ComplexNumber(x,y),x1,x2,y1,y2);
			}
		}
	} if(choice == 1){
		for (double x = x1; x<=x2; x+=(0.02/Math.pow(2,zoom))){
			for(double y = y1; y<=y2; y+=(0.02/Math.pow(2,zoom))){
				z0 = new ComplexNumber(x,y);
				ans = check(z0, cons, 0);
				color(ans,1);
				ComplexNumber.rightGraph(z0,x1,x2,y1,y2);
			}
		}
	}
}

public static void color(int ans, int choice){
	if (ans == 255) {
		StdDraw.setPenColor(StdDraw.BLACK);
	} else {
		if (ans < 255) {
			ans = (int) ComplexNumber.scale(ans, 0, 200, 0, 100);
		} else if (ans>=255) {
			ans = (int) ComplexNumber.scale(ans, 200, 5000, 100, 250);
		}	

        if(choice == 0){
            StdDraw.setPenColor(0, ans, ans);
        } else if (choice ==1){
            StdDraw.setPenColor(ans, 0, ans);
        }		
		      
	}

}

	public static int check(ComplexNumber zn, ComplexNumber c, int counter){
		int ans = 0;
		if(zn.magnitude() < 2){
			if (counter < 255){
				ComplexNumber zn1 = new ComplexNumber(zn.power(2).add(c));
				counter++;
				ans = check(zn1, c, counter);
				return ans;
			} else {
				ans = 255;
			}
		} else {
			ans = counter*20;
		}
		return ans;
	}
}