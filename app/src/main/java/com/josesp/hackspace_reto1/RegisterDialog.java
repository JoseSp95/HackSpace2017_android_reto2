package com.josesp.hackspace_reto1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.josesp.hackspace_reto1.model.UsuarioDB;
import com.josesp.hackspace_reto1.model.UsuarioDBHelper;

public class RegisterDialog extends DialogFragment {

    public static String TAG = "sign_up_message";
    public static String MESSAGE = "Hola Jose Suarez";

    /*
    public interface OnDialogListener{
        void onLoginButtonClick();
    }

    private OnDialogListener onDialogListener;
    private String message;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onDialogListener = (OnDialogListener) getActivity();
        message = getArguments().getString("message");
    }*/

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity().getLayoutInflater().inflate(R.layout.login_modal, null);
        Button btnAccept = view.findViewById(R.id.button_login);
        TextView txtClose = view.findViewById(R.id.close_dialog_sing_up);
        final EditText txtName = view.findViewById(R.id.txtName);
        final EditText txtEmail = view.findViewById(R.id.txtEmail);
        final EditText txtPhone = view.findViewById(R.id.txtTelephone);
        final EditText txtPassword = view.findViewById(R.id.txtPassword);
        final CheckBox cbxAgree = view.findViewById(R.id.cbx_agree_all_statements);

        final UsuarioDBHelper dbHelper = new UsuarioDBHelper(getContext());

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txtEmail.getText().toString().trim().equals("")){
                    Toast.makeText(getContext(), "Complete el campo Email", Toast.LENGTH_LONG).show();
                    return;
                }

                if(txtPassword.getText().toString().trim().equals("")){
                    Toast.makeText(getContext(), "Complete el campo Password", Toast.LENGTH_LONG).show();
                    return;
                }


                if(!cbxAgree.isChecked()){
                    Toast.makeText(getContext(), "Acepte los términos ", Toast.LENGTH_LONG).show();
                    return;
                }

                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(UsuarioDB.UsuarioEntrada.nombre_col2, txtName.getText().toString());
                values.put(UsuarioDB.UsuarioEntrada.correo_col1, txtEmail.getText().toString());
                values.put(UsuarioDB.UsuarioEntrada.phone_col3, txtPhone.getText().toString());
                values.put(UsuarioDB.UsuarioEntrada.password_col4, txtPassword.getText().toString());

                long newRowId = db.insert(UsuarioDB.UsuarioEntrada.TABLA_NOMBRE, null, values);
                Toast.makeText(getContext(), "Usuario registrado", Toast.LENGTH_LONG).show();
                dismiss();

                //Toast.makeText(getContext(), "Se guardo el usuario con ID : " + newRowId , Toast.LENGTH_LONG).show();

            }
        });

        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        builder.setView(view);
        return builder.create();

    }

    /*
    public void onLoginButtonClick(){
        onDialogListener.onLoginButtonClick();
    }
*/
}