package dao;
import java.util.Date;

public class DAO{
	private Integer id;
	private String nome;
	private String descricao;
	private String conteudo;
	private String img;
	public Date data_mod;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getData_mod() {
		return data_mod;
	}
	public void setData_mod(Date data_mod) {
		this.data_mod = data_mod;
	}	
}
