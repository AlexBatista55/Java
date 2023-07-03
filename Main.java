
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Person> pessoas = new ArrayList<Person>();
        boolean exit = true;
        while (exit){
            Scanner scanner = new Scanner(System.in);

            System.out.println("-----Bem Vindo ao cadastro de Pessoas!-----");
            System.out.println("Seleciona a opção");
            System.out.println("1 - Cadastrar uma pessoa");
            System.out.println("2 - Buscar uma pessoa cadastrada");
            System.out.println("3 - Excluir uma pessoa cadastrada ");
            System.out.println("4 - Sair do sistema ");
            int option = scanner.nextInt();
            //  aqui tentei colocar uma validação, caso o usuario nao digitasse um numero inteiro, desse alguma mensagem
            // encontrei alguns metodos que não deram certo:
            // *(if (!(option instanceof Integer)))*
            // *(if (option.getClass() != int.class && option.getClass() != Integer.class)))
            switch (option){

                case 1 :
                    addPessoas(pessoas);
                    break;
                case 2 :
                    System.out.println("Qual o nome que deseja buscar?");
                    String nameToFind = scanner.next();
                    findPessoa(pessoas, nameToFind);
                    break;
                case 3 :
                    System.out.println("Qual o nome que deseja remover?");
                    String nameToRemove = scanner.next();
                    removePessoa(pessoas, nameToRemove);
                    break;
                case 4 :
                    exit = false;
                    break;
                default:
                    System.out.println("Opção inválida!");

            }
        }
    }

    private static void addPessoas(List<Person> pessoas){
        Person pessoa = new Person();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome completo da pessoa");
        pessoa.name = scanner.nextLine();
        System.out.println("Digite a Data de Nascimento da pessoa");
        pessoa.dtNas = scanner.nextLine();
        System.out.println("Digite o endereço da pessoa");
        pessoa.endereco = scanner.nextLine();
        pessoas.add(pessoa);
        System.out.println("Obrigado por digitar o nome completo do " + pessoa.name);
    }

    private static void findPessoa(List<Person> pessoas, String pessoaName) {

        for(int count = 0; count < pessoas.size(); count++){
            Person pessoa = pessoas.get(count);
            if(pessoa.name.equals(pessoaName)){
                System.out.println("Encontrei o " + pessoaName + "! Ele nasceu em " + pessoa.dtNas + " e mora no endereço:"
                + pessoa.endereco + "!");
            } else {
                System.out.println("A pessoa " + pessoaName + " não possui cadastro!"); // Essa validação tbm não deu certo
            }
        }
    }
    private static void removePessoa(List<Person> pessoas, String pessoaName) {

        for(int count = 0; count < pessoas.size(); count++){
            Person pessoa = pessoas.remove(count);
            if(pessoa.name.equals(pessoaName)){
                System.out.println("Pessoa " + pessoaName + ", removida com sucesso!");
            }
            if(pessoa.name!=pessoaName){
                System.out.println("A pessoa " + pessoaName + " não possui cadastro!"); //Tentei colocar algumas
                // validações para dar uma mensagem caso o nome não existissem, mas não deu certo. Se puder dar um feed back
                // as pesquisas na internet também não surtiu efeito.
                //
            }

        }
    }
}