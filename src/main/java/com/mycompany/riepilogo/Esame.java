/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.riepilogo;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class Esame {

    //Dichiarazione variabili comuni
    static String cognome[];
    static String nome[];
    static String esame;
    static String ammissione[];
    static String amm_yes;
    static String amm_no;
    static int voto[];
    static int soglia;
    static int votomax;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int scelta = -1;

        do {
            try {
                String strIntScelta = JOptionPane.showInputDialog(null, "Seleziona:"
                        + "\n"
                        + "\n1) Inizializza sessione"
                        + "\n2) Inserisci nominativi esaminandi"
                        + "\n3) Inserisci votazioni"
                        + "\n4) Presenta risultati"
                        + "\n"
                        + "\n0) Uscire"
                );
                scelta = Integer.parseInt(strIntScelta);

                switch (scelta) {
                    case 0:
                        break;
                    case 1:
                        //Richiama preparaEsame
                        preparaEsame();
                        break;
                    case 2:
                        //Richiama inizioSessione
                        inizioSessione();
                        break;
                    case 3:
                        //Richiama correzioneEsame
                        correzioneEsame();
                        break;
                    case 4:
                        //Richiama vistaTabellone
                        vistaTabellone();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, " Il valore deve essere numerico!");
                        scelta = -1;
                }
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, " Il valore deve essere numerico!");
                scelta = -1;
            }
        } while (scelta > 0);

    }

    static void preparaEsame() {
        //Inizializzazione variabili
        esame = JOptionPane.showInputDialog("Inserire nome esame");
        esame = esame.toUpperCase();
        votomax = Utility.chiediIntero("Inserire votazione massima", "Il valore deve essere numerico", "Superato il numero massimo", 1, 100);
        soglia = Utility.chiediIntero("soglia di ammissione", "Il valore deve essere numerico", "Superato il numero massimo", 1, votomax);
        amm_yes = JOptionPane.showInputDialog("Inserire dicitura per ammissione (es. ammesso, promosso", "Ammesso");
        amm_no = JOptionPane.showInputDialog("Inserire dicitura per NON ammissione (es. non ammesso, bocciato", "Non ammesso");
        int alunni = Utility.chiediIntero("Numero Alunni", "Il valore deve essere numerico", "Superato il numero massimo", 1, 100);
        //Inizializza arrays
        voto = new int[alunni];
        cognome = new String[alunni];
        nome = new String[alunni];
        ammissione = new String[alunni];

    }

    static void inizioSessione() {
        //Compilazione Nome e Cognome
        for (int i = 0; i < cognome.length; i++) {
            cognome[i] = JOptionPane.showInputDialog("Inserisci Cognome");
            nome[i] = JOptionPane.showInputDialog("Inserisci Nome");
            cognome[i] = cognome[i].toUpperCase();
            nome[i] = Utility.mettiMaiuscola(nome[i]);
        }

    }

    static void correzioneEsame() {
        //Compilazione votazioni
        for (int i = 0; i < cognome.length; i++) {

            voto[i] = Utility.chiediIntero("Inserisci Votazione", "Il valore deve essere numerico", cognome[i], nome[i]);
            //Verifica soglia e attribuzione risultato
            if (voto[i] < soglia) {
                ammissione[i] = amm_no.toUpperCase();
            } else {
                ammissione[i] = amm_yes.toUpperCase();
            }

        }
    }

    static void vistaTabellone() {
        //Costruisce la tabella con i risultati
        String visualizzazione = "";
        visualizzazione = visualizzazione + "Classe " + esame + "\nVotazioni"+"\n";
        for (int i = 0; i < cognome.length; i++) {
            visualizzazione = visualizzazione + " " + cognome[i] + " " + nome[i] + " - Voto: " + voto[i] + " [" + ammissione[i] + "]" + "\n";

        }
        JOptionPane.showMessageDialog(null, visualizzazione);
    }

}
