package enums;

public enum TituloPagina {
    HOME("Página Inicial");

    private final String titulo;

    TituloPagina(String tituloPagina) {
        this.titulo = tituloPagina;
    }

    public String getTitulo() {
        return titulo;
    }
}
