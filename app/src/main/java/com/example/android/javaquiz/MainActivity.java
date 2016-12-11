/** Author: Shuxian Liu
 ** Udacity China ID: shu201322@gmail.com
 ** Last date: Thu 03 Nov 2016
 **/
package com.example.android.javaquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /** TextView objects show the question. **/
    TextView mTextView1, mTextView2, mTextView3, mTextView4, mTextView5;
    /** EditText object shows the answer of question1. **/
    EditText mEditText1;
    /** CheckBox objects show the answers of question2 and question3. **/
    CheckBox mCheckBox1A, mCheckBox1B, mCheckBox2A, mCheckBox2B;
    /** RadioGroup objects contain the RadioButton objects. **/
    RadioGroup mRadioGroup1, mRadioGroup2;
    /** RadioButton objects show the answers of question4 and question5. **/
    RadioButton mRadioButton1A, mRadioButton1B, mRadioButton2A, mRadioButton2B;
    /** Button object submit all answers to show the result. **/
    Button mSubmitButton;
    /** Calculate the mark. **/
    int point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Loading the controls. **/
        mTextView1 = (TextView) this.findViewById(R.id.textView1);
        mTextView2 = (TextView) this.findViewById(R.id.textView2);
        mTextView3 = (TextView) this.findViewById(R.id.textView3);
        mTextView4 = (TextView) this.findViewById(R.id.textView4);
        mTextView5 = (TextView) this.findViewById(R.id.textView5);
        mEditText1 = (EditText) this.findViewById(R.id.editText1);
        mCheckBox1A = (CheckBox) this.findViewById(R.id.checkBox1A);
        mCheckBox1B = (CheckBox) this.findViewById(R.id.checkBox1B);
        mCheckBox2A = (CheckBox) this.findViewById(R.id.checkBox2A);
        mCheckBox2B = (CheckBox) this.findViewById(R.id.checkBox2B);
        mRadioGroup1 = (RadioGroup) this.findViewById(R.id.radioGroup1);
        mRadioGroup2 = (RadioGroup) this.findViewById(R.id.radioGroup2);
        mRadioButton1A = (RadioButton) this.findViewById(R.id.radioButton1A);
        mRadioButton1B = (RadioButton) this.findViewById(R.id.radioButton1B);
        mRadioButton2A = (RadioButton) this.findViewById(R.id.radioButton2A);
        mRadioButton2B = (RadioButton) this.findViewById(R.id.radioButton2B);
        mSubmitButton = (Button) this.findViewById(R.id.submitButton);

        /** Increase 10 points when choose this option. **/
        mCheckBox1A.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mCheckBox1A.isChecked()) {point = point + 10; return;}
            }
        });

        /** Increase 10 points when choose this option. **/
        mCheckBox1B.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mCheckBox1B.isChecked()) {point = point + 10; return;}
            }
        });

        /** Increase 10 points when choose this option. **/
        mCheckBox2A.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mCheckBox2A.isChecked()) {point = point + 10; return;}
            }
        });

        /** Increase 10 points when choose this option. **/
        mCheckBox2B.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mCheckBox2B.isChecked()) {point = point + 10; return;}
            }
        });

        /** Increase 20 points when choose the 1st option. **/
        mRadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mRadioButton1A.getId()) {point = point + 20;}
                else {point = point + 0; return;}
            }
        });

        /** Increase 20 points when choose the 1st option. **/
        mRadioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mRadioButton2A.getId()) {point = point + 20;}
                else {point = point + 0; return;}
            }
        });

        /** Show a total mark dialog after click submit button. **/
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** Increase 20 points when fill in this field. **/
                String mString = mEditText1.getText().toString();
                if (mString.trim().equals("java")) {point = point + 20;}
                else {mEditText1.setError("Incorrect!"); return;}

                DisplayToast("You get " + point + ". Keep learning.");
            }
        });
    }

    /** This method show the final result. **/
    public void DisplayToast(String string) {
        Toast mToast = Toast.makeText(this, string, Toast.LENGTH_LONG);
        mToast.setGravity(Gravity.TOP, 0, 450);
        mToast.show();
    }
}