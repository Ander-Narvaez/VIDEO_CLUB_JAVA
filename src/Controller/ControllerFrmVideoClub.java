package Controller;

import Model.ClsClient;
import Model.ClsMovie;
import Model.ClsReference;
import Model.ClsRentedProducts;
import Model.ClsVideogame;
import View.FrmVideoClub;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
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
    private ClsReference reference;
    private ClsRentedProducts rentalProduct;
    private ArrayList<ClsVideogame> arraysvideogame;
    private ArrayList<ClsMovie> arraysmovie;
    private ArrayList<ClsClient> arraysclient;
    private ArrayList<ClsReference> arraysReference;
    private ArrayList<ClsRentedProducts> arraysRentedProducts;
    private DefaultTableModel modelClient;
    private DefaultTableModel modelVideoGame;
    private DefaultTableModel modelMovie;
    private DefaultTableModel modelRentalProduct;
    private DefaultTableModel modelRented;
   

    public ControllerFrmVideoClub() {
        this.frmvideoclub = new FrmVideoClub();
        this.videogame = new ClsVideogame();
        this.movie = new ClsMovie();
        this.reference = new ClsReference();
        this.rentalProduct = new ClsRentedProducts();
        this.arraysvideogame = new ArrayList<ClsVideogame>();
        this.arraysmovie = new ArrayList<ClsMovie>();
        this.arraysclient = new ArrayList<ClsClient>();
        this.arraysReference = new ArrayList<ClsReference>();
        this.arraysRentedProducts = new ArrayList<ClsRentedProducts>();
        this.modelVideoGame = new DefaultTableModel();
        this.modelMovie = new DefaultTableModel();
        this.modelClient = new DefaultTableModel();
        this.modelRentalProduct = new DefaultTableModel();
        this.modelRented = new DefaultTableModel();
    }

    public void startMain() {
        this.frmvideoclub.setTitle("Video Club");
        this.frmvideoclub.setLocationRelativeTo(null);
        this.frmvideoclub.getPanels().setSelectedIndex(1);
        showInformation();
        this.frmvideoclub.setVisible(true);
        this.frmvideoclub.getBtnSaveProduct().addActionListener(this);
        this.frmvideoclub.getBtnSaveClient().addActionListener(this);
        this.frmvideoclub.getRbdMovie().addActionListener(this);
        this.frmvideoclub.getRbdVideoGame().addActionListener(this);
        this.frmvideoclub.getBtnSaveRental().addActionListener(this);
        
    }
    
    public void showInformation (){
        showMovie();
        showVideoGames();
        showClient();
        disable();
        showRentalClient();
        showRentalProduct();
        showRentedProducts();
    }
            

    @Override
    public void actionPerformed(ActionEvent event) {
        
        //BtnProduct
        if (event.getSource() == this.frmvideoclub.getBtnSaveProduct()) {
            
            this.reference = new ClsReference(this.frmvideoclub.getTxtTittle().getText(),
                                                  getselectedrbdType(),
                                                  Integer.parseInt(this.frmvideoclub.getTxtPrice().getText()),
                                                  (int) this.frmvideoclub.getSpnDays().getValue(),
                                                  getselectedrbdRent());
            this.arraysReference.add(reference);

            
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
                showInformation();
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
                showInformation();
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
             showInformation();
        }
        
        
        //BtnRental
        if(event.getSource() == this.frmvideoclub.getBtnSaveRental()){
            
            int fila = this.frmvideoclub.getTblClientRental().getSelectedRow();
            int filaProduct = this.frmvideoclub.getTblRentalProduct().getSelectedRow();
            
            if(fila >-1 && filaProduct >-1){
                   
                int id = (int) this.frmvideoclub.getTblClientRental().getValueAt(fila, 0);
                String name =  this.frmvideoclub.getTblClientRental().getValueAt(fila, 1).toString();
                String addres = this.frmvideoclub.getTblClientRental().getValueAt(fila, 2).toString();
                int telephone = (int) this.frmvideoclub.getTblClientRental().getValueAt(fila, 3);
                
                this.client = new ClsClient(id, name, addres, telephone);
                
                String title = this.frmvideoclub.getTblRentalProduct().getValueAt(filaProduct, 0).toString();
                String type = this.frmvideoclub.getTblRentalProduct().getValueAt(filaProduct, 1).toString();
                double price =  (double) this.frmvideoclub.getTblRentalProduct().getValueAt(filaProduct, 2);
                int year = (int) this.frmvideoclub.getTblRentalProduct().getValueAt(filaProduct, 3);
                String director =  this.frmvideoclub.getTblRentalProduct().getValueAt(filaProduct, 4).toString();
                
                this.reference =  new ClsReference(title, type, price, year, director);
                
                this.rentalProduct =  new ClsRentedProducts(client,
                                                            reference, 
                                                            this.frmvideoclub.getTxtRentalDate().getText(), 
                                                            this.frmvideoclub.getTxtReturnDate().getText(),
                                                            Double.parseDouble(this.frmvideoclub.getTxtAmount().getText()));
                
                this.arraysRentedProducts.add(rentalProduct);
                showInformation();
                this.frmvideoclub.getTxtRentalDate().setText("");
                this.frmvideoclub.getTxtReturnDate().setText("");
                this.frmvideoclub.getTxtAmount().setText("");
                this.frmvideoclub.getPanels().setSelectedIndex(7);
                               
            }                  
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
    
   public void showRentedProducts(){
        String [] title = {" Client Name", "Customer Phone",  "Product Name","Type Products", "Products Price", "Rental Date","Return Date", "Amount"};
        
        this.modelRented = new DefaultTableModel(null, title) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        
        for (int i = 0; i < this.arraysRentedProducts.size(); i++) {
            Object[] objeto = {this.arraysRentedProducts.get(i).getaClient().getaName(),
                               this.arraysRentedProducts.get(i).getaClient().getaTelephone(),
                               this.arraysRentedProducts.get(i).getaProduct().getaTitle(),
                               this.arraysRentedProducts.get(i).getaProduct().getaType(),
                               this.arraysRentedProducts.get(i).getaProduct().getaPriceRental(),
                               this.arraysRentedProducts.get(i).getaRentalDate(),
                               this.arraysRentedProducts.get(i).getaReturnDate(),
                               this.arraysRentedProducts.get(i).getaAmount()};
            this.modelRented.addRow(objeto);
        }
        
        this.frmvideoclub.getTblConsultRent().setModel(modelRented);
    }
    
    public void  showRentalProduct(){
        String [] title = {"Title", "Type", "Rental Price","Rental Term", "Rented"};
        
        this.modelRentalProduct = new DefaultTableModel(null, title) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        
         for (int i = 0; i < this.arraysReference.size(); i++) {
            Object[] objeto = {this.arraysReference.get(i).getaTitle(),
                               this.arraysReference.get(i).getaType(),
                               this.arraysReference.get(i).getaPriceRental(),
                               this.arraysReference.get(i).getaRentalTerm(),
                               this.arraysReference.get(i).getaRented()
                               };
            this.modelRentalProduct.addRow(objeto);
        }
        
        this.frmvideoclub.getTblRentalProduct().setModel(modelRentalProduct);
    }
    
    public void showRentalClient(){
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
        
        this.frmvideoclub.getTblClientRental().setModel(modelClient); 
    }
    
}
