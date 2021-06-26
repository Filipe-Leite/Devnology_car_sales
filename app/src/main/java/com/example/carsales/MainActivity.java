package com.example.carsales;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //DECLARANDO UM OBJETO LISTVIEW
    ListView listViewOpcoes;

    //MÉTODO onCreate EXECUTADO NA INICIALIZAÇÃO DA ACTIVITY
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //DETERMINA O CONTEÚDO DA NOSSA ACTIVITY
        setContentView(R.layout.activity_main);

        /*CARREGA O MÉTODO DE CRIAÇÃO DOS COMPONENTES*/
        this.CriarComponentes();

        //CRIA EVENTO PARA A LISTA
        this.CriarEventos();

        /*CARREGA AS OPÇÕES DA LISTA*/
        this.CarregaOpcoesLista();
    }
    //CRIA EVENTO PARA A LISTA
    protected void CriarEventos(){

        listViewOpcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opcaoMenu = ((TextView) view).getText().toString();

                RedirecionaTela(opcaoMenu);


            }
        });
    }
    //REDIRECIONA PARA A TELA SELECIONADA NO MENU
    protected void RedirecionaTela(String opcaoMenu){

        Intent intentRedirecionar;

        if(opcaoMenu.equals("Cadastrar")){

            intentRedirecionar = new Intent(this, CadastrarActivity.class);
            startActivity(intentRedirecionar);
            finish();
        }
        else if(opcaoMenu.equals("Carros disponíveis")){

            intentRedirecionar = new Intent(this, ConsultarActivity.class);
            startActivity(intentRedirecionar);
            finish();
        }
        else
            Toast.makeText(getApplicationContext(), "Opção inválida!", Toast.LENGTH_SHORT).show();

    }

    //VINCULA O COMPONENTE DA NOSSA TELA AO OBJETO DA NOSSA ATIVIDADE
    protected void CriarComponentes(){

        //VINCULANDO A LISTA DA TELA AO LISTVIEW QUE DECLARAMOS
        listViewOpcoes = (ListView) this.findViewById(R.id.listViewOpcoes);
    }

    //CRIA A OPÇÕES DA NOSSA LISTA E ADICIONA AO LISTVIEW DA NOSSA TELA.
    protected  void CarregaOpcoesLista(){

        String[] itens = new String[3];

        itens[0] = "Cadastrar";
        itens[1] = "Carros disponíveis";
        itens[2] = "Carros vendidos";

        ArrayAdapter<String> arrayItens = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itens);


        listViewOpcoes.setAdapter(arrayItens);

    }
}