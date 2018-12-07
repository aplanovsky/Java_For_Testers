package my.sandbox;

public class HW{
  public static void main(String[] args)
  {
    hello("Wind");
    hello("Win");
    hello("Ween");
    hello("World");
    hello("Word");
    hello("Lord");
    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " +  r.b  + " = " + r.area());
  }
  public static  void  hello(String s){
    System.out.println("Hello, " + s + "!");
  }


}
