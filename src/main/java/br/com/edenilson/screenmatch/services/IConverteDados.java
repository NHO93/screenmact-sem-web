package br.com.edenilson.screenmatch.services;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
