package com.example.games;

public class Games {
    String nome, genero, desenvolvedor;
    int ano;

    public Games(String nome, String genero, String desenvolvedor, int ano){
        this.nome = nome;
        this.genero = genero;
        this.desenvolvedor = desenvolvedor;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
