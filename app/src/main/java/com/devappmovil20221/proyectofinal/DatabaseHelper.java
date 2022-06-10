package com.devappmovil20221.proyectofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="Curso1";
    private static final String TABLE_NAME="Preguntas";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_TEXT="text";
    private static final String KEY_QUESTION="question";
    private static final String KEY_ANS1="ans1";
    private static final String KEY_ANS1NEXT="ans1next";
    private static final String KEY_ANS2="ans2";
    private static final String KEY_ANS2NEXT="ans2next";
    private static final String KEY_ANS3="ans3";
    private static final String KEY_ANS3NEXT="ans3next";
    private static final String KEY_ANS4="ans4";
    private static final String KEY_ANS4NEXT="ans4next";

    //Constructor
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        manualRenewDB(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        manualRenewDB();
    }

    public void addPregunta(ContenidoPregunta pregunta){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_ID, pregunta.getId());
        values.put(KEY_NAME, pregunta.getNombre());
        values.put(KEY_TEXT, pregunta.getTexto());
        values.put(KEY_QUESTION, pregunta.getPregunta());
        values.put(KEY_ANS1, pregunta.getRes1());
        values.put(KEY_ANS1NEXT, pregunta.getRes1next());
        values.put(KEY_ANS2, pregunta.getRes2());
        values.put(KEY_ANS2NEXT, pregunta.getRes2next());
        values.put(KEY_ANS3, pregunta.getRes3());
        values.put(KEY_ANS3NEXT, pregunta.getRes3next());
        values.put(KEY_ANS4, pregunta.getRes4());
        values.put(KEY_ANS4NEXT, pregunta.getRes4next());
        db.insert(TABLE_NAME, null, values);
    }

    public void addPregunta(int id, String nombre, String texto, String pregunta, String res1, int res1Next, String res2, int res2next, String res3, int res3next, String res4, int res4next){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_ID, id);
        values.put(KEY_NAME, nombre);
        values.put(KEY_TEXT, texto);
        values.put(KEY_QUESTION, pregunta);
        values.put(KEY_ANS1, res1);
        values.put(KEY_ANS1NEXT, res1Next);
        values.put(KEY_ANS2, res2);
        values.put(KEY_ANS2NEXT, res2next);
        values.put(KEY_ANS3, res3);
        values.put(KEY_ANS3NEXT, res3next);
        values.put(KEY_ANS4, res4);
        values.put(KEY_ANS4NEXT, res4next);
        db.insert(TABLE_NAME, null, values);
    }

    public ContenidoPregunta getPregunta(int id){
        ContenidoPregunta pregunta=new ContenidoPregunta();
        String selectQuery="SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID + " = " + id;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                pregunta.setId(Integer.parseInt(cursor.getString(0)));
                pregunta.setNombre(cursor.getString(1));
                pregunta.setTexto(cursor.getString(2));
                pregunta.setPregunta(cursor.getString(3));
                pregunta.setRes1(cursor.getString(4));
                pregunta.setRes1next(Integer.parseInt(cursor.getString(5)));
                pregunta.setRes2(cursor.getString(6));
                pregunta.setRes2next(Integer.parseInt(cursor.getString(7)));
                pregunta.setRes3(cursor.getString(8));
                pregunta.setRes3next(Integer.parseInt(cursor.getString(9)));
                pregunta.setRes4(cursor.getString(10));
                pregunta.setRes4next(Integer.parseInt(cursor.getString(11)));
            } while (cursor.moveToNext());
        }
        return pregunta;
    }

    public void deletePregunta(ContenidoPregunta question){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID+"=?", new String[]{String.valueOf(question.getId())});
    }

    public int getCount(){
        String countQuery="SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(countQuery, null);
        int count=cursor.getCount();
        return count;
    }

    public void manualRenewDB(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        createDB(db);
    }

    public void manualRenewDB(SQLiteDatabase db){
        if(db == null){
            db=this.getWritableDatabase();
        }
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        createDB(db);
    }

    public void createDB(SQLiteDatabase db){
        String CREATE_TABLE="CREATE TABLE "
                + TABLE_NAME + " ("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_TEXT + " TEXT,"
                + KEY_QUESTION + " TEXT,"
                + KEY_ANS1 + " TEXT,"
                + KEY_ANS1NEXT + " INT,"
                + KEY_ANS2 + " TEXT,"
                + KEY_ANS2NEXT + " INT,"
                + KEY_ANS3 + " TEXT,"
                + KEY_ANS3NEXT + " INT,"
                + KEY_ANS4 + " TEXT,"
                + KEY_ANS4NEXT + " INT)";
        db.execSQL(CREATE_TABLE);
    }
}
