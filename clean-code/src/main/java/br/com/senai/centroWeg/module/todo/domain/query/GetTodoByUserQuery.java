package br.com.senai.centroWeg.module.todo.domain.query;

public record GetTodoByUserQuery(int userId) {
    public static GetTodoByUserQuery of(int userId){
        return new GetTodoByUserQuery(userId);
    }
}
