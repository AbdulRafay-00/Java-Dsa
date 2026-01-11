interface inti_Face_class {
    void sound();    
}

public class AnonimusClass {
    public static void main(String[] args) {

// normal Anonimus class
        // inti_Face_class inti = new inti_Face_class(){

        //     @Override
        //      public void sound() {
        //         // TODO Auto-generated method stub
        //         System.out.println("poolk");
        //     }

        // };

        // aninimus class with lemda expression

        inti_Face_class inti = () -> System.out.println("pooilki"); 

        inti.sound();
    }
}
