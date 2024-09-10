package com.example.projetoac1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup question1Group, question2Group, question3Group;
    Button clearButton, calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        question1Group = findViewById(R.id.radioBio);
        question2Group = findViewById(R.id.radioMat);
        question3Group = findViewById(R.id.radioHis);

        clearButton = findViewById(R.id.buttonLimpar);
        calculateButton = findViewById(R.id.buttonCorrigir);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question1Group.clearCheck();
                question2Group.clearCheck();
                question3Group.clearCheck();
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = 0;

                if (question1Group.getCheckedRadioButtonId() == R.id.button4) {
                    score++;
                    showToast("Questão 1: Correto!\nAs baleias são mamíferos porque possuem glândulas mamárias, respiram por pulmões e dão à luz filhotes, mesmo vivendo no ambiente marinho.");
                } else {
                    showToast("Questão 1: Incorreto.\nA resposta correta é a opção 4 - Baleia.\nExplicação: As baleias são mamíferos porque possuem glândulas mamárias, respiram por pulmões e dão à luz filhotes, mesmo vivendo no ambiente marinho.");
                }

                if (question2Group.getCheckedRadioButtonId() == R.id.button8) {
                    score++;
                    showToast("Questão 2: Correto!\nA raiz quadrada de 144 é 12, pois 12 x 12 = 144.");
                } else {
                    showToast("Questão 2: Incorreto.\nA resposta correta é a opção 3 - 12.\nExplicação: A raiz quadrada de 144 é 12, pois 12 x 12 = 144.");
                }

                if (question3Group.getCheckedRadioButtonId() == R.id.button13) {
                    score++;
                    showToast("Questão 3: Correto!\nO 'Grito do Ipiranga' em 7 de setembro de 1822 marcou a Independência do Brasil, quando Dom Pedro I declarou a separação de Portugal.");
                } else {
                    showToast("Questão 3: Incorreto.\nA resposta correta é a opção 3 - O Grito do Ipiranga.\nExplicação: O 'Grito do Ipiranga' em 7 de setembro de 1822 marcou a Independência do Brasil, quando Dom Pedro I declarou a separação de Portugal.");
                }

                Toast.makeText(MainActivity.this, "Você acertou " + score + " de 3 perguntas", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
