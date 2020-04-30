import javax.swing.JOptionPane;

public class app {

	public static void main(String[] args) {
		
		boolean flag = true;
		
		while (flag == true) {

			int escolha = Integer.parseInt(JOptionPane.showInputDialog("Opções: \n 1- Adicionar cliente \n 2- Fechar conta \n 3- Sortear cliente \n 4- Sair \n\n"));

			switch (escolha) {
				case 1:
					
					break;

				case 2:
					
					break;

				case 3:
					
					break;

				case 4:
					
					break;
			
				default:
					JOptionPane.showMessageDialog(null,"Opção Inválida!");
					break;
			}
		}
	}
}
