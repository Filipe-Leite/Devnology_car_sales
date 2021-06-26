package com.example.carsales.Uteis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseUtil extends SQLiteOpenHelper {

    //NOME DA BASE DE DADOS
    private static final String NOME_BASE_DE_DADOS   = "SISTEMA.db";

    //VERSÃO DO BANCO DE DADOS
    private static final int    VERSAO_BASE_DE_DADOS = 1;

    //CONSTRUTOR
    public DatabaseUtil(Context context){

        super(context,NOME_BASE_DE_DADOS,null,VERSAO_BASE_DE_DADOS);
    }

    /*NA INICIALIZAÇÃO DA CLASSE VAMOS CRIAR A TABELA QUE VAMOS USAR*/
    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder stringBuilderCreateTable = new StringBuilder();

        stringBuilderCreateTable.append(" CREATE TABLE tb_carro (");
        stringBuilderCreateTable.append("        id_carro      INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilderCreateTable.append("        ds_modelo        TEXT    NOT NULL)            ");

        db.execSQL(stringBuilderCreateTable.toString());

    }
    /*SE TROCAR A VERSÃO DO BANCO DE DADOS VOCÊ PODE EXECUTAR ALGUMA ROTINA
      COMO CRIAR COLUNAS, EXCLUIR ENTRE OUTRAS */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS tb_carro");
        onCreate(db);

    }

    /*MÉTODO QUE VAMOS USAR NA CLASSE QUE VAI EXECUTAR AS ROTINAS NO
    BANCO DE DADOS*/
    public SQLiteDatabase GetConexaoDataBase(){

        return this.getWritableDatabase();
    }
}
