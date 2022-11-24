
import java.text.*;


class App
{


static double f(double x, double y)
{
    double v = x * Math.sqrt(y);
    return v;
}
 

static double predict(double x, double y, double h)
{
    
    double y1p = y + h * f(x, y);
    return y1p;
}
 

static double correct(double x, double y,
                    double x1, double y1,
                    double h)
{
    
    double e = 0.00001;
    double y1c = y1;
 
    do
    {
        y1 = y1c;
        y1c = y + 0.5 * h * (f(x, y) + f(x1, y1));
    }
    while (Math.abs(y1c - y1) > e);
 
    
    return y1c;
}
 
static void printFinalValues(double x, double xn,
                    double y, double h)
{

    System.out.println("\n\nLa función que se está usando es la misma que la del ejemplo utilizado en el salón.\nx * Math.sqrt(y)");
 
    while (x < xn)
    {
        double x1 = x + h;
        double y1p = predict(x, y, h);
        double y1c = correct(x, y, x1, y1p, h);
        x = x1;
        y = y1c;
        System.out.println("los valores  de y en x = "+
                        x + " is : "+ y); 
    }
 
   
    DecimalFormat df = new DecimalFormat("#.#####");
    System.out.println("\n\nEl valor final de y en x = "+
                        x + " is : "+df.format(y)+"\n\n");
}
 

public static void main (String[] args)
{
   
    double x = 1, y = 4;
 
   
    double xn = 1.5;
 
   
    double h = 0.1;
 
    printFinalValues(x, xn, y, h);
}
}
 
