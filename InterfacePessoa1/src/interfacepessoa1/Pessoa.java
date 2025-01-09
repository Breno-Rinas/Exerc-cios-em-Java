
package interfacepessoa1;
public class Pessoa implements cidadao {
   private int numeroVotacoes;

    public Pessoa() {
        this.numeroVotacoes = 0;
    }
   
    public void vota(){
        this.numeroVotacoes += 1;
        System.out.println("Eu já votei " + this.numeroVotacoes + " vezes no ano");
    }
   
}
