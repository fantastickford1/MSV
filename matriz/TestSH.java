package matriz;
import java.io.*;

public class TestSH extends AnalizaFile{

  private double[] alpha; //alfa obtenida en matlab
  private double[][] xs; //x obtenida de los datos de prueba
  private double[] ys; //Y de los datos de prueba de tamaño 20
  private double[][] x; //x obtenida de los datos de iris
  private final int sizeIris = 80; //tamaño de datos de iris (80)
  private final int sizeTest = 20; //tamaño de datos de prueba iris(20)
  private double sum; //sumatoria de la funcion
  private double[] result = new double[20];//almacenamieto de total de sumarias repetida 20 veces


  public TestSH(){
    this.alpha = new double[0];
    this.xs = new double[0][0];
    this.ys = new double[0];
    this.x = new double[0][0];
    this.sum = 0.0;
  }

  public TestSH(String alphaFile, String xsFile, String ysFile, String xFile){
    super();
    this.alpha = getAlpha(alphaFile);
    this.xs = getXs(xsFile);
    this.ys = getYs(ysFile);
    this.x = getXIris(xFile);
    this.sum = 0.0;
  }

  public double[] DecisionFunction(){

    MSV mult = new MSV();

    for(int i=0; i< sizeTest; i++){
      for(int j=0; j< sizeIris; j++){
        sum= sum+ alpha[i]*ys[i]*(mult.multVectorDou(getVector(j,x),getVector(i,xs))+1);
      }
      result[i]=sum;
      sum=0;
    }
    return result;
  }

  private double[] getAlpha(String alphaFile){
    this.setFileName(alphaFile);
    int num = getLines();
    String [] aux = getAllLines(num);
    double [] dou = new double[aux.length];
    for(int cont = 0; cont < aux.length; cont++){
      dou[cont] = Double.parseDouble(aux[cont]);
    }
    return dou;

  }

  private double[][] getXs(String xsFile){
    this.setFileName(xsFile);
    int num2 = getLines();
    String [] temp2 = getAllLines(num2);
    String[] a;
    double[] b = new double[4];
    double cp;
    double[][] temporal = new double[20][4];

    for(int c= 0; c < temp2.length; c++){
      for(int c2= 0; c2 < 4; c2++){
        a= temp2[c].split(",");
        for(int c3=0; c3<4; c3++){
          cp= Double.parseDouble(a[c3]);
          b[c3]= cp;
        }
        
        temporal[c][c2]= b[c2];
      }   
    }

    return temporal;
  }

  private double[] getYs(String ysFile){
    this.setFileName(ysFile);
    int num1 = getLines();
    String [] temp = getAllLines(num1);
    double [] entero = new double[temp.length];
    for(int cont1 = 0; cont1 < temp.length; cont1++){
      entero[cont1] = Double.parseDouble(temp[cont1]);
    }
    return entero;
  }

  private double[][] getXIris(String xFile){
    this.setFileName(xFile);
    int num3 = getLines();
    String [] temp3 = getAllLines(num3);
    String[] a1;
    double[] b1 = new double[4];
    double cp1;
    double [][] tempflotant = new double[80][4];

    for(int x= 0; x < temp3.length; x++){
      for(int y= 0; y < 4; y++){
        a1= temp3[x].split(",");
        for(int z=0; z<4; z++){
          cp1= Double.parseDouble(a1[z]);
          b1[z]= cp1;
        }
        
        tempflotant[x][y]= b1[y];
      }
    }

    return tempflotant;
  }


  private double [] getVector(int f, double[][] bidimensional){
    double[] temp4= new double[4];
    for(int cont2=0; cont2< 4; cont2++){
       temp4[cont2]= bidimensional[f][cont2];
    }
    
    return temp4;
  }












}








