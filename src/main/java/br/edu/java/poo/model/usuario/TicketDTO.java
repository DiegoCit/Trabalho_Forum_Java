package br.edu.java.poo.model.usuario;

import java.sql.Timestamp;

public class TicketDTO {
    private int id;
    private String titulo;
    private String mensagem;
    private String status;
    private Timestamp tempoInicio;
    private Timestamp tempoFim;

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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTempoInicio() {
        return tempoInicio;
    }

    public void setTempoInicio(Timestamp tempoInicio) {
        this.tempoInicio = tempoInicio;
    }

    public Timestamp getTempoFim() {
        return tempoFim;
    }

    public void setTempoFim(Timestamp tempoFim) {
        this.tempoFim = tempoFim;
    }
}
