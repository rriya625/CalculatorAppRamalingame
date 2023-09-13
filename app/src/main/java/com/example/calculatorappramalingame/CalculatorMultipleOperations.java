package com.example.calculatorappramalingame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorMultipleOperations extends AppCompatActivity {


    //Diplay textView for inputs
    private TextView display;
    //numbers and operators the user clicks
    private String currentInput = "";
    //Answer/result
    private double result = 0;
    //String for operators
    private String operator = "";

    //Toast: https://stackoverflow.com/questions/3500197/how-to-display-toast-in-android
    public boolean showToast(){
        if(currentInput.equals("")){
            String message = "Cannot start with symbol!";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_multiple_operations);

        display = findViewById(R.id.textViewforinput);

        //Declaring and initializing buttons: https://stackoverflow.com/questions/21736187/button-button-findviewbyidr-id-button-always-resolves-to-null-in-android
        Button button0 = findViewById(R.id.button0id);
        Button button1 = findViewById(R.id.button1id);
        Button button2 = findViewById(R.id.button2id);
        Button button3 = findViewById(R.id.button3id);
        Button button4 = findViewById(R.id.button4id);
        Button button5 = findViewById(R.id.button5id);
        Button button6 = findViewById(R.id.button6id);
        Button button7 = findViewById(R.id.button7id);
        Button button8 = findViewById(R.id.button8id);
        Button button9 = findViewById(R.id.button9id);
        Button decimalButton = findViewById(R.id.buttonDecimalid);
        Button pieButton = findViewById(R.id.buttonpieid);
        Button addButton = findViewById(R.id.plusButton);
        Button subtractButton = findViewById(R.id.minusButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button divideButton = findViewById(R.id.divideButton);
        Button calculateButton = findViewById(R.id.equalsButton);
        Button clearButton = findViewById(R.id.buttonclearid);

        //OnClick ListenerMethod: https://stackoverflow.com/questions/25803727/android-setonclicklistener-method-how-does-it-work

        pieButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                currentInput += " 3.1415926535897932384626";
                updateDisplay(currentInput);
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                currentInput += "0";
                updateDisplay(currentInput);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput += "1";
                updateDisplay(currentInput);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput += "2";
                updateDisplay(currentInput);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput += "3";
                updateDisplay(currentInput);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput += "4";
                updateDisplay(currentInput);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput += "5";
                updateDisplay(currentInput);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput += "6";
                updateDisplay(currentInput);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput += "7";
                updateDisplay(currentInput);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput += "8";
                updateDisplay(currentInput);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput += "9";
                updateDisplay(currentInput);
            }
        });

        decimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput += ".";
                updateDisplay(currentInput);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!showToast()){
                    currentInput += "+";
                }
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!showToast()){
                    currentInput += "-";
                }
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!showToast()){
                    currentInput += "*";
                }
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!showToast()){
                    currentInput += "/";
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If-else if... statement checks if the string ends in an operator and removes it if it does. Displays a toast message if an operator was removed
                if(currentInput.substring(currentInput.length() - 1).equals("/")){
                    String error = "Cannot end with a symbol! (operator is excluded)";
                    Toast.makeText(CalculatorMultipleOperations.this,error,Toast.LENGTH_SHORT).show();
                    currentInput = currentInput.substring(0,currentInput.length()-1);
                    calculateExpression(currentInput);
                }
                else if(currentInput.substring(currentInput.length() - 1).equals("*")){
                    String error = "Cannot end with a symbol! (operator is excluded)";
                    Toast.makeText(CalculatorMultipleOperations.this,error,Toast.LENGTH_SHORT).show();
                    currentInput = currentInput.substring(0,currentInput.length()-1);
                    calculateExpression(currentInput);

                }
                else if(currentInput.substring(currentInput.length() - 1).equals("+")){
                    String error = "Cannot end with a symbol! (operator is excluded)";
                    Toast.makeText(CalculatorMultipleOperations.this,error,Toast.LENGTH_SHORT).show();
                    currentInput = currentInput.substring(0,currentInput.length()-1);
                    calculateExpression(currentInput);

                }
                else if (currentInput.substring(currentInput.length() - 1).equals("-")) {
                    String error = "Cannot end with a symbol! (operator is excluded)";
                    Toast.makeText(CalculatorMultipleOperations.this,error,Toast.LENGTH_SHORT).show();
                    currentInput = currentInput.substring(0,currentInput.length()-1);
                    calculateExpression(currentInput);
                }
                else{
                    calculateExpression(currentInput);
                }
            }
        });
    }
    //Enum: https://developer.android.com/reference/java/lang/Enum
    // Define an enum for mathematical operators
    enum Operator {
        ADDITION("+"),
        SUBTRACTION("-"),
        MULTIPLICATION("*"),
        DIVISION("/");

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }

        // Create a static method to find an Operator enum based on a given symbol
        /*public static Operator fromSymbol(String symbol) {
            for (Operator op : Operator.values()) {
                if (op.getSymbol().equals(symbol)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Invalid operator symbol: " + symbol);
        }

         */
    }

    //Calculates math with an operator and 2 numbers
    private double calculateOperator(Operator operator, double num1, double num2){
        switch (operator) {
            case ADDITION:
                return num1 + num2;
            case SUBTRACTION:
                return num1 - num2;
            case MULTIPLICATION:
                return num1 * num2;
            case DIVISION:
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    //Static method to find an Operator enum based on a given symbol
    private void calculateExpression(String currentInput) {
        //Patterns: https://developer.android.com/reference/android/util/Patterns
        List<String> userInputs = new ArrayList<>();
        // Use regular expressions to split the expression
        Pattern pattern = Pattern.compile("[-+*/]");
        //Matcher: https://developer.android.com/reference/java/util/regex/Matcher
        Matcher matcher = pattern.matcher(currentInput);
        List<String> elements = new ArrayList<>();

        int prevEnd = 0;
        while (matcher.find()) {

            //Below is to separate whole number and symbols  3+5/7
            //String match = matcher.group();
            //userInputs.add(match);

            int operatorIndex = matcher.start();
            if (operatorIndex > prevEnd) {
                String number = currentInput.substring(prevEnd, operatorIndex).trim();
                elements.add(number);
            }
            elements.add(matcher.group());
            prevEnd = matcher.end();
        }

        // Add the last number after the last operator
        if (prevEnd < currentInput.length()) {
            String lastNumber = currentInput.substring(prevEnd).trim();
            elements.add(lastNumber);
        }

        // Print the elements
        for (String element : elements) {
            userInputs.add(element);
        }
        System.out.println(userInputs);

        List<String> additionAndSubtractionList = new ArrayList<>();
        String num1 = userInputs.get(0);
        additionAndSubtractionList.add(num1);

        //For loop that calculates the multiplication and division math (PEMDAS)
        for (int i = 1; i < userInputs.size(); i++){
            if(userInputs.get(i).equals("/")){
                Double calcNumber = calculateOperator(Operator.DIVISION, Double.parseDouble(num1),Double.parseDouble(userInputs.get(i+1)));
                additionAndSubtractionList.set(additionAndSubtractionList.size()-1,Double.toString(calcNumber));
                i++;
            }
            else if(userInputs.get(i).equals("*")){
                Double calcNumber = calculateOperator(Operator.MULTIPLICATION, Double.parseDouble(num1),Double.parseDouble(userInputs.get(i+1)));
                additionAndSubtractionList.set(additionAndSubtractionList.size()-1,Double.toString(calcNumber));
                i++;
            }
            else{
                num1 = userInputs.get(i);
                additionAndSubtractionList.add(num1);
            }
        }
        System.out.println(additionAndSubtractionList);
        //For loop that calculates the addition and subtraction math (PEMDAS)
        Double num2 = Double.parseDouble(additionAndSubtractionList.get(0));
        for(int i = 1; i < additionAndSubtractionList.size(); i++){
            if(additionAndSubtractionList.get(i).equals("+")){
                Double calcNumber = calculateOperator(Operator.ADDITION, num2, Double.parseDouble(additionAndSubtractionList.get(i+1)));
                num2 = calcNumber;
                i++;
            }
            else if (additionAndSubtractionList.get(i).equals("-")){
                Double calcNumber = calculateOperator(Operator.SUBTRACTION, num2, Double.parseDouble(additionAndSubtractionList.get(i+1)));
                num2 = calcNumber;
                i++;
            }
        }

        updateDisplay(Double.toString(num2));

        /*
        String showToast = "";
        for (int i = 0; i < additionAndSubtractionList.size(); i++) {
            showToast += additionAndSubtractionList.get(i);
        }
        Toast.makeText(this, showToast, Toast.LENGTH_LONG).show();
        */

    }
    //Method that clears user input on a button click
    private void clear() {
        currentInput = "";
        result = 0;
        operator = "";
        updateDisplay(currentInput);
    }

    //Method that updates the display
    private void updateDisplay(String currentInput) {
        display.setText(currentInput.isEmpty() ? String.valueOf(result) : currentInput);
         // ? and : kind of like a if else... If its empty do "String.valueOf(result)" else do "currentInput"

        //Sets the text in the TextView named display based on the contents of currentInput and result.
        //If currentInput isn't empty it displays currentInput, else it displays the calculated result

        //isEmpty method: https://www.w3schools.com/java/ref_string_isempty.asp
        //valueOf method: https://www.geeksforgeeks.org/java-string-valueof/#
    }

}