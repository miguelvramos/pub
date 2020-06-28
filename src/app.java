import javax.swing.JOptionPane;
import java.util.Random;

public class app {
	public static void main(String[] args) {
		Lista lista = new Lista();
		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

		boolean flag = true;
		while (flag == true) {
			int escolha = Integer.parseInt(JOptionPane.showInputDialog(
					"Opções: \n1 - Adicionar cliente \n2 - Fechar conta \n3 - Sortear cliente \n4- Sair \n5 - Listar celulares"));
			switch (escolha) {
				case 1:
					long telefoneCliente = Long.parseLong(JOptionPane.showInputDialog(
						null, "Digite o telefone do cliente: "));
					if (lista.buscarNoNumeroTelefone(telefoneCliente) == true && arvoreBinaria.localizar(telefoneCliente) == 1) {
						JOptionPane.showMessageDialog(null, "Esse número já existe.");
					} else {
						No noCliente = new No();
						noCliente.setCliente(new Cliente(telefoneCliente));
						lista.inserirNoFim(noCliente);
						arvoreBinaria.incluir(new NoArvoreBinaria(telefoneCliente));
					}
					break;
				case 2:
					long telefoneClienteRemover = Long.parseLong(JOptionPane.showInputDialog(
						null, "Digite o telefone do cliente para dar baixa."));
					if (lista.removerNo(telefoneClienteRemover)) {
						JOptionPane.showMessageDialog(null, "Cliente removido.");
					} else {
						JOptionPane.showMessageDialog(null, "Número não encontrado.");
					}
					break;
				case 3:
					if (lista.getQuantidade() > 0) {
						Random sortear = new Random();
						No noClienteSorteado = lista.buscarNoEspecifico(sortear.nextInt(lista.getQuantidade()));
						Cliente clienteSorteado = noClienteSorteado.getCliente();
						JOptionPane.showMessageDialog(
								null, "O número sorteado foi " +
										clienteSorteado.getNumeroTelefone());
						lista.removerNo(clienteSorteado.getNumeroTelefone());
					} else {
						JOptionPane.showMessageDialog(null, "A lista está vazia.");
					}
					break;
				case 4:
					flag = false;
					break;
				case 5:
					JOptionPane.showMessageDialog(null, arvoreBinaria.getLista());
					break;
				case 6:
					arvoreBinaria.limparDados();
					lista.limparDados();
					JOptionPane.showMessageDialog(null, "Todos os dados foram deletados.");
					break;
				default:
					JOptionPane.showMessageDialog(null,"Opção Inválida!");
					break;
			}
		}
	}
}
