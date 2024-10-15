import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Banco {
	private String nome;
	private List<Conta> contas = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public List<Cliente> getClientes() {
		List<Cliente> clientes = new ArrayList<>();
		for (Conta conta : contas)
			clientes.add(conta.cliente);

		return new ArrayList<>(new LinkedHashSet<>(clientes));
	}

	public void abrirConta(Conta.TipoConta tipoConta, Cliente cliente) {
		if (tipoConta == Conta.TipoConta.CONTA_CORRENTE)
			contas.add(new ContaCorrente(cliente));
		else
			contas.add(new ContaPoupanca(cliente));
	}

	public void encerrarConta(Cliente cliente, Conta.TipoConta tipoConta) throws EncerramentoInvalido {
		Conta contaCliente = encontrarConta(cliente, tipoConta);
		if (contaCliente.saldo == 0)
			contas.removeIf(conta -> conta.equals(contaCliente));
		else
			throw new EncerramentoInvalido(contaCliente);
	}

	public Conta encontrarConta(Cliente cliente, Conta.TipoConta tipoConta) {
		return contas.stream()
				.filter(conta -> conta.cliente == cliente && conta.tipoConta == tipoConta)
				.findFirst()
				.orElse(null);
	}
}
