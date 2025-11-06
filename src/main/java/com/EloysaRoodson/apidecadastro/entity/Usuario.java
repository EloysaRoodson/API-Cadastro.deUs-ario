package com.EloysaRoodson.apidecadastro.entity;

 import jakarta.persistence.*; 
 @Entity
 @Table(name = "usuarios")
 @SequenceGenerator(
    name = "usuario_seq",
    sequenceName = "usuario_sequence",
    initialValue = 100000000,  // Start with 9 digits
    allocationSize = 1
 )
 public class Usuario { 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @Column(updatable = false)
    private long id;
    
    private String nome;
    private int idade;
    private String cidade;
    
    @Column(unique = true)
    private String telefone;
    
    @Column(unique = true)
    private String email;
    
    private String senha;

    
    public long getId() { return id; } 
    public void setId(long id) { this.id = id; } 
    public String getNome() { return nome; } 
    public void setNome(String nome) { this.nome = nome; } 
    public String getEmail() { return email; } 
    public void setEmail(String email) { this.email = email; } 
    public String getSenha() { return senha; } 
    public void setSenha(String senha) { this.senha = senha; } 
    public int getIdade() { return idade; } 
    public void setIdade(int idade) { this.idade = idade; } 
    public String getCidade() { return cidade; } 
    public void setCidade(String cidade) { this.cidade = cidade; } 
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; } 
}