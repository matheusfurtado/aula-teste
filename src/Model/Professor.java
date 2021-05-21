package Model;

import DAO.ProfessorDAO;
import java.util.*;

public class Professor extends Pessoa {
    
    private String disciplina;
    private Double salario;
    private String especializacao;

    public Professor() {
    }

    public Professor(String disciplina, Double salario, String especializacao) {
        this.disciplina = disciplina;
        this.salario = salario;
        this.especializacao = especializacao;
    }

    public Professor(String disciplina, Double salario, String especializacao, int id, String nome, int idade) {
        super(id, nome, idade);
        this.disciplina = disciplina;
        this.salario = salario;
        this.especializacao = especializacao;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
    
     @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Idade: " + this.getIdade()
                + "\n Disciplina: " + this.getDisciplina()
                + "\n Salario:" + this.getSalario()
                + "\n Especializacao:" + this.getEspecializacao()
                + "\n -----------";
    }
    // Retorna lista Professor
     public ArrayList getMinhaLista() {
        return ProfessorDAO.MinhaLista;
    }

    // Cadastra novo professor
    public boolean InsertProfessorBD(Professor objeto) {
        ProfessorDAO.MinhaLista.add(objeto);
        return true;

    }

    // Deleta um professor especifico pelo seu campo ID
    public boolean DeleteProfessorBD(int id) {
        int indice = this.procuraIndice(id);
        ProfessorDAO.MinhaLista.remove(indice);
        return true;
    }

    // Edita um professor especifico pelo seu campo ID
    public boolean UpdateProfessorBD(int id, Professor objeto) {
        int indice = this.procuraIndice(id);
        ProfessorDAO.MinhaLista.set(indice, objeto);
        return true;
    }

    // procura o INDICE de objeto da MinhaLista que contem o ID enviado.
    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < ProfessorDAO.MinhaLista.size(); i++) {
            if (ProfessorDAO.MinhaLista.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

    // carrega dados de um professor especifico pelo seu ID
    public Professor carregaProfessor(int id) {
        int indice = this.procuraIndice(id);
        return ProfessorDAO.MinhaLista.get(indice);
    }
    
      // retorna o maior ID da nossa base de dados
    public int maiorID(){
        return ProfessorDAO.maiorID();
    }   
}
