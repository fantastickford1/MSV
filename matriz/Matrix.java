/*
 * Subclase de AnalizaFile
 * --
 *
 */

package matriz;
import java.io.*;
/**
 *
 * @author Karlos
 */
public class Matrix extends AnalizaFile{

    public int size;
//constructor por default
    public Matrix(){
        super();
        this.size = 0;
    }
//constructor que recibe un nombre del archivo y usa el constructor de su SuperClase
    public Matrix(String txt){
    super(txt);
    this.size = this.getLines();
    }
//metodo para multiplicar vectores
    public float multVector(float[] firtVextor, float[] secondVextor){
      float sum = 0;
      if(firtVextor.length == secondVextor.length){
        int tm = firtVextor.length;
        for (int aux = 0;aux < (tm - 1) ; aux ++ ) {
          float mult = firtVextor[aux] * secondVextor[aux];
          sum = sum + mult;
        }
      }else return 0;
      return sum;
    }
//metodo para convertir un string a flotante con split
    public float[] convrtAndSpltStrngToFlt(String stringto, String spl){
      String[] x = stringto.split(spl);
      float[] v = new float[x.length];
      for (int i=0 ; i < x.length ; i++ ) {
        float number = Float.parseFloat(x[i]);
        v[i] = number;
      }
      return v;
    }

//metodo para escribir o crear un txt (arreglar)
public void fileWriter(String arch_name, float[][] arrayfloat){
    File new_archivo = new File(arch_name);
    try {
      FileWriter fw = new FileWriter(new_archivo);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);
      for (int conti = 0; conti < arrayfloat.length ; conti++ ){
        for (int contj = 0; contj < arrayfloat.length ; contj++ ) {
          if(contj == 0){
            pw.printf("%.2f", arrayfloat[conti][contj]);
          }else{
            pw.print(",");
            pw.printf("%.2f", arrayfloat[conti][contj]);
          }
        }
        pw.println(" ");
      }

      pw.close();
      bw.close();

    }catch(IOException e){
      System.out.println("Error al crear el archivo");
    }
  }

}
