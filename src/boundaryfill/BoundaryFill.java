/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boundaryfill;

import java.util.Random;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jhonn
 */
public class BoundaryFill extends Canvas {

    /**
     * @param args the command line arguments
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        controle(g);
    }

    void controle(Graphics g) {

        Quadradinho matriz[][] = new Quadradinho[10][10];

        Random aleatorio = new Random();

        Integer aux[][] = new Integer[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                aux[i][j] = aleatorio.nextInt(2);
                if (aux[i][j] == 0) {
                    matriz[i][j] = new Quadradinho(Color.red);
                } else {
                    matriz[i][j] = new Quadradinho(Color.BLUE);
                }
            }
        }

        imprimeMatrizQuadradinho(matriz, g, 0);
        imprimeMatrizQuadradinho(matriz, g, 300);
        Integer coordenadas[] = {5, 2};

        Quadradinho aux1[][] = boundaryFill(Color.YELLOW, coordenadas, matriz, 0, Color.YELLOW);

        System.out.println("");

        imprimeMatrizQuadradinhosAmarelos(aux1, g, 300);

    }

    static void imprimeMatrizInteira(Integer matriz[][]) {
        for (int linhas = 0; linhas < matriz.length; linhas++) {
            for (int colunas = 0; colunas < matriz[0].length; colunas++) {
                System.out.print(matriz[linhas][colunas] + "\t");
            }
            System.out.println("");
        }
    }

    static void imprimeMatrizQuadradinhosAmarelos(Quadradinho matriz[][], Graphics g, int xInicial) {
        int xAnt = xInicial;
        int yAnt = 0;
        for (int linhas = 0; linhas < matriz.length; linhas++) {
            int[] yCoordenadas = {yAnt, yAnt, yAnt + 20, yAnt + 20};
            for (int colunas = 0; colunas < matriz[0].length; colunas++) {
                int[] xCoordenadas = {xAnt, xAnt + 20, xAnt + 20, xAnt};
                xAnt += 20;
                if (matriz[linhas][colunas].cor.equals(Color.YELLOW)) {
                    
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                    g.setColor(matriz[linhas][colunas].cor);
                    g.fillPolygon(xCoordenadas, yCoordenadas, 4);
                    g.setColor(Color.BLACK);
                    g.drawPolygon(xCoordenadas, yCoordenadas, 4);
                }
            }
            yAnt += 20;
            xAnt = xInicial;
        }
    }

    static void imprimeMatrizQuadradinho(Quadradinho matriz[][], Graphics g, int xInicial) {
        int xAnt = xInicial;
        int yAnt = 0;
        for (int linhas = 0; linhas < matriz.length; linhas++) {
            int[] yCoordenadas = {yAnt, yAnt, yAnt + 20, yAnt + 20};
            for (int colunas = 0; colunas < matriz[0].length; colunas++) {
                int[] xCoordenadas = {xAnt, xAnt + 20, xAnt + 20, xAnt};
                xAnt += 20;
                g.setColor(matriz[linhas][colunas].cor);
                g.fillPolygon(xCoordenadas, yCoordenadas, 4);
                g.setColor(Color.BLACK);
                g.drawPolygon(xCoordenadas, yCoordenadas, 4);
            }
            yAnt += 20;
            xAnt = xInicial;
        }
    }

    Quadradinho[][] boundaryFill(Color teste, Integer[] coordenadas, Quadradinho[][] matriz, Integer passo, Color cor) {
        if (passo == 0) {
            boundaryFill(matriz[coordenadas[0]][coordenadas[1] - 1].cor, coordenadas, matriz, 1, cor);
        } /*else if (passo == 1) {
            matriz[coordenadas[0]][coordenadas[1]] = cor;
            if (matriz[coordenadas[0]][coordenadas[1] - 1] != null) {
                Integer aux[] = {coordenadas[0], coordenadas[1] - 1};
                boundaryFill(teste, aux, matriz, passo + 1, cor);
            }

            if (matriz[coordenadas[0] - 1][coordenadas[1]] != null) {
                Integer aux[] = {coordenadas[0] - 1, coordenadas[1]};
                boundaryFill(teste, aux, matriz, passo + 1, cor);
            }

            if (matriz[coordenadas[0]][coordenadas[1] + 1] != null) {
                Integer aux[] = {coordenadas[0], coordenadas[1] + 1};
                boundaryFill(teste, aux, matriz, passo + 1, cor);
            }

            if (matriz[coordenadas[0] + 1][coordenadas[1]] != null) {
                Integer aux[] = {coordenadas[0] + 1, coordenadas[1]};
                boundaryFill(teste, aux, matriz, passo + 1, cor);
            }
        }*/ else {

            matriz[coordenadas[0]][coordenadas[1]].cor = cor;

            if (coordenadas[1] - 1 >= 0) {
                if (matriz[coordenadas[0]][coordenadas[1] - 1].cor.equals(teste)) {
                    Integer aux[] = {coordenadas[0], coordenadas[1] - 1};
                    boundaryFill(teste, aux, matriz, passo + 1, cor);
                }
            }

            if (coordenadas[0] - 1 >= 0) {
                if (matriz[coordenadas[0] - 1][coordenadas[1]].cor.equals(teste)) {
                    Integer aux[] = {coordenadas[0] - 1, coordenadas[1]};
                    boundaryFill(teste, aux, matriz, passo + 1, cor);
                }
            }

            if (coordenadas[1] + 1 < matriz[0].length) {
                if (matriz[coordenadas[0]][coordenadas[1] + 1].cor.equals(teste)) {
                    Integer aux[] = {coordenadas[0], coordenadas[1] + 1};
                    boundaryFill(teste, aux, matriz, passo + 1, cor);
                }
            }

            if (coordenadas[0] + 1 < matriz.length) {
                if (matriz[coordenadas[0] + 1][coordenadas[1]].cor.equals(teste)) {
                    Integer aux[] = {coordenadas[0] + 1, coordenadas[1]};
                    boundaryFill(teste, aux, matriz, passo + 1, cor);
                }
            }
        }
        return matriz;
    }

}
