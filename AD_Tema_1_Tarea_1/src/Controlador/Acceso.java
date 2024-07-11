/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Coche;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Acceso {

    //Objetos de escritura y lectura (secuencial texto)
    private static File fCoches = new File("src/coches.dat");
    public Scanner sLector;
    private FileWriter tEscritor;
    //Objetos escritura y lectura(serializado)
    private static File fCochesDiesel = new File("src/diesel.dat");
    private ObjectInputStream oLector;
    private ObjectOutputStream oEscritor;

    public Acceso() {
        /*this.sLector = sLector;
        this.tEscritor = tEscritor;
        this.oLector = oLector;
        this.oEscritor = oEscritor;*/
    }

    public boolean verifyFCochesDiesel() {
        return fCochesDiesel.exists();
    }

    public boolean verifyFCoches() {
        return fCoches.exists();
    }

    public void saveCar(Coche ch) {
        try {
            if (!verifyFCoches()) {
                fCoches.createNewFile();
            }
            tEscritor = new FileWriter(fCoches, true);
            BufferedWriter bEscritor = new BufferedWriter(tEscritor);
            tEscritor.append(ch.toString() + "\n");

        } catch (IOException ex) {

        }finally {
                try{
                    tEscritor.close();
                }catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error",
                "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "El coche se guardó",
                "Guardado", JOptionPane.INFORMATION_MESSAGE);
    }
    public ArrayList<Coche> readfCoches() {
        ArrayList<Coche> listaCoches = new ArrayList<>();
        try {
            if (verifyFCoches()) {
                // Abrir el archivo de lectura
                sLector = new Scanner(fCoches);
                while (sLector.hasNextLine()) {
                    String[] cocheData = sLector.nextLine().split("@");
                    if (cocheData.length == 6) {
                        String matricula = cocheData[0];
                        String marca = cocheData[1];
                        String modelo = cocheData[2];
                        String combustible = cocheData[3];
                        String kilometros = cocheData[4];
                        String vendido = cocheData[5];
                        boolean vend=(vendido.equals("Si"));
                        Coche coche = new Coche(matricula, marca, modelo, combustible, Integer.valueOf(kilometros),vend);
                        listaCoches.add(coche);
                    }
                }
                sLector.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaCoches;
    }
    public void writeDieselSelection(ArrayList<Coche> listaCoches) {
        //int count = 0; antes tenia el metodo int y devolvía el total de registros guardados, pero no lo uso, a si que lo paso a void
        try {
            if (!verifyFCochesDiesel()) {
                fCochesDiesel.createNewFile();
            }
            // Abrir el archivo de escritura
            oEscritor = new ObjectOutputStream(new FileOutputStream(fCochesDiesel));
            for (Coche coche : listaCoches) {
                if (coche.getCombustible().equals("Diesel")) {
                    oEscritor.writeObject(coche);
                    //count++;
                }
            }
            oEscritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Coche> readfCochesDiesel() {
        ArrayList<Coche> cochesDiesel = new ArrayList<>();
        try {
            if (verifyFCochesDiesel()) {
                // Abrir el archivo de lectura
                oLector = new ObjectInputStream(new FileInputStream(fCochesDiesel));
                while (true) {
                    try {
                        Coche coche = (Coche) oLector.readObject();
                        cochesDiesel.add(coche);
                    } catch (EOFException e) {
                        break; // Fin del archivo
                    }
                }
                oLector.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cochesDiesel;
    }

}
