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
            contentValues.put(db.KEY_RUSSIAN, "жизнь"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Leben");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "читать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "lesen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "делать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "machen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "думать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "denken");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "путешествовать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "reisen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "играть"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "spielen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "ждать, дожидаться"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "warten");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "становиться, делаться"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "werden");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "жить, проживать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "wohnen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "возраст"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Alter");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //10
            contentValues.put(db.KEY_RUSSIAN, "хотеть"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "wollen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "родители"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Eltern");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "семья"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Familie");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "женщина, жена"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Frau");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "ребенок"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Kind");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "год"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Jahr");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "день"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Tag");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "месяц"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Monat");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "Я"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "ich");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "мир"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Welt");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //20
            contentValues.put(db.KEY_RUSSIAN, "дальше"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "weiter");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "всё"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "alles");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "далеко"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "weit");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "скоро"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "bald");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "сторона, страница"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Seite");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "через, сквозь"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "durch");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "число"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Zahl");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "старый, пожилой"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "alt");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "труд, работа"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Arbeit");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "свободный, независимый"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "frei");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //30
            contentValues.put(db.KEY_RUSSIAN, "всегда"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "immer");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "маленький, малый"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "klein");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "ты"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "du");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "новый, недавний"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "neu");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "женатый, замужняя"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "verheiratet");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "овдовевший"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "verwitwet");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "тут, там, здесь"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "da");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "сперва, только"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "erst");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "около, разве"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "etwa");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "что-нибудь, немного"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "etwas");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //40
            contentValues.put(db.KEY_RUSSIAN, "здесь, тут, вот"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "hier");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "теперь, сейчас"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "jetzt");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "к сожалению"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "leider");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "(пока) ещё, всё-ещё"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "noch");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "никакой"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "kein");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "уже"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "schon");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "впрочем, вообще"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "übrigens");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "но"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "aber");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "из"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "aus");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "это"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das (es)");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //50
            contentValues.put(db.KEY_RUSSIAN, "твой (твоя, твоё, твои)"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "dein");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "от"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "von");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "что?"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "was");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "кто?"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "wer");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "как?"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "wie");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "сколько?"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "wieviel");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "значит так!, ах так!"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "ach so!");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "до свидания!"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "auf Wiedersehen!");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "красивый, прекрасный"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "schön");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "стоять"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "stehen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "вечер"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Abend");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "в настоящее время"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "zur Zeit");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "мужчина, супруг"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Mann, die Männer");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "крепкий, прочный"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "fest");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "не, ни"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "nicht");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "учитель, преподаватель"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Lehrer");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "и"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "und");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "страна, край"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Land, die Länder");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "также, тоже"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "auch");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "поздний, позднеe"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "später");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //70
            contentValues.put(db.KEY_RUSSIAN, "там"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "dort");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "купить, покупать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "kaufen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "продавать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "verkaufen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "вместе, сообща"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "zusammen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "тогда, потом"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "dann");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "час"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Stunde");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "возможный (возможно)"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "möglich");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "любовь"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Liebe");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "лежать, быть расположенным"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "liegen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "отвечать, давать ответ"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "antworten");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "приходить, прибывать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "kommen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "извинять, прощать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "entschuldigen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "действовать, работать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "funktionieren");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "стоить, пробовать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "kosten");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "сказать, говорить"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "sagen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "полоскать, промывать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "spülen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "соответствовать (истине)"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "stimmen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "мыть, стирать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "waschen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "обменивать, разменивать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "wechseln");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "ответ, отклик"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Antwort");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //90
            contentValues.put(db.KEY_RUSSIAN, "бензин"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Benzin");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "постель, кровать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Bett");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "картина, рисунок"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Bild");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "ошибка"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Fehler");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "называть, зваться"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "heißen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "деньги"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Geld");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "занятие, сделка, магазин"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Geschäft");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "дом, здание"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Haus, die Häuser");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "домашнее хозяйство"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Haushalt");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "очаг, плита"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Herd");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "идея, мысль"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Idee");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "мочь, уметь"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "können");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "быстро"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "schnell");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "быть"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "sein");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "полка, стеллаж"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Regal");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "по-другому"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "anders");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "внутри"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "in");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "иметь"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "haben");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "стул"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Stuhl, die Stühle");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "стол"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Tisch");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //110
            contentValues.put(db.KEY_RUSSIAN, "горшок, кастрюля"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Topf, die Töpfe");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "часы"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Uhr");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "солнце"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Sonne");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "идти, ходить"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "gehen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "время"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Zeit");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "похожий, сходный"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "ähnlich");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "смотреть, глядеть"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "sehen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "честный, порядочный"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "ehrlich");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "разбитый, сломанный"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "kaputt");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "большой, крупный"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "groß");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "весёлый, забавный"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "lustig");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "оригинальный, своеобразный"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "originell");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "очень, весьма, крайне"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "sehr");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "сегодня"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "heute");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "много, многие"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "viel");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "или"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "oder");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "а, но"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "sondern");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "к, на, в"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "zu");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "наружу"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "raus");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "спасибо"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "danke");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //130
            contentValues.put(db.KEY_RUSSIAN, "пожалуйста"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "bitte");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "лампа"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Lampe");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "пить"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "trinken");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "кушать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "essen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "карандаш"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Bleistift");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "систематизировать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "ordnen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "профессия"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Beruf");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "врач, доктор"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Arzt, die Ärzte");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "дерево"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Baum, die Bäume");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "после"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "nach");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "на (горизонтальной поверхности)"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "auf");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "против, около"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "gegen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "как, когда"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "als");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "автомобиль"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Auto");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "он"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "er");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "заказывать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "bestellen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "платить, выплачивать"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "bezahlen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "нуждаться"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "brauchen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "точно, именно"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "genau");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "думать, верить"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "glauben");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //150
            contentValues.put(db.KEY_RUSSIAN, "варить, готовить (пищу)"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "kochen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "любить"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "mögen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "над"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "über");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "упражняться"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "üben");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "ужин"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Abendessen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "объявление, заявление"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Anzeige");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "яблоко"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Apfel, die Äpfel");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "быть должным"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "müssen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "хлеб"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Brot");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "между"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "zwischen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "масло (животное)"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Butter");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "под"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "unter");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "яйцо"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Ei, die Eier");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "лёд, мороженое"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Eis");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "клубника, земляника"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Erdbeere");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "бутылка, фляжка"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Flasche");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "мясо"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Fleisch");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "вопрос"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Frage");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "сам"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "selbst");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "завтрак"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Frühstück");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //170
            contentValues.put(db.KEY_RUSSIAN, "вилка"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Gabel");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "газета"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Zeitung");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "овощи, зелень"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Gemüse");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "блюдо, кушанье, суд"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Gericht");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "разговор, беседа"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Gespräch");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "напиток, питьё"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Getränk");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "пряности, приправа"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Gewürz");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "стекло, стакан, рюмка"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Glas, die Gläser");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "процент"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Prozent");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "сыр, творог"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Käse");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "пирог, пирожное"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Kuchen");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "ложка"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Löffel");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "больше"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "mehr");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "нож"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Messer");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "десерт"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Nachtisch");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "масло (растительное)"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Öl");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "перец"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Pfeffer");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "цветок"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Blume");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "цена"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Preis");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "рис"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Reis");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //190
            contentValues.put(db.KEY_RUSSIAN, "сок"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Saft, die Säfte");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "сливки"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Sahne");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "ветчина"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Schinken");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "соус, подливка"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Soße");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "медленно"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "langsam");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "вода"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "das Wasser");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "суп, похлёбка"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Suppe");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "чашка (чайная)"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Tasse");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "тарелка"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "der Teller");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            contentValues.put(db.KEY_RUSSIAN, "помидор"); //заполнение бд
            contentValues.put(db.KEY_GERMAN, "die Tomate");
            databaseWrite.insert(db.TABLE_CONSTANTS, null, contentValues);
            //200
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