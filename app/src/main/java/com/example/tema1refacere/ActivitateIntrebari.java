package com.example.tema1refacere;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivitateIntrebari extends AppCompatActivity {

    private List<templateChestionar> listaIntrebari;

    private templateChestionar intrebareCurenta;
    int totalIntrebari;
    int contor=0;
    boolean aSelectatRasp;

    private Button btnNextQ;
    private TextView tvIntrebare;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3, rb4, rb5;


    private TextView tvNrIntreb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitate_intrebari);

        tvIntrebare=findViewById(R.id.simion_maria_tb_intrebare);
        listaIntrebari= new ArrayList<>(Arrays.asList(new templateChestionar("Cum vi s-a parut timpul de asteptare?"),
                new templateChestionar("Cum ati evalua comportamentul personalului?"),
                new templateChestionar("Cum vi s-a parut atmosfera si aspectul general al zonei de asteptare?"),
                new templateChestionar("Daca ar fi sa notati implicareea si profesionalismul medicului ati spune ca a fost: "),
                new templateChestionar("Ce parere aveti despre costurile consultatiei?"),
                new templateChestionar("Avand in vedere contextul pandemic, cum ati evalua masurile de siguranta adoptate de clinica? "),
                new templateChestionar("O evaluare generala a experientei dumneavoastra?")));
        totalIntrebari=listaIntrebari.size();
        radioGroup=findViewById(R.id.simion_maria_rg_raspunsuri);
        rb1=findViewById(R.id.simion_maria_rb1);
        rb2=findViewById(R.id.simion_maria_rb2);
        rb3=findViewById(R.id.simion_maria_rb3);
        rb4=findViewById(R.id.simion_maria_rb4);
        rb5=findViewById(R.id.simion_maria_rb5);
        btnNextQ= findViewById(R.id.simion_maria_btn_next2);

        tvNrIntreb=findViewById(R.id.simion_maria_tv_q_nr);
        urmatoareaIntrebare();

        btnNextQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!aSelectatRasp)
                {
                    if( rb1.isChecked() || rb2.isChecked()|| rb3.isChecked() || rb4.isChecked() || rb5.isChecked()) {

                        aSelectatRasp=true;

                    }
                    else{
                        Toast.makeText(getApplicationContext(), R.string.warning_raspuns_gol, Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    urmatoareaIntrebare();
                }
            }
        });

    }
    private void urmatoareaIntrebare()
    {
        radioGroup.clearCheck();
        if(contor<totalIntrebari)
        {
            intrebareCurenta=listaIntrebari.get(contor);
            tvIntrebare.setText(intrebareCurenta.getIntrebare());
            contor++;
            tvNrIntreb.setText(getString(R.string.intrebare)+contor+"/"+totalIntrebari);
            aSelectatRasp=false;

        }
        else{

            Toast.makeText(getApplicationContext(), R.string.final_mess, Toast.LENGTH_LONG ).show();
            finish();
        }
    }


}