package com.devlucasmart.cookieFortune.exceptions;

public class NumeroNaoInformadoException extends RuntimeException {
    public NumeroNaoInformadoException() {
        super("Range de Numeros do sorteio nao informado");
    }
}
