package br.com.digitalHouseDesafioKotlin

class DigitalHouseManager() {

    var listaAlunos = mutableListOf<Aluno>();
    var listaProfessores = mutableListOf<Professor>();
    var listaCursos = mutableListOf<Curso>()
    var listaMatriculas = mutableListOf<Matricula>()

    //funcoes
    fun registrarCurso(
            nome:String,
            codigo:Int,
            quantidadeMaximaDeAlunos:Int,
            quantidadeVagasDisponiveis: Int
        ):Curso?{

        var curso = Curso(nome, codigo, quantidadeMaximaDeAlunos, quantidadeVagasDisponiveis);

        if(listaCursos.contains(curso)){
            println("Não foi possível incluir o curso! O mesmo já foi incluído.");
            return null;
        }

        listaCursos.add(curso);
        return curso;
    }
    fun excluirCurso(codigo:Int){

        var indice = -1;
        for(i in 0..listaCursos.size){
            if(listaCursos.get(i).codigo == codigo){
                indice = i;
                break;
            }
        }

        if(indice >= 0){
            listaCursos.removeAt(indice);
            println("Curso removido com sucesso!");
            return;
        }

        println("Não foi possível remover o curso! Registro não encontrado.");
    }
    fun registrarProfessorAdjunto(
            nome:String,
            sobrenome:String,
            codigoProfessor:Int,
            quantidadeDeHorasMonitoria:Int
        ): ProfessorAdjunto?{

        var professorAjunto = ProfessorAdjunto(quantidadeDeHorasMonitoria, codigoProfessor, nome, sobrenome);

        if(listaProfessores.contains(professorAjunto)){
            println("Não foi possível incluir o professor adjunto! Registro já incluído.")
            return null;
        }

        listaProfessores.add(professorAjunto);
        println("Professor adjunto incluído com sucesso!")
        return professorAjunto;
    }
    fun registrarProfessorTitular(
            nome:String,
            sobrenome:String,
            codigoProfessor:Int,
            especialidade:String
        ): ProfessorTitular? {

        var professorTitular = ProfessorTitular(especialidade, codigoProfessor, nome, sobrenome);

        if(listaProfessores.contains(professorTitular)){
            println("Não foi possível incluir o professor titular! Registro já incluído.");
            return null;
        }

        listaProfessores.add(professorTitular);
        println("Professor titular incluído com sucesso!");
        return professorTitular;
    }
    fun excluirProfessor(codigoProfessor:Int){

        var indice = -1;

        for (i in 0 .. listaProfessores.size){
            if(listaProfessores.get(i).codigo == codigoProfessor){
                indice = i;
                break;
            }
        }

        if(indice >= 0){
            listaProfessores.removeAt(indice);
            println("Professor excluído com sucesso!");
            return;
        }

        println("Não foi possível excluir os professor! Registro não encontrado.")
    }
    fun matricularAluno(
            nome:String,
            sobrenome:String,
            codigoAluno:Int
        ){

        var indice = -1;

        //Pesquisando aluno
        for(i in 0 .. listaAlunos.size){
            if(listaAlunos.get(i).codigo == codigoAluno){
                indice = i;
                break;
            }
        }

        if(indice >= 0){
            println("Não é possível registrar o aluno! Registro já incluído.")
            return;
        }

        var aluno = Aluno(codigoAluno, nome, sobrenome);
        listaAlunos.add(aluno);
        println("Aluno incluído com sucesso!");
    }
    fun matricularAluno(
            codigoAluno:Int,
            codigoCurso:Int
        ){

        //Pesquisando o curso
        var curso : Curso? = null;
        if(listaCursos.size > 0){
            for(i in 0 .. listaCursos.size-1){
                if(listaCursos.get(i).codigo == codigoCurso){
                    curso = listaCursos.get(i);
                }
            }
        }
        if(listaCursos == null){
            println("Não foi possível matricular o aluno! Curso não encontrado.");
            return;
        }

        //Pesquisando o aluno
        var aluno : Aluno? = null;
        if(listaAlunos.size > 0){
            for(i in 0 .. listaAlunos.size){
                if(listaAlunos.get(i).codigo == codigoCurso){
                    aluno = listaAlunos.get(i);
                }
            }
        }
        if(listaAlunos == null){
            println("Não foi possível matricular o aluno! Aluno não encontrado.");
            return;
        }

        var codigoGenerator = retornaCodigoGeneratorMatricula();
        var matricula = Matricula(aluno, curso, codigoGenerator);
        listaMatriculas.add(matricula);
    }
    fun alocarProfessores(
            codigoCurso:Int,
            codigoProfessorTitular:Int,
            codigoProfessorAdjunto:Int
        ){

        //buscando professor titular
        var professorTitular : ProfessorTitular? = null;
        for(professor in listaProfessores){
            if(professor.codigo == codigoProfessorTitular && professor is ProfessorTitular){
                professorTitular = professor;
            }
        }
        if(professorTitular == null){
            println("Não foi possível alocar! Professor titular não encontrado.");
            return;
        }

        //buscando professor adjunto
        var professorAdjunto : ProfessorAdjunto? = null;
        for (prof in listaProfessores) {
            if (prof.codigo == codigoProfessorAdjunto && prof is ProfessorAdjunto) {
                professorAdjunto = prof;
            }
        }
        if(professorAdjunto == null){
            println("Não foi possível alocar! Professor adjunto não encontrado.");
            return;
        }

        var curso :Curso? = null;
        if(listaCursos.size >= 0){
            for(i in 0 .. listaCursos.size){
                if(listaCursos.get(i).codigo == codigoCurso){
                    curso = listaCursos.get(i);
                    listaCursos.get(i).professorAjunto = professorAdjunto;
                    listaCursos.get(i).professorTitular = professorTitular;

                    println("Professores alocados com sucesso!")
                    break;
                }
            }
        }
        if(curso == null){
            println("Não foi possível alocar! Curso não encontrado.");
            return;
        }


    }
    fun retornaCodigoGeneratorMatricula():Int{
        var ultimoCodigo = 0;
        for(matricula in listaMatriculas){
            if(matricula.codigo > ultimoCodigo){
                ultimoCodigo = matricula.codigo;
            }
        }

        return ultimoCodigo+1;
    }

}