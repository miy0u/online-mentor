package com.example.realmentor;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        TextView vocabularyGE = (TextView) view.findViewById(R.id.vocabularyGE_textview);
        TextView vocabularyRU = (TextView) view.findViewById(R.id.vocabularyRU_textview);

        vocabularyDB db = new vocabularyDB(requireContext());
        SQLiteDatabase databaseRead = db.getReadableDatabase();

        Cursor cursor = databaseRead.query(vocabularyDB.TABLE_CONSTANTS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {//если первый элемент сушествует, то...
            //создаются индексы, с помощью которых можно будет взять строку
            int idIndex = cursor.getColumnIndex(vocabularyDB.KEY_ID);
            int idRussian = cursor.getColumnIndex(vocabularyDB.KEY_RUSSIAN);
            int idGerman = cursor.getColumnIndex(vocabularyDB.KEY_GERMAN);

            LinkedList<String> ListRU = new LinkedList<>();// создается массив, чтобы можно было сохранить туда данные строки
            LinkedList<String> ListGE = new LinkedList<>();// создается массив, чтобы можно было сохранить туда данные строки
            ListRU.add(0, cursor.getString(idRussian));//заполняется первый элемент
            ListGE.add(0, cursor.getString(idGerman));//заполняется первый элемент
            int i = 1;//переменная, чтобы можно было перебирать последующие элементы и выводить по одному
            while (cursor.moveToNext()) {//пока можно перейти на следующий элемент, делаем это...
                int idIndexNext = cursor.getColumnIndex(vocabularyDB.KEY_ID);
                int idRussianNext = cursor.getColumnIndex(vocabularyDB.KEY_RUSSIAN);
                int idGermanNext = cursor.getColumnIndex(vocabularyDB.KEY_GERMAN);
                ListRU.add(i, cursor.getString(idRussianNext));//заполняются остальные элементы массива
                ListGE.add(i, cursor.getString(idGermanNext));//заполняется первый элемент
                i++;
            }
            ;
            for (int j = 0; j < ListRU.size(); j++) {//конструкция, чтобы можно было вывести все элементы, а не только последний
                vocabularyRU.append(ListRU.get(j) + "\n");
                vocabularyGE.append(ListGE.get(j) + "\n");
            }
            cursor.close();//закрываем и освобождаем память, ОБЯЗАТЕЛЬНО

            db.close();//закрываем базу данных
        }
        return view;
    }
}