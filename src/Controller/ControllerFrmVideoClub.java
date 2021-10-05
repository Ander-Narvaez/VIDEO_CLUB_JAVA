package Controller;

import Model.ClsClient;
import Model.ClsMovie;
import Model.ClsVideogame;
import View.FrmVideoClub;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anarvaezgo
 */
public class ControllerFrmVideoClub implements ActionListener, KeyListener {

    private FrmVideoClub frmvideoclub;
    private ClsVideogame videogame;
    private ClsMovie movie;
    private ClsClient client;
    private ArrayList<ClsVideogame> arraysvideogame;
    private ArrayList<ClsMovie> arraysmovie;
    private ArrayList<ClsClient> arraysclient;
    private DefaultTableModel modelVideoGame;
    private DefaultTableModel modelMovie;
    private DefaultTableModel modelClient;

    public ControllerFrmVideoClub() {
        this.frmvideoclub = new FrmVideoClub();
        this.videogame = new ClsVideogame();
        this.movie = new ClsMovie();
        this.arraysvideogame = new ArrayList<ClsVideogame>();
        this.arraysmovie = new ArrayList<ClsMovie>();
        this.arraysclient = new ArrayList<ClsClient>();
        this.modelVideoGame = new DefaultTableModel();
        this.modelMovie = new DefaultTableModel();
        this.modelClient = new DefaultTableModel();
    }

