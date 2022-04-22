package com.example.realmentor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MenuActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    vocabularyDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        db = new vocabularyDB(this);//бд добавляется
        SQLiteDatabase databaseRead = db.getReadableDatabase();//экземпляр читаемой бд
        Cursor cursor = databaseRead.query(db.TABLE_CONSTANTS,null, null, null, null, null, null);//включаем курсор для перебора элементов
        if (cursor.moveToFirst()){ //проверка на то, заполнена ли бд. в случае, если заполнена, она не будет заполняться заново и приложение не будет виснуть
            cursor.close();
        }else{ //тут происходит заполнение, если не заполнена
            cursor.close();
            SQLiteDatabase databaseWrite = db.getWritableDatabase(); //экземпляр редаческой бд
            ContentValues contentValues = new ContentValues();
            contentValues.put(db.KEY_RUSSIAN, "Жизнь"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Leben");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Читать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "lesen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Делать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "machen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Думать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "denken");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Путешествовать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "reisen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Играть"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "spielen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Ждать, дожидаться"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "warten");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Cтановиться, делаться"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "werden");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Жить, проживать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "wohnen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Возраст"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Alter");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //10
            contentValues.put(db.KEY_RUSSIAN, "Хотеть"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "wollen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Родители"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Eltern");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Семья"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Familie");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Женщина, жена"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Frau");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Ребенок"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Kind");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Год"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Jahr");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "День"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Tag");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Месяц"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Monat");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Я"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "ich");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Мир"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Welt");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //20
            contentValues.put(db.KEY_RUSSIAN, "Дальше"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "weiter");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Всё"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "alles");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Далеко"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "weit");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Скоро"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "bald");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Сторона, страница"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Seite");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Через, сквозь"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "durch");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Число"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Zahl");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Старый, пожилой"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "alt");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Труд, работа"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Arbeit");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Свободный, независимый"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "frei");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //30
            contentValues.put(db.KEY_RUSSIAN, "Всегда"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "immer");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Маленький, малый"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "klein");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Ты"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "du");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Новый, недавний"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "neu");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Женатый, замужняя"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "verheiratet");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Овдовевший"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "verwitwet");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Тут, там, здесь"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "da");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Сперва, только"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "erst");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Около, разве"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "etwa");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Что-нибудь, немного"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "etwas");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //40
            contentValues.put(db.KEY_RUSSIAN, "Здесь, тут, вот"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "hier");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Теперь, сейчас"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "jetzt");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "К сожалению"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "leider");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "(пока) Ещё, всё-ещё"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "noch");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Никакой"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "kein");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Уже"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "schon");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Впрочем, вообще"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "übrigens");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Но"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "aber");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Из"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "aus");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Это"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das (es)");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //50
            db.close();
        }
        navigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.bodyContainer, new FirstFragment()).commit();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment = new FirstFragment();
                                break;

                    case R.id.nav_vocabulary:
                        fragment = new SecondFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.bodyContainer, fragment).commit();
                return true;
            }
        });
    }

}