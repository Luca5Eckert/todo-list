package br.com.senai.centroWeg.model;

public class Tarefa {

    private int id;
    private String nomeTarefa;
    private StatusTarefa statusTarefa;
    private String descricao;

    public Tarefa(int id, String nomeTarefa, StatusTarefa statusTarefa, String descricao) {
        this.id = id;
        this.nomeTarefa = nomeTarefa;
        this.statusTarefa = statusTarefa;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StatusTarefa getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(StatusTarefa statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public StatusTarefa getStatusTarefas() {
        return statusTarefa;
    }

    public void setStatusTarefas(StatusTarefa statusTarefas) {
        this.statusTarefa = statusTarefas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "nomeTarefa: " + nomeTarefa + " status: " + statusTarefa +
                "\ndescricao: " + descricao;
    }
}
