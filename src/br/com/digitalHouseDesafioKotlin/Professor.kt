package br.com.digitalHouseDesafioKotlin

abstract class Professor(
        var codigo:Int,
        var nome: String,
        var sobrenome: String
    ) {

    init {
        var tempoDeCasa: Int = 0;
    }

    //funcoes
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Professor

        if (codigo != other.codigo) return false

        return true
    }

    override fun hashCode(): Int {
        return codigo
    }
}