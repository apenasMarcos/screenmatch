package br.com.marcos.screenmatch.service;

public interface IConvertData {
    <T>  T obtainData(String json, Class<T> tClass);
}
