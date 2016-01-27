
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class VentanaAhorcado extends javax.swing.JFrame {

    String palabraOculta = "";
    
    //contador para saber el numero de fallos
    int numeroFallos = 0;
    
    //Tareas:
    /*
    1. Elegir la palabra oculta de un array de Strings aleaotriamente
    2. Que acabe el juego. HAS GANADO O HAS PERDIDO.
    3. Que se pinte de forma automatica, el numero de guiones dependiendo del
        número de letras que tenga la palabra
    
    /**
     * Creates new form VentanaAhorcado
     */
    public VentanaAhorcado() {
        initComponents();
        //aqui va el codigo que poniamos en el run en ACM
        cambiaImagenAhorcado();
        eligePalabraOculta();
        pintaGuionesEnLabel();
    }

    
    private void eligePalabraOculta() {
        
        //Método básico de lectura de ficheros en Java
        File fichero = null;
        FileReader fr = null;
        BufferedReader br = null;
        Random r = new Random();
        fichero = new File("src/lemario-20101017.txt");
        String linea = "";
        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            int numeroLineasFichero = 0;
            while ((linea = br.readLine()) != null) {
                   numeroLineasFichero++;
            }
            System.out.println(numeroLineasFichero);
            int lineaSeleccionada = r.nextInt(numeroLineasFichero);
            System.out.println(lineaSeleccionada);
            
            fr.close();
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            for (int i=0; i<lineaSeleccionada; i++) {
                linea = br.readLine();
            }
            System.out.println(linea);
            
        } catch (FileNotFoundException ex) { 
        }
          catch (IOException ex) {  
        }
        palabraOculta = linea;
        
        //falta revisar las palabras con tilde o con guion
        //falta revisar palabras con espacios en blanco
        //falta escribir la palabra que has pedido
       
//        String [] listaDePalabras = new String[10];
//        
//        
//        listaDePalabras[0] = "WILLY";
//        listaDePalabras[1] = "MITOLOGIA";
//        listaDePalabras[2] = "SOWFTWARE";
//        listaDePalabras[3] = "PROGRAMACION";
//        listaDePalabras[4] = "ESTERNON";
//        listaDePalabras[5] = "DESAFIANTE";
//        listaDePalabras[6] = "HIPOPOTOMONSTROSISQUIPEDALIOFOBIA";
//        listaDePalabras[7] = "CONSECOTALEFOBIA";
//        listaDePalabras[8] = "ANATIDAEFOBIA";
//        listaDePalabras[9] = "ELECTROENCEFALOGRAFISTA";
//        palabraOculta = listaDePalabras[r.nextInt(9)];
//        System.out.println(palabraOculta);
    }
     
    private void pintaGuionesEnLabel() {
        jLabel1.setText("");
        for (int i=0; i<palabraOculta.length(); i++) {
            jLabel1.setText(jLabel1.getText() + "_ ");
        }
    }
    
    private void cambiaImagenAhorcado() {
        
        String nombreImagen = "";
        
        switch (numeroFallos) {
                case 0: nombreImagen = "/ahorcado_0.png"; break;
                case 1: nombreImagen = "/ahorcado_1.png"; break;
                case 2: nombreImagen = "/ahorcado_2.png"; break;
                case 3: nombreImagen = "/ahorcado_3.png"; break;
                case 4: nombreImagen = "/ahorcado_4.png"; break;
                case 5: nombreImagen = "/ahorcado_5.png"; break;
                case -1: nombreImagen = "/acertasteTodo.png"; break;
                default : nombreImagen = "/ahorcado_fin.png"; break;
            }
        //después del switch, tendremos en nombreImagen el nombre correcto
        //de la imagen que tenemos que mostrar dependiendo del numero de fallos
        ImageIcon imagen;
        imagen = new ImageIcon(getClass().getResource(nombreImagen));
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(jLabel2.getWidth(),
                jLabel2.getHeight(), Image.SCALE_DEFAULT));
        jLabel2.setIcon(icono);
        
    }
    

    private void chequeaLetra (JButton boton) {
        if (boton.isEnabled()) {
        String letra = boton.getText().toLowerCase();
        boton.setEnabled(false);
        String palabraConGuiones = jLabel1.getText();
        
        if (palabraOculta.contains(letra)) {
            for (int i=0; i < palabraOculta.length(); i++) {
                if(palabraOculta.charAt(i) == letra.charAt(0)) {
                    palabraConGuiones = 
                            palabraConGuiones.substring(0, 2*i)
                            + letra
                            + palabraConGuiones.substring(2*i +1);
                }
            }
            jLabel1.setText(palabraConGuiones);
            //compruebo si en la palabraConGuiones hay guiones o no
            //si hay algun guión no hago nada porque no he adivinado todavia la partida
            //si no hay guiones, tengo que indicar de alguna forma que he ganado la partida
            if (!palabraConGuiones.contains("_")) {
                numeroFallos = -1;
            }
        }
        else {
            numeroFallos++;
        }
        }
        cambiaImagenAhorcado();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonA = new javax.swing.JButton();
        botonB = new javax.swing.JButton();
        botonC = new javax.swing.JButton();
        botonD = new javax.swing.JButton();
        botonE = new javax.swing.JButton();
        botonF = new javax.swing.JButton();
        botonG = new javax.swing.JButton();
        botonH = new javax.swing.JButton();
        botonI = new javax.swing.JButton();
        botonJ = new javax.swing.JButton();
        botonK = new javax.swing.JButton();
        botonL = new javax.swing.JButton();
        botonM = new javax.swing.JButton();
        botonN = new javax.swing.JButton();
        botonÑ = new javax.swing.JButton();
        botonO = new javax.swing.JButton();
        botonP = new javax.swing.JButton();
        botonQ = new javax.swing.JButton();
        botonR = new javax.swing.JButton();
        botonS = new javax.swing.JButton();
        botonT = new javax.swing.JButton();
        botonU = new javax.swing.JButton();
        botonV = new javax.swing.JButton();
        botonW = new javax.swing.JButton();
        botonX = new javax.swing.JButton();
        botonY = new javax.swing.JButton();
        botonZ = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 21)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("_ _ _ _ _ ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 354, 64));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 270, 260));

        botonA.setText("A");
        botonA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonAMousePressed(evt);
            }
        });
        getContentPane().add(botonA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 372, 42, 42));

        botonB.setText("B");
        botonB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonBMousePressed(evt);
            }
        });
        getContentPane().add(botonB, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 372, 42, 42));

        botonC.setText("C");
        botonC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonCMousePressed(evt);
            }
        });
        getContentPane().add(botonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 372, 42, 42));

        botonD.setText("D");
        botonD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonDMousePressed(evt);
            }
        });
        getContentPane().add(botonD, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 372, 42, 42));

        botonE.setText("E");
        botonE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonEMousePressed(evt);
            }
        });
        getContentPane().add(botonE, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 372, 42, 42));

        botonF.setText("F");
        botonF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonFMousePressed(evt);
            }
        });
        getContentPane().add(botonF, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 372, 42, 42));

        botonG.setText("G");
        botonG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonGMousePressed(evt);
            }
        });
        getContentPane().add(botonG, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 372, 42, 42));

        botonH.setText("H");
        botonH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonHMousePressed(evt);
            }
        });
        getContentPane().add(botonH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 42, 42));

        botonI.setText("I");
        botonI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonIMousePressed(evt);
            }
        });
        getContentPane().add(botonI, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 420, 42, 42));

        botonJ.setText("J");
        botonJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonJMousePressed(evt);
            }
        });
        getContentPane().add(botonJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 420, 42, 42));

        botonK.setText("K");
        botonK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonKMousePressed(evt);
            }
        });
        botonK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonKActionPerformed(evt);
            }
        });
        getContentPane().add(botonK, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 420, 42, 42));

        botonL.setText("L");
        botonL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonLMousePressed(evt);
            }
        });
        getContentPane().add(botonL, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 420, 42, 42));

        botonM.setText("M");
        botonM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonMMousePressed(evt);
            }
        });
        getContentPane().add(botonM, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 42, 42));

        botonN.setText("N");
        botonN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonNMousePressed(evt);
            }
        });
        getContentPane().add(botonN, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 420, 42, 42));

        botonÑ.setText("Ñ");
        botonÑ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonÑMousePressed(evt);
            }
        });
        getContentPane().add(botonÑ, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 468, 42, 42));

        botonO.setText("O");
        botonO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonOMousePressed(evt);
            }
        });
        getContentPane().add(botonO, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 468, 42, 42));

        botonP.setText("P");
        botonP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonPMousePressed(evt);
            }
        });
        getContentPane().add(botonP, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 468, 42, 42));

        botonQ.setText("Q");
        botonQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonQMousePressed(evt);
            }
        });
        getContentPane().add(botonQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 468, 42, 42));

        botonR.setText("R");
        botonR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonRMousePressed(evt);
            }
        });
        getContentPane().add(botonR, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 468, 42, 42));

        botonS.setText("S");
        botonS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonSMousePressed(evt);
            }
        });
        getContentPane().add(botonS, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 468, 42, 42));

        botonT.setText("T");
        botonT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonTMousePressed(evt);
            }
        });
        botonT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTActionPerformed(evt);
            }
        });
        getContentPane().add(botonT, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 468, 42, 42));

        botonU.setText("U");
        botonU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonUMousePressed(evt);
            }
        });
        getContentPane().add(botonU, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 516, 42, 42));

        botonV.setText("V");
        botonV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonVMousePressed(evt);
            }
        });
        getContentPane().add(botonV, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 516, 42, 42));

        botonW.setText("W");
        botonW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonWMousePressed(evt);
            }
        });
        getContentPane().add(botonW, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 516, 42, 42));

        botonX.setText("X");
        botonX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonXMousePressed(evt);
            }
        });
        botonX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonXActionPerformed(evt);
            }
        });
        getContentPane().add(botonX, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 516, 42, 42));

        botonY.setText("Y");
        botonY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonYMousePressed(evt);
            }
        });
        getContentPane().add(botonY, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 516, 42, 42));

        botonZ.setText("Z");
        botonZ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonZMousePressed(evt);
            }
        });
        botonZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonZActionPerformed(evt);
            }
        });
        getContentPane().add(botonZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 516, 42, 42));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 360, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonAMousePressed

    private void botonBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonBMousePressed

    private void botonCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonCMousePressed

    private void botonDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonDMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonDMousePressed

    private void botonEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonEMousePressed

    private void botonFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonFMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonFMousePressed

    private void botonGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonGMousePressed

    private void botonHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonHMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonHMousePressed

    private void botonIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonIMousePressed

    private void botonJMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonJMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonJMousePressed

    private void botonKMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonKMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonKMousePressed

    private void botonLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonLMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonLMousePressed

    private void botonMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonMMousePressed

    private void botonNMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonNMousePressed

    private void botonÑMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonÑMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonÑMousePressed

    private void botonOMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonOMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonOMousePressed

    private void botonPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonPMousePressed

    private void botonQMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonQMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonQMousePressed

    private void botonRMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonRMousePressed

    private void botonSMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonSMousePressed

    private void botonTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonTMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonTMousePressed

    private void botonUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonUMousePressed

    private void botonVMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonVMousePressed

    private void botonWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonWMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonWMousePressed

    private void botonXMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonXMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonXMousePressed

    private void botonYMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonYMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonYMousePressed

    private void botonZMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonZMousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonZMousePressed

    private void botonKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonKActionPerformed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonKActionPerformed

    private void botonTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTActionPerformed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonTActionPerformed

    private void botonXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonXActionPerformed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonXActionPerformed

    private void botonZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonZActionPerformed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_botonZActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAhorcado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonA;
    private javax.swing.JButton botonB;
    private javax.swing.JButton botonC;
    private javax.swing.JButton botonD;
    private javax.swing.JButton botonE;
    private javax.swing.JButton botonF;
    private javax.swing.JButton botonG;
    private javax.swing.JButton botonH;
    private javax.swing.JButton botonI;
    private javax.swing.JButton botonJ;
    private javax.swing.JButton botonK;
    private javax.swing.JButton botonL;
    private javax.swing.JButton botonM;
    private javax.swing.JButton botonN;
    private javax.swing.JButton botonO;
    private javax.swing.JButton botonP;
    private javax.swing.JButton botonQ;
    private javax.swing.JButton botonR;
    private javax.swing.JButton botonS;
    private javax.swing.JButton botonT;
    private javax.swing.JButton botonU;
    private javax.swing.JButton botonV;
    private javax.swing.JButton botonW;
    private javax.swing.JButton botonX;
    private javax.swing.JButton botonY;
    private javax.swing.JButton botonZ;
    private javax.swing.JButton botonÑ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
