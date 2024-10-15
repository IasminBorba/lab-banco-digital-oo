public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente, TipoConta.CONTA_CORRENTE);
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.emitirExtrato();
    }
}
