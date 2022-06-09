package com.devappmovil20221.proyectofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="TUEDatabase";
    private static final String TABLE_CONTACTS="Questions";
    private static final String KEY_ID="id";
    private static final String KEY_BODY ="body";
    private static final String KEY_QUESTION ="question";
    private static final String KEY_FIRSTANSWER ="firstanswer";
    private static final String KEY_SECONDANSWER ="secondanswer";
    private static final String KEY_THIRDANSWER ="thirdanswer";
    private static final String KEY_FOURTHANSWER ="fourthanswer";
    private static final String KEY_FIRSTSCORE ="firstscore";
    private static final String KEY_SECONDSCORE ="secondscore";
    private static final String KEY_THIRDSCORE ="thirdscore";
    private static final String KEY_FOURTHSCORE ="fourthscore";

    //Constructor
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_CONTACTS_TABLE="CREATE TABLE "
                +TABLE_CONTACTS+"("
                +KEY_ID+" INTEGER PRIMARY KEY,"
                +KEY_BODY+" TEXT,"
                +KEY_QUESTION+" TEXT,"
                +KEY_FIRSTANSWER+" TEXT,"
                +KEY_FIRSTSCORE+" INTEGER,"
                +KEY_SECONDANSWER+" TEXT,"
                +KEY_SECONDSCORE+" INTEGER,"
                +KEY_THIRDANSWER+" TEXT,"
                +KEY_THIRDSCORE+" INTEGER,"
                +KEY_FOURTHANSWER+" TEXT,"
                +KEY_FOURTHSCORE+" INTEGER)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACTS);
    }
/*
    public void addContact(Contact contact){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_BODY, contact.getName());
        values.put(KEY_QUESTION, contact.getPhoneNumber());
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    public Contact getContact(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_CONTACTS, new String[]{
                KEY_ID,
                KEY_BODY,
                KEY_QUESTION
        }, KEY_ID+"=?", new String[]{
                String.valueOf(id)
        }, null, null, null, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
        }
        Contact contact= new Contact(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
        db.close();
        return contact;
    }

    public List<Contact> getAllContacts(){
        ArrayList<Contact> allContacts=new ArrayList<Contact>();
        String selectQuery="SELECT * FROM "+TABLE_CONTACTS;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Contact contact=new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                allContacts.add(contact);
            } while (cursor.moveToNext());
        }
        db.close();
        return allContacts;
    }

    public void updateContact(int id, String name, String phoneNumber){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_BODY, name);
        values.put(kEY_QUESTION,phoneNumber);
        db.update(TABLE_CONTACTS, values, KEY_ID+"=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteContact(Contact contact){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID+"=?", new String[]{String.valueOf(contact.getId())});
        db.close();
    }

    public int getContactsCount(){
        String countQuery="SELECT * FROM "+TABLE_CONTACTS;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(countQuery, null);
        int count=cursor.getCount();
        db.close();
        return count;
    }

    public void manualRenewDB(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACTS);
        String CREATE_CONTACTS_TABLE="CREATE TABLE "
                +TABLE_CONTACTS+"("
                +KEY_ID+" INTEGER PRIMARY KEY,"
                + KEY_BODY +" TEXT,"
                + kEY_QUESTION +" TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
        db.close();
    }*/
}
