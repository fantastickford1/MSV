/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz;

/**
 *
 * @author Karlos
 */
public class Matrix extends AnalizaFile{

    public int size;

    public Matrix(){
        this.size = 0;
    }

    public Matrix(String txt){
    super(txt);
    this.size = super.getLines();
    }


}
