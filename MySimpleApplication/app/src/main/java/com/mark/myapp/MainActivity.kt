package com.mark.myapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
 * MainActivity class which extends AppCompatActivity and implements the View.OnClickListener interface.
 *
 * This activity handles user interactions with two buttons: one that outputs text to a TextView
 * and another that triggers a console practice method. It also includes an EditText for user input.
 */
class MainActivity : AppCompatActivity(), View.OnClickListener  {
    // A boolean to track if the "Practice on Console" button has been activated
    var isBtnPracticeOnConsoleActivated = false;

    // Declaration of UI elements that will be initialized later (lateinit keyword allows late initialization)
    lateinit var btnToOutput : Button
    lateinit var btnPracticeOnConsole : Button
    lateinit var etInput : EditText
    lateinit var tvOutput : TextView

    /*
     * The 'onCreate' function is called when the activity is first created.
     * Initializes the UI elements and sets up listeners for button clicks.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enables edge-to-edge display mode for immersive UI (may adjust window insets for full-screen effects)
        enableEdgeToEdge()
        // Set the content view to the layout defined in activity_main.xml
        setContentView(R.layout.activity_main)
        // Adjusts the layout's padding to accommodate system bars (like status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // Get insets related to system bars
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Set padding on the view to account for system bars' size (status bar, navigation bar)
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find buttons and input/output fields in the layout by their ID
        btnToOutput = findViewById(R.id.buttonOutput)
        btnPracticeOnConsole = findViewById(R.id.buttonConsole)
        etInput = findViewById(R.id.inputText)
        tvOutput = findViewById(R.id.outputText)

        // Set click listeners on the buttons, assigning 'this' as the click handler
        btnToOutput.setOnClickListener(this)
        btnPracticeOnConsole.setOnClickListener(this)

    }

    /*
     * Called when a view (button in this case) is clicked.
     * This method identifies which button was pressed and performs the corresponding action.
     *
     * the parameter 'v' is the view that was clicked
     */
    override fun onClick(v: View?) {

        // Get the user input from the EditText field as a string
        var inputText = etInput.text.toString();

        // Variable to hold the result that will be displayed in the TextView
        var resultText = ""

        // Check which button was clicked by examining the view's ID
        when(v?.id){

            // If the "Output" button is clicked
            R.id.buttonOutput -> {

                // Set the result text to the input text
                resultText = inputText

            }

            // If the "Practice on Console" button is clicked
            R.id.buttonConsole -> {

                // Check if the console practice button has already been activated
                if(!isBtnPracticeOnConsoleActivated){

                    // Mark it as activated to prevent re-triggering the action
                    isBtnPracticeOnConsoleActivated = true

                    // Create an instance of the PracticeConsole class
                    val pcObject = PracticeConsole()

                    // Call the method that handles the output on LOGCAT CONSOLE
                    pcObject.practiceOnConsoleMethod()

                }

            }

        }

        // Display the result in the TextView (output in the TextView)
        tvOutput.text = "$resultText"

    }

}