    public void startMain() {
        this.frmvideoclub.setTitle("Video Club");
        this.frmvideoclub.setLocationRelativeTo(null);
        this.frmvideoclub.getPanels().setSelectedIndex(1);
        showMovie();
        showVideoGames();
        showClient();
        this.frmvideoclub.setVisible(true);
        this.frmvideoclub.getBtnSaveProduct().addActionListener(this);
        this.frmvideoclub.getBtnSaveClient().addActionListener(this);
        this.frmvideoclub.getRbdMovie().addActionListener(this);
        this.frmvideoclub.getRbdVideoGame().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        //BtnProduct
        if (event.getSource() == this.frmvideoclub.getBtnSaveProduct()) {
            
            System.out.println("click save");
            if(getselectedrbdType()== "Video Game"){
                
                System.out.println("videogame save");
                videogame = new ClsVideogame(this.frmvideoclub.getCmbStyle().getSelectedItem().toString(),
                                            this.frmvideoclub.getCmbPlatform().getSelectedItem().toString(),
                                            this.frmvideoclub.getTxtTittle().getText(),
                                            getselectedrbdType(),
                                            Integer.parseInt(this.frmvideoclub.getTxtPrice().getText()), 
                                            (int) this.frmvideoclub.getSpnDays().getValue(),
                                            getselectedrbdRent());
                System.out.println("new object video game "+videogame);
                this.arraysvideogame.add(videogame);
                showVideoGames();
                CleanFields();
                this.frmvideoclub.getCmbStyle().setSelectedIndex(0);
                this.frmvideoclub.getCmbPlatform().setSelectedIndex(0);
                disable();
            }else{
         
                System.out.println("movie save");
                 movie = new ClsMovie(this.frmvideoclub.getCmbGender().getSelectedItem().toString(),
                                            Integer.parseInt(this.frmvideoclub.getTxtYear().getText()),
                                            this.frmvideoclub.getTxtDirector().getText(),
                                            this.frmvideoclub.getTxtInterpreters().getText(),
                                            this.frmvideoclub.getTxtTittle().getText(),
                                            getselectedrbdType(),
                                            Integer.parseInt(this.frmvideoclub.getTxtPrice().getText()), 
                                            (int) this.frmvideoclub.getSpnDays().getValue(),
                                            getselectedrbdRent());
                System.out.println("new object movie"+movie);
                this.arraysmovie.add(movie);
                showMovie();
                CleanFields();
                this.frmvideoclub.getCmbGender().setSelectedIndex(0);
                this.frmvideoclub.getTxtYear().setText("");
                this.frmvideoclub.getTxtDirector().setText("");
                this.frmvideoclub.getTxtInterpreters().setText("");
                disable();
            }
        }
        
        
        
        if(event.getSource() == this.frmvideoclub.getRbdMovie() ){
            System.out.println("click movie");
            this.frmvideoclub.getCmbStyle().setEnabled(false);
            this.frmvideoclub.getCmbPlatform().setEnabled(false);
            this.frmvideoclub.getPanelInformationVideogame().setEnabled(false);  
            
            this.frmvideoclub.getPanelinformationMovie().setEnabled(true);
            this.frmvideoclub.getCmbGender().setEnabled(true);
            this.frmvideoclub.getTxtYear().setEnabled(true);
            this.frmvideoclub.getTxtDirector().setEnabled(true);
            this.frmvideoclub.getTxtInterpreters().setEnabled(true);
            
        } else if (this.frmvideoclub.getRbdVideoGame().isSelected()){
            System.out.println("click video game");
            this.frmvideoclub.getCmbStyle().setEnabled(true);
            this.frmvideoclub.getCmbPlatform().setEnabled(true);        
            this.frmvideoclub.getPanelInformationVideogame().setEnabled(true);   
            
            this.frmvideoclub.getPanelinformationMovie().setEnabled(false);
            this.frmvideoclub.getCmbGender().setEnabled(false);
            this.frmvideoclub.getTxtYear().setEnabled(false);
            this.frmvideoclub.getTxtDirector().setEnabled(false);
            this.frmvideoclub.getTxtInterpreters().setEnabled(false);
      
        }
        
        //BtnClient
        if(event.getSource() == this.frmvideoclub.getBtnSaveClient()){
             System.out.println("Client save");
             client = new ClsClient(Integer.parseInt(this.frmvideoclub.getTxtID().getText()),
                                    this.frmvideoclub.getTxtName().getText(),
                                    this.frmvideoclub.getTxtAddres().getText(),
                                    Integer.parseInt(this.frmvideoclub.getTxtTelephone().getText()));
                            
             System.out.println("new object client"+client);
             this.arraysclient.add(client);
             
             
             this.frmvideoclub.getTxtID().setText("");
             this.frmvideoclub.getTxtName().setText("");
             this.frmvideoclub.getTxtAddres().setText("");
             this.frmvideoclub.getTxtTelephone().setText("");
             showClient();
             
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    //Methods
    
    public String getselectedrbdType() {
        if (this.frmvideoclub.getRbdVideoGame().isSelected())return "Video Game";
        return "Movie";
    }

    public String getselectedrbdRent() {
        if (this.frmvideoclub.getRbdYes().isSelected()) return "Yes";
        return "Not";
    }
    
    
    public void showVideoGames(){
        String [] title = {"Title", "Type", "Rental Price","Rental Term", "Rented", "Style", "Platform"};
        
        this.modelVideoGame = new DefaultTableModel(null, title) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        
        for (int i = 0; i < this.arraysvideogame.size(); i++) {
            Object[] objeto = {this.arraysvideogame.get(i).getaTitle(),
                               this.arraysvideogame.get(i).getaType(),
                               this.arraysvideogame.get(i).getaPriceRental(),
                               this.arraysvideogame.get(i).getaRentalTerm(),
                               this.arraysvideogame.get(i).getaRented(),
                               this.arraysvideogame.get(i).getaStyle(),
                               this.arraysvideogame.get(i).getaPlatform()};
            this.modelVideoGame.addRow(objeto);
        }
        
        this.frmvideoclub.getTblVideoGames().setModel(modelVideoGame);
    }
    
    public void  showMovie(){
        String [] title = {"Title", "Type", "Rental Price","Rental Term", "Rented","Gender", "Year",
                           "Director", "Interpreters"};
        
        this.modelMovie = new DefaultTableModel(null, title) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        
         for (int i = 0; i < this.arraysmovie.size(); i++) {
            Object[] objeto = {this.arraysmovie.get(i).getaTitle(),
                               this.arraysmovie.get(i).getaType(),
                               this.arraysmovie.get(i).getaPriceRental(),
                               this.arraysmovie.get(i).getaRentalTerm(),
                               this.arraysmovie.get(i).getaRented(),
                               this.arraysmovie.get(i).getaGender(),
                               this.arraysmovie.get(i).getaYear(),
                               this.arraysmovie.get(i).getaDirector(),
                               this.arraysmovie.get(i).getaInterpreters()};
            this.modelMovie.addRow(objeto);
        }
        
        this.frmvideoclub.getTblmovies().setModel(modelMovie);
    }
    
    public void showClient(){
        String [] title = {"ID", "Name", "Addres","Telephone"};
        
        this.modelClient = new DefaultTableModel(null, title) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        
         for (int i = 0; i < this.arraysclient.size(); i++) {
            Object[] objeto = {this.arraysclient.get(i).getaId(),
                               this.arraysclient.get(i).getaName(),
                               this.arraysclient.get(i).getaAddres(),
                               this.arraysclient.get(i).getaTelephone()};
            this.modelClient.addRow(objeto);
        }
        
        this.frmvideoclub.getTblListClient().setModel(modelClient); 
    }
    
   public void CleanFields (){
       this.frmvideoclub.getTxtTittle().setText("");
       this.frmvideoclub.getTxtPrice().setText("");
       this.frmvideoclub.getButtonGroup1().clearSelection();
       this.frmvideoclub.getButtonGroup2().clearSelection();
       this.frmvideoclub.getSpnDays().setValue(0);
   }
   
   public void disable (){
        this.frmvideoclub.getPanelinformationMovie().setEnabled(false);
        this.frmvideoclub.getCmbGender().setEnabled(false);
        this.frmvideoclub.getTxtYear().setEnabled(false);
        this.frmvideoclub.getTxtDirector().setEnabled(false);
        this.frmvideoclub.getTxtInterpreters().setEnabled(false);
            
        this.frmvideoclub.getCmbStyle().setEnabled(false);
        this.frmvideoclub.getCmbPlatform().setEnabled(false);
        this.frmvideoclub.getPanelInformationVideogame().setEnabled(false); 
   }
   
   
}
