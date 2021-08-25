package application;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Robo {

    private Integer posicaoX;
    private Integer posicaoY;
    private Integer direcao; // 1 = Norte, 2 = Leste,3 = Sul, 4 = Oeste   
    private ArrayList<Integer[]> canteiro;
    private Integer maximoX;
    private Integer maximoY;

    public Robo(Integer posicaoX, Integer posicaoY, Integer direcao,Integer maximoX, Integer maximoY) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.direcao = direcao;
        this.maximoX = maximoX;
        this.maximoY = maximoY;
    }

    public Robo(Integer maximoX, Integer maximoY) {
     
        this.maximoX = maximoX;
        this.maximoY = maximoY;
        this.posicaoX = verificaArea("Posi��o do robo em rela��o a largura da horta", "posicao", JOptionPane.QUESTION_MESSAGE, maximoX);
        this.posicaoY = verificaArea("Posi��o do robo em rela��o ao comprimento da horta", "Posi��o", JOptionPane.QUESTION_MESSAGE, maximoY);

        do {
  
            direcao = Integer.parseInt(verificaEntrada("O robo est� posicionado para:\n"
                    + "1.Norte\n"
                    + "2.Leste\n"
                    + "3.Sul\n"
                    + "4.Oeste", "Dire��o", JOptionPane.QUESTION_MESSAGE));
            if (!(direcao > 0 && direcao < 5)) {
                direcao = 0;
                JOptionPane.showMessageDialog(null, "Por favor, insira uma op��o v�lida", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (direcao == 0);
        
        this.canteiro = new ArrayList<>();
        int canteiroBool = 0;
        do {                      
            Integer irrigar[] = new Integer[2];
            irrigar[0] = verificaArea("Posi��o do canteiro em rela��o ao comprimento da horta", "Canteiro", JOptionPane.QUESTION_MESSAGE, maximoX);
            irrigar[1] = verificaArea("Posi��o do canteiro em rela��o a largura da horta", "Canteiro", JOptionPane.QUESTION_MESSAGE, maximoY);
            canteiro.add(irrigar);
            canteiroBool = JOptionPane.showConfirmDialog(null, "Deseja irrigar mais algum canteiro?", null, JOptionPane.YES_NO_OPTION);
        } while (canteiroBool == 0);
    }

    public Integer getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(Integer posicaoX) {
        this.posicaoX = posicaoX;
    }

    public Integer getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(Integer posicaoY) {
        this.posicaoY = posicaoY;
    }

    public Integer getDirecao() {
        return direcao;
    }

    public void setDirecao(Integer direcao) {
        this.direcao = direcao;
    }

    public ArrayList<Integer[]> getCanteiro() {
        return canteiro;
    }

    public void setCanteiro(ArrayList<Integer[]> canteiro) {
        this.canteiro = canteiro;
    }
    
    public String verificaEntrada(String descricao, String titulo , Integer tipoMensagem) {
        String input = "";
        do {
            input = JOptionPane.showInputDialog(null, descricao, titulo, tipoMensagem);
            if (!input.matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null, "Por favor, digitar somente números.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (!input.matches("^[0-9]*$"));
        return input;
    }
    
    public Integer verificaArea(String descricao, String titulo , Integer tipoMensagem, Integer max){
        Integer input = 0;
        do {
            input = Integer.parseInt(verificaEntrada(descricao, titulo , tipoMensagem));
            if (input > max) {
                JOptionPane.showMessageDialog(null, "Por favor, digitar espa�o menor do que a �rea da horta",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (input > max);
        
        return input;
    }
}
