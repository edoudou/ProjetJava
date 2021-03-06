/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Classes.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc2014.SSHTunnel;

/**
 *
 * @author Jack
 */
public class connexion {
    Connection link = null;
    SSHTunnel ssh;
    public connexion(){
        
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            System.out.println("Probleme de driver");
        }
        try {
            //link = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
            //link = DriverManager.getConnection("jdbc:mysql://srv-webA2.ece.fr","short-rw","lzYKntDA");
            //setLinkECE("short","34694462@ZERed","lzYKntDA");
            setLink();
        } catch (SQLException ex) {
            System.out.println("Probleme de connexion a la base de donnée");
        }
    }
    
    public Docteur[] SearchDoctor(String req){
        Docteur[] tabDoc;
        try {
            Statement requete = link.createStatement();
            ResultSet result = requete.executeQuery(req);
            
            tabDoc = null;
            if(result!=null){
                for(int n = 1; result.next() ;n++){
                    Docteur[] tabCopy = tabDoc;
                    tabDoc = new Docteur[n];

                    if(tabCopy!=null)System.arraycopy(tabCopy, 0, tabDoc, 0, n-1);

                    tabDoc[n-1] = new Docteur(result.getString("specialite"),result.getInt("numero"),result.getString("nom"),result.getString("prenom"),result.getInt("tel"),result.getString("adresse"));
                }
            }
            
            return tabDoc;
            
        } catch (SQLException ex) {
            System.out.println("Probleme de Creation de requete");
        }
        
        return null;
    }
    
    public Infirmier[] SearchInfirmier(String req){
        Infirmier[] tabInf;
        try {
            Statement requete = link.createStatement();
            ResultSet result = requete.executeQuery(req);
            
            
            
            tabInf = null;
            for(int n = 1; result.next() ;n++){
                
                Infirmier[] tabCopy = tabInf;
                tabInf = new Infirmier[n];
                
                if(tabCopy!=null)System.arraycopy(tabCopy, 0, tabInf, 0, n-1);
                
                tabInf[n-1] = new Infirmier(result.getString("code_service"),result.getString("rotation"),result.getDouble("salaire"),result.getInt("numero"),result.getString("nom"),result.getString("prenom"),result.getInt("tel"),result.getString("adresse"));
                
            }
            
            return tabInf;
            
        } catch (SQLException ex) {
            System.out.println("Probleme de Creation de requete");
        }
        
        return null;
    }
    
    public Patient[] SearchPatient(String req){
        Patient[] tabPat;
        try {
            
            
            Statement requete = link.createStatement();
            ResultSet result = requete.executeQuery(req);
            
            tabPat = null;
            for(int n = 1; result.next() ;n++){
                Patient[] tabCopy = tabPat;
                tabPat = new Patient[n];
                
                if(tabCopy!=null)System.arraycopy(tabCopy, 0, tabPat, 0, n-1);
                
                if(result.getString("h.no_malade")==null)tabPat[n-1] = new Patient(result.getString("m.mutuelle"),result.getInt("m.numero"),result.getString("m.nom"),result.getString("m.prenom"),result.getInt("m.tel"),result.getString("m.adresse"));
                else tabPat[n-1] = new Patient(result.getString("m.mutuelle"),new Hospitalisation(result.getString("s.nom"),result.getInt("h.no_chambre"),result.getInt("h.lit")),result.getInt("m.numero"),result.getString("m.nom"),result.getString("m.prenom"),result.getInt("m.tel"),result.getString("m.adresse"));
            }
            
            return tabPat;
            
        } catch (SQLException ex) {
            System.out.println("Probleme de Creation de requete");
        }
        
        return null;
    }
    
    public Service[] SearchService(String req){
        Service[] tabPat;
        try {
            Statement requete = link.createStatement();
            ResultSet result = requete.executeQuery(req);

            tabPat = null;
            for(int n = 1; result.next() ;n++){
                Service[] tabCopy = tabPat;
                tabPat = new Service[n];
                
                if(tabCopy!=null)System.arraycopy(tabCopy, 0, tabPat, 0, n-1);
                
                tabPat[n-1] = new Service(result.getString("code"),result.getString("s.nom"),result.getString("batiment"),result.getString("e.nom"));
            }
            
            return tabPat;
            
        } catch (SQLException ex) {
            System.out.println("Probleme de Creation de requete");
        }
        
        return null;
    }
    
    public boolean updateData(String req){
        try {
            Statement requete = link.createStatement();
            requete.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println("Probleme durant la mise a jour de données");
            return false;
        }
    }
    
    public void setLinkECE(String User,String MDP,String MDPSQL) throws SQLException{
        ssh = new SSHTunnel(User,MDP);
        if (ssh.connect()) {
            System.out.println("Connexion reussie");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3305/" + User;
            
            //création d'une connexion JDBC à la base
            link = DriverManager.getConnection(urlDatabase, User+"-rw" , MDPSQL);
        }
    }
    
    public void setLink(Connection link){
        this.link = link;

    }
    
    public void setLink() throws SQLException{
        link = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");

    }
    
    public int getA_I(){
        int maxE,maxM;
        try {
            Statement requete = link.createStatement();
            ResultSet result = requete.executeQuery("SELECT max(numero) FROM malade");
            result.next();
            maxM = result.getInt("max(numero)");
            
            ResultSet result2 = requete.executeQuery("SELECT max(numero) FROM employe");
            result2.next();
            maxE = result2.getInt("max(numero)");
            
            if(maxM < maxE)
                return maxE;
            else
                return maxM;
            
        } catch (SQLException ex) {
            System.out.println("Probleme de Creation de requete");
        }
        return -1;
    }
    
    public String[][] getServicePatient(){
        String[][] tab = new String[0][2];
        try {
            Statement requete = link.createStatement();
            ResultSet result = requete.executeQuery("SELECT s.nom, count(m.numero) FROM service s LEFT JOIN (malade m JOIN hospitalisation h ON m.numero = h. no_malade) ON h.code_service = s.code GROUP BY s.nom");
            
            for(int n = 1; result.next() ;n++){
                
                String[][] tabCopy = tab;
                

                
                tab = new String[n][2];
                if(tabCopy!=null)System.arraycopy(tabCopy, 0, tab, 0, n-1);
                tab[n-1][0] = result.getString("count(m.numero)");
                tab[n-1][1] = result.getString("s.nom");
            }
            
            return tab;
            
        } catch (SQLException ex) {
            System.out.println("Probleme de Creation de requete");
        }
        return null;
    }
    
    public String[][] getDoctorPatient(){
        String[][] tab = null;
        try {
            Statement requete = link.createStatement();
            ResultSet result = requete.executeQuery("SELECT e.nom, count(m.numero) FROM (employe e JOIN docteur d ON d.numero = e.numero)LEFT JOIN (malade m JOIN soigne s ON m.numero = no_malade) ON e.numero = no_docteur GROUP BY e.nom");

            
            for(int n = 1; result.next() ;n++){
                
                
                String[][] tabCopy = tab;
                
                tab = new String[n][2];
                if(tabCopy!=null)System.arraycopy(tabCopy, 0, tab, 0, n-1);

                
                tab[n-1][0] = result.getString("count(m.numero)");
                tab[n-1][1] = result.getString("e.nom");
            }
            
            return tab;
            
        } catch (SQLException ex) {
            System.out.println("Probleme de Creation de requete");
        }
        return null;
    }
}
