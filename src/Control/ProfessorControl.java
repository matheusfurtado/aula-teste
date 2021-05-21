package Control;

import Model.Professor;
import java.util.ArrayList;


public class ProfessorControl {
    private final Professor control;

    public ProfessorControl() {
        this.control = new Professor();
    }

    // Create 
    public boolean Cadastrar(String disciplina, Double salario, String especializacao, String nome, int idade) {

        // ProfessorControl recebe os dados da VIEW, cria um objeto COMPLETO e manda este objeto para professor para inserir em MinhaLista(DAO)
        // Professor CONTROL NAO DEVE ACESSAR DAO DIRETAMENTE. LA em professor deve ter uma funcao que acessa DAO para inserir. InsertProfessorBD()
        
        int id = control.maiorID() + 1;
        Professor objeto = new Professor(disciplina, salario, especializacao, id, nome, idade);
        if(control.InsertProfessorBD(objeto)){
            return true;
        }else{
            return false;
        }
    }

    // Update
    public boolean Editar(String disciplina, Double salario, String especializacao, int id, String nome, int idade) {
        Professor objeto = new Professor(disciplina, salario, especializacao, id, nome, idade);
        if(control.UpdateProfessorBD(id, objeto)){
            return true;
        }else{
            return false;
        }
    }

    // Delete
    public boolean Apagar(int id) {
        if(control.DeleteProfessorBD(id)){
            return true;
        }else{
            return false;
        }
    }

    // Read
    public Professor LoadAluno(int id) {
        // procurar o professor com este id e retornar um objeto com TODOS OS DADOS.
        return control.carregaProfessor(id);
    }

    // Read
    public ArrayList getMinhaLista() {
        return control.getMinhaLista();
    }
    
    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {
        
        ArrayList<Professor> minhalista = control.getMinhaLista();
        int tamanho = minhalista.size();
        
        String MatrizProfessor[][] = new String[tamanho][6];
        for (int i = 0; i < tamanho; i++) {
            MatrizProfessor[i][0] = minhalista.get(i).getId() + "";
            MatrizProfessor[i][1] = minhalista.get(i).getNome();
            MatrizProfessor[i][2] = minhalista.get(i).getIdade() + "";
            MatrizProfessor[i][3] = minhalista.get(i).getDisciplina();
            MatrizProfessor[i][4] = minhalista.get(i).getSalario()+ "";
            MatrizProfessor[i][5] = minhalista.get(i).getEspecializacao()+ "";
        }        
        
        return MatrizProfessor;        
    }
}
