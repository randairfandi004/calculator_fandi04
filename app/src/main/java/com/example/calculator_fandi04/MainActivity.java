package com.example.calculator_fandi04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b0;
    private Button b_equal;
    private Button b_multi;
    private Button b_divide;
    private Button b_add;
    private Button b_sub;
    private Button b_clear;
    private Button b_delete;
    private Button b_dot;
    private Button b_para1;
    private Button b_para2;
    private TextView inputText;
    private TextView outputText;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '=';
    private final char EXTRA = '@';
    private final char MODULUS = '%';
    private char ACTION;
    private double val1 = Double.NaN;
    private double val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSetup();

        b1.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ifErrorOnOutput();
                exceedLength();
                inputText.setText(inputText.getText().toString()+"1");
            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputText.setText(inputText.getText().toString() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ifErrorOnOutput();
                exceedLength();
                inputText.setText(inputText.getText().toString() + "3");

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputText.setText(inputText.getText().toString() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputText.setText(inputText.getText().toString() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputText.setText(inputText.getText().toString() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputText.setText(inputText.getText().toString() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputText.setText(inputText.getText().toString() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputText.setText(inputText.getText().toString() + "9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                inputText.setText(inputText.getText().toString() + "0");
            }
        });

        b_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                inputText.setText(inputText.getText().toString() + ".");
            }
        });

        b_para1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputText.getText().length() > 0) {
                    ACTION = MODULUS;
                    operation();
                    if (!ifReallyDecimal()) {
                        outputText.setText(val1 + "%");
                    } else {
                        outputText.setText((int) val1 + "%");
                    }
                    inputText.setText(null);
                } else {
                    outputText.setText("Error");
                }
            }
        });

        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputText.getText().length() > 0) {
                    ACTION = ADDITION;
                    operation();
                    if (!ifReallyDecimal()) {
                        outputText.setText(val1 + "+");
                    } else {
                        outputText.setText((int) val1 + "+");
                    }
                    inputText.setText(null);
                } else {
                    outputText.setText("Error");
                }
            }
        });

        b_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputText.getText().length() > 0) {
                    ACTION = SUBTRACTION;
                    operation();
                    if (inputText.getText().length() > 0)
                        if (!ifReallyDecimal()) {
                            outputText.setText(val1 + "-");
                        } else {
                            outputText.setText((int) val1 + "-");
                        }
                    inputText.setText(null);
                } else {
                    outputText.setText("Error");
                }
            }
        });

        b_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputText.getText().length() > 0) {
                    ACTION = MULTIPLICATION;
                    operation();
                    if (!ifReallyDecimal()) {
                        outputText.setText(val1 + "×");
                    } else {
                        outputText.setText((int) val1 + "×");
                    }
                    inputText.setText(null);
                } else {
                    outputText.setText("Error");
                }
            }
        });

        b_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputText.getText().length() > 0) {
                    ACTION = DIVISION;
                    operation();
                    if (ifReallyDecimal()) {
                        outputText.setText((int) val1 + "÷");
                    } else {
                        outputText.setText(val1 + "÷");
                    }
                    inputText.setText(null);
                } else {
                    outputText.setText("Error");
                }
            }
        });

        b_para2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!outputText.getText().toString().isEmpty() || !inputText.getText().toString().isEmpty()) {
                    val1 = Double.parseDouble(inputText.getText().toString());
                    ACTION = EXTRA;
                    outputText.setText("-" + inputText.getText().toString());
                    inputText.setText("");
                } else {
                    outputText.setText("Error");
                }
            }
        });

        b_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputText.getText().length() > 0) {
                    operation();
                    ACTION = EQU;
                    if (!ifReallyDecimal()) {
                        outputText.setText(/*t2.getText().toString() + String.valueOf(val2) + "=" + */String.valueOf(val1));
                    } else {
                        outputText.setText(/*t2.getText().toString() + String.valueOf(val2) + "=" + */String.valueOf((int) val1));
                    }
                    inputText.setText(null);
                } else {
                    outputText.setText("Error");
                }
            }
        });

        b_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputText.getText().length() > 0) {
                    CharSequence name =inputText.getText().toString();
                    inputText.setText(name.subSequence(0, name.length() - 1));
                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    inputText.setText("");
                    outputText.setText("");
                }
            }
        });

        // Assuming b_clear is your AC button
        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                inputText.setText("");
                outputText.setText("");
            }
        });
    }
    private void operation() {
        if (!Double.isNaN(val1)) {
            if (outputText.getText().toString().charAt(0) == '-') {
                val1 = (-1) * val1;
            }
            val2 = Double.parseDouble(inputText.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EXTRA:
                    val1 = (-1) * val1;
                    break;
                case MODULUS:
                    val1 = val1 % val2;
                    break;
                case EQU:
                    break;
            }
        } else {
            val1 = Double.parseDouble(inputText.getText().toString());
        }
    }
    // Make text small if too many digits.
    private void viewSetup(){
        b1 = findViewById(R.id.satu_btn);
        b2 = findViewById(R.id.dua_btn);
        b3 = findViewById(R.id.tiga_btn);
        b4 = findViewById(R.id.empat_btn);
        b5 = findViewById(R.id.lima_btn);
        b6 = findViewById(R.id.enam_btn);
        b7 = findViewById(R.id.tutjuh_btn);
        b8 = findViewById(R.id.lapan_btn);
        b9 = findViewById(R.id.semb_btn);
        b0 = findViewById(R.id.nol_btn);
        b_equal = findViewById(R.id.hasil_btn);
        b_multi = findViewById(R.id.kali_btn);
        b_divide = findViewById(R.id.bagi_btn);
        b_add = findViewById(R.id.tambah_btn);
        b_sub = findViewById(R.id.kurang_btn);
        b_clear = findViewById(R.id.ac_btn);
        b_delete = findViewById(R.id.del_btn);

        b_dot = findViewById(R.id.koma_btn);
        b_para1 = findViewById(R.id.plusmin_btn);
        b_para2 = findViewById(R.id.plusmin_btn);
        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);
    }
    //Error Handling
    private void exceedLength(){
        if (inputText.getText().toString().length() > 10) {
            inputText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
    }
    // Remove error message that is already written there.
    private void ifErrorOnOutput() {
        if (outputText.getText().toString().equals("Error")) {
            outputText.setText("");
        }
    }

    // Whether value if a double or not
    private boolean ifReallyDecimal() {
        return val1 == (int) val1;
    }

    private void noOperation() {
        String inputExpression = outputText.getText().toString();
        if (!inputExpression.isEmpty() && !inputExpression.equals("Error")) {
            if (inputExpression.contains("-")) {
                inputExpression = inputExpression.replace("-", "");
                outputText.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("+")) {
                inputExpression = inputExpression.replace("+", "");
                outputText.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("/")) {
                inputExpression = inputExpression.replace("/", "");
                outputText.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("%")) {
                inputExpression = inputExpression.replace("%", "");
                outputText.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("×")) {
                inputExpression = inputExpression.replace("×", "");
                outputText.setText("");
                val1 = Double.parseDouble(inputExpression);
            }
        }
    }
}