package com.elastos.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import org.wallet.library.entity.UriFactory;

public class HomeActivity extends Activity {

    public static String words;
    private ListView mInputLv;
    private EditText mShowEdt;
    private String[] tmp = new String[12];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_layout);

        mInputLv = findViewById(R.id.word_list);
        mShowEdt = findViewById(R.id.show_word);

        words = Utils.getWords(this, "words/mnemonic_chinese.txt");

        mInputLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        for(int i=0; i<12; i++) tmp[i] = i+"";
        mInputLv.setAdapter(new WordAdapter(this, tmp));
    }

    public void verify(View view) {
        String result = arryToString(tmp);
        mShowEdt.setText(result);
    }

    public void trans(View view) {

    }

    public void testScheme(View view){
        String mUri = null;
        //null
        mUri = "elaphant://eladposvote?AppID=23091883A390CCBFFFED4928F996936AFCEBB1B57192532D15271158F3A277FD1BB3309DA2719334CBE1DE7BA2408047E2786A94F370CE66C208159B3A8D1162&PublicKey=03128A35842DD061BD016B9B2913BE07028063E5A80365D713DB77508406E85815&Signature=undefined&DID=iZW9ozTSXk4ukRXx7vCTTFYebZHFwMUtz7&AppName=dopsvote.h5.app&ReturnUrl=https://elaphantapp.github.io/dposvote/#/return_url&CandidatePublicKeys=[\"\"]&inside=1";

        //
//        mUri = "elaphant://eladposvote?AppID=23091883A390CCBFFFED4928F996936AFCEBB1B57192532D15271158F3A277FD1BB3309DA2719334CBE1DE7BA2408047E2786A94F370CE66C208159B3A8D1162&PublicKey=03128A35842DD061BD016B9B2913BE07028063E5A80365D713DB77508406E85815&Signature=undefined&DID=iZW9ozTSXk4ukRXx7vCTTFYebZHFwMUtz7&AppName=dopsvote.h5.app&ReturnUrl=https://elaphantapp.github.io/dposvote/#/return_url&CandidatePublicKeys=\"\"&inside=1";

//        mUri = "elaphant://eladposvote?AppID=23091883A390CCBFFFED4928F996936AFCEBB1B57192532D15271158F3A277FD1BB3309DA2719334CBE1DE7BA2408047E2786A94F370CE66C208159B3A8D1162&PublicKey=03128A35842DD061BD016B9B2913BE07028063E5A80365D713DB77508406E85815&Signature=undefined&DID=iZW9ozTSXk4ukRXx7vCTTFYebZHFwMUtz7&AppName=dopsvote.h5.app&ReturnUrl=https://elaphantapp.github.io/dposvote/#/return_url&inside=1";

        UriFactory uriFactory = new UriFactory();
        uriFactory.parse(mUri);

        String tmp = uriFactory.getCandidatePublicKeys();
        Log.i("", "");
    }

    private String arryToString(String[] arrys){
        StringBuilder sb = new StringBuilder();
        for(String arry : arrys){
            sb.append(arry).append(" ");
        }

        return sb.toString();
    }

}
