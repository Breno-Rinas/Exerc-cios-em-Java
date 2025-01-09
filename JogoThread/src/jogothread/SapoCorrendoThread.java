package jogothread;

public class SapoCorrendoThread extends Thread {

    private String nome;
    private int distanciaCorrida = 0;
    private int distanciaTotalCorrida;
    private int pulo = 0;
    private int pulos = 0;
    static int colocacao = 0;
    final static int PULO_MAXIMO = 50;

    public SapoCorrendoThread(String nome, int distanciaTotalCorrida) {
        super(nome);
        this.distanciaTotalCorrida = distanciaTotalCorrida;
        this.nome = nome;
    }

    public void sapoImprimindoSituacao() {
        System.out.println("O " + nome + " pulou " + pulo + "cm e já percorreu "
                + distanciaCorrida + "cm");
    }

    public void sapoPulando() {
        pulos++;
        pulo = (int) (Math.random() * PULO_MAXIMO);
        distanciaCorrida += pulo;
        if (distanciaCorrida > distanciaTotalCorrida) {
            distanciaCorrida = distanciaTotalCorrida;
            
        }
    }

    public void sapoDescansando() {
        yield();
    }

    public void colocacaoSapo() {
        colocacao++;
        System.out.println(nome + " foi o " + colocacao
                + "º colocado com " + pulos + " pulos");
    }

    public void run() {
        while (distanciaCorrida < distanciaTotalCorrida) {
            sapoPulando();
            sapoImprimindoSituacao();
            sapoDescansando();
        }
        colocacaoSapo();
    }
}
