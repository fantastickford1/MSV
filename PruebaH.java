import matriz.*;

public class PruebaH{
  public static void main(String[] args) {
  	TestSH hola= new TestSH("alpha.txt", "xs.txt", "yiris.txt", "xiris.txt");

  	double[] aux = hola.DecisionFunction();

  	for(int gft = 0; gft < aux.length; gft++){
  		System.out.println(aux[gft]);
  	}

  }

}
