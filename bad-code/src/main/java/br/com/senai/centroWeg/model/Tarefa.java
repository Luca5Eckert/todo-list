package br.com.senai.centroWeg.model;

public class Tarefa {

    private String nomeTarefa;
    private StatusTarefa statusTarefas;
    private String descricao;

    public Tarefa(String nomeTarefa, StatusTarefa statusTarefas, String descricao) {
        this.nomeTarefa = nomeTarefa;
        this.statusTarefas = statusTarefas;
        this.descricao = descricao;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public StatusTarefa getStatusTarefas() {
        return statusTarefas;
    }

    public void setStatusTarefas(StatusTarefa statusTarefas) {
        this.statusTarefas = statusTarefas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
