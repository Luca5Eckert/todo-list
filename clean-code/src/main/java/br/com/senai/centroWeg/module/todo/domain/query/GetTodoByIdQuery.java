package br.com.senai.centroWeg.module.todo.domain.query;

public record GetTodoByIdQuery(int id) {
    public static  GetTodoByIdQuery of(int id){
        return new GetTodoByIdQuery(id);
    }
}
