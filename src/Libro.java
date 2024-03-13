class Libro {
    private int codigoDelLibro;
    private String titulo;
    private String autor;
    private String apellidoAutor;
    private boolean disponibilidad;

    public Libro(int codigoDelLibro, String titulo, String autor, String apellidoAutor, boolean disponibilidad) {
        this.codigoDelLibro = codigoDelLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.apellidoAutor = apellidoAutor;
        this.disponibilidad = disponibilidad;
    }

    public int getCodigoDelLibro() {
        return codigoDelLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}