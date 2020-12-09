package br.com.digitalHouseDesafioKotlin

fun main() {


    //Professores titulares
    var profTitular1 = ProfessorTitular("Matemática", 1, "Jean", "Titular");
    var profTitular2 = ProfessorTitular("Matemática e Física", 2, "Douglas", "Titular");


    //Professores adjuntos
    var profAdjunto1 = ProfessorAdjunto(10, 3, "Ribeiro", "Adjunto");
    var profAdjunto2 = ProfessorAdjunto(20, 4, "Pereira", "Adjunto");


    //Cursos
    var curso1 = Curso("Full Stack", 20001, 3, 40);
    var curso2 = Curso("Android", 20002, 2, 40);


    var manager = DigitalHouseManager();


    //Alocando professores
    manager.alocarProfessores(curso1.codigo, profTitular1.codigo, profAdjunto1.codigo);
    manager.alocarProfessores(curso2.codigo, profTitular2.codigo, profAdjunto2.codigo);


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

}