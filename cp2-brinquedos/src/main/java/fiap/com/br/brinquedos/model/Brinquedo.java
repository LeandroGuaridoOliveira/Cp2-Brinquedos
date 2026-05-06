package fiap.com.br.brinquedos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TDS_TB_Brinquedos")
public class Brinquedo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Column(name = "classificacao", nullable = false, length = 20)
    private String classificacao;

    @Column(name = "tamanho", nullable = false, length = 20)
    private String tamanho;

    @Column(name = "preco", nullable = false)
    private Double preco;

    // ---- Construtores ----

    public Brinquedo() {
    }

    public Brinquedo(String nome, String tipo, String classificacao, String tamanho, Double preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    // ---- Getters e Setters ----

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Brinquedo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", classificacao='" + classificacao + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", preco=" + preco +
                '}';
    }
}
