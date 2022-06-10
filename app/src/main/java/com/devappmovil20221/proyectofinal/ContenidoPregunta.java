package com.devappmovil20221.proyectofinal;

public class ContenidoPregunta {
    private int id;
    private String nombre;
    private String texto;
    private String pregunta;
    private String res1;
    private int res1next;
    private String res2;
    private int res2next;
    private String res3;
    private int res3next;
    private String res4;
    private int res4next;

    public ContenidoPregunta(int id, String nombre, String texto, String pregunta, String res1, int res1Next, String res2, int res2next, String res3, int res3next, String res4, int res4next) {
        this.id = id;
        this.nombre = nombre;
        this.texto = texto;
        this.pregunta = pregunta;
        this.res1 = res1;
        this.res1next = res1Next;
        this.res2 = res2;
        this.res2next = res2next;
        this.res3 = res3;
        this.res3next = res3next;
        this.res4 = res4;
        this.res4next = res4next;
    }

    public ContenidoPregunta(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRes1() {
        return res1;
    }

    public void setRes1(String res1) {
        this.res1 = res1;
    }

    public int getRes1next() {
        return res1next;
    }

    public void setRes1next(int res1next) {
        this.res1next = res1next;
    }

    public String getRes2() {
        return res2;
    }

    public void setRes2(String res2) {
        this.res2 = res2;
    }

    public int getRes2next() {
        return res2next;
    }

    public void setRes2next(int res2next) {
        this.res2next = res2next;
    }

    public String getRes3() {
        return res3;
    }

    public void setRes3(String res3) {
        this.res3 = res3;
    }

    public int getRes3next() {
        return res3next;
    }

    public void setRes3next(int res3next) {
        this.res3next = res3next;
    }

    public String getRes4() {
        return res4;
    }

    public void setRes4(String res4) {
        this.res4 = res4;
    }

    public int getRes4next() {
        return res4next;
    }

    public void setRes4next(int res4next) {
        this.res4next = res4next;
    }
}
