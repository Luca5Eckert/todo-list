package br.com.senai.centroWeg;

import br.com.senai.centroWeg.model.StatusTarefa;
import br.com.senai.centroWeg.model.Tarefa;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    public static final List<Tarefa> tarefas = new ArrayList<>();
    public static int id = 0;

    public static void main(String[] args) {


        while(!Iniciar()){
        }
        System.out.println("Obrigado por usar nosso sistema!");

    }

    public static boolean Iniciar(){

        System.out.print("""
                ----------------------------------------
                |           Lista de Tarefas           |
                ----------------------------------------
                | 1 - Criar Tarefa                     |
                | 2 - Atualizar Status Tarefa          |
                | 3 - Excluir Tarefa                   |
                | 4 - Listar Tarefas                   |
                |                                      |
                | 0 - sair                             |
                ----------------------------------------
                  Escolha sua opção: """);
        int escolha = input.nextInt();
        input.nextLine();

        switch(escolha){
            case 1 -> {
                id ++;

                System.out.println("Digite o nome da tarefa:");

                String nome = input.nextLine();

                System.out.println("Digite a descrição da tarefa:");
                String descricao = input.nextLine();

                criarTarefa(new Tarefa(id,nome,StatusTarefa.PENDENTE,descricao));

                System.out.println("Tarefa criada com Sucesso");
            }
            case 2 -> {
                boolean opcaoCorreta = false;

                System.out.println("Digite o Id da tarefa que deseja mudar o status: ");
                int idNovo = input.nextInt();

                while(!opcaoCorreta){
                    System.out.println("""
                ----------------------------------------
                |   Escolha o novo status da Tarefas   |
                ----------------------------------------
                | 1 - Pendente                         |
                | 2 - Em Andamento                     |
                | 3 - Concluida                        |
                |                                      |
                | 0 - sair                             |
                ----------------------------------------
                  Escolha sua opção:
                """);
                    int novoStatus= input.nextInt();

                    switch (novoStatus){
                        case 1 -> {
                            alterarStatus(idNovo,StatusTarefa.PENDENTE);
                            opcaoCorreta = true;
                            System.out.println("Status alterado com sucesso");
                        }
                        case 2 -> {
                            alterarStatus(idNovo,StatusTarefa.EM_ANDAMENTO);
                            opcaoCorreta = true;
                            System.out.println("Status alterado com sucesso");
                        }
                        case 3 -> {
                            alterarStatus(idNovo,StatusTarefa.CONCLUIDA);
                            opcaoCorreta = true;
                            System.out.println("Status alterado com sucesso");
                        }
                        case 0 -> {
                            opcaoCorreta = true;
                            System.out.println("nenhum status foi alterado, saindo");
                        }
                        default -> {
                            System.out.println("Opção não reconhecida");
                        }

                    }
                }
            }
            case 3 -> {
                System.out.println("Digite o ID da tarefa que deseja excluir");
                int idDeExclusao = input.nextInt();
                excluirTarefa(idDeExclusao-1);
                System.out.println("Tarefa excluida com sucesso");
                input.nextLine();
            }
            case 4 -> {
                verTarefas();
            }
            case 0 -> {
                return true;
            }
            default -> {
                System.out.println("Opção não reconhecida");
            }
        }
        return false;
    }


    public static void alterarStatus(int idTarefa, StatusTarefa statusTarefa){
        for (Tarefa tarefaAlterar : tarefas){
            if(tarefaAlterar.getId() == idTarefa){
                tarefaAlterar.setStatusTarefas(statusTarefa);
            }
        }
    }

    public static void excluirTarefa(int id){
        tarefas.remove(id);
    }

    public static void criarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public static void verTarefas(){
        for(Tarefa tarefa : tarefas){
            System.out.println(tarefa);
        }
    }



}
