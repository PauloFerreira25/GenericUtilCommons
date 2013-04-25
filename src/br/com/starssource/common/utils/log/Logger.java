package br.com.starssource.common.utils.log;

public class Logger {
	private String system;
	private String subsystem;
	private String metodo;

	
	public boolean setLogger(String system, String subsystem, String metodo) {
		this.subsystem = subsystem;
		this.system = system;
		this.metodo = metodo;
		return true;
	};

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getSubsystem() {
		return subsystem;
	}

	public void setSubsystem(String subsystem) {
		this.subsystem = subsystem;
	}

	public String getMetodo() {
		return metodo;
	}


	public void info(String texto) {
		this.saidaFormatada(texto, "Info");
	}

	public void debug(String texto) {
		this.saidaFormatada(texto, "Debug");
	}

	public void trace(String texto) {
		this.saidaFormatada(texto, "Trace");
	}

	public void error(String texto) {
		this.saidaFormatada(texto, "Error");
	}

	public void error(String texto, Exception e) {
		this.saidaFormatada(texto, "Error", e);
	}

	public void warning(String texto) {
		this.saidaFormatada(texto, "Warning");
	}

	public void critical(String texto) {
		this.saidaFormatada(texto, "Critical");
	}

	private void saidaFormatada(String texto, String level, Exception e) {
		saidaFormatada(texto, level);
		this.saida("<<<--------------------------------->>>");
		this.saida(e.getMessage() + " " + e.fillInStackTrace());
		e.printStackTrace();
		this.saida("<<<--------------------------------->>>");
	}

	private void saidaFormatada(String texto, String level) {
		this.saida(level + " - " + this.system + " - " + this.subsystem + " - "
				+ this.metodo + " - " + texto);
	}

	private void saida(String s) {
		System.out.println(s);
	}
}
