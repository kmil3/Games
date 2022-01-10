package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Games implements Serializable {
    String nome, genero, desenvolvedor, ano;
    ArrayList<Games> listajogos = new ArrayList<Games>();


    public Games(String nome, String genero, String desenvolvedor, String ano){
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        sample.Games jogo = (sample.Games) o;
        return Objects.equals(nome, jogo.getNome()) && Objects.equals(genero, jogo.getGenero()) && Objects.equals(desenvolvedor, jogo.getDesenvolvedor()) && Objects.equals(ano, jogo.getAno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, desenvolvedor, ano);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "Nome:'" + nome + '\'' +
                ", Genero:'" + genero + '\'' +
                ", Desenvolvedor:'" + desenvolvedor + '\'' +
                ", Ano:'" + ano + '\'' +
                '}';
    }
}
