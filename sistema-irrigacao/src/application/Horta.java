package application;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Horta {
	
	private int linhaX;
	private int linhaY;
	private ArrayList<String[]> area;
	
	public Horta(int linhaX, int linhaY, ArrayList<String[]> area) {
		super();
		this.linhaX = linhaX;
		this.linhaY = linhaY;
		
	}
	
	  public Horta() {
	        this.linhaX = Integer.parseInt(verificaEntrada("Digite o comprimento da horta", "Comprimento")); 
	        this.linhaY = Integer.parseInt(verificaEntrada("Digite a largura da horta", "Largura"));
	    }

	public int getLinhaX() {
		return linhaX;
	}

	public void setLinhaX(int linhaX) {
		this.linhaX = linhaX;
	}

	public int getLinhaY() {
		return linhaY;
	}

	public void setLinhaY(int linhaY) {
		this.linhaY = linhaY;
	}
	
	 public String verificaEntrada(String descricao, String titulo) {

	        String input = "";
	        do {
	            input = JOptionPane.showInputDialog(null, descricao, titulo, JOptionPane.QUESTION_MESSAGE);
	            if (!input.matches("^[0-9]*$")) {
	                JOptionPane.showMessageDialog(null, "Por favor, digitar somente números.", "Erro", JOptionPane.ERROR_MESSAGE);
	            }
	        } while (!input.matches("^[0-9]*$"));
	        return input;
	    }
	

}
