package com.androidutn.peliculas.model;

public class Pelicula {

    private int id;
    private String titulo;
    private double puntaje;
    private String imagenUrl;
    private String fecha;
    private String resumen;
    private String idioma;
    private int duracion;

    public Pelicula(String titulo, double puntaje, String imagenUrl, String fecha, String resumen) {
        this.titulo = titulo;
        this.puntaje = puntaje;
        this.imagenUrl = imagenUrl;
        this.fecha = fecha;
        this.resumen = resumen;
    }

    public Pelicula() {

    }

    public String getTmdbImagenUrl() {
        return "http://image.tmdb.org/t/p/" + "w342" + imagenUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
