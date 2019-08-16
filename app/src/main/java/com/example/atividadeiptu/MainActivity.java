package com.example.atividadeiptu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtArea;
    private TextView txtValor;
    private ListView listTipos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtArea = findViewById(R.id.editArea);
        txtValor = findViewById(R.id.textViewValor);
        listTipos = findViewById(R.id.listViewTipo);
        ArrayAdapter adapt = ArrayAdapter.createFromResource(this, R.array.tipos, android.R.layout.simple_list_item_1);
        listTipos.setAdapter(adapt);

        listTipos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = edtArea.getText().toString();
                if (!str.isEmpty()) {
                    double area = Double.parseDouble(str);
                    double valor = 0;

                    switch (position) {
                        case 0:
                            valor = area * 100;
                            break;
                        case 1:
                            valor = area * 150;
                            break;
                        case 3:
                            valor = area * 200;
                            break;
                        default:
                            valor = 0.0;
                    }
                    txtValor.setText("Valor do IPTU " + Double.toString(valor));
                }
            }
        });
    }
}
