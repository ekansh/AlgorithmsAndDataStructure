package amazon.matrix;

public class IntersectionOfRectangle {
	public static class Rectangle {

        // coordinates of bottom left corner
        private int leftX;
        private int bottomY;

        // dimensions
        private int width;
        private int height;

        public Rectangle() {}

        public Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return String.format("(left: %d, bottom: %d, width: %d, height: %d)",
                leftX, bottomY, width, height);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Rectangle)) {
                return false;
            }
            final Rectangle r = (Rectangle) o;
            return leftX == r.leftX && bottomY == r.bottomY
                   && width == r.width && height == r.height;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + leftX;
            result = result * 31 + bottomY;
            result = result * 31 + width;
            result = result * 31 + height;
            return result;
        }
    }

    public static Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {
    	int maxStartingPointX = Math.max(rect2.getLeftX(), rect1.getLeftX());
    	int minEndingPointX =Math.min(rect2.getLeftX()+rect2.getWidth(), rect1.getLeftX()+rect1.getWidth());
    	if(maxStartingPointX >=minEndingPointX) return new Rectangle();
    	
    	int maxStartingPointY = Math.max(rect2.getBottomY(), rect1.getBottomY());
    	int minEndingPointY =Math.min(rect2.getBottomY()+rect2.getHeight(), rect1.getBottomY()+rect1.getHeight());
    	if(maxStartingPointY >=minEndingPointY) return new Rectangle();
    	
    
        return new Rectangle(maxStartingPointX,maxStartingPointY,
        		(minEndingPointX-maxStartingPointX),(minEndingPointY-maxStartingPointY));
    }


}
/*
public static void main(String[] args) {
new Rect(new Point(2,2), new Point(2,4), new Point(4,2)
getIntersectionOfRectangle()
}
private static class Point{
int x, y;
Point(int a, int b){x=a; y=b;}
}
private static class Rect{
Point a,b,c,d;
Rect(Point x, Point y, Point x2, Point y2){
	a=x; b=y; c=x2; d=y2;
}
}
*/