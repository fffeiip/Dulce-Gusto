package br.ufrpe.dulceGusto.dados;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;

public class RepositorioCliente {
	
	private Cliente[] clientes;
	private int proxima;
	private int tamanho;
	
	public RepositorioCliente(){
		tamanho=100;
		this.clientes = new Cliente[tamanho];
		
	}
	public int getProxima(){
		return proxima;
	}
	public int getTamanho(){
		return tamanho;
	}
	public boolean novoCliente(Cliente cliente){
		boolean retorno = false;
		for(int i=0;i<tamanho;i++){
			if(	cliente!=null 
					&& 
					this.getProxima()<this.clientes.length){				
				for(int j =0; j<this.clientes.length;j++){
					boolean equivale = cliente.getCpf().equals(clientes[j].getCpf());
					if(!equivale){
						clientes[proxima] = cliente;
						proxima++;
						retorno = true;
						if(this.getProxima()>this.getTamanho()){
							this.tamanho = tamanho*2;
						}
					}
				
				}
			}
		}
		return retorno;
	}
	public int obterIndice(String cpf){
		
		int indice = -1;
		for (int i=0; i<this.getProxima();i++){
			if(clientes[i].getCpf().equals(cpf)){
				indice =i;
			}
		}
		
		return indice;
	}
	public Cliente buscarCliente(String cpf){
		Cliente retorno = null;
		int indice = this.obterIndice(cpf);
		if(indice != -1){
			retorno = this.clientes[indice];
		}
		return retorno;
	}
	public boolean removerCliente(String cpf){
		boolean retorno = false;
		int indice = this.obterIndice(cpf);
		if(indice!=-1){
			this.clientes[indice] = this.clientes[proxima-1];
			this.clientes[proxima-1] = null;
			proxima--;
			retorno = true;
		}
		
		return retorno;
	}
	public void alterarCliente(Cliente cliente){
		int indice = this.obterIndice(cliente.getCpf());
		
		if(indice != -1){
			this.clientes[indice] = cliente;
		}
	}
	
}
