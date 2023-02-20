package entitites;

public class EmpregadoTercerizado extends Empregado{
	
	private double pagamentoAdicional;

	
	
	public EmpregadoTercerizado() {
		super();
	}
	
	
	
	public EmpregadoTercerizado(String nome, Integer horas, double valorPorHora, double pagamentoAdicional) {
		super(nome, horas, valorPorHora);
		this.pagamentoAdicional = pagamentoAdicional;
	}
	public double getPagamentoAdicional() {
		return pagamentoAdicional;
	}
	public void setPagamentoAdicional(double pagamentoAdicional) {
		this.pagamentoAdicional = pagamentoAdicional;
	}
	
	
	@Override
	public double pagamento() {
		return super.pagamento() + pagamentoAdicional * 1.1;
	}
}
