import javax.swing.JOptionPane;
import java.util.Random;

public class app {
	public static void main(String[] args) {
		Lista lista = new Lista();
		boolean flag = true;

		Cliente cliente1 = new Cliente("Henrique", "3333");
        No novoNo1 = new No();
        novoNo1.setCliente(cliente1);
        lista.inserirNoFim(novoNo1);

        Cliente cliente2 = new Cliente("Miguel", "9999");
        No novoNo2 = new No();
        novoNo2.setCliente(cliente2);
        lista.inserirNoFim(novoNo2);

        Cliente cliente3 = new Cliente("Arthur", "4444");
        No novoNo3 = new No();
        novoNo3.setCliente(cliente3);
        lista.inserirNoFim(novoNo3);
		
		while (flag == true) {

			int escolha = Integer.parseInt(JOptionPane.showInputDialog("Opções: \n 1- Adicionar cliente \n 2- Fechar conta \n 3- Sortear cliente \n 4- Sair \n\n"));

			switch (escolha) {
				case 1:
					String nomeCliente = JOptionPane.showInputDialog(null, "Digite o nome do cliente");
					String telefoneCliente = JOptionPane.showInputDialog(null, "Digite o telefone do cliente");
					No noCliente = new No();
					noCliente.setCliente(new Cliente(nomeCliente, telefoneCliente));
					lista.inserirNoFim(noCliente);
					break;

				case 2:
					String telefoneClienteRemover = JOptionPane.showInputDialog(null, "Digite o telefone do cliente para dar baixa");
					if (lista.removerNo(telefoneClienteRemover)) {
						JOptionPane.showMessageDialog(null, "Cliente removido");
					} else {
						JOptionPane.showMessageDialog(null, "Numero não encontrado");
					}
					break;

				case 3:
					Random sortear = new Random();
					No noClienteSorteado = lista.buscarNoEspecifico(sortear.nextInt(lista.getQuantidade()));
					Cliente clienteSorteado = noClienteSorteado.getCliente();
					JOptionPane.showMessageDialog(null, "Cliente sorteado foi o " + clienteSorteado.getNome() + ", telefone: " + clienteSorteado.getNumeroTelefone());
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
