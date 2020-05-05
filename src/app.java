import javax.swing.JOptionPane;
import java.util.Random;

public class app {
	public static void main(String[] args) {
		Lista lista = new Lista();
		boolean flag = true;
		while (flag == true) {
			int escolha = Integer.parseInt(JOptionPane.showInputDialog(
					"Opções: \n 1- Adicionar cliente \n 2- Fechar conta \n 3- Sortear cliente \n 4- Sair \n"));
			switch (escolha) {
				case 1:
					String telefoneCliente = JOptionPane.showInputDialog(
							null, "Digite o telefone do cliente: ");
					No noCliente = new No();
					noCliente.setCliente(new Cliente(telefoneCliente));
					lista.inserirNoFim(noCliente);
					break;
				case 2:
					String telefoneClienteRemover = JOptionPane.showInputDialog(
							null, "Digite o telefone do cliente para dar baixa.");
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
				default:
					JOptionPane.showMessageDialog(null,"Opção Inválida!");
					break;
			}
		}
	}
}
