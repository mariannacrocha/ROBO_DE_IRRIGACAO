package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;



public class Program {

	    private Horta plantacao;
	    private Robo bot;
	    private ArrayList<String[]> area;
	    private String[] linhaAuxiliar;

	    public Program() {
	        this.plantacao = new Horta();
	        this.bot = new Robo(plantacao.getLinhaX() - 1, plantacao.getLinhaY() - 1);
	        this.area = new ArrayList<>();
	        for (int i = 0; i < plantacao.getLinhaX(); i++) {
	            area.add(new String[plantacao.getLinhaY()]);
	        }
	    }

	    public void mostraInfo() {
	        area.stream().forEach((linha) -> {
	            for (int i = 0; i < linha.length; i++) {
	                if(Arrays.equals(linha, area.get(bot.getPosicaoY()))&& i == bot.getPosicaoX())
	                    linha[i] = "|R|";
	                else
	                    linha[i] = "| |";
	                    
	            }
	        });
	        System.out.println("Posição Inicial: (" + bot.getPosicaoX() + " ," + bot.getPosicaoY() + ")");
	        System.out.println("Direçãoo inicial:" + direcao());

	        System.out.print("Canteiros a irrigar: ");
		        bot.getCanteiro().stream().forEach((ge) -> {     
	            System.out.print(Arrays.toString(ge));
	            linhaAuxiliar = area.get(ge[1]);
	            linhaAuxiliar[ge[0]] = "|i" + (bot.getCanteiro().lastIndexOf(ge) + 1) + "|";
	            area.remove(linhaAuxiliar);
	            area.add(ge[1], linhaAuxiliar);
	        });
	        System.out.println("");
	        
	        for (int i = (area.size() - 1); i >= 0; i--) { 
	            System.out.println(i + Arrays.toString(area.get(i)));
	        }
	        for (int i = 0; i <= (plantacao.getLinhaX() - 1); i++) { 
	            System.out.print("   " + i + " ");
	        }
	        System.out.println("");
	    }

	    public String direcao() {           
	        switch (bot.getDirecao()) {   
	            case 1:
	                return "Norte";
	            case 2:
	                return "Leste";
	            case 3:
	                return "Sul";
	            default:
	                return "Oeste";
	        }
	    }

	    public void movimento() {           
	        String resultado = "Caminho:";
	        Integer x = bot.getPosicaoX();
	        Integer y = bot.getPosicaoY();
	        Integer destinoX;
	        Integer destinoY;
	        for (Integer[] canteiro : bot.getCanteiro()) {
	            destinoX = canteiro[0];
	            destinoY = canteiro[1];
	            if (destinoX > x) {
	                switch (bot.getDirecao()) { 
	                    case 1:
	                        resultado += " D ";
	                        break;
	                    case 2:
	                        break;
	                    case 3:
	                        resultado += " E ";
	                        break;
	                    default:
	                        resultado += " D D ";
	                        break;
	                }
	                bot.setDirecao(2);

	                while (!Objects.equals(destinoX, x)) {
	                    resultado += " M ";
	                    x++;
	                }
	            } else if (destinoX < x) {
	                switch (bot.getDirecao()) { 
	                    case 1:
	                        resultado += " E ";
	                        break;
	                    case 2:
	                        resultado += " D D ";
	                        break;
	                    case 3:
	                        resultado += " D ";
	                        break;
	                    default:
	                        break;

	                }
	                bot.setDirecao(4);
	                while (!Objects.equals(destinoX, x)) {
	                    resultado += " M ";
	                    x--;
	                }
	            }
	            if (destinoY > y) {             
	                switch (bot.getDirecao()) {
	                    case 1:
	                        break;
	                    case 2:
	                        resultado += " E ";
	                        break;
	                    case 3:
	                        resultado += " D D ";
	                        break;
	                    default:
	                        resultado += " D ";
	                        break;
	                }
	                bot.setDirecao(1);

	                while (!Objects.equals(destinoY, y)) {
	                    resultado += " M ";
	                    y++;
	                }
	            } else if (destinoY < y) {         
	                switch (bot.getDirecao()) {
	                    case 1:
	                        resultado += " D D ";
	                        break;
	                    case 2:
	                        resultado += " D ";
	                        break;
	                    case 3:
	                        break;
	                    default:
	                        resultado += " E ";
	                        break;

	                }
	                bot.setDirecao(3);
	                while (!Objects.equals(destinoY, y)) {
	                    resultado += " M ";
	                    y--;
	                }
	                
	            }
	            resultado += " I ";
	        }

	        System.out.println(resultado);
	        System.out.println("Direção final:" + direcao());

	    }

	    public static void main(String[] args) {
	    	Program run = new Program();
	        run.mostraInfo();
	        run.movimento();
	    }
	}

