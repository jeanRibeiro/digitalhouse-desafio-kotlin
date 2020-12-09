package br.com.digitalHouseDesafioKotlin

class Aluno(
        var codigo: Int,
        var nome: String,
        var sobrenome: String
    ) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Aluno

        if (codigo != other.codigo) return false

        return true
    }

    override fun hashCode(): Int {
        return codigo
    }
}