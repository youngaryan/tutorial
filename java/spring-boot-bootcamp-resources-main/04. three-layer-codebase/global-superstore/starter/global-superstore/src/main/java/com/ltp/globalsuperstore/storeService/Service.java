package com.ltp.globalsuperstore.storeService;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.storeReopository.Respository;

public class Service {
    private Respository respository = new Respository();

     public void addItem(Item item){
        respository.addItem(item);
    }

    public void updateItem(int index, Item item){
        respository.updateItem(index, item);
    }

    public Item getItemByIndex(int index){
        return respository.getItemByIndex(index);
    }

    public List<Item> getAllItems(){
        return respository.getAllItems();
    }

    public String handleStatus(Item item){
        int index = getIndexFromId(item.getId());
        String status = Constants.SUCCESS_STATUS;
        if (index == Constants.NOT_FOUND) {
            addItem(item);
        } else if (within5Days(item.getDate(), getItemByIndex(index).getDate())) {
            updateItem(index, item);
        } else {
            status = Constants.FAILED_STATUS;
        }
        return status;
    }

    public int getIndexFromId(String id) {
        for (int i = 0; i < getAllItems().size(); i++) {
                if (getItemByIndex(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

    public boolean discountCheck(Item item){
        if(item.getPrice() != null && item.getDiscount() !=null){
            return item.getPrice() <= item.getDiscount();
        }
        return true;
    }

    public Item handleSubmit(String id){
        int index = getIndexFromId(id);
        return index == Constants.NOT_FOUND ? new Item() : getItemByIndex(index);

    }
}
