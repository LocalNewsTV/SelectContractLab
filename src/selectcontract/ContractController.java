/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract;

/**
 *
 * @author Rawrg
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class ContractController {
    private ContractView theView;
    private ContractModel theModel;
    
    ContractController(ContractView theView, ContractModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addPrevListener(new PrevButtonListener());
        this.theView.addBidListener(new BidButtonListener());
        this.theView.addNextListener(new NextButtonListener());
        this.theView.addcomboBoxListener(new ComboListener());
        this.theView.setOriginCityList(this.theModel.getOriginCityList());
        this.theView.addMenuAddContractListener(new AddContractListener());
        setUpDisplay();
    }
    
    private void setUpDisplay() {
        try {
            if(theModel.getContractCount() > 0){
                Contract c = theModel.getTheContract();
                theView.setContractID(c.getContractID());
                theView.setDestCity(c.getDestCity());
                theView.setOriginCity(c.getOriginCity());
                theView.setOrderItem(c.getOrderItem());
                theView.updateContractViewPanel(theModel.getCurrentContractNum(), theModel.getContractCount());
            }
            else{
            theView.setContractID("???");
            theView.setDestCity("???");
            theView.setOriginCity("???");
            theView.setOrderItem("???");
            }
        }
        catch (Error ex) {
            //Provide an error mesage to the console output.
            System.out.println(ex);
            theView.displayErrorMessage("Error: There was a problem setting the contract.\n Contract number: " + theModel.getCurrentContractNum());
        }
    }
    
    class PrevButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (theModel.getCurrentContractNum() == 0){
                
                return;
            }
            
            try {
                //Retrieve the contract behind the currently displayed contract
                theModel.prevContract();
            }
            catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
            }
            setUpDisplay();
        }
    }
        class NextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (theModel.getCurrentContractNum() == theModel.getContractCount()){
                return;
            }
            
            try {
                //Retrieve the contract behind the currently displayed contract
                theModel.nextContract();
            }
            catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
            }
            setUpDisplay();
        }
    }
            class BidButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ConfirmBid cb;
                cb = new ConfirmBid(theView, true, theModel.getTheContract());
                cb.setLocationRelativeTo(null);
                cb.setVisible(true);
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Error: the numbers entered must be integers.");
            }
        }
    }
    class AddContractListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                AddContract ac = new AddContract(theView, true);
                ac.setLocationRelativeTo(null);
                ac.setVisible(true);
            } catch (Exception ex){
                System.out.println(ex);
                theView.displayErrorMessage("Error!");
            } finally{
                theView.setOriginCityList(theModel.getOriginCityList());
                theModel = new ContractModel();
                setUpDisplay();
            }
        }
    }
      
    class ComboListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e){
        System.out.println(e.getItem().toString());
        if(e.getStateChange() == ItemEvent.SELECTED) {}
            String selectedCity = e.getItem().toString();
            System.out.println(selectedCity);
            theModel.updateContractList(selectedCity);
            setUpDisplay();
        }
        
    }
}
