package com.josesp.hackspace_reto1.model;

import android.provider.BaseColumns;

public class UsuarioDB {

    private UsuarioDB(){
    }

    public static class UsuarioEntrada implements BaseColumns{

        public static final String TABLA_NOMBRE = "usuario";
        public static final String correo_col1= "email";
        public static final String nombre_col2 = "nombre";
        public static final String phone_col3 = "phone";
        public static final String password_col4 = "password";

    }

    private static final String TIPO_TEXTO = " TEXT";
    private static final String SEPARADOR = ",";

    public static final String SQL_CREAR_TABLA_USUARIO =
            "CREATE TABLE " + UsuarioEntrada.TABLA_NOMBRE + " (" +
                    UsuarioEntrada.correo_col1 + " PRIMARY KEY, " +
                    UsuarioEntrada.nombre_col2 + TIPO_TEXTO + SEPARADOR +
                    UsuarioEntrada.phone_col3  + TIPO_TEXTO + SEPARADOR +
                    UsuarioEntrada.password_col4 + TIPO_TEXTO + ")";

    public static final String SQL_ELIMINAR_TABLA_USUARIO =
            "DROP TABLE IF EXIST" + UsuarioEntrada.TABLA_NOMBRE ;



}
