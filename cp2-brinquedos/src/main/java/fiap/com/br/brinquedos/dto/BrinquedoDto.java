package fiap.com.br.brinquedos.dto;

import jakarta.validation.constraints.*;

public class BrinquedoDto {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O tipo é obrigatório")
    @Size(max = 50, message = "O tipo deve ter no máximo 50 caracteres")
    private String tipo;

    // Ex: "Livre", "+3", "+7", "+10", "+14"
    @NotBlank(message = "A classificação etária é obrigatória")
    private String classificacao;

    // Ex: "Pequeno", "Médio", "Grande"
    @NotBlank(message = "O tamanho é obrigatório")
    private String tamanho;

    @NotNull(message = "O preço é obrigatório")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
    private Double preco;

    // ---- Construtores ----

    public BrinquedoDto() {
    }

    public BrinquedoDto(String nome, String tipo, String classificacao, String tamanho, Double preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.classificacao = classificacao;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    // ---- Getters e Setters ----

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
}
