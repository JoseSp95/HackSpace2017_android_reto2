package com.josesp.hackspace_reto1.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class UsuarioDBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NOMBRE = "usuario.db";

    public UsuarioDBHelper(Context context){
        super(context, DB_NOMBRE, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioDB.SQL_CREAR_TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(UsuarioDB.SQL_ELIMINAR_TABLA_USUARIO);
        onCreate(db);
    }
}
