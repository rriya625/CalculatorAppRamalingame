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
    //Setting Pie as a final variable
    private static final String PIE = "3.1415926535897932384626";
    //Diplay textView for inputs
    private TextView display;
    //numbers and operators the user clicks
    private String currentInput = "";
    //Answer/result
    private double result = 0;
    //String for operators
    private String operator = "";
    //Boolean that stops the calculation if an impossible calculation occurs (Division by zero)
    private boolean stopCalculation = false;

    //Toast: https://stackoverflow.com/questions/3500197/how-to-display-toast-in-android
    //Function that shows different toast messages
    public void ShowUserError(String messageToUser){
        Toast.makeText(this, messageToUser, Toast.LENGTH_SHORT).show();
    }
    //Function that checks if the user input starts with a symbol and displays a toast if it does
    public boolean isStartWithSymbol(){
        if(currentInput.equals("")){
            ShowUserError("Cannot start with symbol!");
            return true;
        }
        else{
            return false;
        }
    }

    //Boolean function that gives a toast if an operator is already entered and prompts the user to enter the next number otherwise returns false
    public boolean isLastCharOperator(String input) {
        if (input.length() > 0) {
            char lastChar = input.charAt(input.length() - 1);
            if  (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
                ShowUserError("Already entered operator! '" + lastChar + "' enter the next number");
                return  true;
            }
        }
        return false; // Return false for an empty string
    }
    //Boolean function that gives a toast if a decimal is already entered and prompts the user to enter the next digit/operator otherwise returns false
    public boolean isLastCharPeriod(String input){
        if (input.length() > 0) {
            char lastChar = input.charAt(input.length() - 1);
            if (lastChar == '.') {
                ShowUserError("Already entered '" + lastChar + "' enter the next digit/operator");
                return true;
            }
        }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_multiple_operations);

        //Textview that displays the input/answers
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
                // Check if the last characters of currentInput are not equal to the constant string
                if (currentInput.trim().equals("")){
                    currentInput += PIE;
                    updateDisplay(currentInput);
                }
                //checks if the current input doesn't already have pie and a number 0-9
                else if (!currentInput.endsWith(PIE) && (!currentInput.matches(".*[0-9]$")) ){
                        currentInput += PIE;
                        updateDisplay(currentInput);
                }
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
                if(!isLastCharPeriod(currentInput) && !currentInput.endsWith(PIE)) {
                    currentInput += ".";
                    updateDisplay(currentInput);
                }
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isStartWithSymbol() && !isLastCharOperator(currentInput)){
                    calcuateCurrentValueOnOperatorClick();
                    if(!currentInput.trim().equals("")) {
                        currentInput += "+";
                        updateDisplay(currentInput);
                    }
                }
            }
        });
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isStartWithSymbol() && !isLastCharOperator(currentInput)){
                    calcuateCurrentValueOnOperatorClick();
                    if(!currentInput.trim().equals("")) {
                        currentInput += "-";
                        updateDisplay(currentInput);
                    }

                }
            }
        });
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isStartWithSymbol() && !isLastCharOperator(currentInput)){
                    calcuateCurrentValueOnOperatorClick();
                    if(!currentInput.trim().equals("")) {
                        currentInput += "*";
                        updateDisplay(currentInput);
                    }
                }
            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isStartWithSymbol() && !isLastCharOperator(currentInput)){
                    calcuateCurrentValueOnOperatorClick();
                    if(!currentInput.trim().equals("")) {
                        currentInput += "/";
                        updateDisplay(currentInput);
                    }

                }
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //Clear button
            public void onClick(View v) {
                clear();
            }
        });
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcuateCurrentValue();
            }
        });
    }
    private void calcuateCurrentValue(){
        if (!currentInput.trim().equals("")) {
           // If-else if... statement checks if the string ends in an operator and removes it if it does. Displays a toast message if an operator was removed
            if (currentInput.endsWith("/") || currentInput.endsWith("*") ||
                    currentInput.endsWith("+") || currentInput.endsWith("-")) {
                currentInput.substring(0, currentInput.length() - 1);
            }
            calculateExpression(currentInput);
        }
    }
    //Function that calculates the values as the user inputs it
    private void calcuateCurrentValueOnOperatorClick(){
        if (currentInput.contains("/") || currentInput.contains("*") ||
                currentInput.contains("+") || currentInput.contains("-")) {
            calculateExpression(currentInput);
        }
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
    //Method to find an Operator enum based on a given symbol
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
                    stopCalculation = true;
                    ShowUserError("Division by zero not allowed");
                    return 0;
                }
                else {
                    return num1 / num2;
                }
            default: {
                stopCalculation = true;
                ShowUserError("Division by zero not allowed");
                return 0;
            }
        }
    }
    //Function tht calculates the user input
    private void calculateExpression(String currentInput){
        //Patterns: https://developer.android.com/reference/android/util/Patterns
        List<String> userInputs = new ArrayList<>();
        // Use regular expressions to split the expression
        Pattern pattern = Pattern.compile("[-+*/]");
        //Matcher: https://developer.android.com/reference/java/util/regex/Matcher
        Matcher matcher = pattern.matcher(currentInput);
        List<String> elements = new ArrayList<>();

        int prevEnd = 0;
        while (matcher.find()) {

            //Below is to separate whole numbers and symbols  3+5/7
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

        //For loop that calculates the math
        //stopCalculation is false b/c the answer is not defined yet
        stopCalculation = false;
        for (int i = 1; i < userInputs.size(); i++){
            //If stopCalculation is true -- breaks the loop -- answer is undefined
            if (stopCalculation){
                this.currentInput = "";
                updateDisplay(this.currentInput);
                break;
            }
            //If the input is division, division occurs
            if(userInputs.get(i).equals("/")){
                Double calcNumber = calculateOperator(Operator.DIVISION, Double.parseDouble(num1),Double.parseDouble(userInputs.get(i+1)));
                additionAndSubtractionList.set(additionAndSubtractionList.size()-1,Double.toString(calcNumber));
                i++;
            }
            //If the input is multiplication, multiplication occurs
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
        //System.out.println(additionAndSubtractionList);
        Double num2 = Double.parseDouble(additionAndSubtractionList.get(0));
        if (!stopCalculation) {
            for (int i = 1; i < additionAndSubtractionList.size(); i++) {
                //If the input is addition, addition occurs
                if (additionAndSubtractionList.get(i).equals("+")) {
                    Double calcNumber = calculateOperator(Operator.ADDITION, num2, Double.parseDouble(additionAndSubtractionList.get(i + 1)));
                    num2 = calcNumber;
                    i++;
                }
                //If the input is subtraction, subtraction occurs
                else if (additionAndSubtractionList.get(i).equals("-")){
                    Double calcNumber = calculateOperator(Operator.SUBTRACTION, num2, Double.parseDouble(additionAndSubtractionList.get(i + 1)));
                    num2 = calcNumber;
                    i++;
                }
            }
        }
        if(stopCalculation){
            this.currentInput = "";
        }
        else{
            this.currentInput = Double.toString(num2);
            if (this.currentInput.endsWith(".0")){
                this.currentInput = this.currentInput.replaceAll("\\.0$", "");
            }
        }
        updateDisplay(this.currentInput);
    }
    //Method that clears user input on a button click
    private void clear() {
        result = 0;
        operator = "";
        currentInput = "";
        updateDisplay(currentInput);
    }
    //Method that updates the display
    private void updateDisplay(String currentInput) {
        display.setText(currentInput);

        //Previously used but didn't work properly
        //display.setText(currentInput.isEmpty() ? String.valueOf(result) : currentInput);
         // ? and : kind of like a if else... If its empty do "String.valueOf(result)" else do "currentInput"

        //Sets the text in the TextView named display based on the contents of currentInput and result.
        //If currentInput isn't empty it displays currentInput, else it displays the calculated result

        //isEmpty method: https://www.w3schools.com/java/ref_string_isempty.asp
        //valueOf method: https://www.geeksforgeeks.org/java-string-valueof/#
    }
}