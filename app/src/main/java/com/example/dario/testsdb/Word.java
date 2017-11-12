package com.example.dario.testsdb;

public class Word {

    private int id;
    private String word;

    public Word(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public int getIdWord() {return id;}

    public void setIdWord(int id) {this.id = id;}

    public String getWord() {return word;}

    public void setWord(String word) {this.word = word;}

}