package jogothread;

public class JogoThread {

    private final static int NUM_SAPOS = 5;
    private final static int DISTANCIA = 500;

    public static void main(String[] args) {

        for (int i = 1; i <= NUM_SAPOS; i++) {
            new SapoCorrendoThread("SAPO_" + i, DISTANCIA).start();
        }

    }
}
