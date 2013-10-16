# Errata
## Android Programming: The Big Nerd Ranch Guide


### Chapter 1

#### Page 26 
In the 2nd to last line the URL for the developer site link has an extra "http://" at the front. 

### Chapter 2

#### Page 37

Button specification in the XML diagram shows `android:text="@string/next_question_button"`, but it should read `android:text="@string/next_button"`.

#### Page 39 - Listing 2.6

Missing comma when creating the array:

    private TrueFalse[] mQuestionBank = new TrueFalse[] {
        new TrueFalse(R.string.question_oceans, true),
        new TrueFalse(R.string.question_mideast, false),
        new TrueFalse(R.string.question_africa, false) <-- comma needed at end of this line
        new TrueFalse(R.string.question_americas, true),
        new TrueFalse(R.string.question_asia, true),
    };
    
The extra trailing comma is not required, but we typically include it because it makes adding new items later easier.

#### Page 51

Same error as Page 37, though text is striked out in the code example here.


#### Page 45

Paragragh at bottom of the page says, 

    Within this directory, locate the drawable-hdpi, res/drawable-mdpi, and drawable-xhdpi directories.

The middle item should omit "res/".

#### Misc: mQuestionBank vs. mAnswerKey

The instance variable for the list of questions is called mQuestionBank in this chapter. In Chapters 3, 4, and 5, the same variable is called mAnswerKey.

Go with the name you originally typed in - mQuestionBank. Chapters 3, 4, and 5 are incorrect.


### Chapter 5

#### Page 93

A passage says, 

     "You can just create a new file named fragment_crime.xml..." 

The "fragment_crime.xml" filename should be "activity_cheat.xml" instead.

#### Page 94 - Listing 5.2

The `android:text` attribute for the first TextView is shown as "@string/warning_text_view". This should instead be `"@string/warning_text"`.

### Chapter 8

#### Page 151 - Listing 8.3

The EditText includes two new margin attributes that were not previously present. These two attributes should be marked bold in the text.

#### Page 152 - Listing 8.5

A passage says,

    Organize your imports to resolve the references to DatePicker and CheckBox.

There is no DatePicker in the listing, so the passage should not mention DatePicker at all.



