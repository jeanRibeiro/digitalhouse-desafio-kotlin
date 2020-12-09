package br.com.digitalHouseDesafioKotlin

class Curso(
        var codigo: Int,
        var nome :String,
        var qtdVagaDisponivel: Int,
        var qtdMaximaAlunos: Int
        ) {

    //atributos
    var professorTitular: ProfessorTitular? = null;
    var professorAjunto: ProfessorAdjunto? = null;
    var listaAlunosMatriculados = mutableListOf<Aluno>();

    constructor(nome: String, codigoCurso: Int, qtdMaximaAlunos: Int, qtdVagaDisponivel:Int):this(codigoCurso, nome, qtdVagaDisponivel, qtdMaximaAlunos){
        this.nome = nome;
        this.codigo = codigoCurso;
        this.qtdMaximaAlunos = qtdMaximaAlunos;
    }

    //funcoes
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Curso

        if (codigo != other.codigo) return false

        return true
    }
    override fun hashCode(): Int {
        return codigo
    }
    fun adicionarUmAluno(aluno:Aluno): Boolean{
        if(qtdVagaDisponivel > 0){
            //antes de adicionar verifico se o aluno já está na lista
            if(listaAlunosMatriculados.contains(aluno)){
                println("Não foi possível adicionar o aluno \"${aluno.nome}\"! O mesmo já foi incluindo.");
                return false;
            }
            listaAlunosMatriculados.add(aluno);
            return true;
        }
        println("Não foi possível adicionar o aluno \"${aluno.nome}\"! Não há vaga disponível. ");
        return false;
    }
    fun excluirAluno(aluno:Aluno){
        var posicaoAluno = listaAlunosMatriculados.indexOf(aluno);

        if(posicaoAluno >= 0){
            listaAlunosMatriculados.removeAt(posicaoAluno);
            println("Aluno removido com sucesso!");
            return;
        }

        println("Não foi possível remover o aluno! Registro não encontrado.");
    }

}