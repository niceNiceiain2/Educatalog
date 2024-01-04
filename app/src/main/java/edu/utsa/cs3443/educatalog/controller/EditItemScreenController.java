package edu.utsa.cs3443.educatalog.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import edu.utsa.cs3443.educatalog.CreateActivity;
import edu.utsa.cs3443.educatalog.EditActivity;
import edu.utsa.cs3443.educatalog.MainPageActivity;
import edu.utsa.cs3443.educatalog.R;
import edu.utsa.cs3443.educatalog.model.Inventory;
import edu.utsa.cs3443.educatalog.model.InventoryItem;

public class EditItemScreenController implements View.OnClickListener {

    /*
     * Sets the OnClick method and takes in the view.
     * OnClick function makes all the avengers in a view.
     */
    @Override
    public void onClick(View view) {
        Context s = view.getContext();

        /*
         * Sets the context and gets the Context.
         * CharSequence has av.toString as all the avengers in a button and returns the duration.
         */
        Context context = view.getContext();

        Intent intent = new Intent(context, EditActivity.class);
        context.startActivity(intent);
    }
}
