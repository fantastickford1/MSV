/**
 *
 * @author Karlos
 */
import matriz.*;
import java.lang.Math;

public class HesianaAndKernel {
    public static void main(String[] args) {

      MSV j = new MSV("iris.txt");

      String[] vector = new String[j.size];


      vector = j.getAllLines(j.size);
////////////////////////////////////////////////////////////
      float[][] h = new float[j.size][j.size];
      float[][] hKernel = new float[j.size][j.size];
      float[] xi = new float[5];
      float[] xj = new float[5];
      for (int i=0; i < j.size ; i++ ) {
        for (int g=0; g < j.size ; g++ ) {
          xi = j.convrtAndSpltStrngToFlt(vector[i],",");
          xj = j.convrtAndSpltStrngToFlt(vector[g],",");
          float multXX = j.multVector(xi,xj);
          h[i][g] =  (xi[4]*xj[4])*(multXX);
          hKernel[i][g] =  (xi[4]*xj[4])* (float)Math.pow((multXX + 1),2);
        }
      }
///////////////////////////////////////////////////////////////////
      j.fileWriter("datos.txt", h);
      j.fileWriter("Kernel.txt", hKernel);

    }

}
