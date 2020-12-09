package br.com.digitalHouseDesafioKotlin

fun main() {

    var manager = DigitalHouseManager();

    
    //Professores titulares
    var profTitular1 = manager.registrarProfessorTitular("Jean", "Titular", 1, "Matemática");
    var profTitular2 = manager.registrarProfessorTitular("Douglas", "Titular", 2, "Matemática e Física");


    //Professores adjuntos
    var profAdjunto1 = manager.registrarProfessorAdjunto("Ribeiro", "Adjunto", 3, 10);
    var profAdjunto2 = manager.registrarProfessorAdjunto("Pereira", "Adjunto", 4, 20);


    //Cursos
    var curso1 = manager.registrarCurso("Full Stack", 20001, 3, 40);
    var curso2 = manager.registrarCurso("Android", 20002, 2, 40);


    //Alocando professores
    if (profTitular1 != null && profAdjunto1 != null && curso1 != null) {
        manager.alocarProfessores(curso1.codigo, profTitular1.codigo, profAdjunto1.codigo)
    }
    else{
        println("Professores ou curso não encontrados!");
        return;
    }
    if (profTitular2 != null && profAdjunto2 != null && curso2 != null) {
        manager.alocarProfessores(curso2.codigo, profTitular2.codigo, profAdjunto2.codigo);
    }
    else{
        println("Professores ou curso não encontrados!");
        return;
    }


    //Matriculando alunos
    var aluno1 = Aluno(1, "Jean Teste", "Da Silva")
    var aluno2 = Aluno(2, "Cássio Teste", "Fernandes")
    manager.matricularAluno(aluno1.codigo, curso1.codigo);
    manager.matricularAluno(aluno2.codigo, curso1.codigo);

    var aluno3 = Aluno(3, "Aluno 3", "Teste")
    var aluno4 = Aluno(4, "Aluno 4", "Teste")
    var aluno5 = Aluno(5, "Aluno 5", "Teste")
    manager.matricularAluno(aluno3.codigo, curso2.codigo);
    manager.matricularAluno(aluno4.codigo, curso2.codigo);
    manager.matricularAluno(aluno5.codigo, curso2.codigo);


    /*
    *  OUTRO MODELO PARA SE FAZER
    *
    //Professores
    manager.registrarProfessorTitular("Jean", "Titular", 1, "Matemática");
    manager.registrarProfessorTitular("Douglas", "Titular", 2, "Matemática e Física");
    manager.registrarProfessorAdjunto("Ribeiro", "Adjunto", 3, 10);
    manager.registrarProfessorAdjunto("Pereira", "Adjunto", 4, 20);


    //Cursos
    manager.registrarCurso("Full Stack", 20001, 3, 40);
    manager.registrarCurso("Android", 20002, 2, 40);


    //Alocando
    manager.alocarProfessores(curso1.codigo, profTitular1.codigo, profAdjunto1.codigo);
    manager.alocarProfessores(curso2.codigo, profTitular2.codigo, profAdjunto2.codigo);


    //Matriculando alunos
    *
    * */



}