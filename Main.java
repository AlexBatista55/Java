
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
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
            System.out.println("4 - Editar o nome de uma pessoa cadastrada ");
            System.out.println("5 - Idade das pessoas cadastradas");
            System.out.println("6 - Sexo pessoas cadastradas");
            System.out.println("7 - Sair do sistema ");
            int option = scanner.nextInt();
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
                    System.out.println("Qual o nome que deseja editar?");
                    String nameToEdit = scanner.next();
                    System.out.println("Qual é o novo nome?");
                    String newName = scanner.next();
                    editPessoa(pessoas, nameToEdit,newName);
                    break;
                case 5 :
                    LocalDate dataAtual = LocalDate.now();
                    int anoAtual = dataAtual.getYear();
                    int mesAtual = dataAtual.getMonthValue();
                    idadePessoa(pessoas, anoAtual,mesAtual);
                    break;
                case 6 :
                    sexoPessoa(pessoas);
                    break;
                case 7 :
                    exit = false;
                    break;
                default:
                    System.out.println("Opção inválida!");

            }
        }
    }

    public static void addPessoas(List<Person> pessoas){
        Person pessoa = new Person();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome completo da pessoa");
        pessoa.name = scanner.nextLine();
        System.out.println("Digite o sexo da pessoa");
        pessoa.sexo = scanner.nextLine();
        System.out.println("Digite a Data de Nascimento da pessoa. Ex(01/01/2001)");
        pessoa.dtNas = scanner.nextLine();
        System.out.println("Digite o endereço da pessoa");
        pessoa.endereco = scanner.nextLine();
        pessoas.add(pessoa);
        System.out.println("Obrigado por digitar o nome completo do " + pessoa.name);
    }

    public static void findPessoa(List<Person> pessoas, String pessoaName) {
        String nameFound="";
        String dataFound="";
        String addressFound="";
        for(int count = 0; count < pessoas.size(); count++) {
            Person pessoa = pessoas.get(count);
            if (pessoa.name.equals(pessoaName)) {
                nameFound=pessoaName;
                dataFound=pessoa.dtNas;
                addressFound=pessoa.endereco;
            }
        }
        if (nameFound!="") {
            System.out.println("Encontrei o " + nameFound + "! Ele nasceu em " + dataFound + " e mora no endereço:"
                    + addressFound + "!");
        } else {
            System.out.println("A pessoa " + nameFound + " não possui cadastro!"); // Essa validação tbm não deu certo
        }
    }
    private static void removePessoa(List<Person> pessoas, String pessoaName) {
        String nameFound="";
        for(int count = 0; count < pessoas.size(); count++) {
            Person pessoa = pessoas.remove(count);
            if (pessoa.name.equals(pessoaName)) {
                nameFound = pessoaName;
                ;
            }
        }
        if(nameFound!=""){
            System.out.println("Pessoa " + pessoaName + ", removida com sucesso!");
        }else {
            System.out.println("A pessoa " + pessoaName + " não possui cadastro!");
        }
    }
    private static void editPessoa(List<Person> pessoas, String pessoaName,String newName){
        String nameFound="";
        for(int count = 0; count < pessoas.size(); count++){
            Person pessoa = pessoas.get(count);
            String nome = pessoa.name;
            if(nome.equals(pessoaName)){
                nameFound= newName;
                pessoa.name = newName;
                System.out.println("Pessoa " + pessoaName + ", editada com sucesso!");
            }
        }
        if(nameFound!=""){
            System.out.println("Pessoa " + pessoaName + ", editada para "+ newName + " com sucesso!");
        }else {
            System.out.println("Pessoa " + pessoaName + ",não encontrada!");
        }
    }
    private static void idadePessoa(List<Person> pessoas, Integer anoAtual, Integer mesAtual){
        String nameFound="";
        for(int count = 0; count < pessoas.size(); count++) {
            Person pessoa = pessoas.get(count);
            String[] data = pessoa.dtNas.split("/");
            String dia = data[0];
            String mes = data[1];
            String ano = data[2];
            int month = Integer.parseInt(mes);
            int year = Integer.parseInt(ano);
            int age = anoAtual - year;
            if(mesAtual<month){
                pessoa.idade=age-1;
                System.out.println("Pessoa " + pessoa.name + ", possui "+ pessoa.idade + " anos!");
            }
            else{
                pessoa.idade=age;
                System.out.println("Pessoa " + pessoa.name + ", possui "+ pessoa.idade + " anos!");
            }
        }
    }
    public static void sexoPessoa(List<Person> pessoas) {
        int countM = 0;
        int countF = 0;
        for(int count = 0; count < pessoas.size(); count++){
            if(pessoas.get(count).sexo.equals("Masculino")){
                countM++;
            }else{
                countF++;
            }
        }
        System.out.println("O cadastro possui: " + countM + " do sexo masculino e "+countF+" do sexo feminino!" );
    }
}