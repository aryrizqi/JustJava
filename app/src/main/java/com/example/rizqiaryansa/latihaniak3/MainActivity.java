package com.example.rizqiaryansa.latihaniak3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    TextView priceTextView, quantityTextView, messageTextView;
    EditText namatext;
    CheckBox whippedcreamCb, chocolateCb;
    String message;
    int topping;
    Button btnincrement, btndecrement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceTextView = (TextView) findViewById(R.id.price_text_view);
        messageTextView = (TextView) findViewById(R.id.message_text_view);
        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        namatext = (EditText) findViewById(R.id.nama_text);
        whippedcreamCb = (CheckBox) findViewById(R.id.whipped_cream);
        chocolateCb = (CheckBox) findViewById(R.id.chocolate);
        btnincrement = (Button) findViewById(R.id.btn_increment);
        btndecrement = (Button) findViewById(R.id.btn_decrement);

        btnincrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity += 1;
                display(quantity);
            }
        });
    }

    /**
     * This method is called when the plus button is clicked.
     */
//    public void increment(View view) {
//        quantity = quantity + 1;
//        display(quantity);
//    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity -= 1;
        if (quantity < 0) {
            quantity = 0;
        }
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        message =  namatext.getText() + " memesan " + quantity + " Coffee\n";
//        String priceMessage = "Free";
//        displayMessage(priceMessage);
//        EditText harga = (EditText) findViewById(R.id.harga_view);
//        int hrg = harga.setText("" + number);
        if (whippedcreamCb.isChecked() && chocolateCb.isChecked()) {
            topping = 3;
            message = message +
                    "dengan topping " +  whippedcreamCb.getText() + " dan " + chocolateCb.getText() + "\n" +
                    "Total harga $" + ((quantity * 5) + (quantity * topping));
        } else if (chocolateCb.isChecked()) {
            topping = 2;
            message = message +
                    "dengan topping " + chocolateCb.getText() + "\n" +
                     "Total harga $" + ((quantity * 5) + (quantity * topping));
        } else if (whippedcreamCb.isChecked()) {
            topping = 1;
            message = message +
                    "dengan topping " + whippedcreamCb.getText() + "\n" +
                     "Total harga $" + ((quantity * 5) + (quantity * topping));
        } else {
            message = message + " tanpa toppping\n" +
                     "Total harga $" + ((quantity * 5) + (quantity * topping));
        }
        displayPrice((quantity * 5) + (quantity * topping));
        displayMessage(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {

        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        priceTextView.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        messageTextView.setText(message);
    }
}
