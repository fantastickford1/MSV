package matriz;
import java.io.*;
import java.lang.Math;

public class TestSH extends AnalizaFile{

  private double[] alpha; //alfa obtenida en matlab
  private double[][] xs; //x obtenida de los datos de prueba
  private double[] y; //Y de los datos de prueba de tamaño 20
  private double[][] x; //x obtenida de los datos de iris
  private double[] yPrueba;
  private final int ns = 3; //tamaño de datos de iris (80)
  private final int ms = 20; //tamaño de datos de prueba iris(20)
  private double sum; //sumatoria de la funcion
  private double[] result = new double[20];//almacenamieto de total de sumarias repetida 20 veces


  public TestSH(){
    this.alpha = new double[0];
    this.xs = new double[0][0];
    this.y = new double[0];
    this.x = new double[0][0];
    this.yPrueba= new double[0];
    this.sum = 0.0;
  }

  public TestSH(String alphaFile, String xsFile, String yFile, String xFile, String yPruebaFile){
    super();
    this.alpha = getAlpha(alphaFile);
    this.xs = getXs(xsFile);
    this.y = getYIris(yFile);
    this.x = getXIris(xFile);
    this.yPrueba= getYIris(yPruebaFile);
    this.sum = 0.0;
  }

  public double[] DecisionFunction(){
    MSV mult = new MSV();

    double[][] trnX = new double[3][4];
    double[] trnY = new double[3];
    double[] alphas = new double[3];

      double[] er = getVector(23,x);
      double[] at = getVector(24,x);
      double[] yu = getVector(47,x);

      for (int vlm = 0 ; vlm < 4 ; vlm++ ) {
        trnX[0][vlm] = er[vlm];
        trnX[1][vlm] = at[vlm];
        trnX[2][vlm] = yu[vlm];
      }
      for (int cs = 0; cs < 3 ;cs++ ) {
        for (int kl = 0; kl < 4 ; kl++ ) {
          System.out.print(trnX[cs][kl] + "\t");
        }
        System.out.println();
      }
      System.out.println();

      trnY[0] = getPosition(23,y);
      trnY[1] = getPosition(24,y);
      trnY[2] = getPosition(47,y);

      alphas[0] = getPosition(23,alpha);
      alphas[1] = getPosition(24,alpha);
      alphas[2] = getPosition(47,alpha);

    for(int i=0; i< ms; i++){
      for(int j=0; j< ns; j++){
        double hp = mult.multVectorDou(getVector(j,trnX),getVector(i,xs));
        sum= sum+ alphas[j]*trnY[j]*(hp);
      }
      result[i]=sum;
      sum=0;
    }
    return result;
  }

  public void matrizConfusion(double[] suma){
    int a=0,b=0,c=0,d=0;

    for(int i=0;i<20;i++){
      System.out.println(suma[i]);
      if(suma[i]>=0){
        if(yPrueba[i] == 1){
          a++;
        }else{
          c++;
        }
      }else{
        if(yPrueba[i] == 1){
          b++;
        }else{
          d++;
        }
      }
    }
    System.out.println("El valor de a es : "+ a);
    System.out.println("El valor de b es : "+ b);
    System.out.println("El valor de c es : "+ c);
    System.out.println("El valor de d es : "+ d);
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

  private double[] getYIris(String ysFile){
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

  private double getPosition(int f, double[] bidimensional){
    double temp4;
    temp4 = bidimensional[f];

    return temp4;
  }












}
