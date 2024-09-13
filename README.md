# SimpleKotlinApplication  
  
A simple app for practising Kotlin.
  
This program handles user interactions with two buttons: one that outputs text to a TextView
and another that triggers a console practice method. It also includes an EditText for user input.  
  
The program is ready to handle UI interactions, with clear separation of input/output display and console action handling.


## Code Explanation:

### MainActivity Class:

Implements the 'AppCompatActivity' class to enable features like activity lifecycle and 'View.OnClickListener' for handling click events.

### Member Variables:

'isBtnPracticeOnConsoleActivated': A boolean to track whether the "Practice on Console" button has been activated. Prevents repeated actions.  
'btnToOutput', 'btnPracticeOnConsole': Button objects for two user actions. 'lateinit' ensures they are initialized later (after 'setContentView()').  
'etInput': EditText object for capturing user input.  
'tvOutput': TextView to display the result.  

### onCreate() Method:

Called when the activity starts. Sets the layout and initializes the buttons and views.
Configures system bars to be handled correctly using insets.
Sets click listeners for both buttons.

### onClick() Method:

Handles button click events using 'when' to determine which button was pressed ('R.id.buttonOutput' or 'R.id.buttonConsole').
For the output button ('R.id.buttonOutput'), it directly displays the input text in the TextView.
For the console button ('R.id.buttonConsole'), it checks if the button was already pressed (using 'isBtnPracticeOnConsoleActivated') and, if not, calls a method from the 'PracticeConsole' class.

