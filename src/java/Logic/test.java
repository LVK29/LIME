/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author sumit
 */
public class test {
    public static void main(String[] args) {
         File f1=new File(path_info.path+"chunks/");
        File f1a[]=f1.listFiles();
        System.out.println("f1 size "+f1a.length);
        
        
        File f2=new File(path_info.path+"chunks/");
        File f2a[]=f2.listFiles();
        System.out.println("f2 size "+f2a.length);
        ArrayList al=new ArrayList();
        
        for(int i=0;i<f1a.length;i++)
        {
            System.out.println(">"+f1a[i].getName());
     //   al.add(f1a[i].getAbsoluteFile());
        al.add(path_info.path+"chunks/"+f1a[i].getName());
        }
        for(int i=0;i<f2a.length;i++)
        {
            System.out.println(">"+f2a[i].getName());
      //  al.add(f2a[i].getAbsoluteFile());
        al.add(path_info.path+"chunks/"+f2a[i].getName());
        }
        
        for(int i=0;i<al.size();i++)
        {
            System.out.println(">>"+al.get(i));
        }
        System.out.println("__________________________________");
        
         Collections.shuffle(al);
         
           for(int i=0;i<al.size();i++)
        {
            System.out.println(">>"+al.get(i));
        }
         
         
         Split_Files sf=new Split_Files();
         sf.mergeParts(al, path_info.path+"final.mp3");
         
    }
}
