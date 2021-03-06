package at.ancio.empregosociomatico.models;

public class Vagas {

    private String nome;
    private String empresa;
    private String Disponibilidade;
    private String image;
    private String description;
    private String data;

    public Vagas() {
    }

    public Vagas(String nome, String empresa, String disponibilidade, String image, String description, String data) {
        this.nome = nome;
        this.empresa = empresa;
        Disponibilidade = disponibilidade;
        this.image = image;
        this.description = description;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getDisponibilidade() {
        return Disponibilidade;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getData() {
        return data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setDisponibilidade(String disponibilidade) {
        Disponibilidade = disponibilidade;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setData(String data) {
        this.data = data;
    }
}


