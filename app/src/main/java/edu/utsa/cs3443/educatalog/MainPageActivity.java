package edu.utsa.cs3443.educatalog;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import edu.utsa.cs3443.educatalog.controller.CreateItemScreenController;
import edu.utsa.cs3443.educatalog.controller.DeleteItemController;
import edu.utsa.cs3443.educatalog.controller.EditItemScreenController;
import edu.utsa.cs3443.educatalog.model.Inventory;
import edu.utsa.cs3443.educatalog.model.InventoryItem;

/*
 * Iain Summerlin - tea587
 *
 *
 */
public class MainPageActivity extends AppCompatActivity {

    TableLayout tableLayout;
    public static int itemSelected;

    @Override
    /*
     * Sets the OnCreate method and takes in the bundle and saved Instance state.
     * OnCreate function makes all the avengers in a button and returns the setOnClicker.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        Button deleteitem = findViewById(R.id.button3);
        deleteitem.setOnClickListener(new DeleteItemController());

        Button signup = findViewById(R.id.button4);
        signup.setOnClickListener(new CreateItemScreenController());

        Button edititem = findViewById(R.id.button5);
        edititem.setOnClickListener(new EditItemScreenController());


        if (Inventory.getInventory() == null) {
            Inventory.buildInventory(getApplicationContext());
        }
        initializeTableLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fillTable();
    }

    private void fillTable() {
        Integer count = 0;
        List<InventoryItem> invList = Inventory.getInventory().getList();
        for (int i = 0; i < invList.size(); i++) {

            TableRow tableRow = new TableRow(MainPageActivity.this);
            //if (count % 2 != 0) {
            //    tableRow.setBackgroundColor(Color.GRAY);
            //}
            tableRow.setId(View.generateViewId());
            tableRow.setClickable(true);
            tableRow.setBackgroundResource(android.R.drawable.list_selector_background);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));

            TextView labelBarcode = new TextView(MainPageActivity.this);
            labelBarcode.setId(View.generateViewId());
            labelBarcode.setGravity(Gravity.CENTER);
            labelBarcode.setTextColor(Color.BLACK);
            labelBarcode.setTextSize(18);
            labelBarcode.setText(invList.get(i).getName());
            tableRow.addView(labelBarcode);

            TextView labelLocation = new TextView(MainPageActivity.this);
            labelLocation.setId(View.generateViewId());
            labelLocation.setGravity(Gravity.CENTER);
            labelLocation.setTextColor(Color.BLACK);
            labelLocation.setTextSize(18);
            labelLocation.setText(invList.get(i).getQty());
            tableRow.addView(labelLocation);

            TextView labelQuantity = new TextView(MainPageActivity.this);
            labelQuantity.setId(View.generateViewId());
            labelQuantity.setGravity(Gravity.CENTER);
            labelQuantity.setTextColor(Color.BLACK);
            labelQuantity.setTextSize(18);
            labelQuantity.setText(invList.get(i).getLastAction());
            tableRow.addView(labelQuantity);

            final int n = i;
            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemSelected = n;
                    //Toast.makeText(MainPageActivity.this, "Click item " + n, Toast.LENGTH_SHORT).show();
                    v.setBackgroundColor(Color.YELLOW);
                }
            });

            tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            count++;
        }
    }

    private void initializeTableLayout() {
        tableLayout = this.findViewById(R.id.tableLayout);
        TableRow tr_head = new TableRow(MainPageActivity.this);
        tr_head.setId(View.generateViewId());
        tr_head.setBackgroundColor(Color.parseColor("#673AB7"));
        tr_head.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

        TextView label_barcode = new TextView(MainPageActivity.this);
        label_barcode.setId(View.generateViewId());
        label_barcode.setText("Name");
        label_barcode.setTextSize(20);
        label_barcode.setTextColor(Color.WHITE);
        label_barcode.setGravity(Gravity.CENTER);
        tr_head.addView(label_barcode);// add the column to the table row here

        TextView label_location = new TextView(MainPageActivity.this);
        label_location.setId(View.generateViewId());// define id that must be         unique
        label_location.setText("Quantity"); // set the text for the header
        label_location.setTextSize(20);
        label_location.setTextColor(Color.WHITE); // set the color
        label_location.setGravity(Gravity.CENTER);
        tr_head.addView(label_location); // add the column to the table row here

        TextView label_quantity = new TextView(MainPageActivity.this);
        label_quantity.setId(View.generateViewId());// define id that must be         unique
        label_quantity.setText("Last Activity"); // set the text for the header
        label_quantity.setTextSize(20);
        label_quantity.setTextColor(Color.WHITE); // set the color
        label_quantity.setGravity(Gravity.CENTER);
        tr_head.addView(label_quantity); // add the column to the table row here

        tableLayout.setScrollContainer(true);
        tableLayout.addView(tr_head, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
    }

}