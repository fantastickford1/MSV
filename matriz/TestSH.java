package matriz;
import java.io.*;

public class TestSH extends AnalizaFile{

  private double[] alpha; //alfa obtenida en matlab
  private double[] xs; //x obtenida de los datos de prueba
  private double[] ys; //Y de los datos de prueba de tamaño 20
  private double[] x; //x obtenida de los datos de iris
  private int sizeIris; //tamaño de datos de iris (80)
  private int sizeTest; //tamaño de datos de prueba iris(20)
  private int sum; //sumatoria de la funcion
  private double[] result = new double[20];//almacenamieto de total de sumarias repetida 20 veces
  private String alphaFile;
  private String xsFile;
  private String ysFile;
  private String xFile;

  public TestSH(){
    this.alpha = new double[0];
    this.xs = new double[0];
    this.ys = new double[0];
    this.x = new double[0];
    this.sizeIris = 0;
    this.sizeTest = 0;
    this.sum = 0;
  }

  public TestSH(String alphaFile, String xsFile,double ysFile, String xFile){
    this.alphaFile = alphaFile;
    this.xsFile = xsFile;
    this.ysFile = ysFile;
    this.xFile = xFile;
    this.alpha = getAlpha();
    this.xs = getXs();
    this.ys = getYs();
    this.x = getXIris();
    this.sizeIris = x.size();
    this.sizeTest = ys.size();
    this.sum = 0;
  }

  public double[] DecisionFunction(){


  }

  private double[] getAlpha(){
    super(alphaFile);
    int num = getLines();
    String [] aux = getAllLines(num);
    double [] dou = new double[aux.length];
    for(int cont = 0; cont < aux.length; cont++){
      dou[cont] = Double.parseDouble(aux[count]);
    }
    return dou;

  }

  private double[] getXs(){

  }

  private double[] getYs(){

  }

  private double[] getXIris(){

  }

}
