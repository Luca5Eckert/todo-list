package br.com.senai.centroWeg.service;

import br.com.senai.centroWeg.model.StatusTarefa;
import br.com.senai.centroWeg.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaService {

    public static final List<Tarefa> tarefas = new ArrayList<>();

    public void alterarStatus(Tarefa tarefa, StatusTarefa statusTarefa){
        for (Tarefa tarefaAlterar : tarefas){
            if(tarefaAlterar.getId() == tarefa.getId()){
                tarefaAlterar.setStatusTarefas(statusTarefa);
            }
        }
    }

    public void excluirTarefa(){}

    public void criarTarefa(){}

    public void verTarefas(){
        for(Tarefa tarefa : tarefas){
            System.out.println(tarefa);
        }
    }

}
