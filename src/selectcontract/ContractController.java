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

class ContractController {
    private final ContractView theView;
    private final ContractModel theModel;
    
    ContractController(ContractView theView, ContractModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addPrevListener(new PrevButtonListener());
        this.theView.addBidListener(new BidButtonListener());
        this.theView.addNextListener(new NextButtonListener());
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

}