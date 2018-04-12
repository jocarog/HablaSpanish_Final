package com.example.android.hablaspanish;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * This method is called from the Submit method and gets the edit text views answer for
     * question 1 that needs user input.
     */
    private boolean getRespuesta1() {
        EditText respuesta1 = (EditText) findViewById(R.id.translated_answer_1);
        // Clear the focus after retrieving the text
        respuesta1.clearFocus();
        String respuesta1Str = respuesta1.getText().toString();

        return respuesta1Str.equalsIgnoreCase("I am hungry");
    }


    /*
    * This method is called from the Submit method and gets the check box view answers for
    question 2.
            */
    private boolean getRespuesta2() {
        // The Check Box count starts at 1 and goes from top to bottom.
        CheckBox answer_2_1 = findViewById(R.id.answer_2_1);
        CheckBox answer_2_2 = findViewById(R.id.answer_2_2);
        CheckBox answer_2_3 = findViewById(R.id.answer_2_3);

        // Checkbox 1 is the correct answer.
        // The logic here checks for answers 1 and 3 to be checked and all others to be unchecked.
        return answer_2_1.isChecked() && !answer_2_2.isChecked() && !answer_2_3.isChecked();
    }


    /*
     * This method is called from the Submit method and gets the answer for question 3 radioGroup
     *
     */

    private boolean getRespuesta3() {
    RadioButton getRespuesta3 = findViewById(R.id.answer_3_2);
        if (getRespuesta3.isChecked())
            return true;{


        }
        return false;
    }
    /*
     * This method is called from the Submit method and gets the edit text views answer for
     * question 4 that needs user input.
     */
    private boolean getRespuesta4() {
        EditText respuesta4 = (EditText) findViewById(R.id.translated_answer_2);
        // Clear the focus after retrieving the text
        respuesta4.clearFocus();
        String respuesta4Str = respuesta4.getText().toString();

        return respuesta4Str.equalsIgnoreCase("I need help");
    }

    /*
     * This method is called when the submit button is clicked. It is the main method of the
     * app and calls the answers private methods. A tally of the correctly answered questions is
     * calculated and then displayed on the screen via a Toast message.
     */
    public void submit(View view) {
        int numPreguntas = 4;
        int sum = 0;

        boolean[] pregunta = new boolean[numPreguntas];

        pregunta[0] = getRespuesta1();
        pregunta[1] = getRespuesta2();
        pregunta[2] = getRespuesta3();
        pregunta[3] = getRespuesta4();


        for (int i = 0; i < numPreguntas; i++) {
            if (pregunta[i])
                sum++;
        }

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        Context context = getApplicationContext();
        CharSequence answer1Text;
        // Singular
        if (sum == 1) {
            answer1Text = name + " you got " +sum + " question right! \nCongratulations!";
        }
        // Plural
        else {
            answer1Text = name + " you got " + sum + " questions right! \nCongratulations!";
        }
        Toast toast = Toast.makeText(context, answer1Text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    /*
    *feeling lucky? open google website!
     */
    public void goToGo (View view) {
        goToUrl ( "https://www.google.com/");
    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}




