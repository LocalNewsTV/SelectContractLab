/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 *
 * @author Rawrg
 */
class ContractModel {
    private ArrayList<Contract> theContracts;
    private int contractCounter;
    String fileName = "C:\\Users\\Rawrg\\OneDrive\\School\\SelectContract\\contracts.txt";
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES = 4;
    public static final int INDEX_OF_CONTRACT_ID = 0;
    public static final int INDEX_OF_ORIGIN_CITY = 1;
    public static final int INDEX_OF_DEST_CITY = 2;
    public static final int INDEX_OF_ORDER_ITEM = 3;

    
    ContractModel () {
        
        this.contractCounter = 0;
        theContracts = new ArrayList<Contract>();
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] tokens = line.split(",", NUMBER_OF_CONTRACT_ATTRIBUTES);
                
                String contractID = tokens[INDEX_OF_CONTRACT_ID];
                String originCity = tokens[INDEX_OF_ORIGIN_CITY];
                String destCity = tokens[INDEX_OF_DEST_CITY];
                String orderItem = tokens[INDEX_OF_ORDER_ITEM];
                
                Contract dataContract = new Contract(contractID, originCity, destCity, orderItem);
                theContracts.add(dataContract);
            }
            fileReader.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean foundContract() {
        if(theContracts.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Contract getTheContract() {
        return theContracts.get(contractCounter);
    }
    
    public int getContractCount() {
        return theContracts.size();
    }
    public int getCurrentContractNum() {
        return contractCounter;
    }
    public void nextContract(){
        if(contractCounter + 1 <= theContracts.size()){
            contractCounter++;
        }
    }
    public void prevContract(){
        if(contractCounter - 1 >= 0){
            contractCounter--;     
        }
    }
}
