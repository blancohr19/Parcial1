package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText empleado, hr_extra, vr_extra, salario, pension, salud, salariob, salario_t;
    Button calcular;
    int salario_min = 877802;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empleado=findViewById(R.id.edt_empleado);
        hr_extra=findViewById(R.id.edt_hr_extra);
        vr_extra=findViewById(R.id.edt_v_hr_extra);
        salario=findViewById(R.id.edt_salario);
        pension=findViewById(R.id.edt_pension);
        salud=findViewById(R.id.edt_salud);
        salariob=findViewById(R.id.edt_sal_b);
        salario_t=findViewById(R.id.edt_sal_total);
        calcular=findViewById(R.id.btn_calcular);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menu_parcial1, m);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if(id==R.id.Sal_Minimo){
            salario.setText(String.valueOf(salario_min));
        }

        if(id==R.id.borrar){
            empleado.setText("");
            salario.setText("");
            hr_extra.setText("");
            vr_extra.setText("");
            pension.setText("");
            salud.setText("");
            salariob.setText("");
            salario_t.setText("");
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View view) {

        double salario_emp =Double.parseDouble(salario.getText().toString());
        double valor_horas =Double.parseDouble(vr_extra.getText().toString());
        double horas_extras =Double.parseDouble(hr_extra.getText().toString());


        switch (view.getId()){

            case R.id.btn_calcular:
                if(TextUtils.isEmpty(salario.getText().toString()) || TextUtils.isEmpty(vr_extra.getText().toString()) ||
                        TextUtils.isEmpty(hr_extra.getText().toString()) ){

                    Toast.makeText(getApplicationContext(),"Ingrese Todos los Datos", Toast.LENGTH_LONG).show();
                }else{
                   double salario_br=salario_emp+(valor_horas*horas_extras);
                   salariob.setText(String.valueOf(salario_br));
                   double salario_v_total=salario_br-(salario_br*0.08);
                   salario_t.setText(String.valueOf(salario_v_total));

                   double v_pension=(salario_br*0.04);
                   pension.setText(String.valueOf(v_pension));
                   double v_salud=(salario_br*0.04);
                   salud.setText(String.valueOf(v_salud));

                }
                break;
        }
    }
}
