package com.example.grocery;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //1-AdapterView
    RecyclerView recyclerView;
    //2-Data Source
    List<Item> itemList;
    //3-Adapter(bridge)
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView=findViewById(R.id.recycler_view);
        itemList=new ArrayList<>();
        Item item1= new Item(R.drawable.fruits,"Fruits","Fresh Fruits from the Garden");
        Item item2= new Item(R.drawable.vegetable,"Vegetables","DeliciousVegetables");
        Item item3= new Item(R.drawable.bread,"Bread","Bread,Wheat and Beans");
        Item item4= new Item(R.drawable.beverage,"Beverages","Juice,Tea,Coffee and Soda");
        Item item5= new Item(R.drawable.pop,"Popcorn","Milk,Shakes and Yogurt");
        Item item6= new Item(R.drawable.milk,"Milk","Popcorn,Donut and Drinks");
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);



        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        myAdapter = new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

    }
}