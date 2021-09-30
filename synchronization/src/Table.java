public class Table {

      public void print(int n){
        for(int i=1;i<=5;i++){
            System.out.println("5 er namata " +n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }

    }
//    synchronized  public void print(int n){
//        for(int i=1;i<=5;i++){
//            System.out.println("5 er namata " +n*i);
//            try{
//                Thread.sleep(400);
//            }catch(Exception e){System.out.println(e);}
//        }
//
//    }
}
