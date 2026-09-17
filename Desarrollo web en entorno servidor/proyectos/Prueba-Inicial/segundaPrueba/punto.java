package segundaPrueba;

public class punto {
    private double x;
    private double y;

    public punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    
    public static void main(String[] args) {
        punto punto = new punto(4, 5);
        punto punto1 = new punto(9, 8);
        
        double  d = Math.sqrt(Math.pow((punto1.getX() - punto.getX()),2) + 
        Math.pow((punto1.getY() - punto.getY()),2)); 

        System.out.println(d);
    }

}
