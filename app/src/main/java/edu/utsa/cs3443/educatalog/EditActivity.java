package edu.utsa.cs3443.educatalog;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.educatalog.controller.EditItemController;
import edu.utsa.cs3443.educatalog.model.Inventory;
import edu.utsa.cs3443.educatalog.model.InventoryItem;

public class EditActivity extends AppCompatActivity {
    public static EditText itemName, quantity;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        int n = MainPageActivity.itemSelected;
        InventoryItem item = Inventory.getInventory().getItem(n);

        TextView quantityView = findViewById(R.id.QuantityField);
        quantityView.setText(item.getQty());

        TextView itemView = findViewById(R.id.ItemNameField);
        itemView.setText(item.getName());

        TextView textView = (TextView) findViewById(R.id.TitleText);
        TextView itemNameText = (TextView) findViewById(R.id.ItemNameText);
        TextView quantityText = (TextView) findViewById(R.id.QuantityText);

        textView.setTextSize(40);
        textView.setTextColor(Color.BLUE);
        textView.setWidth(5);

        itemNameText.setTextSize(20);
        itemNameText.setTextColor(Color.BLUE);

        quantityText.setTextSize(20);
        quantityText.setTextColor(Color.BLUE);

        Button submit = findViewById(R.id.SubmitButton);
        itemName=(EditText)findViewById(R.id.ItemNameField);
        quantity=(EditText)findViewById(R.id.QuantityField);
        submit.setOnClickListener(new EditItemController());

    }
}
