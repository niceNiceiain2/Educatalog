package edu.utsa.cs3443.educatalog.controller;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import edu.utsa.cs3443.educatalog.MainPageActivity;
import edu.utsa.cs3443.educatalog.model.Inventory;
import edu.utsa.cs3443.educatalog.model.InventoryItem;

public class DeleteItemController implements View.OnClickListener {

    /*
     * Sets the OnClick method and takes in the view.
     * OnClick function makes all the avengers in a view.
     */
    @Override
    public void onClick(View view) {
        Context context = view.getContext();

        int n = MainPageActivity.itemSelected;
        InventoryItem item = Inventory.getInventory().getItem(n);

        Inventory.getInventory().deleteItem(item.getName());

        Toast toast = Toast.makeText(context, item.getName() + " Deleted",Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(context, MainPageActivity.class);
        context.startActivity(intent);
    }
}