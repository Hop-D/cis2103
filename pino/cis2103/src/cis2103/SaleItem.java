/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cis2103;

/**
 *
 * @author Janica Nyle Pino
 */
public class SaleItem {
    int itemID;
    String itemName;
    int itemQty;
    int itemPrice;
    int subTotal;
    
    public SaleItem() {
        
    }
    
    public SaleItem(int itemID, String itemName, int itemQty, int itemPrice, int subTotal) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
        this.subTotal = subTotal;
    }
}
