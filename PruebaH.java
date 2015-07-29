import matriz.*;

public class PruebaH{
  public static void main(String[] args) {
  	TestSH hola= new TestSH("alpha.txt", "xs.txt", "yiris.txt", "xiris.txt","ys.txt");

  	double[] aux = hola.DecisionFunction();
  	hola.matrizConfusion(aux);

  }

}
