package com.example.antonio.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.Arrays;
import java.util.Random;

import static com.example.antonio.myapplication.Gerador.gerarNumerosDaLoteria;

public class MainActivity extends AppCompatActivity {

    private int[] lista;
    private TextView campoResultato;
    private TextView campoTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_loteria2);
        setTitle("Gerador de Loteria");
        findTextView();
    }

    private void findTextView() {
        campoResultato = findViewById(R.id.main_resultado);
        campoTipo = findViewById(R.id.main_tipo);
    }

    public void click(View view) {
        String string = "";
        switch (view.getId()) {
            case R.id.main_lotofacil:
                lista = gerarNumerosDaLoteria(22, 25);
                string = "Lotofácil";
                break;
            case R.id.main_quina:
                lista = gerarNumerosDaLoteria(5, 80);
                string = "Quina";
                break;
            case R.id.main_mega_sena:
                lista = gerarNumerosDaLoteria(6, 80);
                string = "Mega-Sena";
                break;
        }
        mostarResultadoDaLoteria(string);
    }

    private void mostarResultadoDaLoteria(String string) {
        campoResultato.setText(Arrays.toString(lista).replace("[", "").replace("]", "").replace(",", ""));
        campoTipo.setText("Números gerados da\n" + string);
    }
}
