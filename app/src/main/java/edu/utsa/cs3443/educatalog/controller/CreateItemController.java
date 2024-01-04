package edu.utsa.cs3443.educatalog.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import edu.utsa.cs3443.educatalog.CreateActivity;
import edu.utsa.cs3443.educatalog.MainPageActivity;
import edu.utsa.cs3443.educatalog.model.Inventory;
import edu.utsa.cs3443.educatalog.model.InventoryItem;

public class CreateItemController implements View.OnClickListener {

    /*
     * Sets the OnClick method and takes in the view.
     * OnClick function makes all the avengers in a view.
     */
    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        String itemName = CreateActivity.itemName.getText().toString();
        String quantity = CreateActivity.quantity.getText().toString();

        InventoryItem i = new InventoryItem(itemName, quantity, quantity);
        Inventory.getInventory().addItem(i);

        Intent intent = new Intent(context, MainPageActivity.class);
        context.startActivity(intent);
    }
}