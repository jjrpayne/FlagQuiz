package com.gamehut.flagquiz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    int questions;
    int score;
    int pos;

    Button[] buttons;
    List<String> countries;
    List<String> countryList;
    List<String> countriesLeft;
    String correctAnswer;
    int[] flags;
    ImageView imageView;
    private static Context c;
    TextView textView;

    public static final String SCORE = "com.gamehut.flagquiz.extra.SCORE";

    protected void initializeFlags(){
        // load all of the flag file names into array
        flags = new int[countries.size()];
        flags[0] = c.getResources().getIdentifier("drawable/ad", null, c.getPackageName());
        flags[1] = c.getResources().getIdentifier("drawable/ae", null, c.getPackageName());
        flags[2] = c.getResources().getIdentifier("drawable/af", null, c.getPackageName());
        flags[3] = c.getResources().getIdentifier("drawable/ag", null, c.getPackageName());
        flags[4] = c.getResources().getIdentifier("drawable/al", null, c.getPackageName());
        flags[5] = c.getResources().getIdentifier("drawable/am", null, c.getPackageName());
        flags[6] = c.getResources().getIdentifier("drawable/ao", null, c.getPackageName());
        flags[7] = c.getResources().getIdentifier("drawable/ar", null, c.getPackageName());
        flags[8] = c.getResources().getIdentifier("drawable/at", null, c.getPackageName());
        flags[9] = c.getResources().getIdentifier("drawable/au", null, c.getPackageName());
        flags[10] = c.getResources().getIdentifier("drawable/az", null, c.getPackageName());
        flags[11] = c.getResources().getIdentifier("drawable/ba", null, c.getPackageName());
        flags[12] = c.getResources().getIdentifier("drawable/bb", null, c.getPackageName());
        flags[13] = c.getResources().getIdentifier("drawable/bd", null, c.getPackageName());
        flags[14] = c.getResources().getIdentifier("drawable/be", null, c.getPackageName());
        flags[15] = c.getResources().getIdentifier("drawable/bf", null, c.getPackageName());
        flags[16] = c.getResources().getIdentifier("drawable/bg", null, c.getPackageName());
        flags[17] = c.getResources().getIdentifier("drawable/bh", null, c.getPackageName());
        flags[18] = c.getResources().getIdentifier("drawable/bi", null, c.getPackageName());
        flags[19] = c.getResources().getIdentifier("drawable/bj", null, c.getPackageName());
        flags[20] = c.getResources().getIdentifier("drawable/bn", null, c.getPackageName());
        flags[21] = c.getResources().getIdentifier("drawable/bo", null, c.getPackageName());
        flags[22] = c.getResources().getIdentifier("drawable/br", null, c.getPackageName());
        flags[23] = c.getResources().getIdentifier("drawable/bs", null, c.getPackageName());
        flags[24] = c.getResources().getIdentifier("drawable/bt", null, c.getPackageName());
        flags[25] = c.getResources().getIdentifier("drawable/bw", null, c.getPackageName());
        flags[26] = c.getResources().getIdentifier("drawable/by", null, c.getPackageName());
        flags[27] = c.getResources().getIdentifier("drawable/bz", null, c.getPackageName());
        flags[28] = c.getResources().getIdentifier("drawable/ca", null, c.getPackageName());
        flags[29] = c.getResources().getIdentifier("drawable/cd", null, c.getPackageName());
        flags[30] = c.getResources().getIdentifier("drawable/cf", null, c.getPackageName());
        flags[31] = c.getResources().getIdentifier("drawable/cg", null, c.getPackageName());
        flags[32] = c.getResources().getIdentifier("drawable/ch", null, c.getPackageName());
        flags[33] = c.getResources().getIdentifier("drawable/ci", null, c.getPackageName());
        flags[34] = c.getResources().getIdentifier("drawable/cl", null, c.getPackageName());
        flags[35] = c.getResources().getIdentifier("drawable/cm", null, c.getPackageName());
        flags[36] = c.getResources().getIdentifier("drawable/cn", null, c.getPackageName());
        flags[37] = c.getResources().getIdentifier("drawable/co", null, c.getPackageName());
        flags[38] = c.getResources().getIdentifier("drawable/cr", null, c.getPackageName());
        flags[39] = c.getResources().getIdentifier("drawable/cu", null, c.getPackageName());
        flags[40] = c.getResources().getIdentifier("drawable/cv", null, c.getPackageName());
        flags[41] = c.getResources().getIdentifier("drawable/cy", null, c.getPackageName());
        flags[42] = c.getResources().getIdentifier("drawable/cz", null, c.getPackageName());
        flags[43] = c.getResources().getIdentifier("drawable/de", null, c.getPackageName());
        flags[44] = c.getResources().getIdentifier("drawable/dj", null, c.getPackageName());
        flags[45] = c.getResources().getIdentifier("drawable/dk", null, c.getPackageName());
        flags[46] = c.getResources().getIdentifier("drawable/dm", null, c.getPackageName());
        flags[47] = c.getResources().getIdentifier("drawable/do", null, c.getPackageName());
        flags[48] = c.getResources().getIdentifier("drawable/dz", null, c.getPackageName());
        flags[49] = c.getResources().getIdentifier("drawable/ec", null, c.getPackageName());
        flags[50] = c.getResources().getIdentifier("drawable/ee", null, c.getPackageName());
        flags[51] = c.getResources().getIdentifier("drawable/eg", null, c.getPackageName());
        flags[52] = c.getResources().getIdentifier("drawable/eh", null, c.getPackageName());
        flags[53] = c.getResources().getIdentifier("drawable/er", null, c.getPackageName());
        flags[54] = c.getResources().getIdentifier("drawable/es", null, c.getPackageName());
        flags[55] = c.getResources().getIdentifier("drawable/et", null, c.getPackageName());
        flags[56] = c.getResources().getIdentifier("drawable/fi", null, c.getPackageName());
        flags[57] = c.getResources().getIdentifier("drawable/fj", null, c.getPackageName());
        flags[58] = c.getResources().getIdentifier("drawable/fm", null, c.getPackageName());
        flags[59] = c.getResources().getIdentifier("drawable/fr", null, c.getPackageName());
        flags[60] = c.getResources().getIdentifier("drawable/ga", null, c.getPackageName());
        flags[61] = c.getResources().getIdentifier("drawable/gb", null, c.getPackageName());
        flags[62] = c.getResources().getIdentifier("drawable/gd", null, c.getPackageName());
        flags[63] = c.getResources().getIdentifier("drawable/ge", null, c.getPackageName());
        flags[64] = c.getResources().getIdentifier("drawable/gh", null, c.getPackageName());
        flags[65] = c.getResources().getIdentifier("drawable/gm", null, c.getPackageName());
        flags[66] = c.getResources().getIdentifier("drawable/gn", null, c.getPackageName());
        flags[67] = c.getResources().getIdentifier("drawable/gq", null, c.getPackageName());
        flags[68] = c.getResources().getIdentifier("drawable/gr", null, c.getPackageName());
        flags[69] = c.getResources().getIdentifier("drawable/gt", null, c.getPackageName());
        flags[70] = c.getResources().getIdentifier("drawable/gw", null, c.getPackageName());
        flags[71] = c.getResources().getIdentifier("drawable/gy", null, c.getPackageName());
        flags[72] = c.getResources().getIdentifier("drawable/hn", null, c.getPackageName());
        flags[73] = c.getResources().getIdentifier("drawable/hr", null, c.getPackageName());
        flags[74] = c.getResources().getIdentifier("drawable/ht", null, c.getPackageName());
        flags[75] = c.getResources().getIdentifier("drawable/hu", null, c.getPackageName());
        flags[76] = c.getResources().getIdentifier("drawable/id", null, c.getPackageName());
        flags[77] = c.getResources().getIdentifier("drawable/ie", null, c.getPackageName());
        flags[78] = c.getResources().getIdentifier("drawable/il", null, c.getPackageName());
        flags[79] = c.getResources().getIdentifier("drawable/in", null, c.getPackageName());
        flags[80] = c.getResources().getIdentifier("drawable/iq", null, c.getPackageName());
        flags[81] = c.getResources().getIdentifier("drawable/ir", null, c.getPackageName());
        flags[82] = c.getResources().getIdentifier("drawable/is", null, c.getPackageName());
        flags[83] = c.getResources().getIdentifier("drawable/it", null, c.getPackageName());
        flags[84] = c.getResources().getIdentifier("drawable/jm", null, c.getPackageName());
        flags[85] = c.getResources().getIdentifier("drawable/jo", null, c.getPackageName());
        flags[86] = c.getResources().getIdentifier("drawable/jp", null, c.getPackageName());
        flags[87] = c.getResources().getIdentifier("drawable/ke", null, c.getPackageName());
        flags[88] = c.getResources().getIdentifier("drawable/kg", null, c.getPackageName());
        flags[89] = c.getResources().getIdentifier("drawable/kh", null, c.getPackageName());
        flags[90] = c.getResources().getIdentifier("drawable/ki", null, c.getPackageName());
        flags[91] = c.getResources().getIdentifier("drawable/km", null, c.getPackageName());
        flags[92] = c.getResources().getIdentifier("drawable/kn", null, c.getPackageName());
        flags[93] = c.getResources().getIdentifier("drawable/kp", null, c.getPackageName());
        flags[94] = c.getResources().getIdentifier("drawable/kr", null, c.getPackageName());
        flags[95] = c.getResources().getIdentifier("drawable/ks", null, c.getPackageName());
        flags[96] = c.getResources().getIdentifier("drawable/kw", null, c.getPackageName());
        flags[97] = c.getResources().getIdentifier("drawable/kz", null, c.getPackageName());
        flags[98] = c.getResources().getIdentifier("drawable/la", null, c.getPackageName());
        flags[99] = c.getResources().getIdentifier("drawable/lb", null, c.getPackageName());
        flags[100] = c.getResources().getIdentifier("drawable/lc", null, c.getPackageName());
        flags[101] = c.getResources().getIdentifier("drawable/li", null, c.getPackageName());
        flags[102] = c.getResources().getIdentifier("drawable/lk", null, c.getPackageName());
        flags[103] = c.getResources().getIdentifier("drawable/lr", null, c.getPackageName());
        flags[104] = c.getResources().getIdentifier("drawable/ls", null, c.getPackageName());
        flags[105] = c.getResources().getIdentifier("drawable/lt", null, c.getPackageName());
        flags[106] = c.getResources().getIdentifier("drawable/lu", null, c.getPackageName());
        flags[107] = c.getResources().getIdentifier("drawable/lv", null, c.getPackageName());
        flags[108] = c.getResources().getIdentifier("drawable/ly", null, c.getPackageName());
        flags[109] = c.getResources().getIdentifier("drawable/ma", null, c.getPackageName());
        flags[110] = c.getResources().getIdentifier("drawable/mc", null, c.getPackageName());
        flags[111] = c.getResources().getIdentifier("drawable/md", null, c.getPackageName());
        flags[112] = c.getResources().getIdentifier("drawable/me", null, c.getPackageName());
        flags[113] = c.getResources().getIdentifier("drawable/mg", null, c.getPackageName());
        flags[114] = c.getResources().getIdentifier("drawable/mh", null, c.getPackageName());
        flags[115] = c.getResources().getIdentifier("drawable/mk", null, c.getPackageName());
        flags[116] = c.getResources().getIdentifier("drawable/ml", null, c.getPackageName());
        flags[117] = c.getResources().getIdentifier("drawable/mm", null, c.getPackageName());
        flags[118] = c.getResources().getIdentifier("drawable/mn", null, c.getPackageName());
        flags[119] = c.getResources().getIdentifier("drawable/mr", null, c.getPackageName());
        flags[120] = c.getResources().getIdentifier("drawable/mt", null, c.getPackageName());
        flags[121] = c.getResources().getIdentifier("drawable/mu", null, c.getPackageName());
        flags[122] = c.getResources().getIdentifier("drawable/mv", null, c.getPackageName());
        flags[123] = c.getResources().getIdentifier("drawable/mw", null, c.getPackageName());
        flags[124] = c.getResources().getIdentifier("drawable/mx", null, c.getPackageName());
        flags[125] = c.getResources().getIdentifier("drawable/my", null, c.getPackageName());
        flags[126] = c.getResources().getIdentifier("drawable/mz", null, c.getPackageName());
        flags[127] = c.getResources().getIdentifier("drawable/na", null, c.getPackageName());
        flags[128] = c.getResources().getIdentifier("drawable/ne", null, c.getPackageName());
        flags[129] = c.getResources().getIdentifier("drawable/ng", null, c.getPackageName());
        flags[130] = c.getResources().getIdentifier("drawable/ni", null, c.getPackageName());
        flags[131] = c.getResources().getIdentifier("drawable/nl", null, c.getPackageName());
        flags[132] = c.getResources().getIdentifier("drawable/no", null, c.getPackageName());
        flags[133] = c.getResources().getIdentifier("drawable/np", null, c.getPackageName());
        flags[134] = c.getResources().getIdentifier("drawable/nr", null, c.getPackageName());
        flags[135] = c.getResources().getIdentifier("drawable/nz", null, c.getPackageName());
        flags[136] = c.getResources().getIdentifier("drawable/om", null, c.getPackageName());
        flags[137] = c.getResources().getIdentifier("drawable/pa", null, c.getPackageName());
        flags[138] = c.getResources().getIdentifier("drawable/pe", null, c.getPackageName());
        flags[139] = c.getResources().getIdentifier("drawable/pg", null, c.getPackageName());
        flags[140] = c.getResources().getIdentifier("drawable/ph", null, c.getPackageName());
        flags[141] = c.getResources().getIdentifier("drawable/pk", null, c.getPackageName());
        flags[142] = c.getResources().getIdentifier("drawable/pl", null, c.getPackageName());
        flags[143] = c.getResources().getIdentifier("drawable/pt", null, c.getPackageName());
        flags[144] = c.getResources().getIdentifier("drawable/pw", null, c.getPackageName());
        flags[145] = c.getResources().getIdentifier("drawable/py", null, c.getPackageName());
        flags[146] = c.getResources().getIdentifier("drawable/qa", null, c.getPackageName());
        flags[147] = c.getResources().getIdentifier("drawable/ro", null, c.getPackageName());
        flags[148] = c.getResources().getIdentifier("drawable/rs", null, c.getPackageName());
        flags[149] = c.getResources().getIdentifier("drawable/ru", null, c.getPackageName());
        flags[150] = c.getResources().getIdentifier("drawable/rw", null, c.getPackageName());
        flags[151] = c.getResources().getIdentifier("drawable/sa", null, c.getPackageName());
        flags[152] = c.getResources().getIdentifier("drawable/sb", null, c.getPackageName());
        flags[153] = c.getResources().getIdentifier("drawable/sc", null, c.getPackageName());
        flags[154] = c.getResources().getIdentifier("drawable/sd", null, c.getPackageName());
        flags[155] = c.getResources().getIdentifier("drawable/se", null, c.getPackageName());
        flags[156] = c.getResources().getIdentifier("drawable/sg", null, c.getPackageName());
        flags[157] = c.getResources().getIdentifier("drawable/si", null, c.getPackageName());
        flags[158] = c.getResources().getIdentifier("drawable/sk", null, c.getPackageName());
        flags[159] = c.getResources().getIdentifier("drawable/sl", null, c.getPackageName());
        flags[160] = c.getResources().getIdentifier("drawable/sm", null, c.getPackageName());
        flags[161] = c.getResources().getIdentifier("drawable/sn", null, c.getPackageName());
        flags[162] = c.getResources().getIdentifier("drawable/so", null, c.getPackageName());
        flags[163] = c.getResources().getIdentifier("drawable/sr", null, c.getPackageName());
        flags[164] = c.getResources().getIdentifier("drawable/st", null, c.getPackageName());
        flags[165] = c.getResources().getIdentifier("drawable/sv", null, c.getPackageName());
        flags[166] = c.getResources().getIdentifier("drawable/sy", null, c.getPackageName());
        flags[167] = c.getResources().getIdentifier("drawable/sz", null, c.getPackageName());
        flags[168] = c.getResources().getIdentifier("drawable/td", null, c.getPackageName());
        flags[169] = c.getResources().getIdentifier("drawable/tg", null, c.getPackageName());
        flags[170] = c.getResources().getIdentifier("drawable/th", null, c.getPackageName());
        flags[171] = c.getResources().getIdentifier("drawable/tj", null, c.getPackageName());
        flags[172] = c.getResources().getIdentifier("drawable/tl", null, c.getPackageName());
        flags[173] = c.getResources().getIdentifier("drawable/tm", null, c.getPackageName());
        flags[174] = c.getResources().getIdentifier("drawable/tn", null, c.getPackageName());
        flags[175] = c.getResources().getIdentifier("drawable/to", null, c.getPackageName());
        flags[176] = c.getResources().getIdentifier("drawable/tr", null, c.getPackageName());
        flags[177] = c.getResources().getIdentifier("drawable/tt", null, c.getPackageName());
        flags[178] = c.getResources().getIdentifier("drawable/tv", null, c.getPackageName());
        flags[179] = c.getResources().getIdentifier("drawable/tw", null, c.getPackageName());
        flags[180] = c.getResources().getIdentifier("drawable/tz", null, c.getPackageName());
        flags[181] = c.getResources().getIdentifier("drawable/ua", null, c.getPackageName());
        flags[182] = c.getResources().getIdentifier("drawable/ug", null, c.getPackageName());
        flags[183] = c.getResources().getIdentifier("drawable/us", null, c.getPackageName());
        flags[184] = c.getResources().getIdentifier("drawable/uy", null, c.getPackageName());
        flags[185] = c.getResources().getIdentifier("drawable/uz", null, c.getPackageName());
        flags[186] = c.getResources().getIdentifier("drawable/va", null, c.getPackageName());
        flags[187] = c.getResources().getIdentifier("drawable/vc", null, c.getPackageName());
        flags[188] = c.getResources().getIdentifier("drawable/ve", null, c.getPackageName());
        flags[189] = c.getResources().getIdentifier("drawable/vn", null, c.getPackageName());
        flags[190] = c.getResources().getIdentifier("drawable/vu", null, c.getPackageName());
        flags[191] = c.getResources().getIdentifier("drawable/ws", null, c.getPackageName());
        flags[192] = c.getResources().getIdentifier("drawable/ye", null, c.getPackageName());
        flags[193] = c.getResources().getIdentifier("drawable/za", null, c.getPackageName());
        flags[194] = c.getResources().getIdentifier("drawable/zm", null, c.getPackageName());
        flags[195] = c.getResources().getIdentifier("drawable/zw", null, c.getPackageName());

    }


    protected void initializeQuestion(){
        Random r = new Random();
        // pick a random country that has not yet been picked
        int index = r.nextInt(countriesLeft.size());
        correctAnswer = countriesLeft.get(index);
        countriesLeft.remove(index);

        // remove the correct answer from country list so it only appears once in the answers
        if(countryList.contains(correctAnswer))
            countryList.remove(correctAnswer);

        int cIndex=-1;

        if(countries.contains(correctAnswer)){
            cIndex = countries.indexOf(correctAnswer);
        }

        // load image into imageView.
        // Glide library is used to avoid memory issues
        if(cIndex != -1)
            Glide.with(c).load(flags[cIndex]).into(imageView);

        // load random country names into answer buttons
        int qIndex = r.nextInt(4);
        for (int i = 0; i < 4; i++){
            if (i == qIndex){
                buttons[i].setText(correctAnswer);
            } else {
                int countryIndex = r.nextInt(countryList.size());
                String currentAns = countryList.get(countryIndex);
                countryList.remove(countryIndex);
                buttons[i].setText(currentAns);
            }
        }
        for(int i = 0; i < 4; i++){
            if(i != qIndex){
                countryList.add(buttons[i].getText().toString());
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        c = getApplicationContext();

        questions = 25;
        score = 0;
        pos = 0;
        buttons = new Button[4];
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        textView.setVisibility(TextView.INVISIBLE);

        // list of all countries
        countries = Arrays.asList(getResources().getStringArray(R.array.countries));
        // list of countries to be used as answers
        countryList = new ArrayList<String>(countries);
        // list of countries that have not been used in a question
        countriesLeft = new ArrayList<String>(countries);
        initializeFlags();


        initializeQuestion();
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed()
    {

        // super.onBackPressed(); // Comment this super call to avoid calling finish() or fragmentmanager's backstack pop operation.
    }

    public void onButtonPress(View view) {
        Button pressedButton = (Button)view;
        String buttonText = pressedButton.getText().toString();

        // check if correct answer was picked
        if(buttonText.equals(correctAnswer)){
            score++;
            CharSequence text = "Correct!";
            textView.setText(text);
            if(textView.getVisibility() != TextView.VISIBLE)
                textView.setVisibility(TextView.VISIBLE);
        } else {
            CharSequence text = "Incorrect! The answer was " + correctAnswer;
            textView.setText(text);
            if(textView.getVisibility() != TextView.VISIBLE)
                textView.setVisibility(TextView.VISIBLE);

        }
        pos++;
        // end quiz
        if(pos == questions){
            Intent intent = new Intent(this, EndActivity.class);
            intent.putExtra(SCORE, score);
            startActivity(intent);
        } else {
            initializeQuestion();
        }
    }
}
