package Util;

import beans.Competitor;

import java.io.*;

public class FileUtil {
       public static void writeObjectToFile(Object object,String name){
           FileOutputStream fout= null;
           ObjectOutputStream oos =null;

           try{
               fout= new FileOutputStream(name);
               oos=new ObjectOutputStream(fout);
               oos.writeObject(object);
           } catch(Exception ex){
               ex.printStackTrace();
           }finally{
               if(fout!=null){
                   try{
                       fout.close();
                   }catch (IOException e){
                       e.printStackTrace();
                   }
               }
           }


       }



       public static Object readObjectFromFile(String name)throws Exception{

           ObjectInputStream in = new ObjectInputStream(new FileInputStream(name));
                Object obj = in.readObject();

               return obj;
           }


           public static void writeObjectByObject(Object[]objects,String fileName,boolean append) throws IOException {
           FileOutputStream fos =new FileOutputStream(fileName,append);
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               for(int i=0;i<objects.length;i++){
                Object c= objects[i];
                oos.writeObject(c);
            }





           }

   public static  Object [] readObjectByObject(int count,String fileName) throws Exception{
       FileInputStream fis= new FileInputStream("competitors.ser");
       ObjectInputStream input =new ObjectInputStream(fis);
       Object [] objects =new Object[count];
       for (int i=0;i<2;i++){
           Object obj =input.readObject();
           objects[i]=obj;
       }
          return objects;
   }




       }


