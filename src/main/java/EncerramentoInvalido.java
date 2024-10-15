public class EncerramentoInvalido extends Exception {
    public EncerramentoInvalido(Conta conta) {
        super(String.format("A conta ainda contém saldo no valor de R$%1$,.2f. Por favor, saque todo o valor do saldo antes de encerrar a conta.", conta.saldo));
    }
}
