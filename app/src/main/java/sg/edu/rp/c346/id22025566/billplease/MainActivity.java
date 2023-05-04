package sg.edu.rp.c346.id22025566.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {



    // Declare all variables
    TextView tvDisplayAmt;
    EditText etInputAmt;
    TextView tvDisplayPax;
    EditText etInputPax;
    ToggleButton tBtnSVS;
    ToggleButton tBtnGST;
    TextView tvDisplayDiscount;
    EditText etInputDiscount;
    RadioGroup rgPayment;
    Button btnSplit;
    Button btnReset;
    RadioButton rbPayCash;
    RadioButton rbPayNow;

    TextView tvDisplay;
    TextView tvDisplay2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding variable to UI element
        tvDisplayAmt=findViewById(R.id.textViewDisplayAmt);
        etInputAmt=findViewById(R.id.editTextInputAmt);
        tvDisplayPax=findViewById(R.id.textViewDisplayPax);
        etInputPax=findViewById(R.id.editTextInputPax);
        tBtnSVS=findViewById(R.id.toggleButtonSVS);
        tBtnGST=findViewById(R.id.toggleButtonGST);
        tvDisplayDiscount=findViewById(R.id.textViewDisplayDiscount);
        etInputDiscount=findViewById(R.id.editTextInputDiscount);
        rgPayment=findViewById(R.id.radioGroupPaymentMethod);
        btnSplit=findViewById(R.id.buttonSplit);
        btnReset=findViewById(R.id.buttonReset);
        rbPayCash=findViewById(R.id.radioButtonPayCash);
        rbPayNow=findViewById(R.id.radioButtonPayPayNow);
        tvDisplay=findViewById(R.id.tvDisplay);
        tvDisplay2=findViewById(R.id.tvDisplay2);





        btnReset.setOnClickListener(new View.OnClickListener() { // Reset all fields
            @Override
            public void onClick(View view) {
                // Add your code for the action
                String stringResponsePax= etInputPax.getText().toString();
                stringResponsePax="@string/enter_number_of_pax";

                String stringResponseAmt=etInputAmt.getText().toString();
                stringResponseAmt="@string/enter_amount";

                String stringResponseDiscount=etInputDiscount.getText().toString();
                stringResponseDiscount="@string/enter_discount";
            }
        });

        btnSplit.setOnClickListener(new View.OnClickListener() { // Starts process of splitting bills
            @Override
            public void onClick(View view) {
                // Add your code for the action

                // Retrieve amount entered
                String stringResponseAmount=etInputAmt.getText().toString();
                double doubleResponseAmount=Double.parseDouble(stringResponseAmount);

                // Retrieve number of pax
                String stringPaxAmount=etInputPax.getText().toString();
                int stringResponsePax=Integer.parseInt(stringPaxAmount);

                // Checks if SVS is enabled
                boolean isCheckedSVS=tBtnSVS.isChecked();

                // Checks if GST is enabled
                boolean isCheckedGST=tBtnGST.isChecked();

                //Retrieve discount
                String discount=etInputDiscount.getText().toString();
                double disc=Double.parseDouble(discount);

                double SVS=1.1;
                double GST=1.07;
                double total=0.0;
                String no="8786836";


                if (isCheckedSVS & isCheckedGST){
                     total=doubleResponseAmount*SVS*GST*(1-disc/100);
                }
                else if (isCheckedSVS){
                     total=doubleResponseAmount*SVS*(1-disc/100);
                }
                else if (isCheckedGST){
                    total=doubleResponseAmount*GST*(1-disc/100);
                }
                else{
                     total=doubleResponseAmount*(1-disc/100);
                }

                // how much each pays
                double each = total/stringResponsePax;


                tvDisplay1.setText("Total Cost: $" + total);

                if (rbPayCash.isChecked()){
                    tvDisplay2.setText("Each pays: $" + each + " to " + no);


                }
                if (rbPayNow.isChecked()){
                    tvDisplay2.setText("Each pays: $" + each + " in cash");
                }









            }
        });












    }
}