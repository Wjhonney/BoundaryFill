/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundaryfill;

import javax.swing.JFrame;

/**
 *
 * @author jhonn
 */
public class Base extends JFrame{
    
    public static void main(String[] args) {
        Base bs = new Base();

    }

    public Base() {
        initGui();
    }

    private void initGui() {
        // titulo
        this.setTitle("BoundaryFill");
        // tamanho em pixels altura e largura
        setSize(515, 220);

        // janela aparecer no meio
        setLocationRelativeTo(null);

        // terminar a aplicacao ao fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoundaryFill boundaryFill = new BoundaryFill();

        this.add(boundaryFill);
        // tornar a janela visivel
        setVisible(true);
    }
    
}
