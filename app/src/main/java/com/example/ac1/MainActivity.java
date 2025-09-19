package com.example.ac1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Livro> livros = new ArrayList<>();
    private EditText inputNomeLivro;
    private EditText inputNomeAutor;
    private CheckBox checkLido;
    private LinearLayout todosLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputNomeLivro = findViewById(R.id.inputNomeLivro);
        inputNomeAutor = findViewById(R.id.inputNomeAutor);
        checkLido = findViewById(R.id.checkLido);
        todosLivros = findViewById(R.id.todosLivros);
        Button btnSalvar = findViewById(R.id.btnSalvar);
        Button btnVerificarLivros = findViewById(R.id.btnVerificarLivros);

        btnSalvar.setOnClickListener(v -> {
            String livro = inputNomeLivro.getText().toString();
            String autor = inputNomeAutor.getText().toString();
            boolean lido = checkLido.isChecked();

            Livro novoLivro = new Livro(livro, autor, lido);
            livros.add(novoLivro); // Linha corrigida

            Toast.makeText(this, "Livro salvo!", Toast.LENGTH_SHORT).show();


            inputNomeLivro.setText("");
            inputNomeAutor.setText("");
            checkLido.setChecked(false);
        });

        btnVerificarLivros.setOnClickListener(v -> {
            mostrarLivros();
        });
    }

    private void mostrarLivros() {
        todosLivros.removeAllViews();

        for (Livro livro : livros) {

            TextView livroTextView = new TextView(this);
            String statusLeitura = livro.lido() ? "Lido" : "Não Lido";
            String detalhesLivro = "Título: " + livro.getLivro() + "\nAutor: " + livro.getAutor() + "\nStatus: " + statusLeitura + "\n";
            livroTextView.setText(detalhesLivro);
            livroTextView.setPadding(0, 10, 0, 10);

            todosLivros.addView(livroTextView);
        }
    }
}

