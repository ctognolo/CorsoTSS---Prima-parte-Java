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
public class Utility {

    static int chiediIntero(String richiesta, String messaggio, String messaggio1, int min, int max) {
        //Dichiarazione variabile booleana per intercettare errore
        boolean gestErrore = true;
        //Dichiarazione e inizializzazione variabile di ritorno
        String strIntRis;
        int risultato = 0;
        //Ciclo inserimento dato con gestione errore
        while (gestErrore) {// gestErrore parte da true, ovvero si considera di partire da una situazione di errore
            //Inserimento dato
            strIntRis = JOptionPane.showInputDialog(null, "Inserisci " + richiesta + " (i valori devono essere compresi tra " + min + " e " + max + ")");
            //Elaborazione dato e gestione errore in input
            try {
                risultato = Integer.parseInt(strIntRis);
                if (risultato >= min && risultato <= max) {
                    gestErrore = false;
                } else {
                    JOptionPane.showMessageDialog(null, messaggio1);
                }
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, messaggio);
            }
        }
        //Ritorno il risultato
        return risultato;
    }

    static int chiediIntero(String richiesta, String messaggio) {
        //Dichiarazione variabile booleana per intercettare errore
        boolean gestErrore = true;
        //Dichiarazione e inizializzazione variabile di ritorno
        String strIntRis;
        int risultato = 0;
        //Ciclo inserimento dato con gestione errore
        while (gestErrore) {// gestErrore parte da true, ovvero si considera di partire da una situazione di errore
            //Inserimento dato
            strIntRis = JOptionPane.showInputDialog(null, "Inserisci " + richiesta);
            //Elaborazione dato e gestione errore in input
            try {
                risultato = Integer.parseInt(strIntRis);
                gestErrore = false;
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, messaggio);
            }
        }
        //Ritorno il risultato
        return risultato;
    }

    static int chiediIntero(String richiesta, String messaggio, String Cognome, String Nome) {
        //Dichiarazione variabile booleana per intercettare errore
        boolean gestErrore = true;
        //Dichiarazione e inizializzazione variabile di ritorno
        String strIntRis;
        int risultato = 0;
        //Ciclo inserimento dato con gestione errore
        while (gestErrore) {// gestErrore parte da true, ovvero si considera di partire da una situazione di errore
            //Inserimento dato
            strIntRis = JOptionPane.showInputDialog(null, "Inserisci " + richiesta + " dell'alunno " + Cognome + " " + Nome);
            //Elaborazione dato e gestione errore in input
            try {
                risultato = Integer.parseInt(strIntRis);
                gestErrore = false;
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, messaggio);
            }
        }
        //Ritorno il risultato
        return risultato;
    }

    static String mettiMaiuscola(String testo) {
        //Dichiarazione e inizializzazione variabile di ritorno
        String strRis = "";
        //Ciclo inserimento dato
        String iniz = testo.substring(0, 1).toUpperCase();
        String fine = testo.substring(1, testo.length()).toLowerCase();
        strRis = iniz + fine;
        //Ritorno il risultato
        return strRis;
    }

}
